package org.example.debuggingWithObjects.bankError;

public class App {
//    something is not quite right about Bob's balance.  Find the error and fix it.
    public static void main(String[] args) {
        BankAccount b = new BankAccount("Bob", 100);
        b.deposit(50);
        b.withdraw(30);
        System.out.println("Final balance: " + b.getBalance());
    }
}