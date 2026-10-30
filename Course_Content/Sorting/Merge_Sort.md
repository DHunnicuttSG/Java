# Merge Sort in Java

**Suggested time:** 30 minutes

## Learning Objectives

By the end of this lesson, students should be able to:

- Explain divide, conquer, and combine
- Describe the merge operation for sorted halves
- Implement Merge Sort recursively in Java
- Identify Merge Sort's complexity and space usage

## How Merge Sort Works

Merge Sort follows divide-and-conquer:

1. **Divide:** Split the array into two halves.
2. **Conquer:** Recursively sort each half.
3. **Combine:** Merge the sorted halves into one sorted array.

For example:

```text
[38, 27, 43, 3, 9, 82, 10]
              divide
[38, 27, 43, 3] | [9, 82, 10]
    divide              divide
[38, 27] | [43, 3] | [9, 82] | [10]
       sort and merge...
[3, 27, 38, 43] | [9, 10, 82]
              merge
[3, 9, 10, 27, 38, 43, 82]
```

## Java Implementation

```java
import java.util.Arrays;

public class MergeSortExample {

    public static void mergeSort(int[] values) {
        if (values.length < 2) {
            return;
        }
        mergeSort(values, 0, values.length - 1);
    }

    private static void mergeSort(int[] values, int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = left + (right - left) / 2;
        mergeSort(values, left, middle);
        mergeSort(values, middle + 1, right);
        merge(values, left, middle, right);
    }

    private static void merge(int[] values, int left, int middle, int right) {
        int[] leftValues = Arrays.copyOfRange(values, left, middle + 1);
        int[] rightValues = Arrays.copyOfRange(values, middle + 1, right + 1);

        int leftIndex = 0;
        int rightIndex = 0;
        int destination = left;

        while (leftIndex < leftValues.length && rightIndex < rightValues.length) {
            if (leftValues[leftIndex] <= rightValues[rightIndex]) {
                values[destination++] = leftValues[leftIndex++];
            } else {
                values[destination++] = rightValues[rightIndex++];
            }
        }

        while (leftIndex < leftValues.length) {
            values[destination++] = leftValues[leftIndex++];
        }

        while (rightIndex < rightValues.length) {
            values[destination++] = rightValues[rightIndex++];
        }
    }

    public static void main(String[] args) {
        int[] numbers = {38, 27, 43, 3, 9, 82, 10};

        mergeSort(numbers);

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
```

The comparison uses `<=` so that equal values from the left half are copied first. This helps preserve stability.

## Trace the Merge

Given the sorted halves:

```text
Left:  [2, 7, 8]
Right: [1, 4, 9]
```

1. Compare `2` and `1`. Copy `1`.
2. Compare `2` and `4`. Copy `2`.
3. Compare `7` and `4`. Copy `4`.
4. Continue until both halves are empty.

## Complexity

Merge Sort has:

- Best, average, and worst-case time: O(n log n)
- Additional space: O(n) for the temporary arrays
- Recursive call stack space: O(log n) in addition to temporary arrays
- A stable result

Merge Sort is reliable and predictable, but its temporary storage makes it less memory-efficient than some other algorithms.

## Guided Practice

Calculate the array sizes at each recursive level for eight elements:

```text
Level 0: 8
Level 1: __, __
Level 2: __, __, __, __
Level 3: each level: __
```

How many comparisons could be required to merge two halves containing four elements each?

## Independent Practice

1. Add print statements to show each recursive call's `left` and `right` bounds.
2. Remove `Arrays.copyOfRange` and implement the merge with one temporary array containing both halves.
3. Modify the algorithm to sort `String[]` values in alphabetical order.
4. Count the number of element copies made by the merge operation.

## Key Takeaway

Merge Sort guarantees O(n log n) time and is stable. The main tradeoff is additional memory. It demonstrates the divide-and-conquer strategy used in many advanced algorithms.
