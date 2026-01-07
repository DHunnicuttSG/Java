package org.example.debuggingWithObjects.bookError;


public class App {
    // The total price does not seem right, find the error and fix it.
    public static void main(String[] args) {
        Bookstore store = new Bookstore(new Book("Java 101", 45.23), new Book("Debugging Mastery", 29.94));
        System.out.printf("Total price: %.2f%n", store.getTotalPrice());
    }
}
