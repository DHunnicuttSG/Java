# Insertion Sort in Java

**Suggested time:** 25 minutes

## Learning Objectives

By the end of this lesson, students should be able to:

- Explain the concept of building a sorted portion of an array
- Trace insertion of a value into a sorted portion
- Implement Insertion Sort in Java
- Compare the best-, average-, and worst-case complexity

## How Insertion Sort Works

Insertion Sort divides the array conceptually into a sorted portion and an unsorted portion. It takes one value from the unsorted portion and inserts it into the correct position in the sorted portion.

Think of sorting cards in your hand: when a new card arrives, shift larger cards to the right and place the new card in the gap.

Start with:

```text
[5, 2, 4, 6, 1, 3]
```

Process each value after the first one:

```text
[5 | 2, 4, 6, 1, 3]
[2, 5 | 4, 6, 1, 3]
[2, 4, 5 | 6, 1, 3]
```

The vertical bar separates the sorted and unsorted portions.

## Java Implementation

```java
public class InsertionSortExample {

    public static void insertionSort(int[] values) {
        for (int unsortedIndex = 1; unsortedIndex < values.length; unsortedIndex++) {
            int current = values[unsortedIndex];
            int sortedIndex = unsortedIndex - 1;

            while (sortedIndex >= 0 && values[sortedIndex] > current) {
                values[sortedIndex + 1] = values[sortedIndex];
                sortedIndex--;
            }

            values[sortedIndex + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {5, 2, 4, 6, 1, 3};

        insertionSort(numbers);

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
```

The algorithm does shifts rather than immediate swaps. This is efficient when each new value must move only a short distance.

## Complexity

| Case | Time Complexity | Additional Space |
| --- | --- | --- |
| Best: already sorted | O(n) | O(1) |
| Average | O(n²) | O(1) |
| Worst: reverse sorted | O(n²) | O(1) |

Insertion Sort is stable. It works especially well for small arrays and arrays that are nearly sorted. Java's standard library may use an insertion-sort-like optimization for small subarrays.

## Guided Practice

Trace the sorted portion for:

```text
[8, 5, 4, 7, 3]
```

For each value, write the array after insertion:

```text
After inserting 5: ______
After inserting 4: ______
After inserting 7: ______
```

## Independent Practice

1. Sort a list of students by an integer grade. Use a `Student` class with `name` and `grade` fields.
2. Change the algorithm from ascending order to descending order.
3. Count the number of comparisons made for each possible permutation of `{1, 2, 3}`.
4. Compare the number of comparisons for Insertion Sort with an already sorted array and a reverse-sorted array of size 100.

## Key Takeaway

Insertion Sort is easy to implement, stable, and efficient for small or nearly sorted arrays. Its quadratic worst case makes it unsuitable by itself for large random datasets.
