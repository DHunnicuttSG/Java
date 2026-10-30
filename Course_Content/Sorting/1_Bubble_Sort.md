# Bubble Sort in Java

**Suggested time:** 25 minutes

## Learning Objectives

By the end of this lesson, students should be able to:

- Explain how Bubble Sort compares and swaps adjacent values
- Trace a Bubble Sort pass by hand
- Implement Bubble Sort in Java
- Identify Bubble Sort's time and space complexity
- Recognize when an early-exit optimization is useful

## How Bubble Sort Works

Bubble Sort repeatedly compares two neighboring elements. If the elements are in the wrong order, it swaps them. After each pass, the largest unsorted value moves to its final position.

Use these values:

```text
[5, 1, 4, 2, 8]
```

The first pass compares neighboring pairs:

```text
[5, 1, 4, 2, 8]
 [1, 5, 4, 2, 8]  swap
 [1, 4, 5, 2, 8]  swap
 [1, 4, 2, 5, 8]  swap
 [1, 4, 2, 5, 8]  no swap
```

The value `8` is now in its final position. Later passes move the remaining largest values toward the end.

## Java Implementation

```java
public class BubbleSortExample {

    public static void bubbleSort(int[] values) {
        for (int end = values.length - 1; end > 0; end--) {
            boolean swapped = false;

            for (int i = 0; i < end; i++) {
                if (values[i] > values[i + 1]) {
                    int temporary = values[i];
                    values[i] = values[i + 1];
                    values[i + 1] = temporary;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {5, 1, 4, 2, 8};

        bubbleSort(numbers);

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
```

The `swapped` variable is set to `true` whenever the pass changes the array. If a pass makes no swaps, the array is already sorted and the method can stop.

## Complexity

| Case | Comparisons | Time Complexity |
| --- | ---: | --- |
| Average | Approximately n(n - 1)/2 | O(n²) |
| Best, with early exit | Approximately n | O(n) |
| Worst | n(n - 1)/2 | O(n²) |

Bubble Sort uses O(1) additional space because values are swapped inside the original array. It is stable, meaning equal values keep their original relative order.

## Guided Practice

Trace this array after one complete pass, from left to right:

```text
[9, 3, 6, 1]
```

1. After the first pass, what value is in the final position?
2. Which adjacent pairs were swapped?
3. How many passes are needed for the algorithm to complete?

## Independent Practice

1. Modify the program to sort `double` values instead of `int` values.
2. Add a counter that reports the number of swaps.
3. Test the algorithm with an already sorted array. How many passes occur?

## Key Takeaway

Bubble Sort is simple to understand, but it is slow on large arrays because it repeatedly compares neighboring elements. In production Java code, use library sorting such as `Arrays.sort()` or `Collections.sort()` instead.
