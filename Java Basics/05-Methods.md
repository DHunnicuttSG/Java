## 🧩 **Java Methods

### 🧠 What Is a Method?

A **method** is a block of code that performs a specific task.
It helps make code **modular**, **reusable**, and **easier to understand**.

---

### ⚙️ **General Method Syntax**

```java
accessModifier returnType methodName(parameterList) {
    // method body
    // code to perform task
    return value;  // optional, depends on returnType
}
```

---

### 🧩 **Parts of a Method**

| Part               | Description                                            | Example             |
| ------------------ | ------------------------------------------------------ | ------------------- |
| **accessModifier** | Controls visibility (e.g., `public`, `private`)        | `public`            |
| **returnType**     | Type of value returned (`int`, `double`, `void`, etc.) | `int`               |
| **methodName**     | Descriptive name for what the method does              | `addNumbers`        |
| **parameterList**  | Input values (type and variable name)                  | `(int a, int b)`    |
| **method body**    | Code inside the `{ }`                                  | `{ return a + b; }` |

---

### 🧮 **Example 1 — Method With No Parameters and No Return Value**

```java
public static void greetUser() {
    System.out.println("Hello, student!");
}
```

✅ **Explanation:**

* No parameters.
* `void` return type → doesn’t return anything.
* Called as `greetUser();`

---

### 🔢 **Example 2 — Method With Parameters and Return Value**

```java
public static int add(int x, int y) {
    return x + y;
}
```

✅ **Explanation:**

* Takes two integer parameters.
* Returns an integer result.
* Called as `int sum = add(5, 10);`

---

### 🧮 **Example 3 — Method With One Parameter**

```java
public static double square(double num) {
    return num * num;
}
```

✅ Returns a `double` value.

---

### 🧾 **Example 4 — Method With Multiple Parameters (Different Types)**

```java
public static double calculateAverage(int total, int count, boolean roundResult) {
    double average = (double) total / count;
    if (roundResult) {
        average = Math.round(average);
    }
    return average;
}
```

✅ Demonstrates:

* Different data types in parameters.
* Conditional logic inside a method.

---

### 🔁 **Example 5 — Method With No Parameters But Returns a Value**

```java
public static String getGreeting() {
    return "Welcome to Java programming!";
}
```

✅ Can return data even without input parameters.

---

### 🧮 **Example 6 — Void Method With Parameters**

```java
public static void displaySum(int a, int b) {
    int sum = a + b;
    System.out.println("Sum: " + sum);
}
```

✅ Performs an action but doesn’t return anything.

---

### ⚡ **Example 7 — Method Overloading**

You can define **multiple methods with the same name** but different parameter lists:

```java
public static int multiply(int a, int b) {
    return a * b;
}

public static double multiply(double a, double b, double c) {
    return a * b * c;
}
```

✅ Java picks the correct version based on the argument types and count.

---

### 💬 **Example 8 — Returning Different Types**

```java
public static int getRandomInt() {
    return (int)(Math.random() * 100);
}

public static double getRandomDouble() {
    return Math.random() * 100;
}

public static String getMessage() {
    return "Computation complete!";
}
```

✅ Shows `int`, `double`, and `String` return types.

---

### 🧠 **Best Practices for Writing Methods**

1. **Use descriptive names** — e.g., `calculateTotal()`, `printResults()`.
2. **Keep methods short** — each should do one job.
3. **Avoid too many parameters** — consider grouping data if needed.
4. **Use return values wisely** — return a result instead of printing when possible.
5. **Document methods** with comments or JavaDoc.

---

### 🧩 **Quick Reference Chart**

| Return Type | # of Parameters | Example                                              | Returns     |
| ----------- | --------------- | ---------------------------------------------------- | ----------- |
| `void`      | 0               | `public static void greet()`                         | nothing     |
| `int`       | 2               | `public static int add(int a, int b)`                | integer sum |
| `double`    | 1               | `public static double square(double x)`              | square of x |
| `String`    | 0               | `public static String getGreeting()`                 | message     |
| `boolean`   | 3               | `public static boolean compare(int a, int b, int c)` | true/false  |

---
