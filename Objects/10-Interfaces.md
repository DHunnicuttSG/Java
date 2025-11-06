# 🧩 **Understanding Interfaces in Java**

---

## 🎯 **Learning Objectives**

1. Define what an **interface** is in Java.
2. Explain how interfaces support **abstraction** and **polymorphism**.
3. Create and implement interfaces.
4. Understand **multiple interface inheritance**.
5. Compare **interfaces vs. abstract classes**.
6. Use **default** and **static** methods in interfaces.

---

## 🧠 **1. What Is an Interface?**

An **interface** in Java is a **contract** that defines a set of methods a class must implement.

It tells you **what** a class should do, but **not how** to do it.

Think of it like a **remote control** — it defines buttons (methods), but not the inner workings of the device (implementation).

---

### 🧩 Example: Simple Interface

```java
public interface Animal {
    void makeSound();   // method without body
}
```

* `interface` keyword defines the interface.
* Methods in an interface are **implicitly abstract** and **public**.
* You cannot create an instance of an interface directly.

---

### 🧩 Implementing an Interface

A class uses the `implements` keyword to agree to follow the interface’s contract.

```java
public class Dog implements Animal {
    public void makeSound() {       // must use public
        System.out.println("Woof!");
    }
}
```

### Usage:

```java
public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound();           // Output: Woof!
    }
}
```

✅ The `Dog` class provides the **implementation** of the `makeSound()` method defined by the interface.

---

## 🧠 **2. Purpose of Interfaces**

Interfaces are used to:

* **Achieve abstraction** — focus on what an object can do, not how.
* **Support polymorphism** — treat different classes the same way if they share the same interface.
* **Enable multiple inheritance of behavior** — classes can implement multiple interfaces.

---

### 🧩 Example: Multiple Implementations

```java
public class Cat implements Animal {
    public void makeSound() {
        System.out.println("Meow!");
    }
}

public class Cow implements Animal {
    public void makeSound() {
        System.out.println("Moo!");
    }
}
```

### Usage:

```java
public class TestSounds {
    public static void main(String[] args) {
        Animal[] animals = { new Dog(), new Cat(), new Cow() };
        for (Animal a : animals) {
            a.makeSound();
        }
    }
}
```

**Output:**

```
Woof!
Meow!
Moo!
```

✅ Different objects respond to the same method in their own way — **polymorphism in action**.

---

## 🧠 **3. Interfaces vs. Abstract Classes**

| Feature                   | Interface                                           | Abstract Class                              |
| ------------------------- | --------------------------------------------------- | ------------------------------------------- |
| **Keyword**               | `interface`                                         | `abstract class`                            |
| **Method Implementation** | Cannot have regular methods (except default/static) | Can have both abstract and concrete methods |
| **Fields**                | Must be `public static final` (constants)           | Can have instance variables                 |
| **Multiple Inheritance**  | A class can implement multiple interfaces           | A class can extend only one abstract class  |
| **Use Case**              | Defines a contract (capabilities)                   | Defines a base class (common behavior)      |

---

### 🧩 Example Comparison

#### Interface:

```java
interface Drivable {
    void start();
    void stop();
}
```

#### Abstract Class:

```java
abstract class Vehicle {
    String brand;
    void fuelUp() {
        System.out.println("Vehicle refueled.");
    }
}
```

#### Implementing Both:

```java
class Car extends Vehicle implements Drivable {
    void start() { System.out.println("Car started."); }
    void stop() { System.out.println("Car stopped."); }
}
```

✅ This shows how interfaces describe behavior, while abstract classes can provide shared functionality.

---

## 🧠 **4. Multiple Interfaces**

Java allows a class to implement **more than one interface**, which is one of the ways Java achieves **multiple inheritance of type**.

### Example:

```java
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    public void fly() {
        System.out.println("Duck is flying.");
    }
    public void swim() {
        System.out.println("Duck is swimming.");
    }
}

public class TestDuck {
    public static void main(String[] args) {
        Duck d = new Duck();
        d.fly();
        d.swim();
    }
}
```

**Output:**

```
Duck is flying.
Duck is swimming.
```

