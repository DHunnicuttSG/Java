Java Lambdas and Streams
Lesson Overview

Modern Java development emphasizes writing concise, readable, and maintainable code. Two powerful features introduced in Java 8, Lambda Expressions and the Streams API, enable developers to process collections of data using a declarative programming style. Together, they support aggregate operations, allowing developers to filter, transform, and summarize data efficiently.

By understanding lambdas and streams, developers can write code that focuses on what should be accomplished rather than how to iterate through data structures step-by-step.

Learning Outcomes

By the end of this lesson, you will be able to:

Identify tasks you can use aggregate operations for.
Describe pipelines.
Explain streams as they relate to pipelines.
Compare streams vs. iteration.
Explain lambdas.
Use filter() with Streams.
Use map() with Streams.
Use collect() with Streams.
Use forEach() with Streams.
1. Aggregate Operations
What Are Aggregate Operations?

Aggregate operations process data from collections, arrays, or other data sources by performing actions such as:

Searching
Filtering
Transforming
Sorting
Grouping
Summarizing

Instead of manually writing loops, aggregate operations allow developers to express processing logic in a more readable, functional style.

Common Use Cases

Given a list of employees:

List<Employee> employees = List.of(
    new Employee("Alice", 75000),
    new Employee("Bob", 55000),
    new Employee("Carol", 95000)
);


Aggregate operations can:

Find employees earning more than $70,000
Convert employee names to uppercase
Calculate average salary
Count employees matching a condition
Group employees by department
2. Pipelines
What Is a Pipeline?

A pipeline is a sequence of operations performed on a stream.

A stream pipeline typically consists of three components:

Source
Intermediate Operations
Terminal Operation
Example Pipeline
employees.stream()
         .filter(e -> e.getSalary() > 70000)
         .map(Employee::getName)
         .forEach(System.out::println);

Pipeline Breakdown
Component	ExampleSource	employees.stream()
Intermediate Operation	filter()
Intermediate Operation	map()
Terminal Operation	forEach()
Benefits of Pipelines
Readable
Concise
Maintainable
Easily parallelized
Encourages functional programming
3. Streams and Pipelines
What Is a Stream?

A stream is a sequence of elements supporting aggregate operations.

Streams:

Do not store data
Process data from a source
Support functional-style operations
Can be sequential or parallel
Are consumed once
Creating Streams

From a collection:

List<String> names = List.of("Alice", "Bob", "Carol");

Stream<String> stream = names.stream();


From an array:

String[] names = {"Alice", "Bob", "Carol"};

Stream<String> stream = Arrays.stream(names);


From values:

Stream<String> stream =
    Stream.of("Alice", "Bob", "Carol");

Stream Lifecycle
Source
   ↓
Intermediate Operations
   ↓
Terminal Operation


Example:

List<String> result =
    names.stream()
         .filter(name -> name.startsWith("A"))
         .map(String::toUpperCase)
         .collect(Collectors.toList());

4. Streams vs. Iteration
Traditional Iteration

Before streams, developers typically used loops:

List<String> results = new ArrayList<>();

for (String name : names) {
    if (name.startsWith("A")) {
        results.add(name.toUpperCase());
    }
}

Stream Approach
List<String> results =
    names.stream()
         .filter(name -> name.startsWith("A"))
         .map(String::toUpperCase)
         .collect(Collectors.toList());

Comparison
Iteration	StreamsFocus on how to process data	Focus on what result is desired
Requires explicit loops	Uses declarative operations
More boilerplate code	Less code
Manual processing logic	Built-in aggregate operations
Harder to parallelize	Supports parallel processing
Key Concept

Iteration is external processing.

The developer controls each step.

Streams use internal iteration.

The stream framework handles traversal and processing.

5. Understanding Lambdas
What Is a Lambda Expression?

A lambda expression is an anonymous function that can be passed as an argument to a method.

Syntax
(parameters) -> expression


or

(parameters) -> {
    statements;
}

Examples
Traditional Anonymous Class
Comparator<String> comp = new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
};

