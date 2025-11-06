# 🧩 **Abstract Classes in Java**

---

## 🎯 **Learning Objectives**

1. Define what an **abstract class** is.
2. Explain the difference between **abstract** and **concrete** methods.
3. Understand **why and when** to use abstract classes.
4. Extend abstract classes and override abstract methods.
5. Compare abstract classes with interfaces.
6. Build a simple **inheritance hierarchy** using abstraction.

---

## 🧠 **1. What Is an Abstract Class?**

An **abstract class** in Java is a class that **cannot be instantiated** on its own.
It serves as a **blueprint** for other classes.

It may contain:

* **Abstract methods** → declared but not implemented.
* **Concrete methods** → fully implemented.
* **Fields**, **constructors**, and **static members**.

Abstract classes are defined using the `abstract` keyword.

---

### 🧩 Example: Basic Abstract Class

```java
abstract class Animal {
    abstract void makeSound();  // abstract method (no body)

    void sleep() {              // concrete method
        System.out.println("Zzz...");
    }
}
```

* `abstract` keyword before class name → makes it abstract.
* The `makeSound()` method has no body → subclasses must implement it.
* The `sleep()` method has a body → subclasses inherit it as is.

---

### 🧩 Extending an Abstract Class

To use an abstract class, another class must **extend** it and **implement its abstract methods**.

```java
class Dog extends Animal {
    void makeSound() {
        System.out.println("Woof!");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("Meow!");
    }
}
```

### Usage:

```java
public class TestAnimals {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.makeSound();  // Woof!
        a1.sleep();      // Zzz...
        a2.makeSound();  // Meow!
    }
}
```

✅ The abstract class defines a **template**, and each subclass fills in the details.

---

## 🧠 **2. Why Use Abstract Classes?**

Abstract classes let you:

* **Define shared behavior** (methods and fields).
* **Force subclasses** to implement specific methods.
* **Model real-world hierarchies** (e.g., `Shape`, `Vehicle`, `Employee`).
* Provide **partial implementation** that child classes can build upon.

Think of it as a **base class with a contract**.

---

### 🧩 Example: Vehicle Blueprint

```java
abstract class Vehicle {
    String brand = "Generic";

    abstract void startEngine();  // subclasses must define this

    void fuelUp() {
        System.out.println("Vehicle refueled.");
    }
}
```

### Concrete Subclass:

```java
class Car extends Vehicle {
    void startEngine() {
        System.out.println("Car engine started with a key.");
    }
}

class ElectricCar extends Vehicle {
    void startEngine() {
        System.out.println("Electric car started silently.");
    }
}
```

### Usage:

```java
public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle v1 = new Car();
        Vehicle v2 = new ElectricCar();

        v1.startEngine();
        v2.startEngine();
        v1.fuelUp();
    }
}
```

**Output:**

```
Car engine started with a key.
Electric car started silently.
Vehicle refueled.
```

✅ Both `Car` and `ElectricCar` share common behavior from `Vehicle` but implement their own versions of `startEngine()`.

---

## 🧠 **3. Abstract Methods**

An **abstract method**:

* Has no body.
* Must be implemented by subclasses.
* Cannot be declared `static`, `final`, or `private`.

**Syntax:**

```java
abstract void methodName();
```

### Example:

```java
abstract class Shape {
    abstract double area();  // must be implemented by subclasses
}
```

### Subclass:

```java
class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }
}
```

### Usage:

```java
public class ShapeTest {
    public static void main(String[] args) {
        Shape c = new Circle(3.0);
        System.out.println("Area: " + c.area());
    }
}
```

**Output:**

```
Area: 28.274333882308138
```

---

## 🧠 **4. Constructors in Abstract Classes**

Abstract classes **can have constructors**, which are called when a subclass object is created.
This allows them to **initialize common fields**.

### Example:

```java
abstract class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract void work();
}
```

### Subclass:

```java
class Manager extends Employee {
    Manager(String name, double salary) {
        super(name, salary);  // calls abstract class constructor
    }

    void work() {
        System.out.println(name + " is managing the team.");
    }
}

public class TestEmployee {
    public static void main(String[] args) {
        Employee e = new Manager("Alice", 75000);
        e.work();
    }
}
```

**Output:**

```
Alice is managing the team.
```

✅ Even though you can’t instantiate `Employee`, its constructor still runs when creating a `Manager`.

---

## 🧠 **5. Abstract Class Hierarchies**

Abstract classes can inherit from other abstract classes, forming **multi-level abstractions**.