✅ The `Duck` class inherits behavior contracts from both `Flyable` and `Swimmable`.

---

## 🧠 **5. Default and Static Methods in Interfaces (Java 8+)**

In modern Java, interfaces can contain **default** and **static** methods.
These allow adding functionality without breaking existing implementations.

---

### 🧩 Default Methods

A **default method** has a body and provides a default implementation.

```java
interface Printer {
    default void print() {
        System.out.println("Printing a document...");
    }
}
```

### Usage:

```java
class InkjetPrinter implements Printer {
    // Inherits print() by default
}

public class TestPrinter {
    public static void main(String[] args) {
        InkjetPrinter printer = new InkjetPrinter();
        printer.print();   // Output: Printing a document...
    }
}
```

✅ Classes can **override** default methods if they want different behavior.

---

### 🧩 Static Methods in Interfaces

A **static method** belongs to the interface itself, not to any object.

```java
interface MathHelper {
    static int add(int a, int b) {
        return a + b;
    }
}
```

### Usage:

```java
public class Main {
    public static void main(String[] args) {
        int sum = MathHelper.add(5, 7);  // Accessed using the interface name
        System.out.println("Sum = " + sum);
    }
}
```

**Output:**

```
Sum = 12
```

✅ Static methods in interfaces are useful for **utility functions** related to the interface’s purpose.

---

## 🧠 **6. Interface Inheritance**

Just like classes, interfaces can extend **other interfaces**.

### Example:

```java
interface Animal {
    void eat();
}

interface Pet extends Animal {
    void play();
}

class Dog implements Pet {
    public void eat() {
        System.out.println("Dog is eating.");
    }

    public void play() {
        System.out.println("Dog is playing.");
    }
}
```

**Output:**

```
Dog is eating.
Dog is playing.
```

✅ The `Pet` interface inherits the behavior of `Animal`, and the `Dog` must implement both.

---

## 🧩 **7. Practical Use Case Example**

Imagine you’re building a media app that can **play** and **pause** different types of content — audio, video, etc.

### Interface Definition

```java
public interface Playable {
    void play();
    void pause();
}
```

### Implementing Classes

```java
public class AudioPlayer implements Playable {
    public void play() {
        System.out.println("Playing audio...");
    }
    public void pause() {
        System.out.println("Audio paused.");
    }
}

public class VideoPlayer implements Playable {
    public void play() {
        System.out.println("Playing video...");
    }
    public void pause() {
        System.out.println("Video paused.");
    }
}
```

### Using Polymorphism

```java
public class MediaTest {
    public static void main(String[] args) {
        Playable[] players = { new AudioPlayer(), new VideoPlayer() };
        for (Playable p : players) {
            p.play();
            p.pause();
        }
    }
}
```

**Output:**

```
Playing audio...
Audio paused.
Playing video...
Video paused.
```

✅ Both classes can be treated as `Playable` objects even though they behave differently — that’s the power of **interfaces + polymorphism**.

---

## 🧠 **8. Key Takeaways**

| Concept                   | Description                                            | Example                                    |
| ------------------------- | ------------------------------------------------------ | ------------------------------------------ |
| **Interface**             | A contract that defines methods a class must implement | `interface Animal { void makeSound(); }`   |
| **Implements**            | Keyword to connect a class to an interface             | `class Dog implements Animal { ... }`      |
| **Multiple Interfaces**   | A class can implement more than one interface          | `class Duck implements Flyable, Swimmable` |
| **Default Method**        | Has a method body inside interface                     | `default void print() { ... }`             |
| **Static Method**         | Called using the interface name                        | `MathHelper.add(3,4)`                      |
| **Interface Inheritance** | Interface can extend another                           | `interface Pet extends Animal`             |

---

## 🧠 **Summary**

* Interfaces define **what** methods a class must implement — not **how**.
* They provide a way to achieve **abstraction** and **polymorphism**.
* Classes can **implement multiple interfaces**, supporting **multiple inheritance of type**.
* Modern Java allows **default** and **static** methods inside interfaces.
* Interfaces are used heavily in frameworks, APIs, and real-world Java development (e.g., `Comparable`, `Runnable`, `List`).

---
