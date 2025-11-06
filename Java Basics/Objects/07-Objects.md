Excellent — here’s a **comprehensive and classroom-ready section on Java objects and classes**, including clear examples of the **four pillars of Object-Oriented Programming (OOP)**:

> **Encapsulation**, **Inheritance**, **Polymorphism**, and **Abstraction**

This content is detailed enough for a lecture or a student handout, but still written in plain English with focused code examples.

---

## 🧩 **Java Objects and Classes — The Foundation of OOP**

### 🧠 What Is a Class?

A **class** is a **blueprint** or **template** for creating objects.
It defines **what data** (fields or attributes) and **what actions** (methods) an object can have.

Example:

```java
public class Car {
    // Fields (attributes)
    String brand;
    int year;
    
    // Method (behavior)
    public void startEngine() {
        System.out.println("Engine started...");
    }
}
```

### 🚗 What Is an Object?

An **object** is an **instance** of a class — a real-world example created from the blueprint.

```java
public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();       // Create object
        myCar.brand = "Toyota";
        myCar.year = 2022;
        myCar.startEngine();
        System.out.println(myCar.brand + " " + myCar.year);
    }
}
```

Output:

```
Engine started...
Toyota 2022
```

---

## ⚙️ **Basic Structure of a Java Class**

```java
public class ClassName {
    // 1. Fields (data)
    // 2. Constructors
    // 3. Methods (functions)
}
```

### Example:

```java
public class Student {
    String name;
    int age;

    // Constructor
    public Student(String n, int a) {
        name = n;
        age = a;
    }

    // Method
    public void displayInfo() {
        System.out.println(name + " is " + age + " years old.");
    }
}
```

Creating and using an object:

```java
Student s1 = new Student("Alice", 20);
s1.displayInfo();
```

---

## 🧩 **1️⃣ Encapsulation (Data Hiding)**

### 🧠 Concept:

Encapsulation means **protecting data** by keeping fields **private** and allowing access through **public methods (getters/setters)**.
This ensures that the internal state of an object can’t be directly changed from outside.

### 🧩 Example:

```java
public class BankAccount {
    private double balance;  // private field

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Getter
    public double getBalance() {
        return balance;
    }

    // Setter
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }
}
```

Usage:

```java
public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(500);
        acc.deposit(200);
        acc.withdraw(100);
        System.out.println("Balance: $" + acc.getBalance());
    }
}
```

✅ **Key Point:**
Encapsulation = **data + methods that protect data**.

---

## 🧩 **2️⃣ Inheritance (Code Reuse)**

### 🧠 Concept:

Inheritance allows one class to **inherit fields and methods** from another.
This helps with **code reuse** and hierarchical relationships.

### 🧩 Example:

```java
// Parent class
public class Animal {
    public void eat() {
        System.out.println("This animal eats food.");
    }
}

// Child class
public class Dog extends Animal {
    public void bark() {
        System.out.println("The dog barks.");
    }
}
```

Usage:

```java
public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();   // inherited method
        d.bark();  // child’s own method
    }
}
```

Output:

```
This animal eats food.
The dog barks.
```

✅ **Key Point:**
`extends` keyword is used for inheritance.
Child classes **reuse and extend** the parent’s behavior.

---

## 🧩 **3️⃣ Polymorphism (Many Forms)**

### 🧠 Concept:

Polymorphism means that the **same method name** can behave **differently** depending on the **object that calls it**.

There are **two main types**:

1. **Compile-time polymorphism** → achieved by **method overloading**
2. **Runtime polymorphism** → achieved by **method overriding**

---

### 🧩 Example: **Method Overloading (Compile-Time)**

Same method name, different parameters.

```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public double add(double a, double b) {
        return a + b;
    }
}
```

Usage:

```java
Calculator c = new Calculator();
System.out.println(c.add(2, 3));       // calls int version
System.out.println(c.add(2.5, 3.5));   // calls double version
```

---

### 🧩 Example: **Method Overriding (Runtime)**

A child class **redefines** a parent method.

```java
class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal a2 = new Cat();  // upcasting
        a1.sound();  // Animal version
        a2.sound();  // Cat version (overridden)
    }
}
```

Output:

```
Animal makes a sound
Cat meows
```

✅ **Key Point:**
Polymorphism allows **different objects** to respond to the **same message** in different ways.

---

## 🧩 **4️⃣ Abstraction (Simplifying Complexity)**

### 🧠 Concept:

Abstraction means **showing only essential features** and **hiding the details**.
It’s like using a TV remote — you know what the buttons do, but not the circuitry inside.

Achieved in Java using:

* **Abstract classes**
* **Interfaces**

---

### 🧩 Example: Abstract Class

