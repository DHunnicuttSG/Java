# Heap Sort in Java

**Suggested time:** 30 minutes

## Learning Objectives

By the end of this lesson, students should be able to:

- Explain a binary heap using array indexes
- Build a max heap
- Extract the maximum value and restore heap order
- Implement Heap Sort in Java
- Identify its in-place time and space complexity

## What Is a Heap?

A binary heap is a nearly complete binary tree stored in an array. Heap Sort typically uses a **max heap**:

- The root contains the maximum value.
- Every parent is greater than or equal to its children.
- Heap property does not require sibling values to be ordered.

For an element at index `i`:

```text
Parent:      (i - 1) / 2
Left child:  2 * i + 1
Right child: 2 * i + 2
```

For example, the array `[4, 10, 3, 5, 1]` can represent a tree where the value `10` is near the root.

## How Heap Sort Works

1. Build a max heap from the array.
2. Swap the root with the last element in the heap.
3. Reduce the heap size and restore the heap property at the root.
4. Repeat until one element remains.

Sorting:

```text
[4, 10, 3, 5, 1]
Build max heap: [10, 5, 3, 4, 1]
Move root to end: [1, 5, 3, 4, 10]
Restore heap: [5, 4, 3, 1, 10]
Continue extracting...
Final: [1, 3, 4, 5, 10]
```

## Java Implementation

```java
public class HeapSortExample {

    public static void heapSort(int[] values) {
        for (int start = values.length / 2 - 1; start >= 0; start--) {
            siftDown(values, values.length, start);
        }

        for (int end = values.length - 1; end > 0; end--) {
            swap(values, 0, end);
            siftDown(values, end, 0);
        }
    }

    private static void siftDown(int[] values, int heapSize, int rootIndex) {
        while (true) {
            int leftChild = 2 * rootIndex + 1;
            if (leftChild >= heapSize) {
                return;
            }

            int largerChild = leftChild;
            int rightChild = leftChild + 1;

            if (rightChild < heapSize
                    && values[rightChild] > values[leftChild]) {
                largerChild = rightChild;
            }

            if (values[rootIndex] >= values[largerChild]) {
                return;
            }

            swap(values, rootIndex, largerChild);
            rootIndex = largerChild;
        }
    }

    private static void swap(int[] values, int first, int second) {
        int temporary = values[first];
        values[first] = values[second];
        values[second] = temporary;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 10, 3, 5, 1};

        heapSort(numbers);

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
```

## Complexity

| Operation | Time Complexity |
| --- | --- |
| Build heap | O(n) |
| Extract maximum n times | O(n log n) |
| Overall best, average, and worst case | O(n log n) |
| Additional array space | O(1) |
| Recursive stack space | none in this implementation |

Heap Sort is not stable. Its worst-case time is also O(n log n), making it more predictable than Quick Sort's worst case, while its constant operations are often slower in practice.

## Guided Practice

Given:

```text
[3, 1, 5, 2, 4]
```

1. What index contains the root?
2. Which elements are the children of index 0?
3. After `siftDown`, what might the root be?
4. What should happen to that root during the first extraction?

## Independent Practice

1. Modify the code to sort in descending order using a min heap.
2. Add a counter for calls to `siftDown`.
3. Compare array and tree representations by drawing the heap represented by the array `{9, 4, 7, 1, 3}`.
4. Explain why Heap Sort needs at most `n log n` comparisons.

## Key Takeaway

Heap Sort combines guaranteed O(n log n) performance with constant additional array space. The heap operations take time to understand, but the algorithm provides a useful alternative to recursive divide-and-conquer sorting.
