# Selection Sort in Java

**Suggested time:** 25 minutes

## Learning Objectives

By the end of this lesson, students should be able to:

- Explain how Selection Sort selects a minimum value
- Trace the sorted and unsorted portions of an array
- Implement Selection Sort in Java
- Explain why the number of swaps is usually small

## How Selection Sort Works

Selection Sort scans the unsorted portion to find the smallest value. It then swaps that value with the first element of the unsorted portion.

Start with:

```text
[64, 25, 12, 22, 11]
```

The smallest value, `11`, swaps with position `0`:

```text
[11, 25, 12, 22, 64]
```

Next, find the smallest remaining value, `12`, and place it in position `1`:

```text
[11, 12, 25, 22, 64]
```

Continue until every position is filled.

## Java Implementation

```java
public class SelectionSortExample {

    public static void selectionSort(int[] values) {
        for (int start = 0; start < values.length - 1; start++) {
            int minimumIndex = start;

            for (int scanIndex = start + 1; scanIndex < values.length; scanIndex++) {
                if (values[scanIndex] < values[minimumIndex]) {
                    minimumIndex = scanIndex;
                }
            }

            if (minimumIndex != start) {
                int temporary = values[start];
                values[start] = values[minimumIndex];
                values[minimumIndex] = temporary;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {64, 25, 12, 22, 11};

        selectionSort(numbers);

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
```

## Complexity

| Cost | Amount |
| --- | --- |
| Best case time | O(n²) |
| Average case time | O(n²) |
| Worst case time | O(n²) |
| Additional space | O(1) |
| Swaps | At most n - 1 |

Selection Sort is not stable in its standard form. Consider `[2a, 2b, 1]`: swapping the minimum across the two equal values may change the relative positions of `2a` and `2b`.

Selection Sort always performs roughly the same number of comparisons, even if the array is already sorted.

## Guided Practice

Complete the remaining passes for this array:

```text
[5, 3, 1, 4, 2]
```

1. After the first pass: `________`
2. After the second pass: `________`
3. After the third pass: `________`
4. Final result: `________`

## Independent Practice

1. Add print statements that display the minimum index found during each pass.
2. Count comparisons and swaps separately.
3. Modify the algorithm to find the maximum value and place it at the end.
4. Test both directions: values in ascending order and values in descending order.

## Key Takeaway

Selection Sort performs few swaps, which can be useful when writing an element is expensive. It still requires quadratic comparisons and has poor performance on large unsorted arrays.
