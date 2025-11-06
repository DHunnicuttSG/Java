# 🧭 **Working with Classes and Objects in Java**

---

## 🎯 **Learning Objectives**

1. Create new types using classes.
2. Differentiate between **classes** and **objects**.
3. Explain and use **accessors (getters)** and **mutators (setters)**.
4. Use the **dot operator (.)** to access public properties or methods.
5. Use the **`this` keyword**.
6. Instantiate (create) an object.
7. Invoke (call) methods on an object.
8. Relate **constructors** to methods.
9. Apply the **`static` keyword** to methods and constants.

---

## 🧩 1. Creating New Types (Classes)

A **class** is a **blueprint** for creating new data types — custom types that group **data (fields)** and **behaviors (methods)** together.

### 🧠 Example:

```java
public class Car {
    // Fields (data)
    String brand;
    int speed;

    // Method (behavior)
    public void accelerate() {
        speed += 10;
        System.out.println(brand + " is now going " + speed + " mph.");
    }
}
```

Here, `Car` is a **new type** you’ve created.
Objects created from it (like `myCar`) will have their own `brand` and `speed` values.

---

## 🧩 2. Classes vs. Objects

| Concept    | Description                                  | Example                  |
| ---------- | -------------------------------------------- | ------------------------ |
| **Class**  | A blueprint or template for creating objects | `class Car { ... }`      |
| **Object** | A specific instance of a class               | `Car myCar = new Car();` |

### Example:

```java
Car car1 = new Car();
Car car2 = new Car();

car1.brand = "Toyota";
car2.brand = "Ford";
```

* `Car` → the **class**
* `car1` and `car2` → **objects** (individual instances with unique data)

---

## 🧩 3. Accessors and Mutators (Getters and Setters)

In Java, we often make fields **private** to protect data (encapsulation).
We then use **public methods** to read and modify these fields safely.

### Example:

```java
public class Student {
    private String name;  // private field

    // Accessor (getter)
    public String getName() {
        return name;
    }

    // Mutator (setter)
    public void setName(String newName) {
        name = newName;
    }
}
```

### Usage:

```java
Student s = new Student();
s.setName("Alice");                   // calls setter
System.out.println(s.getName());      // calls getter
```

**Why use them?**

* Protects internal data from unwanted changes.
* Allows validation or logic inside setters (e.g., reject negative grades).

---

## 🧩 4. The Dot Operator (`.`)

The **dot operator** lets you access:

* Public **fields** (data)
* Public **methods** (functions)
* Static **members** (class-level items)

### Example:

```java
Car myCar = new Car();
myCar.brand = "Honda";   // Access field
myCar.accelerate();      // Call method
```

Think of `.` as the “connect” operator between an object and its contents.

---

## 🧩 5. The `this` Keyword

The **`this`** keyword refers to the **current object** — the one that is executing the code.
It’s often used to:

* Differentiate between class fields and method parameters.
* Pass the current object to another method or constructor.

### Example:

```java
public class Car {
    String brand;

    public Car(String brand) {
        this.brand = brand;   // 'this.brand' = instance variable, 'brand' = parameter
    }

    public void showBrand() {
        System.out.println("This car is a " + this.brand);
    }
}
```

### Usage:

```java
Car myCar = new Car("Tesla");
myCar.showBrand();  // Output: This car is a Tesla
```

---

## 🧩 6. Instantiating an Object

Creating (or **instantiating**) an object means using the `new` keyword to make an instance of a class.

### Example:

```java
Car myCar = new Car("Honda");
```

This does three things:

1. Allocates memory for the new object.
2. Calls the class’s **constructor** to initialize it.
3. Returns a reference (`myCar`) to the new object.

---

## 🧩 7. Invoking a Method

To **invoke** (or call) a method, use the **dot operator** followed by the method name and parentheses.

### Example:

```java
myCar.accelerate();   // Calls the accelerate() method
```

If the method has parameters:

```java
myCar.accelerate(20);
```

---

## 🧩 8. Constructors vs. Methods

| Feature     | Constructor              | Method                     |
| ----------- | ------------------------ | -------------------------- |
| Purpose     | Initializes a new object | Defines object behavior    |
| Name        | Same as the class name   | Any valid identifier       |
| Return Type | None (not even void)     | Must have a return type    |
| Called When | Object is created        | Method is invoked manually |

### Example:

```java
public class Person {
    String name;

    // Constructor
    public Person(String name) {
        this.name = name;
    }

    // Method
    public void greet() {
        System.out.println("Hello, my name is " + name);
    }
}
```

### Usage:

```java
Person p = new Person("David");  // Constructor runs
p.greet();                       // Method runs
```

---

## 🧩 9. The `static` Keyword

`static` means that the field or method **belongs to the class**, not to any specific object.
You can access it **without creating an instance**.

### Example 1: Static Constant

```java
public class MathHelper {
    public static final double PI = 3.14159;
}
```

Use it:

```java
System.out.println(MathHelper.PI);  // Accessed through class name
```

### Example 2: Static Method

```java
public class Converter {
    public static double milesToKm(double miles) {
        return miles * 1.60934;
    }
}

public class Main {
    public static void main(String[] args) {
        double km = Converter.milesToKm(10);
        System.out.println("10 miles = " + km + " km");
    }
}
```

**Key points about `static`:**

* No need to create an object.
* Useful for utility or helper methods.
* `static final` is often used for constants.

---

## 🧠 **Summary Table**

| Concept            | Description                                | Example                            |
| ------------------ | ------------------------------------------ | ---------------------------------- |
| **Class**          | Blueprint for creating objects             | `class Car { ... }`                |
| **Object**         | Instance of a class                        | `Car myCar = new Car();`           |
| **Getter/Setter**  | Methods that read or modify private fields | `getName()`, `setName()`           |
| **Dot Operator**   | Accesses fields/methods                    | `myCar.accelerate()`               |
| **`this` Keyword** | Refers to the current object               | `this.brand = brand;`              |
| **Constructor**    | Initializes an object                      | `new Car("Honda")`                 |
| **Method**         | Defines behavior                           | `drive()`, `brake()`               |
| **Static**         | Belongs to the class, not an instance      | `Math.PI`, `Converter.milesToKm()` |

---
