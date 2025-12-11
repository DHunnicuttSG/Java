## Git
What is source control?  
What is a Git repository?  
What does git add --all do?  
What does git commit -m "my comment" do?  
What does git push do?  
What does git pull do?  
Why would you create a branch in Git?  
What does the git clone command do?  

## Java Basics
What are the three steps in the life cycle of a java program?  
What is the difference between a compiler and an interpreter?  
What is the syntax of the main method?  
Describe the benefits of using an IDE during programming.  
List the differences between syntax, runtime, and logic errors.  
List the differences between data and information.  
How do you write single-line and multi-line comments?  
What is wrong with the following code?  
```java
public class Hello {
    String new = “My New House”;
    String short = “I am short”;
    String private  = “I am a private person”;
    int catch = 0;
    double this = 1.0;
}
```
Assign each value to a data type:  
5  
128  
34,780  
Bob  
86.02  
true  
x  

How would you keep the decimal value when doing the following operation?  
```java
int a = 10;  
int b = 4;  
float c = 0;  

c = a / b;  
```

What data type is returned when reading from the console?  
What approach would you use to convert console data to another usable data type?  
Describe how you would debug/step through your code using your IDE?  
What is the output of this method?  
```java
public static void main(String[] args) {
    int a = 12;
    int b = 13;
    String  C = "Java";

    System.out.println(a + b + C);
    System.out.println(C + b + a);
}
```

Analyze the following code and determine the output.
```java
public static void main(String[] args) {
    int a = 12;
    int b = 13;
    String  C = "Java";

    if (a<=b) {
        System.out.println(a + " is less than " + b);
    }
    if (a<=b) {
        System.out.println(a + " is less than " + b);
    } else {
        System.out.println("This is false.");
    }
    if (C.equals("JAVA")) {
        System.out.println("This is true");
    } else {
        System.out.println("This is all uppercase!");
        if (C.equals("Java")) {
            System.out.println("This one is equal");
        }
    }
}
```
Compare and contrast if statements with switch statements.  
Write code to generate a random number between 1 and 6.  
Evaluate and determine the output for the following code:  
```java
 public static void main(String[] args) {
    boolean a = true;
    boolean b = false;
    String c = "Java";

    if (a && b ) {
        System.out.println("Both a and b are true");
    } else {
        System.out.println("Both a and b are not true");
    }

    if(a || b) {
        System.out.println("either a or b is true");
    }

    if (a && (b && c.equals("Java"))) {
        System.out.println("true");
    } else {
        System.out.println("false");
    }
}
```
Write code that generates the following output:  
```bash
Counting down...

10
9
8
7
6
5
4
3
2
1
0

Blast off!
```
What is the difference between a while loop and a do/while loop?  
Write code that generates the following output:  
```bash
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
1 2 3 4 5 6
```

Explain the DRY principle.  
Create a method to calculate the area of a rectangle.  
Create a method to calculate the area of a triangle and return a value.  
Explain the importance of scope.  
What does the final keyword mean when used with a method?  
What does the term @override do to a method?  
How would you overload a method?  
What does the static keyword mean?  
What is the syntax to declare a simple array? A two-dimensional array?  
Write syntax to declare and initialize an array with the values (1,2,3,4,5).  
What occurred in the code if the code returns an ArrayIndexOutOfBoundException?  
What is the difference between an element and an index?  
What are the limitations of an array?  
Is an array an object?  
Write code to print out the values of an array.  
How does the garbage collector know when to return memory to the heap?  
Compare and contrast the stack and the heap.  
How is the import keyword used?  
What is a package?  
What is JavaDoc?  
Is the Java language pass by value or pass by reference?  
What does pass by value mean?  
What does pass by reference mean?  
What is a NullPointerException?  