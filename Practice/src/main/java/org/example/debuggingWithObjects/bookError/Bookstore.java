package org.example.debuggingWithObjects.bookError;

public class Bookstore {
    Book b1, b2;

    Bookstore(Book b1, Book b2) {
        this.b1 = b1;
        this.b2 = b2;
    }

    double getTotalPrice() {
        return b1.price - b2.price;
    }
}