Lambda Version
Comparator<String> comp =
    (a, b) -> a.compareTo(b);

Lambda Examples
One Parameter
name -> name.toUpperCase()

Multiple Parameters
(a, b) -> a + b

No Parameters
() -> System.out.println("Hello")

Why Use Lambdas?

Lambdas:

Reduce boilerplate code
Improve readability
Enable functional programming
Work naturally with streams
Simplify callbacks and event handling
6. Using filter()
Purpose

filter() removes elements that do not satisfy a condition.

Signature
filter(Predicate<T> predicate)


The predicate returns:

true → keep the element
false → discard the element
Example
List<String> names =
    List.of("Alice", "Bob", "Amanda", "Carol");

List<String> filtered =
    names.stream()
         .filter(name -> name.startsWith("A"))
         .collect(Collectors.toList());

System.out.println(filtered);


Output:

[Alice, Amanda]

Filtering Numbers
List<Integer> numbers =
    List.of(1, 2, 3, 4, 5, 6);

numbers.stream()
       .filter(n -> n % 2 == 0)
       .forEach(System.out::println);


Output:

2
4
6

7. Using map()
Purpose

map() transforms each element into a new value.

Signature
map(Function<T, R> mapper)

Example

Convert names to uppercase:

List<String> names =
    List.of("alice", "bob", "carol");

List<String> upperNames =
    names.stream()
         .map(String::toUpperCase)
         .collect(Collectors.toList());

System.out.println(upperNames);


Output:

[ALICE, BOB, CAROL]

Mapping Objects
List<String> employeeNames =
    employees.stream()
             .map(Employee::getName)
             .collect(Collectors.toList());

Common Uses
Extract object properties
Convert types
Format strings
Perform calculations
8. Using collect()
Purpose

collect() gathers stream results into a container.

Commonly used with:

Collectors.toList()
Collectors.toSet()
Collectors.toMap()
Collectors.joining()

Example

Collect into a List

List<String> names =
    employees.stream()
             .map(Employee::getName)
             .collect(Collectors.toList());

Example

Collect into a Set

Set<String> names =
    employees.stream()
             .map(Employee::getName)
             .collect(Collectors.toSet());

Example

Join Strings

String result =
    employees.stream()
             .map(Employee::getName)
             .collect(Collectors.joining(", "));


Output:

Alice, Bob, Carol

9. Using forEach()
Purpose

forEach() is a terminal operation that performs an action on each element.

Example
names.stream()
     .forEach(System.out::println);


Output:

Alice
Bob
Carol

Method References

A method reference can often replace a simple lambda.

Lambda:

name -> System.out.println(name)


Method Reference:

System.out::println


Combined:

names.stream()
     .forEach(System.out::println);

Putting It All Together
Complete Example
List<String> names =
    List.of("Alice", "Bob", "Amanda", "Carol");

List<String> results =
    names.stream()
         .filter(name -> name.startsWith("A"))
         .map(String::toUpperCase)
         .collect(Collectors.toList());

results.forEach(System.out::println);


Output:

ALICE
AMANDA

Best Practices

✅ Prefer streams when processing collections.

✅ Use descriptive lambda parameter names.

✅ Keep stream pipelines short and readable.

✅ Use method references when they improve clarity.

✅ Use filter() before map() when possible to reduce processing.

✅ Choose the appropriate terminal operation for the desired result.

Summary

In this lesson, you learned that:

Aggregate operations process collections of data efficiently.
Pipelines consist of a source, intermediate operations, and a terminal operation.
Streams provide a declarative approach to data processing.
Streams focus on what to accomplish, while iteration focuses on how to accomplish it.
Lambda expressions provide concise implementations of functional interfaces.
filter() selects elements that match a condition.
map() transforms elements into new values.
collect() gathers results into collections or other structures.
forEach() performs actions on each stream element.

Together, Lambdas and Streams enable Java developers to write cleaner, more expressive, and more maintainable code while leveraging the power of functional programming concepts.