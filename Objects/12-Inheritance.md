# 🧩 **Inheritance in Java**

---

## 🎯 **Learning Objectives**

1. Explain how everything in Java extends `Object`.
2. Define **parent (super/base)** and **child (sub/derived)** classes.
3. Use access control (`public`, `protected`, `private`) in inheritance.
4. Distinguish **is-a** vs **has-a** relationships.
5. Explain the **benefits of a well-designed inheritance hierarchy**.
6. Reuse code through inheritance.
7. **Overload** methods.
8. Understand **constructors** in base and derived classes.
9. Use **polymorphism** with inheritance.
10. Relate **abstract classes** and **interfaces** to inheritance.

---

## 🧠 **1. Everything Extends `Object`**

In Java, **every class** implicitly extends the `Object` class, either directly or indirectly.
This makes `Object` the **root** of the class hierarchy.

```java
public class Example {
    // Implicitly extends java.lang.Object
}
```

So, whether you define:

```java
class Animal { }
class Dog extends Animal { }
```

Behind the scenes:

```
Object
  └── Animal
        └── Dog
```

✅ This means every object in Java inherits methods from `Object`, such as:

* `toString()`
* `equals(Object obj)`
* `hashCode()`
* `getClass()`

### Example:

```java
class Car {
    String model = "Sedan";
}

public class TestObject {
    public static void main(String[] args) {
        Car c = new Car();
        System.out.println(c.toString());  // Inherited from Object
    }
}
```

---

## 🧠 **2. Parent (Base, Superclass)** and **Child (Derived, Subclass)**

### **Parent Class (Superclass)**

A **parent class** is the class being inherited from.
Synonyms: *base class*, *superclass*.

### **Child Class (Subclass)**

A **child class** is the class that inherits.
Synonyms: *derived class*, *subclass*, *extended class*.

---

### 🧩 Example:

```java
class Animal {                     // Parent class
    void eat() {
        System.out.println("This animal eats food.");
    }
}

class Dog extends Animal {         // Child class
    void bark() {
        System.out.println("Dog barks.");
    }
}

public class TestInheritance {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();   // Inherited from Animal
        d.bark();  // Defined in Dog
    }
}
```

**Output:**

```
This animal eats food.
Dog barks.
```

✅ The `Dog` inherits all **non-private members** from `Animal`.

---

## 🧠 **3. Access Control in Inheritance**

Access modifiers determine what members of a class can be inherited or accessed by subclasses.

| Modifier                    | Same Class | Same Package | Subclass | Other Package |
| --------------------------- | ---------- | ------------ | -------- | ------------- |
| `public`                    | ✅          | ✅            | ✅        | ✅             |
| `protected`                 | ✅          | ✅            | ✅        | ❌             |
| (default / package-private) | ✅          | ✅            | ❌        | ❌             |
| `private`                   | ✅          | ❌            | ❌        | ❌             |

---

### Example:

```java
class Parent {
    public int x = 10;
    protected int y = 20;
    private int z = 30;

    public void showValues() {
        System.out.println(x + " " + y + " " + z);
    }
}

class Child extends Parent {
    void display() {
        System.out.println(x);  // ✅
        System.out.println(y);  // ✅
        // System.out.println(z); // ❌ private not accessible
    }
}
```

✅ `protected` allows subclasses (even in different packages) to access the member.

---

## 🧠 **4. IS-A vs HAS-A Relationships**

### **IS-A Relationship (Inheritance)**

Represents a relationship where one class **is a type of** another.

Example:
`Dog IS-A Animal`
`Car IS-A Vehicle`

```java
class Animal { }
class Dog extends Animal { }
```

✅ Use `extends` for IS-A.

---

### **HAS-A Relationship (Composition)**

Represents **containment** — one class contains another as a field.

Example:
`Car HAS-A Engine`

```java
class Engine { }
class Car {
    private Engine engine = new Engine();  // HAS-A relationship
}
```

✅ Use **composition** when an object *uses* another object rather than *is a type of* it.

---

## 🧠 **5. Benefits of a Well-Designed Inheritance Hierarchy**

* **Code Reuse** → Common behavior defined once in base class.
* **Readability & Maintainability** → Logical organization of related classes.
* **Polymorphism** → Treat related objects uniformly.
* **Extensibility** → Add new types easily without changing existing code.

### Example Hierarchy

```
Object
  └── Shape
        ├── Circle
        ├── Rectangle
        └── Triangle
```

Each subclass shares `Shape`’s behavior and adds its own.

---

## 🧠 **6. Reusing Code Through Inheritance**

Parent methods are **inherited** by subclasses and can be used directly or overridden.