### Example:

```java
abstract class Machine {
    abstract void powerOn();
}

abstract class Computer extends Machine {
    abstract void boot();
}

class Laptop extends Computer {
    void powerOn() {
        System.out.println("Laptop powered on.");
    }

    void boot() {
        System.out.println("Laptop booting OS...");
    }
}
```

**Usage:**

```java
public class MachineTest {
    public static void main(String[] args) {
        Laptop myLaptop = new Laptop();
        myLaptop.powerOn();
        myLaptop.boot();
    }
}
```

**Output:**

```
Laptop powered on.
Laptop booting OS...
```

✅ Each subclass adds more specialized behavior while inheriting core responsibilities.

---

## 🧠 **6. Abstract Classes vs Interfaces**

| Feature           | Abstract Class                         | Interface                                  |
| ----------------- | -------------------------------------- | ------------------------------------------ |
| **Keyword**       | `abstract class`                       | `interface`                                |
| **Instantiation** | Cannot instantiate                     | Cannot instantiate                         |
| **Methods**       | Can have abstract and concrete methods | Only abstract, default, and static methods |
| **Fields**        | Can have instance variables            | Only `public static final` constants       |
| **Constructors**  | Yes                                    | No                                         |
| **Inheritance**   | Extends one class                      | Implements multiple interfaces             |
| **Use Case**      | For related classes with shared code   | For defining contracts and capabilities    |

---

### 🧩 Example Comparison

#### Abstract Class:

```java
abstract class Shape {
    abstract double area();
    void describe() {
        System.out.println("This is a shape.");
    }
}
```

#### Interface:

```java
interface Drawable {
    void draw();
}
```

#### Concrete Class:

```java
class Rectangle extends Shape implements Drawable {
    double width, height;

    Rectangle(double w, double h) {
        width = w;
        height = h;
    }

    double area() {
        return width * height;
    }

    public void draw() {
        System.out.println("Drawing a rectangle.");
    }
}
```

---

## 🧠 **7. Abstract Classes and Polymorphism**

Abstract classes enable **runtime polymorphism** — different subclasses can be treated as one base type.

### Example:

```java
abstract class Payment {
    abstract void processPayment();
}

class CreditCardPayment extends Payment {
    void processPayment() {
        System.out.println("Processing credit card payment.");
    }
}

class PayPalPayment extends Payment {
    void processPayment() {
        System.out.println("Processing PayPal payment.");
    }
}

public class PaymentTest {
    public static void main(String[] args) {
        Payment p1 = new CreditCardPayment();
        Payment p2 = new PayPalPayment();

        p1.processPayment();
        p2.processPayment();
    }
}
```

**Output:**

```
Processing credit card payment.
Processing PayPal payment.
```

✅ Both subclasses implement the same abstract method differently — a classic example of **polymorphism**.

---

## 🧠 **8. Rules Summary**

| Rule                            | Description                       |
| ------------------------------- | --------------------------------- |
| Use `abstract` keyword          | Before class or method            |
| Cannot instantiate directly     | You must create a subclass        |
| May have constructors           | For initializing fields           |
| May contain concrete methods    | To share common code              |
| Must implement abstract methods | In concrete subclasses            |
| Cannot be `final`               | Because subclasses must extend it |

---

## 🧠 **9. Real-World Analogy**

Imagine a company’s HR system:

* `Employee` is abstract (no “generic” employee object).
* `FullTimeEmployee`, `PartTimeEmployee`, and `Intern` are concrete subclasses.
* The base class defines shared behavior (`getName()`, `getSalary()`), while each subclass customizes the calculation of benefits or pay.

---

## 🧩 **10. Key Takeaways**

* Abstract classes define a **template** for other classes.
* They combine **abstraction** and **code reuse**.
* Subclasses **extend** them and **override** abstract methods.
* They are perfect for building **hierarchies** of related types.
* Interfaces define **contracts**, abstract classes define **shared structure + contracts**.

---

### ✅ Quick Example Summary

```java
abstract class Appliance {
    abstract void turnOn();
    void plugIn() {
        System.out.println("Plugged into power.");
    }
}

class Fan extends Appliance {
    void turnOn() {
        System.out.println("Fan is spinning.");
    }
}

public class Test {
    public static void main(String[] args) {
        Appliance fan = new Fan();
        fan.plugIn();
        fan.turnOn();
    }
}
```

**Output:**

```
Plugged into power.
Fan is spinning.
```

---
