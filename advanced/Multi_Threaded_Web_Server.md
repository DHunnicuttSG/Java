// Main Server Class and Entry Point
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Map;
import java.util.UUID;
import java.util.Optional;

/**
 * The Server class acts as the main application entry point.
 * It's responsible for setting up the server socket and accepting incoming client connections.
 * It delegates the handling of each request to a worker thread from a thread pool,
 * which then routes the request to the appropriate controller.
 */
public class Server {

    private static final int PORT = 8080;
    private static final int THREAD_POOL_SIZE = 5;
    private static final UserRepository userRepository = new InMemoryUserRepository();
    private static final UserController userController = new UserController(userRepository);

    public static void main(String[] args) {
        System.out.println("Starting MVC web server on port " + PORT + "...");
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening for connections...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());
                executorService.submit(new RequestHandler(clientSocket, userController));
            }
        } catch (IOException e) {
            System.err.println("Server exception: " + e.getMessage());
            executorService.shutdown();
        }
    }
}

/**
 * RequestHandler is the Controller for routing.
 * This class handles a single client's HTTP request in a separate thread.
 * It parses the request and routes it to the correct method in the `UserController`.
 */
class RequestHandler implements Runnable {

    private Socket clientSocket;
    private UserController userController;

    public RequestHandler(Socket socket, UserController controller) {
        this.clientSocket = socket;
        this.userController = controller;
    }

    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        ) {
            String requestLine = in.readLine();
            if (requestLine == null) return;

            // Simple request parsing: Method, Path, HTTP Version
            String[] parts = requestLine.split(" ");
            String method = parts[0];
            String path = parts[1];
            
            System.out.println("Received " + method + " request for " + path + " on thread: " + Thread.currentThread().getName());

            // Check if the request is for the user resource
            if (path.startsWith("/users")) {
                if ("GET".equals(method)) {
                    // Route to the read method in the controller
                    userController.handleGet(path, out);
                } else if ("POST".equals(method)) {
                    // Handle POST request, which requires reading the request body
                    String body = readRequestBody(in);
                    userController.handlePost(body, out);
                } else if ("PUT".equals(method)) {
                    String body = readRequestBody(in);
                    userController.handlePut(path, body, out);
                } else if ("DELETE".equals(method)) {
                    userController.handleDelete(path, out);
                }
            } else {
                // Return a 404 Not Found response for unknown paths
                out.println(HtmlView.getNotFoundView());
            }

        } catch (IOException e) {
            System.err.println("Error handling client request: " + e.getMessage());
        } finally {
            try {
                if (!clientSocket.isClosed()) {
                    clientSocket.close();
                }
            } catch (IOException e) {
                System.err.println("Could not close client socket: " + e.getMessage());
            }
        }
    }

    private String readRequestBody(BufferedReader in) throws IOException {
        StringBuilder sb = new StringBuilder();
        // Read headers until a blank line is found
        while (true) {
            String line = in.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }
            // Simple content-length check (not fully robust but sufficient for this example)
            if (line.toLowerCase().startsWith("content-length")) {
                // Assuming Content-Length is the only header we need to handle for now.
                // For a real server, you'd need to parse all headers.
            }
        }
        // Read the body after the headers
        while (in.ready()) {
            sb.append((char) in.read());
        }
        return sb.toString();
    }
}

/**
 * UserController is the main Controller in our MVC design.
 * It contains the business logic for handling user-related requests.
 * It interacts with the `UserRepository` (the Model) and `HtmlView` (the View).
 */
