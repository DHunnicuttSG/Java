package org.example.debuggingWithObjects.bonusBug;

public class Employee {
    private double salary;

    Employee(double salary) {
        this.salary = salary;
    }

    double calculateBonus() {
        return salary * .10;
    }
}
