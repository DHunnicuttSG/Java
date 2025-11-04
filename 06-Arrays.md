## 🧩 **Java Arrays**

### 🧠 What Is an Array?

An **array** is a data structure that stores a **fixed number of values** of the **same data type** under one variable name.

Instead of declaring multiple variables:

```java
int score1 = 90;
int score2 = 85;
int score3 = 100;
```

You can store them together:

```java
int[] scores = {90, 85, 100};
```

✅ Arrays make it easier to **store**, **organize**, and **iterate** through related data.

---

### ⚙️ **Array Declaration and Initialization**

#### 1️⃣ Declaration

```java
int[] numbers;      // preferred form
// or
int numbers[];      // older C-style syntax
```

#### 2️⃣ Allocation (specifying the size)

```java
numbers = new int[5];   // creates space for 5 integers
```

#### 3️⃣ Initialization

You can assign values individually:

```java
numbers[0] = 10;
numbers[1] = 20;
numbers[2] = 30;
```

Or all at once:

```java
int[] numbers = {10, 20, 30, 40, 50};
```

---

### 🧩 **Accessing Array Elements**

Each element is accessed using an **index**, starting at **0**:

```java
System.out.println(numbers[0]); // prints 10
System.out.println(numbers[4]); // prints 50
```

❗ Accessing an index outside the valid range (e.g. `numbers[5]`) causes an **ArrayIndexOutOfBoundsException**.

---

### 🧮 **Array Properties**

* `numbers.length` → returns the number of elements in the array.

  ```java
  System.out.println("Array length: " + numbers.length);
  ```
* Array size is **fixed** once created.

---

## 🔢 **Types of Arrays in Java**

### 1️⃣ **One-Dimensional (1D) Arrays**

Stores values in a single row or list.

Example:

```java
String[] fruits = {"Apple", "Banana", "Cherry"};

for (int i = 0; i < fruits.length; i++) {
    System.out.println(fruits[i]);
}
```

---

### 2️⃣ **Two-Dimensional (2D) Arrays**

Think of a 2D array as a **table** (rows and columns).

Example:

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

Access elements:

```java
System.out.println(matrix[0][2]); // prints 3
System.out.println(matrix[2][1]); // prints 8
```

Iterate with nested loops:

```java
for (int i = 0; i < matrix.length; i++) {          // rows
    for (int j = 0; j < matrix[i].length; j++) {   // columns
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

---

### 3️⃣ **Jagged Arrays (Irregular 2D Arrays)**

A 2D array where each row can have **different lengths**:

```java
int[][] jagged = {
    {1, 2},
    {3, 4, 5},
    {6}
};

for (int i = 0; i < jagged.length; i++) {
    for (int j = 0; j < jagged[i].length; j++) {
        System.out.print(jagged[i][j] + " ");
    }
    System.out.println();
}
```

✅ Useful when data rows don’t all have the same number of columns.

---

### 4️⃣ **Three-Dimensional (3D) Arrays**

Used for more complex data, like 3D grids:

```java
int[][][] cube = new int[2][3][4];
cube[0][1][2] = 99;
System.out.println(cube[0][1][2]); // prints 99
```

Iterated with three nested loops.

---

## 🔁 **Iterating Through Arrays**

### 🔹 **Using a For Loop**

Classic index-based approach:

```java
int[] nums = {2, 4, 6, 8};

for (int i = 0; i < nums.length; i++) {
    System.out.println("Element " + i + ": " + nums[i]);
}
```

---

### 🔹 **Using a For-Each Loop (Enhanced For Loop)**

Simpler syntax when you don’t need the index:

```java
for (int value : nums) {
    System.out.println(value);
}
```

✅ Automatically loops through every element.

---

### 🔹 **Using a While Loop**

```java
int i = 0;
while (i < nums.length) {
    System.out.println(nums[i]);
    i++;
}
```

---

### 🔹 **Using Streams (Advanced for later)**

For modern Java (8+):

```java
Arrays.stream(nums).forEach(System.out::println);
```

✅ Compact, but best introduced after basic iteration is mastered.

---

## 🧠 **Common Array Operations**

| Operation      | Example                                                  |
| -------------- | -------------------------------------------------------- |
| Find max value | Loop through and compare elements                        |
| Sum elements   | Use accumulator variable                                 |
| Copy array     | `int[] copy = Arrays.copyOf(nums, nums.length);`         |
| Sort array     | `Arrays.sort(nums);`                                     |
| Search value   | `Arrays.binarySearch(nums, value);` (sorted arrays only) |

---

## 💬 **Example: Calculate Average of an Array**

```java
public class AverageExample {
    public static void main(String[] args) {
        int[] scores = {85, 90, 78, 92, 88};
        int total = 0;

        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }

        double average = (double) total / scores.length;
        System.out.println("Average: " + average);
    }
}
```

---

## 🧩 **Quick Reference Summary**

| Type         | Syntax                            | Example Access | Notes          |
| ------------ | --------------------------------- | -------------- | -------------- |
| 1D Array     | `int[] a = {1,2,3};`              | `a[1]`         | Simple list    |
| 2D Array     | `int[][] a = new int[3][4];`      | `a[1][2]`      | Rows & columns |
| Jagged Array | `int[][] a = new int[3][];`       | `a[0][1]`      | Uneven rows    |
| 3D Array     | `int[][][] a = new int[2][3][4];` | `a[0][1][2]`   | 3D data cube   |

---