```java
abstract class Shape {
    abstract void draw();   // abstract method (no body)

    public void display() {
        System.out.println("This is a shape.");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing a circle...");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape s = new Circle();
        s.display();
        s.draw();
    }
}
```

Output:

```
This is a shape.
Drawing a circle...
```

✅ **Key Point:**
Abstract classes **cannot be instantiated**, only extended.

---

### 🧩 Example: Interface

```java
interface Vehicle {
    void start();
    void stop();
}

class Bike implements Vehicle {
    public void start() {
        System.out.println("Bike starting...");
    }
    public void stop() {
        System.out.println("Bike stopping...");
    }
}
```

Usage:

```java
Vehicle v = new Bike();
v.start();
v.stop();
```

✅ **Key Point:**
Interfaces define a **contract** — a set of methods that a class **must implement**.

---

## 🧠 **Summary Table — OOP Pillars**

| Concept           | Description                                         | Keyword                         | Example                     |
| ----------------- | --------------------------------------------------- | ------------------------------- | --------------------------- |
| **Encapsulation** | Hiding data using private fields and public methods | `private`, `get`, `set`         | `BankAccount`               |
| **Inheritance**   | Reusing code from another class                     | `extends`                       | `Dog extends Animal`        |
| **Polymorphism**  | One name, many forms                                | `@Override`, method overloading | `sound()` in `Animal`/`Cat` |
| **Abstraction**   | Hiding details and showing essentials               | `abstract`, `interface`         | `Shape`, `Vehicle`          |

---

## 💬 **Key Takeaways**

* Classes define structure; objects are real instances.
* Use encapsulation to protect data.
* Inheritance promotes reuse and relationships.
* Polymorphism allows flexibility and code generalization.
* Abstraction hides implementation details to reduce complexity.

---

# 🧩 **Java OOP Practice Worksheet**

Designed for **students learning Java classes and objects**, focusing on **Encapsulation, Inheritance, Polymorphism, and Abstraction**.
You’ll find an **Answer Key** after the exercises.  

## 🧠 **Instructions**

Each exercise below asks you to write or correct Java code using **classes and objects**.
You may use any IDE or online compiler (such as Replit or JDoodle).
Pay attention to **access modifiers**, **constructors**, and **method overriding**.

---

## **Part 1 – Working with Classes and Objects**

### 🧩 Exercise 1: Create a Simple Class

Create a class called `Book` with:

* Fields: `title`, `author`, and `price`
* A constructor to set all fields
* A method `displayInfo()` that prints the book details

**In `main()`**, create two books and display their information.

---

### 🧩 Exercise 2: Encapsulation

Create a class `Student` with:

* Private fields: `name`, `grade`
* Public getters and setters for each
* A method `display()` that prints the student’s name and grade.

In your `main()` method:

* Create a student object.
* Use setters to assign values, and getters to print them.

**Goal:** Practice protecting data using encapsulation.

---

### 🧩 Exercise 3: Inheritance

Create:

* A **base class** `Employee` with a method `work()` that prints `"Employee is working"`.
* A **child class** `Manager` that inherits from `Employee` and adds a method `manage()` printing `"Manager is managing the team"`.

In `main()`:

* Create a `Manager` object and call both `work()` and `manage()`.

**Goal:** Understand how inheritance allows one class to use another’s methods.

---

## **Part 2 – Polymorphism**

### 🧩 Exercise 4: Method Overloading

Create a class `MathHelper` with two versions of a method `add()`:

* One takes two integers and returns their sum.
* The other takes three integers and returns their total.

In `main()`, test both versions.

---

### 🧩 Exercise 5: Method Overriding (Runtime Polymorphism)

Create:

* A class `Animal` with a method `makeSound()` printing `"Some sound"`.
* A class `Dog` that extends `Animal` and **overrides** `makeSound()` to print `"Woof!"`.

In `main()`:

* Create both an `Animal` and a `Dog` object, call `makeSound()` on both, and observe the difference.

**Goal:** Show how subclass methods replace parent behavior.

---

## **Part 3 – Abstraction and Interfaces**

### 🧩 Exercise 6: Abstract Class

Create:

* An abstract class `Shape` with:

  * An abstract method `area()`.
  * A concrete method `display()` that prints `"Calculating area..."`.
* Two subclasses:

  * `Circle` with a field `radius`
  * `Rectangle` with fields `length` and `width`

Override the `area()` method in each subclass.

In `main()`:

* Create a `Shape` reference to a `Circle` and `Rectangle`.
* Call `display()` and `area()` on each.

---

### 🧩 Exercise 7: Interface Implementation

Create:

* An interface `Playable` with methods `play()` and `pause()`.
* Classes `Guitar` and `Piano` that implement this interface and define their own `play()` and `pause()` behavior.

