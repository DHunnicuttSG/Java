# Quick Sort in Java

**Suggested time:** 30 minutes

## Learning Objectives

By the end of this lesson, students should be able to:

- Explain partitioning around a pivot
- Implement Quick Sort recursively in Java
- Trace the Lomuto partition scheme
- Describe average-case and worst-case performance

## How Quick Sort Works

Quick Sort chooses a pivot, partitions the array around it, and recursively sorts each partition:

1. Choose a pivot.
2. Move smaller values before the pivot and larger values after it.
3. Recursively sort the values before and after the pivot.

This lesson uses the Lomuto partition scheme. It selects the final element as the pivot and maintains a boundary between values less than or equal to the pivot and values greater than the pivot.

Starting with:

```text
[10, 80, 30, 90, 40, 50]
```

If the pivot is `50`, a resulting partition could be:

```text
[10, 30, 40, 50, 80, 90]
           pivot
```

## Java Implementation

```java
public class QuickSortExample {

    public static void quickSort(int[] values) {
        quickSort(values, 0, values.length - 1);
    }

    private static void quickSort(int[] values, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(values, low, high);
        quickSort(values, low, pivotIndex - 1);
        quickSort(values, pivotIndex + 1, high);
    }

    private static int partition(int[] values, int low, int high) {
        int pivot = values[high];
        int smallerBoundary = low;

        for (int scan = low; scan < high; scan++) {
            if (values[scan] <= pivot) {
                swap(values, smallerBoundary, scan);
                smallerBoundary++;
            }
        }

        swap(values, smallerBoundary, high);
        return smallerBoundary;
    }

    private static void swap(int[] values, int first, int second) {
        int temporary = values[first];
        values[first] = values[second];
        values[second] = temporary;
    }

    public static void main(String[] args) {
        int[] numbers = {10, 80, 30, 90, 40, 50};

        quickSort(numbers);

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
```

## Partition Trace

Partition `[7, 2, 1, 6, 8, 5, 3, 4]` with pivot `4`:

| Scan | Action |
| --- | --- |
| 7 | Greater than 4; continue |
| 2 | Swap boundary and scan; boundary moves right |
| 1 | Swap boundary and scan; boundary moves right |
| 6 | Greater than 4; continue |
| 8 | Greater than 4; continue |
| 5 | Greater than 4; continue |
| 3 | Swap boundary and scan; boundary moves right |
| Pivot | Swap pivot into boundary position |

## Complexity

| Case | Time Complexity |
| --- | --- |
| Best | O(n log n) |
| Average | O(n log n) |
| Worst | O(n²) |

The worst case occurs when each pivot selects the smallest or largest remaining value. Arrays that are already sorted with the final element always selected are a worst-case example.

Quick Sort uses O(log n) expected stack space for balanced partitions. Standard Quick Sort is not stable. It usually sorts in place except for recursion, but worst-case recursion can use O(n) stack space.

## Improving the Pivot Choice

Selecting the last value is easy to teach but can cause poor partitions. A practical improvement is to:

- Select a random pivot and swap it with the last element.
- Use the median of three values: low, middle, and high.
- Stop recursive calls for small subarrays and use Insertion Sort.

## Guided Practice

For the array:

```text
[5, 1, 3, 9, 8, 2, 7]
```

The pivot is `7`. Show the array immediately after partitioning:

```text
________
```

## Independent Practice

1. Implement a middle-pivot choice.
2. Modify the code to print the low, pivot, and high values for each recursive call.
3. Count comparisons made on sorted, reverse-sorted, and random arrays.
4. Add a median-of-three pivot and compare it with the final-element pivot.

## Key Takeaway

Quick Sort is usually fast and sorts in place, but its performance depends strongly on pivot choice. Median or randomized pivot choices reduce the likelihood of poor partitions.
