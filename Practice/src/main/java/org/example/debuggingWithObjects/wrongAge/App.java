package org.example.debuggingWithObjects.wrongAge;

public class App {
//    Alice is regressing in age.  Find the error and fix it.
    public static void main(String[] args) {
        Person p = new Person("Alice", 1990);
        System.out.println("Age: " + p.getAge(2025));
    }
}