In `main()`:

* Use a `Playable` reference to call the methods on both instruments.

---

## **Part 4 – Combined Challenge**

### 🧩 Exercise 8: Mini OOP System – Appliances

1. Create an **abstract class** `Appliance` with:

   * Fields: `brand`, `powerWatts`
   * An abstract method `operate()`
   * A concrete method `plugIn()` that prints `"Appliance is now plugged in."`

2. Create subclasses:

   * `Washer` → prints `"Washing clothes..."` in `operate()`
   * `Dryer` → prints `"Drying clothes..."` in `operate()`

3. In `main()`:

   * Create an array of `Appliance` objects (one `Washer` and one `Dryer`)
   * Iterate through the array and call both `plugIn()` and `operate()` for each.

**Goal:** Demonstrate all four OOP pillars in one program.

---

# 🧠 **Answer Key**

---

### ✅ **Exercise 1 — Book**

```java
public class Book {
    String title;
    String author;
    double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println(title + " by " + author + " costs $" + price);
    }

    public static void main(String[] args) {
        Book b1 = new Book("1984", "George Orwell", 12.99);
        Book b2 = new Book("Dune", "Frank Herbert", 15.50);
        b1.displayInfo();
        b2.displayInfo();
    }
}
```

---

### ✅ **Exercise 2 — Student (Encapsulation)**

```java
public class Student {
    private String name;
    private int grade;

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public void display() {
        System.out.println(name + " has grade " + grade);
    }

    public static void main(String[] args) {
        Student s = new Student();
        s.setName("Alice");
        s.setGrade(90);
        s.display();
    }
}
```

---

### ✅ **Exercise 3 — Inheritance**

```java
class Employee {
    public void work() {
        System.out.println("Employee is working");
    }
}

class Manager extends Employee {
    public void manage() {
        System.out.println("Manager is managing the team");
    }

    public static void main(String[] args) {
        Manager m = new Manager();
        m.work();
        m.manage();
    }
}
```

---

### ✅ **Exercise 4 — Method Overloading**

```java
public class MathHelper {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        MathHelper m = new MathHelper();
        System.out.println(m.add(5, 10));
        System.out.println(m.add(3, 4, 5));
    }
}
```

---

### ✅ **Exercise 5 — Method Overriding**

```java
class Animal {
    public void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal a2 = new Dog();
        a1.makeSound();
        a2.makeSound();
    }
}
```

---

### ✅ **Exercise 6 — Abstraction (Abstract Class)**

```java
abstract class Shape {
    abstract void area();

    public void display() {
        System.out.println("Calculating area...");
    }
}

class Circle extends Shape {
    double radius = 5;

    void area() {
        System.out.println("Circle area = " + (Math.PI * radius * radius));
    }
}

class Rectangle extends Shape {
    double length = 4, width = 3;

    void area() {
        System.out.println("Rectangle area = " + (length * width));
    }

    public static void main(String[] args) {
        Shape s1 = new Circle();
        Shape s2 = new Rectangle();
        s1.display(); s1.area();
        s2.display(); s2.area();
    }
}
```

---

### ✅ **Exercise 7 — Interface**

```java
interface Playable {
    void play();
    void pause();
}

class Guitar implements Playable {
    public void play() {
        System.out.println("Strumming the guitar...");
    }
    public void pause() {
        System.out.println("Guitar paused.");
    }
}

class Piano implements Playable {
    public void play() {
        System.out.println("Playing the piano...");
    }
    public void pause() {
        System.out.println("Piano paused.");
    }

    public static void main(String[] args) {
        Playable g = new Guitar();
        Playable p = new Piano();
        g.play(); g.pause();
        p.play(); p.pause();
    }
}
```

---

### ✅ **Exercise 8 — Appliances (All OOP Pillars)**

```java
abstract class Appliance {
    String brand;
    int powerWatts;

    public Appliance(String brand, int powerWatts) {
        this.brand = brand;
        this.powerWatts = powerWatts;
    }

    public void plugIn() {
        System.out.println(brand + " appliance is now plugged in.");
    }

    abstract void operate();
}

class Washer extends Appliance {
    public Washer(String brand, int powerWatts) {
        super(brand, powerWatts);
    }

    void operate() {
        System.out.println("Washing clothes...");
    }
}

class Dryer extends Appliance {
    public Dryer(String brand, int powerWatts) {
        super(brand, powerWatts);
    }

    void operate() {
        System.out.println("Drying clothes...");
    }

    public static void main(String[] args) {
        Appliance[] appliances = {
            new Washer("LG", 1200),
            new Dryer("Samsung", 1500)
        };

        for (Appliance app : appliances) {
            app.plugIn();
            app.operate();
        }
    }
}
```

---
