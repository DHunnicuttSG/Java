package org.example.debuggingWithObjects.animalError;

public class App {
//    The dogs are not barking and the cats are not meowing, find the errors and fix them.
    public static void main(String[] args) {
        Animal d = new Animal();
        Animal c = new Cat();
        System.out.println(d.speak());
        System.out.println(c.speak());
    }
}
