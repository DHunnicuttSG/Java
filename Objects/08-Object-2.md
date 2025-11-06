# 🧭 **Object-Oriented Concepts and Abstraction**
---

## 🎯 **Objectives**

1. Explore different ways of **abstracting problems**.
2. Define **object orientation** as one method of abstraction.
3. Describe the **key characteristics** of an object-oriented language.
4. Understand the concept of **public interface vs. private implementation**.

---

## 🧩 1. Abstraction — Hiding Complexity

**Abstraction** is the process of simplifying a complex system by modeling classes appropriate to the problem.
It allows us to **focus on what an object does**, not **how it does it**.

### 🔍 Everyday Example:

When you drive a car:

* You use the **steering wheel, gas pedal, and brakes** (public interface).
* You don’t need to know how the engine or transmission works (private implementation).

This is abstraction — you interact with the system at a high level.

---

### 🧠 In Programming:

We use abstraction to hide unnecessary details from the user and expose only what is essential.

For example:

```java
public class Calculator {
    public int add(int a, int b) {  // public interface
        return a + b;
    }

    private void logOperation(String operation) {  // private implementation
        System.out.println("Performed: " + operation);
    }
}
```

**Explanation:**

* The `add()` method is **public** — other code can use it.
* The `logOperation()` method is **private** — used internally, hidden from users.

---

## 🧩 2. Object Orientation — A Way to Abstract Problems

Object-Oriented Programming (OOP) is a **method of organizing software** where we model a system as a collection of **objects** that:

* Represent **real-world entities**, and
* **Interact** with one another.

Instead of focusing on **functions or procedures**, OOP centers around **objects** — each with its **data (fields)** and **behavior (methods)**.

---

### 💡 Example:

Let’s model a simple `Car` class in Java.

```java
public class Car {
    // Attributes (data)
    String brand;
    int speed;

    // Constructor
    public Car(String brand) {
        this.brand = brand;
        this.speed = 0;
    }

    // Methods (behavior)
    public void accelerate(int increase) {
        speed += increase;
        System.out.println(brand + " is now going " + speed + " mph.");
    }

    public void brake() {
        speed = 0;
        System.out.println(brand + " has stopped.");
    }
}
```

Each car **object** has:

* **State** → `brand` and `speed`
* **Behavior** → `accelerate()` and `brake()`

---

### 🧠 Creating and Using Objects

```java
public class Main {
    public static void main(String[] args) {
        Car honda = new Car("Honda");
        honda.accelerate(30);
        honda.brake();
    }
}
```

**Output:**

```
Honda is now going 30 mph.
Honda has stopped.
```

Here, `honda` is an **object instance** of the `Car` class.

---

## 🧩 3. Characteristics of an Object-Oriented Language

An **object-oriented language** (like Java, Python, or C#) typically supports four main characteristics — often called the **Four Pillars of OOP**.

| Concept           | Description                                                 | Example                                                    |
| ----------------- | ----------------------------------------------------------- | ---------------------------------------------------------- |
| **Encapsulation** | Hiding data and providing controlled access through methods | `private int balance;` with `getBalance()` and `deposit()` |
| **Inheritance**   | One class inherits attributes and methods from another      | `class Manager extends Employee`                           |
| **Polymorphism**  | Same method name behaves differently depending on context   | `makeSound()` in `Dog` vs. `Cat`                           |
| **Abstraction**   | Exposing only essential features while hiding details       | `Shape` abstract class with `area()` method                |

---

### 🧩 Example of OOP Concepts Combined

```java
abstract class Shape {                  // Abstraction
    abstract void area();
}

class Circle extends Shape {            // Inheritance
    double radius = 5;

    @Override
    void area() {                       // Polymorphism
        System.out.println("Area: " + (Math.PI * radius * radius));
    }
}

class Demo {
    public static void main(String[] args) {
        Shape s = new Circle();
        s.area();                       // Calls Circle’s implementation
    }
}
```

**Output:**

```
Area: 78.53981633974483
```

Here:

* The **abstract class** `Shape` hides details (abstraction).
* The **child class** `Circle` inherits from `Shape`.
* The **method** `area()` is **overridden** (polymorphism).

---

## 🧩 4. Public Interface vs. Private Implementation

This concept defines **how other code interacts** with your class and what is hidden inside.

* The **public interface** includes the methods and properties a user can access.
* The **private implementation** includes the internal logic and data that the user should not directly modify.

---

### 🧠 Example: Bank Account

```java
public class BankAccount {
    private double balance;  // private data

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Public interface
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            logTransaction("Deposited $" + amount);
        }
    }

    public double getBalance() {
        return balance;
    }

    // Private implementation detail
    private void logTransaction(String message) {
        System.out.println("Transaction: " + message);
    }
}
```

### 🔍 Key Points:

* The **user** can call `deposit()` and `getBalance()` — the **public interface**.
* The **user** cannot directly access `balance` or `logTransaction()` — the **private implementation**.
* This ensures **data security** and **controlled behavior**.

---

## 🧩 5. Why These Concepts Matter

| Concept                | Benefit                                                    |
| ---------------------- | ---------------------------------------------------------- |
| **Abstraction**        | Reduces complexity by focusing only on essential features. |
| **Encapsulation**      | Protects data from unintended changes.                     |
| **Inheritance**        | Promotes code reuse and logical hierarchy.                 |
| **Polymorphism**       | Enables flexible and dynamic code behavior.                |
| **Public vs. Private** | Defines clear boundaries and improves reliability.         |

---

## 🧠 Summary

| Term                                           | Definition                                                      | Java Example                                   |
| ---------------------------------------------- | --------------------------------------------------------------- | ---------------------------------------------- |
| **Abstraction**                                | Hiding complex details to simplify usage                        | Abstract class or interface                    |
| **Object Orientation**                         | Organizing programs around objects that have state and behavior | `Car` class with attributes and methods        |
| **OOP Characteristics**                        | Encapsulation, Inheritance, Polymorphism, Abstraction           | Core features of Java                          |
| **Public Interface vs Private Implementation** | Separating what users can access from internal logic            | Public `deposit()`, private `logTransaction()` |

---
