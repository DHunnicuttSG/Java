# 📚 **The Java Collections Framework**

---

## 🎯 **Objectives**

1. Describe the **Java Collections Framework (JCF)**.
2. Explain the difference between a **Collection interface** and its **implementations**.
3. Differentiate between **Lists**, **Sets**, and **Maps**.
4. Identify and use **common collection classes** in Java.

---

## 🧩 1. What Is the Java Collections Framework?

The **Java Collections Framework (JCF)** is a unified architecture for representing and manipulating groups of data — called **collections**.

It provides:

* **Interfaces** that define *what* operations a collection supports.
* **Classes (implementations)** that define *how* those operations are performed.
* **Algorithms** (utility methods in the `Collections` class) for sorting, searching, and more.

### 🧠 Why Use Collections?

Without collections, we would rely on arrays — which are **fixed in size** and lack many built-in utilities.
Collections are **dynamic**, **resizable**, and **rich in functionality**.

---

## 🧩 2. Interface vs Implementation

In Java, **interfaces** define behavior — they specify *what* methods a collection must support.
**Implementations** define *how* that behavior is carried out.

| Concept            | Description                                | Example                           |
| ------------------ | ------------------------------------------ | --------------------------------- |
| **Interface**      | Blueprint or contract for a data structure | `List`, `Set`, `Map`              |
| **Implementation** | Concrete class that provides behavior      | `ArrayList`, `HashSet`, `HashMap` |

### Example:

```java
List<String> names = new ArrayList<>();
Set<Integer> numbers = new HashSet<>();
Map<String, Double> prices = new HashMap<>();
```

Even though we declare them as their **interface type** (`List`, `Set`, `Map`),
we instantiate them using their **implementation classes** (`ArrayList`, `HashSet`, `HashMap`).

✅ **Best Practice:**
Always program to the **interface**, not the implementation.
This allows flexibility to change implementations later without changing code logic.

---

## 🧩 3. Collection Hierarchy Overview

```
           Iterable
               │
          Collection
        ┌───────────────┬───────────────┐
        │               │               │
       List            Set            Queue
        │               │
 ArrayList, LinkedList  HashSet, TreeSet
```

🧭 There’s also **Map**, which is not part of the `Collection` interface but is part of the **Collections Framework**.

---

## 🧩 4. Lists — Ordered Collections with Duplicates

A **List** maintains elements in a specific order and allows **duplicates**.

### Common Implementations

| Class          | Description              | Performance Notes                           |
| -------------- | ------------------------ | ------------------------------------------- |
| **ArrayList**  | Resizable array          | Fast random access, slower inserts/removals |
| **LinkedList** | Doubly-linked list       | Fast inserts/removals, slower random access |
| **Vector**     | Legacy synchronized list | Rarely used today                           |

### Example: Using `ArrayList`

```java
import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Banana");
        fruits.add("Apple");  // Duplicates allowed

        System.out.println("List: " + fruits);
        System.out.println("First item: " + fruits.get(0));

        fruits.remove("Orange");
        System.out.println("After removal: " + fruits);
    }
}
```

**Output:**

```
List: [Apple, Orange, Banana, Apple]
First item: Apple
After removal: [Apple, Banana, Apple]
```

✅ **Key points:**

* Maintains order of insertion
* Allows duplicates
* Indexed access (using `get()`)

---

## 🧩 5. Sets — Unique Collections, No Duplicates

A **Set** is a collection that **cannot contain duplicate elements**.

### Common Implementations

| Class             | Description                            | Ordering Behavior                            |
| ----------------- | -------------------------------------- | -------------------------------------------- |
| **HashSet**       | Backed by a hash table                 | No guaranteed order                          |
| **LinkedHashSet** | Maintains insertion order              | Slightly slower than `HashSet`               |
| **TreeSet**       | Sorted set (implements `NavigableSet`) | Orders elements naturally or by a comparator |

### Example: Using `HashSet`

```java
import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        Set<String> colors = new HashSet<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Red"); // Duplicate ignored

        System.out.println("Set: " + colors);
    }
}
```

**Possible Output:**

```
Set: [Red, Green, Blue]
```

✅ **Key points:**

