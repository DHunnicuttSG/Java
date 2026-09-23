# Java Lesson: StringBuilder and StringBuffer
## Learning Objectives

By the end of this lesson, students will be able to:

* Explain why StringBuilder and StringBuffer exist.
* Describe the immutability of String.
* Use common methods of StringBuilder and StringBuffer.
* Compare StringBuilder, StringBuffer, and String.
* Choose the correct class for real-world applications.
* Answer common interview questions related to mutable strings.

## 1. Introduction

One of the most common mistakes junior developers make is repeatedly concatenating strings using the + operator inside loops.

Consider:
```java
String result = "";

for (int i = 0; i < 1000; i++) {
    result += i;
}
```

This works, but it is inefficient because every concatenation creates a brand-new String object.

Since Java strings are immutable, the original string cannot be modified.

## 2. What Does Immutable Mean?

A String object cannot be changed after it is created.

Example:
```java
String name = "William";

name.concat(" Smith");

System.out.println(name);
```

Output:
```java
William
```

The original string remains unchanged.

Correct usage:
```java
String name = "William";

name = name.concat(" Smith");

System.out.println(name);
```

Output:
```java
William Smith
```
## 3. Why StringBuilder and StringBuffer Exist

Both classes provide mutable strings.

Instead of creating a new object for every modification, they modify the existing object.

Benefits:

* Better performance
* Less memory usage
* Ideal for loops
* Faster string manipulation

## 4. StringBuilder Overview

StringBuilder was introduced in Java 5.

Characteristics:

* Mutable
* Not thread-safe
* Faster than StringBuffer
* Most commonly used

Syntax:
```java
StringBuilder sb = new StringBuilder();
```

## 5. Basic StringBuilder Example
```java
public class StringBuilderDemo {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        sb.append("Java");
        sb.append(" ");
        sb.append("Developer");

        System.out.println(sb);
    }
}
```

Output:
```java
Java Developer
```

## 6. Common StringBuilder Methods
### append()

Adds data to the end.
```java
StringBuilder sb = new StringBuilder("Java");
sb.append(" Programming");
System.out.println(sb);
```

Output:
```java
Java Programming
```

### insert()

Inserts content at a specific index.
```java
StringBuilder sb = new StringBuilder("Jva");
sb.insert(1, "a");
System.out.println(sb);
```

Output:
```java
Java
```

### delete()

Removes characters.
```java
StringBuilder sb = new StringBuilder("Java Programming");
sb.delete(4, 16);
System.out.println(sb);
```

Output:
```java
Java
```

### replace()

Replaces a portion of a string.
```java
StringBuilder sb = new StringBuilder("Java Programming");
sb.replace(5, 16, "Developer");
System.out.println(sb);
```

Output:
```java
Java Developer
```

### reverse()

Reverses the characters.
```java
StringBuilder sb = new StringBuilder("Java");
sb.reverse();
System.out.println(sb);
```

Output:
```java
avaJ
```

### length()
```java
Returns current length.
StringBuilder sb = new StringBuilder("Java");
System.out.println(sb.length());
```

Output:
```java
4
```

### 7. Real-World Example

Building CSV Data
```java
public class CsvBuilder {
    public static void main(String[] args) {

        StringBuilder csv = new StringBuilder();

        csv.append("id,name,email\n");
        csv.append("1,John,john@email.com\n");
        csv.append("2,Sarah,sarah@email.com\n");
        csv.append("3,Bob,bob@email.com\n");

        System.out.println(csv);
    }
}
```

### 8. What Is StringBuffer?

StringBuffer existed before StringBuilder.

Characteristics:

* Mutable
* Thread-safe
* Synchronized
* Slightly slower

Syntax:

StringBuffer buffer = new StringBuffer();

### 9. Basic StringBuffer Example
```java
public class StringBufferDemo {
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();

        sb.append("Production");
        sb.append(" Support");

        System.out.println(sb);
    }
}
```

Output:

Production Support

### 10. StringBuffer Methods

The methods are nearly identical to StringBuilder.
```java
append()
insert()
delete()
replace()
reverse()
length()
capacity()
```

Example:
```java
StringBuffer buffer = new StringBuffer("Hello");
buffer.append(" World");
System.out.println(buffer);
```

Output:
```java
Hello World
```

### 11. StringBuilder vs StringBuffer
|Feature|	StringBuilder|	StringBuffer|
|---|---|---|
|Mutable|	Yes|	Yes|
|Thread Safe|	No|	Yes|
|Synchronized|	No|	Yes|
|Speed|	Faster|	Slower|
|Introduced|	Java 5|	Java 1.0|
|Typical Use|	Single-threaded apps|	Multi-threaded apps|

### 12. Capacity vs Length

Many interviewers ask this question.

**Length**

