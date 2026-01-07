package org.example.debuggingWithObjects.wrongAge;

public class Person {
    private String name;
    private int birthYear;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public int getAge(int currentYear) {
        return birthYear - currentYear;
    }
}
