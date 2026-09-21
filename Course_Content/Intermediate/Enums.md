# Java Enums 
Using enums in a Calculator Application

## Learning Objectives

By the end of this lesson, students will be able to:

* Explain what an Enum is.
* Understand why Enums are better than using strings for fixed values.
* Create and use Java Enums.
* Pass Enums as method parameters.
* Use Enums in business logic.
* Build a simple calculator using Enum-based operations.
* Understand common interview questions involving Enums.

## What is an Enum?

An Enum (Enumeration) is a special Java type used to represent a fixed set of constants.

Think of it as a controlled list of values.

For example:
```text
MONDAY
TUESDAY
WEDNESDAY
THURSDAY
FRIDAY
```

Only these values are allowed.

## Why Use Enums?

Suppose we create a calculator using Strings:
```text
String operation = "ADD";
```

The problem:

"ADD"
"Add"
"add"
"addition"
"ADDD"


All of these are different strings.

Typos can easily cause bugs.

## Better Solution

Use an Enum.
```text
Operation.ADD
```

Now Java guarantees only valid values can be used.

## Real World Uses of Enums

Enums are commonly used for:

1. Order Status
2. Payment Type
3. User Role
4. Days of Week
5. Ticket Priority
6. Application State
7. Calculator Operations


Example:
```text
PENDING
APPROVED
REJECTED
```
## Calculator Application Requirements

Our calculator should support:
```text
ADD
SUBTRACT
MULTIPLY
DIVIDE
```

## Project Structure
```text
calculator-app
│
├── Operation.java
├── CalculatorService.java
└── Main.java
```

## Step 1: Create the Enum
**Operation.java**
```java
public enum Operation {

    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE
}
```

That's it.

Each value becomes a constant.

Understanding Enum Constants

You can reference them like:
```java
Operation.ADD
```

or
```java
Operation.MULTIPLY
```

Example:
```java
Operation operation = Operation.ADD;
```

## Step 2: Create the Calculator Service

**CalculatorService.java**
```java
public class CalculatorService {

    public double calculate(
            double num1,
            double num2,
            Operation operation) {

        switch(operation) {

            case ADD:
                return num1 + num2;

            case SUBTRACT:
                return num1 - num2;

            case MULTIPLY:
                return num1 * num2;

            case DIVIDE:
                return num1 / num2;

            default:
                throw new IllegalArgumentException(
                        "Invalid Operation");
        }
    }
}
```
## Understanding the Switch Statement

The Enum drives the calculation.

If:
```text
Operation.ADD
```

Then:
```java
return num1 + num2;
```

If:
```java
Operation.MULTIPLY
```

Then:
```java
return num1 * num2;
```

## Step 3: Create the Main Class
**Main.java**
```java
public class Main {

    public static void main(String[] args) {

        CalculatorService calculator =
                new CalculatorService();

        double result =
                calculator.calculate(
                        5,
                        3,
                        Operation.ADD);

        System.out.println(result);
    }
}
```
**Output**
```java
8.0
```

## Testing Each Operation
**ADD**
```java
double result =
        calculator.calculate(
                10,
                5,
                Operation.ADD);
```

Output:
```java
15.0
```

**SUBTRACT**
```java
double result =
        calculator.calculate(
                10,
                5,
                Operation.SUBTRACT);
```

Output:
```java
5.0
```

**MULTIPLY**
```java
double result =
        calculator.calculate(
                10,
                5,
                Operation.MULTIPLY);
```

Output:
```java
50.0
```

**DIVIDE**
```java
double result =
        calculator.calculate(
                10,
                5,
                Operation.DIVIDE);
```

Output:
```java
2.0
```

## Visualizing the Flow
```java
User Input
     ↓
calculate(10,5,ADD)
     ↓
Switch Statement
     ↓
ADD Case Executes
     ↓
Returns 15
```

## Step 4: Improve Division Validation

What happens here?
```java
10 / 0
```

Result:
```java
Infinity
```

This may not be what the business wants.

Let's add validation.
```java
case DIVIDE:

    if(num2 == 0) {
        throw new ArithmeticException(
                "Cannot divide by zero");
    }

    return num1 / num2;
```
## Testing Division by Zero
```java
calculator.calculate(
        10,
        0,
        Operation.DIVIDE);
```

Output:
```java
Exception in thread "main"
java.lang.ArithmeticException
```

## Step 5: Add Descriptions to Enum Values

