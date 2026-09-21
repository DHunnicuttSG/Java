# 📘 Java Code-Along: Book Object with Composition

---

## 🎯 Learning Objectives

By the end of this exercise, students will be able to:

* Understand **composition** in Java (a "has-a" relationship).
* Create and use **multiple classes** working together.
* Instantiate objects and **nest them** within other objects.
* Use **getters, setters, and constructors** effectively.
* Generate and print a **JSON representation** of an object.

---

## 🧩 Step 1: Create the `Author` Class

An `Author` has a **name**, **email**, and **affiliation**.

```java
// File: Author.java
public class Author {
    private String name;
    private String email;
    private String affiliation;

    // Constructor
    public Author(String name, String email, String affiliation) {
        this.name = name;
        this.email = email;
        this.affiliation = affiliation;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAffiliation() {
        return affiliation;
    }

    // toString() for debugging
    @Override
    public String toString() {
        return "{ \"name\": \"" + name + "\", " +
               "\"email\": \"" + email + "\", " +
               "\"affiliation\": \"" + affiliation + "\" }";
    }
}
```

✅ **Concepts used:**

* Constructor for initialization
* Getters for data access
* Overridden `toString()` method for JSON-like formatting

---

## 🧩 Step 2: Create the `Publisher` Class

A `Publisher` has a **name**, **address**, and **website**.

```java
// File: Publisher.java
public class Publisher {
    private String name;
    private String address;
    private String website;

    // Constructor
    public Publisher(String name, String address, String website) {
        this.name = name;
        this.address = address;
        this.website = website;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getWebsite() {
        return website;
    }

    // toString() for JSON-like output
    @Override
    public String toString() {
        return "{ \"name\": \"" + name + "\", " +
               "\"address\": \"" + address + "\", " +
               "\"website\": \"" + website + "\" }";
    }
}
```

✅ **Concepts used:**

* Encapsulation (private fields, getters)
* String concatenation for formatted output

---

## 🧩 Step 3: Create the `Book` Class

A `Book` **has-a** `Publisher` and one or more `Author` objects.

```java
// File: Book.java
import java.util.List;

public class Book {
    private String title;
    private String isbn;
    private double price;
    private Publisher publisher;        // Composition: Book HAS-A Publisher
    private List<Author> authors;       // Composition: Book HAS-A list of Authors

    // Constructor
    public Book(String title, String isbn, double price, Publisher publisher, List<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.publisher = publisher;
        this.authors = authors;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    // toString() for JSON-style representation
    @Override
    public String toString() {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("  \"title\": \"" + title + "\",\n");
        json.append("  \"isbn\": \"" + isbn + "\",\n");
        json.append("  \"price\": " + price + ",\n");
        json.append("  \"publisher\": " + publisher.toString() + ",\n");
        json.append("  \"authors\": [\n");

        for (int i = 0; i < authors.size(); i++) {
            json.append("    " + authors.get(i).toString());
            if (i < authors.size() - 1) json.append(",");
            json.append("\n");
        }

        json.append("  ]\n}");
        return json.toString();
    }
}
```

✅ **Concepts used:**

* **Composition:** Book *has-a* Publisher and *has-a* list of Authors
* **Encapsulation** via private fields
* **Constructor chaining** to initialize all attributes
* **Custom `toString()`** for JSON-style output

---

## 🧩 Step 4: Create the `Main` Class (Test Program)

Now we’ll instantiate and connect all the pieces.

```java
// File: Main.java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Step 1: Create Author objects
        Author a1 = new Author("Alice Johnson", "alice@example.com", "Tech University");
        Author a2 = new Author("Bob Smith", "bob@example.com", "Data Institute");

        // Step 2: Create a Publisher object
        Publisher publisher = new Publisher("CodePress", "123 Main St, New York", "www.codepress.com");

        // Step 3: Create a List of Authors
        List<Author> authors = Arrays.asList(a1, a2);

        // Step 4: Create the Book object (composition)
        Book book = new Book("Learning Java OOP", "978-1234567890", 49.99, publisher, authors);

        // Step 5: Print out Book object in JSON format
        System.out.println(book.toString());
    }
}
```

✅ **Concepts used:**

* Object instantiation (`new Author`, `new Publisher`, `new Book`)
* **Composition in action**: objects within objects
* Output formatting through `toString()` overrides

---

## 🧾 Example Output

When you run `Main.java`, you’ll get:

```
{
  "title": "Learning Java OOP",
  "isbn": "978-1234567890",
  "price": 49.99,
  "publisher": { "name": "CodePress", "address": "123 Main St, New York", "website": "www.codepress.com" },
  "authors": [
    { "name": "Alice Johnson", "email": "alice@example.com", "affiliation": "Tech University" },
    { "name": "Bob Smith", "email": "bob@example.com", "affiliation": "Data Institute" }
  ]
}
```

---

## 💡 Discussion

| Concept                    | Description                                           | Example in Code                                |
| -------------------------- | ----------------------------------------------------- | ---------------------------------------------- |
| **Composition**            | A class contains other class objects                  | `Book` has `Publisher` and `Authors`           |
| **Encapsulation**          | Keeping data private and using getters                | All private fields                             |
| **Constructor Chaining**   | Initializes multiple attributes on creation           | `Book` constructor                             |
| **Object Relationships**   | “Has-a” instead of “Is-a”                             | A book *has-a* publisher, not *is-a* publisher |
| **Polymorphism Potential** | Could later support `EBook`, `PrintedBook` subclasses | Future extension                               |

---

## 🧠 Challenge Exercise

1. Add a new field to `Book` — e.g., `genre` or `publicationYear`.
2. Add another author to the list and reprint the JSON.
3. Write a new method `applyDiscount(double percent)` in `Book` that adjusts the price.
4. Add a method in `Publisher` to format its info as a single string.

---
