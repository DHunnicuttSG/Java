package org.example.debuggingWithObjects.bonusBug;

public class App {
    // Something is not quite right with the salaries, fix it, please.
    public static void main(String[] args) {
        Employee e = new Employee(50000); //$50,000
        System.out.printf("New Salary + Bonus: %.2f%n",  e.calculateBonus());
    }
}