class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CRUD - READ
    public void handleGet(String path, PrintWriter out) {
        if (path.equals("/users")) {
            // Get all users
            out.println(HtmlView.getUserListView(userRepository.findAll()));
        } else {
            // Get a single user by ID
            String userId = path.substring(path.lastIndexOf("/") + 1);
            Optional<User> user = userRepository.findById(userId);
            if (user.isPresent()) {
                out.println(HtmlView.getUserDetailView(user.get()));
            } else {
                out.println(HtmlView.getNotFoundView());
            }
        }
    }

    // CRUD - CREATE
    public void handlePost(String body, PrintWriter out) {
        // Simple parsing of a "name=John" style body
        String[] parts = body.split("=");
        if (parts.length == 2 && parts[0].equals("name")) {
            User newUser = new User(UUID.randomUUID().toString(), parts[1]);
            userRepository.save(newUser);
            out.println(HtmlView.getSuccessView("User created successfully!"));
        } else {
            out.println(HtmlView.getBadRequestView());
        }
    }
    
    // CRUD - UPDATE
    public void handlePut(String path, String body, PrintWriter out) {
        String userId = path.substring(path.lastIndexOf("/") + 1);
        String[] parts = body.split("=");
        if (parts.length == 2 && parts[0].equals("name")) {
            Optional<User> existingUser = userRepository.findById(userId);
            if (existingUser.isPresent()) {
                existingUser.get().setName(parts[1]);
                userRepository.save(existingUser.get());
                out.println(HtmlView.getSuccessView("User updated successfully!"));
            } else {
                out.println(HtmlView.getNotFoundView());
            }
        } else {
             out.println(HtmlView.getBadRequestView());
        }
    }

    // CRUD - DELETE
    public void handleDelete(String path, PrintWriter out) {
        String userId = path.substring(path.lastIndexOf("/") + 1);
        if (userRepository.deleteById(userId)) {
            out.println(HtmlView.getSuccessView("User deleted successfully!"));
        } else {
            out.println(HtmlView.getNotFoundView());
        }
    }
}

/**
 * UserRepository is the interface for our Model layer.
 * It defines the contract for data access operations, separating the
 * business logic from the persistence layer.
 */
interface UserRepository {
    // CRUD operations
    void save(User user);
    Optional<User> findById(String id);
    Map<String, User> findAll();
    boolean deleteById(String id);
}

/**
 * InMemoryUserRepository is the implementation of our Model.
 * This class uses a thread-safe `ConcurrentHashMap` as a simple, in-memory
 * database to store and retrieve user objects. This is safe for concurrent access.
 */
class InMemoryUserRepository implements UserRepository {
    // Thread-safe map for our "database"
    private final ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();

    // A simple counter for generating user IDs, though we'll use UUIDs.
    private final AtomicLong counter = new AtomicLong();

    // Initialize with some dummy data for testing
    public InMemoryUserRepository() {
        save(new User(UUID.randomUUID().toString(), "Alice"));
        save(new User(UUID.randomUUID().toString(), "Bob"));
    }

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public Map<String, User> findAll() {
        return users;
    }

    @Override
    public boolean deleteById(String id) {
        return users.remove(id) != null;
    }
}

/**
 * The User class is our Model object.
 * This is a simple POJO (Plain Old Java Object) that represents our data.
 * It contains the state (name, id) and methods to access that state.
 */
class User {
    private final String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * The HtmlView class is our View component.
 * It's responsible for generating the HTML content that is sent back to the client.
 * It keeps the HTML generation logic separate from the controller.
 */
class HtmlView {

    public static String getUserListView(Map<String, User> users) {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK\n");
        sb.append("Content-Type: text/html\n\n");
        sb.append("<html><body><h1>User List</h1><ul>");
        users.forEach((id, user) -> sb.append("<li>ID: ").append(user.getId()).append(", Name: ").append(user.getName()).append("</li>"));
        sb.append("</ul></body></html>");
        return sb.toString();
    }

    public static String getUserDetailView(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK\n");
        sb.append("Content-Type: text/html\n\n");
        sb.append("<html><body><h1>User Details</h1>");
        sb.append("<p><b>ID:</b> ").append(user.getId()).append("</p>");
        sb.append("<p><b>Name:</b> ").append(user.getName()).append("</p>");
        sb.append("</body></html>");
        return sb.toString();
    }

    public static String getSuccessView(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK\n");
        sb.append("Content-Type: text/html\n\n");
        sb.append("<html><body><h1>Success!</h1><p>").append(message).append("</p></body></html>");
        return sb.toString();
    }

    public static String getBadRequestView() {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 400 Bad Request\n");
        sb.append("Content-Type: text/html\n\n");
        sb.append("<html><body><h1>400 Bad Request</h1><p>Invalid request format.</p></body></html>");
        return sb.toString();
    }
    
    public static String getNotFoundView() {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 404 Not Found\n");
        sb.append("Content-Type: text/html\n\n");
        sb.append("<html><body><h1>404 Not Found</h1><p>The requested resource was not found.</p></body></html>");
        return sb.toString();
    }
}
