package org.example.Objects;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person();

        Person p2 = new Person(2, 22, "Joe", "Smith", false, 160.0);


//        System.out.println(p1.getHeight());
//
//        System.out.println(p2.getFirstName() + " " + p2.getLastname());
//
//        p2.speak();
//        p2.walk();

        double[] myArray = new double[1];
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }
    }
}