Number of actual characters.
```java
StringBuilder sb = new StringBuilder("Java");
System.out.println(sb.length());
```

Output:
```java
4
```
**Capacity**

Number of characters the object can currently store before resizing.
```java
StringBuilder sb = new StringBuilder();
System.out.println(sb.capacity());
```

Output:
```java
16
```

Default capacity = 16

**Capacity Example**
```java
StringBuilder sb = new StringBuilder("Java");
System.out.println("Length: " + sb.length());
System.out.println("Capacity: " + sb.capacity());
```

Output:
```java
Length: 4
Capacity: 20
```

Because:
```java
16 + 4 = 20
```

### 13. Performance Demonstration

String Concatenation
```java
long start = System.currentTimeMillis();
String str = "";
for(int i = 0; i < 100000; i++) {
    str += i;
}
long end = System.currentTimeMillis();
System.out.println(end - start);
```

StringBuilder
```java
long start = System.currentTimeMillis();
StringBuilder sb = new StringBuilder();
for(int i = 0; i < 100000; i++) {
    sb.append(i);
}
long end = System.currentTimeMillis();
System.out.println(end - start);
```

Students will notice a significant performance improvement.

### 14. When Should I Use Each?
#### Use String

When:

* Value won't change
* Small strings
* Constants

Example:
```java
String firstName = "William";
```
#### Use StringBuilder

When:

* Frequent modifications
* Loops
* Most application code

Example:
```java
StringBuilder report = new StringBuilder();
```

#### Use StringBuffer

When:

* Multiple threads modify the same object
* Thread safety is required

Example:
```java
StringBuffer sharedLog = new StringBuffer();
```

## 15. Common Interview Questions
### Q1. What is the difference between String and StringBuilder?

Answer

* String is immutable.
* StringBuilder is mutable.
* StringBuilder performs better for repeated modifications.

### Q2. What is the difference between StringBuilder and StringBuffer?

Answer

* StringBuilder is not synchronized.
* StringBuffer is synchronized.
* StringBuilder is faster.
* StringBuffer is thread-safe.

### Q3. Why is String immutable?

Answer

Benefits include:

* Security
* Thread safety
* String pool optimization
* Better performance in many scenarios

### Q4. What is synchronization?

Answer

Synchronization prevents multiple threads from modifying the same resource simultaneously in unsafe ways.

### Q5. Why is StringBuilder faster?

Answer

It does not perform synchronization checks on every operation.

### Q6. What is the default capacity of a StringBuilder?

Answer

16

### Q7. What happens when capacity is exceeded?

Answer

Java automatically increases capacity.

Formula:
```java
(newCapacity * 2) + 2
```

Example:
```java
16 → 34
34 → 70
70 → 142
```

### Q8. Is StringBuilder thread-safe?

Answer

No.

### Q9. Can StringBuilder be converted to String?

Answer

Yes.
```java
StringBuilder sb = new StringBuilder("Java");

String result = sb.toString();
```

### Q10. Which should you use in modern applications?

Answer

Usually:

StringBuilder


Because most string manipulation occurs in single-threaded contexts.

## 16. Hands-On Lab
### Exercise 1

Create a StringBuilder that produces:
```java
Welcome to Java Development
```
### Exercise 2

Start with:
```java
Java Develoment
```

Fix the spelling using insert().

Expected:
```java
Java Development
```

### Exercise 3
Reverse:
```java
Production Support
```

### Exercise 4
```java
Create a CSV containing five employees using only append().
```

### Exercise 5

Create a simple menu system:
```java
1. View Tickets
2. Create Ticket
3. Exit
```
using StringBuilder.

## 17. Advanced Interview Discussion Topics

These topics frequently appear in mid-level Java interviews:

### String Pool
* What is the String Pool?
* Why are string literals stored there?
* How does it improve performance?
### Garbage Collection
* Why does repeated String concatenation create garbage?
* How does StringBuilder reduce GC pressure?
Thread Safety
* Explain synchronization.
* Explain race conditions.
* Why is StringBuffer thread-safe?
### Memory Optimization
```java
StringBuilder sb = new StringBuilder(1000);
```

Why set capacity beforehand?

Answer:

* Reduces resizing operations
* Improves performance

### toString()

Interviewers may ask:
```java
StringBuilder sb = new StringBuilder("Java");
String s = sb.toString();
```

Does changing sb afterward change s?

Answer:
```java
No
```
Because toString() creates a new immutable String object.

## Summary

✅ String is immutable.  
✅ StringBuilder is mutable and fast.  
✅ StringBuffer is mutable and thread-safe.  
✅ StringBuilder is preferred for most application development.  
✅ StringBuffer is used when multiple threads modify the same object.  
✅ Common interview topics include immutability, synchronization, thread  safety, capacity, performance, and the String Pool.  
✅ Understanding when to use each class is a common Java interview requirement.  