* No duplicates allowed
* Does not maintain order (use `LinkedHashSet` for insertion order)
* Very fast for lookups (`O(1)` average)

---

## 🧩 6. Maps — Key-Value Pairs

A **Map** stores data as **key-value pairs**, where:

* Each **key is unique**
* Each **key maps to exactly one value**

### Common Implementations

| Class             | Description                     | Ordering Behavior               |
| ----------------- | ------------------------------- | ------------------------------- |
| **HashMap**       | Fast key-based lookup           | No guaranteed order             |
| **LinkedHashMap** | Maintains insertion order       | Predictable iteration order     |
| **TreeMap**       | Sorted by natural order of keys | Implements `NavigableMap`       |
| **Hashtable**     | Legacy synchronized map         | Replaced by `ConcurrentHashMap` |

### Example: Using `HashMap`

```java
import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> ages = new HashMap<>();

        ages.put("Alice", 30);
        ages.put("Bob", 25);
        ages.put("Charlie", 35);
        ages.put("Alice", 31); // Overwrites old value

        System.out.println("Map: " + ages);
        System.out.println("Bob's age: " + ages.get("Bob"));

        ages.remove("Charlie");
        System.out.println("After removal: " + ages);
    }
}
```

**Output:**

```
Map: {Bob=25, Alice=31, Charlie=35}
Bob's age: 25
After removal: {Bob=25, Alice=31}
```

✅ **Key points:**

* Each key must be unique
* Each key maps to one value
* Ideal for lookups using identifiers

---

## 🧩 7. Comparison Summary

| Type     | Interface  | Allows Duplicates? | Ordered?   | Key-Value? | Common Implementations                |
| -------- | ---------- | ------------------ | ---------- | ---------- | ------------------------------------- |
| **List** | `List<E>`  | ✅ Yes              | ✅ Yes      | ❌ No       | `ArrayList`, `LinkedList`             |
| **Set**  | `Set<E>`   | ❌ No               | ⚙️ Depends | ❌ No       | `HashSet`, `LinkedHashSet`, `TreeSet` |
| **Map**  | `Map<K,V>` | ❌ Keys only        | ⚙️ Depends | ✅ Yes      | `HashMap`, `TreeMap`, `LinkedHashMap` |

---

## 🧩 8. Utility Class: `Collections`

Java provides the **`Collections` utility class** for common operations.

### Example:

```java
import java.util.*;

public class CollectionsExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 2, 5);

        Collections.sort(numbers);
        System.out.println("Sorted: " + numbers);

        Collections.reverse(numbers);
        System.out.println("Reversed: " + numbers);

        System.out.println("Max: " + Collections.max(numbers));
    }
}
```

**Output:**

```
Sorted: [1, 2, 3, 4, 5]
Reversed: [5, 4, 3, 2, 1]
Max: 5
```

✅ **Common methods:**

* `sort()`, `reverse()`, `shuffle()`, `max()`, `min()`, `frequency()`, `binarySearch()`

---

## 🧠 Discussion: Choosing the Right Collection

| Use Case                                       | Recommended Collection |
| ---------------------------------------------- | ---------------------- |
| Need ordered, index-based list with duplicates | `ArrayList`            |
| Need fast insertion/deletion from both ends    | `LinkedList`           |
| Need unique elements without order             | `HashSet`              |
| Need unique elements in sorted order           | `TreeSet`              |
| Need key-value mapping with fast lookup        | `HashMap`              |
| Need sorted key-value pairs                    | `TreeMap`              |

---

## 🧩 9. Summary

| Concept                         | Description                                                                               |
| ------------------------------- | ----------------------------------------------------------------------------------------- |
| **Collections Framework**       | Unified set of interfaces, implementations, and utilities for working with groups of data |
| **Interface vs Implementation** | Interface defines *what* operations, implementation defines *how* they are done           |
| **List**                        | Ordered, allows duplicates                                                                |
| **Set**                         | Unordered, no duplicates                                                                  |
| **Map**                         | Key-value pairs, unique keys                                                              |
| **Common Classes**              | `ArrayList`, `HashSet`, `TreeMap`, `HashMap`, `LinkedHashSet`                             |

---