```java
class Employee {
    void work() {
        System.out.println("Employee working...");
    }
}

class Manager extends Employee {
    void manage() {
        System.out.println("Manager supervising team.");
    }
}

public class Office {
    public static void main(String[] args) {
        Manager m = new Manager();
        m.work();   // Reused from Employee
        m.manage(); // Defined in Manager
    }
}
```

---

## 🧠 **7. Method Overloading**

**Overloading** means defining multiple methods with the same name but different **parameters**.

### Example:

```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

✅ Overloading improves flexibility and code readability.

---

## 🧠 **8. Constructors with Base and Derived Classes**

When a subclass object is created, **the parent constructor runs first**, then the child’s.

### Example:

```java
class Animal {
    Animal() {
        System.out.println("Animal constructor called.");
    }
}

class Dog extends Animal {
    Dog() {
        System.out.println("Dog constructor called.");
    }
}

public class TestConstructor {
    public static void main(String[] args) {
        new Dog();
    }
}
```

**Output:**

```
Animal constructor called.
Dog constructor called.
```

✅ You can use `super()` to explicitly call a specific superclass constructor.

---

### 🧩 Example with Parameters

```java
class Animal {
    String name;

    Animal(String n) {
        name = n;
        System.out.println("Animal: " + name);
    }
}

class Dog extends Animal {
    Dog(String n) {
        super(n); // Call parent constructor
        System.out.println("Dog created: " + n);
    }
}
```

**Output:**

```
Animal: Buddy
Dog created: Buddy
```

---

## 🧠 **9. Polymorphism with Inheritance**

**Polymorphism** allows one reference type to refer to objects of different classes.

### Example:

```java
class Shape {
    void draw() {
        System.out.println("Drawing a shape.");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing a circle.");
    }
}

class Square extends Shape {
    void draw() {
        System.out.println("Drawing a square.");
    }
}

public class TestPolymorphism {
    public static void main(String[] args) {
        Shape s;

        s = new Circle();
        s.draw();   // Circle version

        s = new Square();
        s.draw();   // Square version
    }
}
```

**Output:**

```
Drawing a circle.
Drawing a square.
```

✅ The `Shape` reference can refer to any subclass — method calls are resolved at runtime (**dynamic binding**).

---

## 🧠 **10. Relating Abstract Classes and Interfaces**

### Abstract Base Class

* Can contain **both abstract and concrete methods**.
* Provides a **partial implementation**.

### Interface

* Defines a **contract** for what must be done.
* Contains only **method signatures** (plus optional `default` and `static` methods).

---

### Example Combining All Three

```java
interface Drawable {
    void draw();
}

abstract class Shape implements Drawable {
    abstract double area();

    void describe() {
        System.out.println("This is a shape.");
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }

    public void draw() {
        System.out.println("Drawing a circle.");
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        Shape s = new Circle(5);
        s.describe();
        s.draw();
        System.out.println("Area: " + s.area());
    }
}
```

**Output:**

```
This is a shape.
Drawing a circle.
Area: 78.53981633974483
```

✅ This example ties inheritance, abstraction, and interfaces together:

* `Shape` is the **abstract base class**.
* `Circle` is the **concrete subclass**.
* `Drawable` is the **interface** that adds capability.

---

## 🧠 **Summary Table**

| Concept            | Description                            | Example                               |
| ------------------ | -------------------------------------- | ------------------------------------- |
| **Parent Class**   | Class being inherited from             | `class Animal {}`                     |
| **Child Class**    | Class that inherits                    | `class Dog extends Animal {}`         |
| **IS-A**           | Inheritance relationship               | `Dog IS-A Animal`                     |
| **HAS-A**          | Composition relationship               | `Car HAS-A Engine`                    |
| **Overloading**    | Same method name, different parameters | `add(int,int)` / `add(double,double)` |
| **Polymorphism**   | Base type, multiple behaviors          | `Shape s = new Circle();`             |
| **super()**        | Calls base constructor                 | `super(name);`                        |
| **Object class**   | Root of all classes                    | `toString()`, `equals()`              |
| **Abstract Class** | Base class with partial implementation | `abstract class Shape {}`             |
| **Interface**      | Defines behavior contract              | `interface Drawable {}`               |

---

## 🧩 **Key Takeaways**

* Every Java class extends `Object`.
* A **child class** inherits from a **parent class** using `extends`.
* Use **access modifiers** to control visibility of inherited members.
* Use **IS-A** for inheritance and **HAS-A** for composition.
* Inheritance promotes **reuse**, **organization**, and **polymorphism**.
* **Constructors** in base classes run before subclass constructors.
* **Method overloading** provides multiple versions of a method with different parameters.
* **Abstract classes** and **interfaces** define shared structure and behavior for inheritance hierarchies.

---
