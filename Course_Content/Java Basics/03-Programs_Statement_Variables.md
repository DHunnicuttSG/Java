# Programs, Statements, and Variables

This module lays the groundwork for your journey into programming. We'll explore fundamental concepts from computer science and see how they apply directly to writing code in Java.

## 1. Defining Core Concepts

**What is a Computer?**

A computer is an electronic machine that processes data, following a set of instructions called a program. It takes in input, performs computations, and produces output.

**Data vs. Information**

Data are raw, unprocessed facts, figures, or symbols. For example, the number 85. Information is data that has been processed, organized, or structured to provide meaning. When you say "The student's score is 85," the number is now information because it has context.

**Program vs. Programming**

A program is a set of instructions written in a programming language that a computer can execute. It's the finished product. Programming is the process of creating, testing, and maintaining that program. It's the action of writing the instructions.

## 2. The Language of Code

**Syntax vs. Semantics**

Syntax refers to the grammar and rules of a programming language. It dictates how statements must be structured to be valid. For example, every Java statement must end with a semicolon ;. Semantics refers to the meaning or purpose of a statement. A syntactically correct line of code may have no meaningful purpose (e.g., int x = 5 + 5; is syntactically correct, but the variable x is never used, which could be a semantic error).

**The Importance of Comments**

Comments are notes in your code that are ignored by the compiler. They are crucial for explaining complex logic, clarifying the purpose of a variable or method, and making your code readable for other developers (and your future self!). The more complex the code, the more important comments become.

**Identifiers**

An identifier is a unique name you give to a variable, method, class, or other programming element. It serves as a way to refer to that element in your code. Good identifiers are descriptive and follow naming conventions, making your code self-documenting.

## 3. Handling Data with Code

**Primitive vs. Reference Data Types**

Primitive data types (int, char, boolean, double) store the actual value directly in memory. They are the building blocks of data. Reference data types (String, Scanner, or any custom class) store a memory address that "refers" to an object where the actual data is stored. Think of a primitive type as a house, and a reference type as a street address that points to a house.

**Literals, Variables, and Expressions**

A literal is a fixed, unchanging value in your code. Examples include 10, 3.14, 'A', and "Hello".A variable is a storage location identified by an identifier. Its value can change during program execution.An expression is a combination of literals, variables, and operators that evaluates to a single value.

```java
public class DataExample {
    public static void main(String[] args) {
        // '100' is an integer literal.
        // 'finalScore' is a variable (an identifier) of type int.
        int finalScore = 100;

        // The entire line is a String literal.
        String message = "Your final score is: " + finalScore;

        // The part 'finalScore > 90' is a boolean expression.
        // It evaluates to 'true' or 'false'.
        boolean isA = (finalScore > 90);

        System.out.println(message);
        System.out.println("Did I get an A? " + isA);
    }
}
```

## 4. The Role of Objects and Specifications

In object-oriented programming (OOP), objects are instances of classes. They combine data (variables) and behavior (methods) into a single, cohesive unit. The specification of an object describes what it does, not how it does it. This is a powerful concept because it allows a team to agree on how different parts of a program should interact without needing to know the low-level implementation details. For example, a Car object has a drive() method (its specification), and you don't need to know the engine's internal mechanics to use it.


## 5. Reserved words, operators, syntax, and statements 

These are all fundamental components of any programming language. They are the rules and tools you use to write working code.

***

### Reserved Words
**Reserved words**, or keywords, are special words in Java that are reserved for a specific purpose by the language itself. You cannot use them as identifiers (names for variables, methods, or classes). Examples include `public`, `class`, `void`, `static`, `if`, and `else`. They are case-sensitive and must be used exactly as they are defined. For instance, `public` is a reserved word, but `Public` is not. 

---

### Operators
**Operators** are special symbols that perform operations on one or more values or variables. They're a core part of creating expressions.

* **Arithmetic Operators** are used for mathematical operations: `+` (addition), `-` (subtraction), `*` (multiplication), `/` (division), and `%` (modulus).
* **Relational Operators** are used to compare values and return a boolean result: `==` (equal to), `!=` (not equal to), `>` (greater than), `<` (less than), `>=` (greater than or equal to), and `<=` (less than or equal to).
* **Logical Operators** combine boolean expressions: `&&` (logical AND), `||` (logical OR), and `!` (logical NOT).

---

### Syntax
**Syntax** refers to the set of rules that governs how you write a program. It's the "grammar" of the language. If you violate a syntax rule, your code won't compile, and the compiler will report an error. A simple example of a syntax rule is that every statement in Java must end with a semicolon `;`. Another rule is that curly braces `{}` are used to define a block of code.

---

### Statements
A **statement** is a single, complete instruction that performs an action. It's the basic unit of execution in Java. A single line of code often makes up a statement, but it can also span multiple lines.

For example, `int x = 10;` is a statement that declares an integer variable `x` and initializes it to the literal value `10`. Similarly, an `if` statement, a `for` loop, and a method call are all examples of different kinds of statements.