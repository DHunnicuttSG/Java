# Java Fundamentals: A Developer's Module

This module provides an introduction to the core concepts of the Java programming language. It is designed to equip you with the foundational knowledge needed to begin building applications and to write clean, readable, and maintainable code.

## 1. Data Types and Variables

In Java, every variable must have a declared data type. This tells the compiler what kind of data the variable will hold and how much memory it needs. Java has two main categories of data types:

* Primitive Types: These are the most basic types, such as int for integers, double for floating-point numbers, and boolean for true/false values. They store the actual value directly in memory.

* Reference Types: These are objects, like String or custom-defined classes. They store a memory address (a reference) to where the actual data is located.

```Java
// Primitive types
int age = 30;
double price = 19.99;
boolean isStudent = true;
char grade = 'A';

// Reference type
String name = "Alice";
```

## 2. Expressions and Operators

An expression is a combination of variables, literals, and operators that evaluates to a single value. Operators are special symbols used to perform operations on variables and values.

Arithmetic Operators
* `+` (addition), `-` (subtraction), `*` (multiplication), `/` (division), `%` (modulus)

Relational Operators
* `==` (equal to), `!=` (not equal to), `>` (greater than), `<` (less than), `>=` (greater than or equal to), `<=` (less than or equal to)These are used for comparison and always return a boolean value.

Logical Operators
* `&&` (logical AND), `||` (logical OR),`!` (logical NOT)These are used to combine boolean expressions.

```Java
// Arithmetic expressions
int result = 10 + 5; // result is 15
int remainder = 17 % 3; // remainder is 2

// Relational expressions
boolean isAdult = age >= 18; // isAdult is true

// Logical expressions
boolean canVote = (age >= 18) && (name.equals("Alice")); // canVote is true
```

## 3. Naming Conventions and Readability

Consistent naming and formatting are crucial for writing readable code.

* Code Layout: Use consistent indentation (4 spaces is standard) and organize your code with blank lines to separate logical sections.
* Comments: Use // for single-line comments and /* ... */ for multi-line comments to explain your code's purpose and logic.
* Object Naming Conventions:
    * Classes: Use PascalCase (MyAwesomeClass).
    * Methods and Variables: Use camelCase (calculateTotal, studentName).
    * Constants: Use UPPER_SNAKE_CASE (MAX_SPEED, PI)./*

```java
 * This is a multi-line comment.
 * It describes the purpose of the main class.
 */
public class LoanCalculator { // Class name: PascalCase

    // Constant for the maximum loan amount
    public static final double MAX_LOAN = 50000.00; // Constant name: UPPER_SNAKE_CASE

    public static void main(String[] args) {
        // Variable name: camelCase
        double principalAmount = 25000.00; 
        double monthlyPayment = calculateMonthlyPayment(principalAmount); // Method name: camelCase
        
        // Use blank lines to improve readability
        System.out.println("The monthly payment is: " + monthlyPayment);
    }

    public static double calculateMonthlyPayment(double principal) {
        // Method logic here...
        return principal * 0.05; // Dummy calculation
    }
}
```

## 4. Control Flow: Conditionals and Loops

Control flow statements determine the order in which your code is executed.
* Conditional Statements (if, else if, else): These execute a block of code only if a certain condition is met.

```java
int score = 85;
if (score >= 90) {
    System.out.println("Excellent!");
} else if (score >= 75) {
    System.out.println("Good job!");
} else {
    System.out.println("Keep practicing.");
}
```
* Loops (for, while): These execute a block of code repeatedly.

```java
// For loop: repeats a specific number of times
for (int i = 0; i < 5; i++) {
    System.out.println("Iteration: " + i);
}

// While loop: repeats as long as a condition is true
int count = 0;
while (count < 3) {
    System.out.println("Count is: " + count);
    count++;
}
```

## 5. Methods for Code Organization

Methods are reusable blocks of code that perform a specific task. They help break down complex programs into smaller, more manageable pieces, making your code easier to read, debug, and maintain.

```java
public class GreetingApp {
    public static void main(String[] args) {
        // Calling the method
        greetUser("Charlie");
    }

    // Defining a method
    public static void greetUser(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
```

## 6. Arrays

An array is an object that stores a fixed-size collection of data elements of the same type.

* Declaration and Initialization:

```java
// Declare and initialize an array of integers
int[] numbers = {10, 20, 30, 40, 50};

// Declare an array of 3 strings and allocate memory
String[] names = new String[3];

// Assign values to the elements
names[0] = "Adam";
names[1] = "Beth";
names[2] = "Carl";
```

* Accessing and Iterating: You access elements using an index (starting from 0).

```java
// Access an element
System.out.println("The second number is: " + numbers[1]); // Output: 20

// Iterate through an array using a for loop
for (int i = 0; i < names.length; i++) {
    System.out.println(names[i]);
}

// Enhanced for loop (for-each)
for (int num : numbers) {
    System.out.println(num);
}
```

## 7. Debugging with an IDE

An Integrated Development Environment (IDE) provides tools to help you find and fix errors (bugs) in your code. The most common debugging tools are:

1. Breakpoints: You set these on a specific line of code. When the program runs, it will pause execution at the breakpoint, allowing you to inspect the program's state.
2. Stepping: Once the program is paused, you can "step" through the code line by line.

    * Step Over: Executes the current line and moves to the next.
    * Step Into: Enters a method call to debug its inner workings.
    * Step Out: Finishes the current method and returns to the line where it was called.
3. Variable Inspection: While paused, you can hover over variables to see their current values, helping you understand how the program is behaving.

8. Visualizing Program Flow with a Flowchart

A flowchart is a diagram that visually represents the steps and decisions in a program. It uses different shapes to represent different actions.

Image of a simple flowchart

```Mermaid.js
graph TD  
    A[Start] --> B(Input a number);
    B --> C{Is number % 2 == 0?};
    C -- Yes --> D[Print "Even"];
    C -- No --> E[Print "Odd"];
    D --> F[End];
    E --> F;
```