# Java User Input and Parsing

Now that you're familiar with data types and variables, let's learn how to make your programs interactive! This module will teach you how to collect information directly from a user, process it, and use it within your application.

## 1. Collecting User Input with the Scanner Class

The java.util.Scanner class is your primary tool for reading input from a user, typically from the keyboard (the standard input stream).
To use Scanner, you need to:

1. Import the class at the top of your file: import java.util.Scanner;
2. Create an instance of Scanner, passing System.in as the argument to tell it to read from the keyboard.
3. Use the Scanner object's methods to read different types of data.

```java
import java.util.Scanner; // Step 1: Import the Scanner class

public class GreetUser {
    public static void main(String[] args) {
        // Step 2: Create a Scanner object to read from the keyboard
        Scanner scanner = new Scanner(System.in); 
        
        System.out.println("Please enter your name:");
        
        // Step 3: Use nextLine() to read a line of text (a String)
        String userName = scanner.nextLine(); 
        
        System.out.println("Hello, " + userName + "!");

        // Close the scanner when you're done with it to free up resources
        scanner.close(); 
    }
}
```

## 2. Parsing Input into Specific Data Types

The Scanner class provides several methods to read specific data types, effectively "parsing" the user's input. It's important to choose the correct method to avoid runtime errors.

* scanner.nextInt(): Reads the next integer from the input.
* scanner.nextDouble(): Reads the next double (floating-point number).
* scanner.nextBoolean(): Reads the next boolean (true or false).
* scanner.next(): Reads a single word (a token) from the input.
* scanner.nextLine(): Reads the entire line of input, including spaces, until a new line is encountered.

```java
import java.util.Scanner;

public class DataParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your age (as a whole number):");
        int age = scanner.nextInt(); // Reads an integer

        System.out.println("Enter your GPA (e.g., 3.85):");
        double gpa = scanner.nextDouble(); // Reads a double

        System.out.println("You are " + age + " years old with a GPA of " + gpa + ".");

        scanner.close();
    }
}
```

Important: When reading a number and then a string, it's a good practice to use an extra scanner.nextLine() to consume the leftover newline character after reading the number. This prevents issues with the next nextLine() call.

## 3. Using Parsed Data in a Program

Once you've collected and parsed the user's input, you can use the data just like any other variable. This allows you to create dynamic programs that respond to user actions.

**Example: A Simple Calculator**

This example demonstrates how to take two numbers and an operator from the user and perform a calculation.

```java
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Simple Calculator!");

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the operator (+, -, *, /): ");
        String operator = scanner.next();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        double result;

        if (operator.equals("+")) {
            result = num1 + num2;
        } else if (operator.equals("-")) {
            result = num1 - num2;
        } else if (operator.equals("*")) {
            result = num1 * num2;
        } else if (operator.equals("/")) {
            // Check for division by zero
            if (num2 == 0) {
                System.out.println("Error: Cannot divide by zero.");
                return; // Exit the program
            }
            result = num1 / num2;
        } else {
            System.out.println("Error: Invalid operator.");
            return; // Exit the program
        }

        System.out.println("The result is: " + result);
        
        scanner.close();
    }
}
```

## 4. Exercise: Create a Profile Builder

Your task is to write a program that collects a few pieces of information from the user and then prints a summary.

Steps:

1. Create a new Java class called ProfileBuilder.  
2. Import the Scanner class and create a Scanner object in your main method.  
3. Prompt the user to enter their first name (a String).  
4. Prompt the user to enter their favorite number (an int).  
5. Prompt the user to enter whether they are a developer (a boolean).  
6. Store each piece of information in an appropriately named variable.  
7. Print a summary of the user's profile, something like:  
   Hello [First Name]! Your favorite number is [Favorite Number] and it is [True/False] that you are a developer.  
8. Close the Scanner object.