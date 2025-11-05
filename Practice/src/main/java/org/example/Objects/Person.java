package org.example.Objects;

import java.sql.Array;

public class Person {
    private int personId;
    private int age;
    private String firstName;
    private String lastname;
    private boolean isFemale;
    private double height;

    public void speak(){
        System.out.println("I am speaking...");
    }

    public void walk() {
        System.out.println("I am walking...");
    }

    int[] myArray = new int[3];



    Person() {}

    public Person(int personId, int age, String firstName, String lastname, boolean isFemale, double height) {
        this.personId = personId;
        this.age = age;
        this.firstName = firstName;
        this.lastname = lastname;
        this.isFemale = isFemale;
        this.height = height;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public void setFemale(boolean female) {
        isFemale = female;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