Enums can contain data and methods.

**Enhanced Operation Enum**
```java
public enum Operation {

    ADD("Addition"),
    SUBTRACT("Subtraction"),
    MULTIPLY("Multiplication"),
    DIVIDE("Division");

    private final String description;

    Operation(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
```

## Using the Description
```java
System.out.println(
        Operation.ADD.getDescription());
```

Output:
```java
Addition
```
## Why This Is Useful

Real applications often need:

1. Database Code
2. User-Friendly Description
3. Display Label


Example:

1. ACTIVE("Active User")
2. INACTIVE("Inactive User")
3. LOCKED("Locked User")

## Step 6: Move Behavior into the Enum

This is a more advanced approach.

Instead of using a switch statement, each Enum can perform its own calculation.

**Operation.java**
```java
public enum Operation {

    ADD {
        @Override
        public double apply(
                double a,
                double b) {
            return a + b;
        }
    },

    SUBTRACT {
        @Override
        public double apply(
                double a,
                double b) {
            return a - b;
        }
    },

    MULTIPLY {
        @Override
        public double apply(
                double a,
                double b) {
            return a * b;
        }
    },

    DIVIDE {
        @Override
        public double apply(
                double a,
                double b) {

            if(b == 0) {
                throw new ArithmeticException(
                    "Cannot divide by zero");
            }

            return a / b;
        }
    };

    public abstract double apply(
            double a,
            double b);
}
```
## Updated Calculator Service

Notice the switch statement disappears.
```java
public class CalculatorService {

    public double calculate(
            double num1,
            double num2,
            Operation operation) {

        return operation.apply(
                num1,
                num2);
    }
}
```

This is a common enterprise technique.

## Why is This Better?

Old approach:
```java
switch(operation)
```

Every new operation requires modifying the switch.

New approach:
```java
operation.apply()
```

Every operation manages itself.

This follows the:
```java
Open/Closed Principle
```

Open for extension.

Closed for modification.

## Common Junior Developer Mistakes
**Mistake #1**

Using Strings Instead of Enums

Bad:
```java
String operation = "ADD";
```

Good:
```java
Operation.ADD;
```

**Mistake #2**

Comparing Enum Names

Bad:
```java
if(operation.name().equals("ADD"))
```

Good:
```java
if(operation == Operation.ADD)
```

**Mistake #3**

Creating Duplicate Enums

Bad:
```java
CalculatorOperation
MathOperation
ArithmeticOperation
```

When one enum would work.

## Interview Questions
**Question**

What is an Enum?

**Answer**

An Enum is a special Java type that represents a fixed set of predefined constants.

---
**Question**

Why use an Enum instead of a String?

**Answer**

Enums provide type safety, prevent invalid values, improve readability, and reduce bugs caused by misspellings.

---
**Question**

Can Enums contain methods?

**Answer**

Yes.

Enums can contain:
```java
Fields
Constructors
Methods
Business Logic
```

They are much more powerful than simple constants.

---
**Question**

Can Enums Implement Interfaces?

**Answer**

Yes.

Enums can implement interfaces just like regular classes.
```java
public enum Operation implements Runnable {
}
```

## Student Lab Exercise
**Exercise 1**

Add a new operation:
```java
MODULUS
```

Example:
```java
10 % 3 = 1

```
---
**Exercise 2**

Add:
```java
POWER
```

Example:
```java
2 ^ 3 = 8
```
---
**Exercise 3**

Add descriptions for all operations.

Example:
```java
ADD("Adds two numbers")
```

Display the description before showing the result.

---
**Exercise 4 (Challenge)**

Allow the user to loop through all operations.

Example:
```java
for(Operation op : Operation.values()) {
    System.out.println(op);
}
```

Expected Output:
```java
ADD
SUBTRACT
MULTIPLY
DIVIDE
```

---
## Lesson Summary

Enums provide a safe, structured way to represent a fixed set of values.

In our calculator application:
```java
Operation.ADD
Operation.SUBTRACT
Operation.MULTIPLY
Operation.DIVIDE
```

We learned how to:

* Create an Enum
* Use Enums in a service
* Pass Enums as method parameters
* Use Enums in switch statements
* Add fields and methods to Enums
* Move business behavior directly into Enum constants

**Key Takeaway**

>Use an Enum whenever you have a fixed set of known values. Enums provide type safety, readability, maintainability, and often eliminate the need for error-prone String comparisons."