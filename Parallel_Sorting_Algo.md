```java
// ParallelSortDemo.java
// This program demonstrates the use of Arrays.parallelSort() and compares its performance
// to the traditional Arrays.sort() method for large datasets.

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ParallelSortDemo {

    // Define the size of the array to be sorted.
    // Parallel sorting is most effective on large datasets.
    private static final int ARRAY_SIZE = 100_000_000;

    public static void main(String[] args) {
        System.out.println("Beginning sorting performance comparison with an array size of " + ARRAY_SIZE);
        
        // Create an array and populate it with random integers
        int[] dataForParallelSort = generateRandomArray(ARRAY_SIZE);
        
        // Create a copy for the serial sort comparison
        int[] dataForSerialSort = Arrays.copyOf(dataForParallelSort, ARRAY_SIZE);

        System.out.println("Starting serial sort...");
        long serialStartTime = System.nanoTime();
        // Use the traditional single-threaded sort
        Arrays.sort(dataForSerialSort);
        long serialEndTime = System.nanoTime();
        long serialDuration = (serialEndTime - serialStartTime) / 1_000_000;
        System.out.println("Serial sort finished. Duration: " + serialDuration + " ms");

        System.out.println("\nStarting parallel sort...");
        long parallelStartTime = System.nanoTime();
        // Use the multi-threaded parallel sort
        Arrays.parallelSort(dataForParallelSort);
        long parallelEndTime = System.nanoTime();
        long parallelDuration = (parallelEndTime - parallelStartTime) / 1_000_000;
        System.out.println("Parallel sort finished. Duration: " + parallelDuration + " ms");
        
        // It's a good practice to verify that both arrays are sorted correctly
        boolean arraysAreIdentical = Arrays.equals(dataForParallelSort, dataForSerialSort);
        System.out.println("\nDid both sorts produce the same result? " + arraysAreIdentical);
        
        // You can also demonstrate a custom parallel sort using streams
        System.out.println("\nDemonstrating parallel stream sort...");
        int[] dataForStreamSort = generateRandomArray(ARRAY_SIZE);
        long streamStartTime = System.nanoTime();
        int[] sortedByStream = IntStream.of(dataForStreamSort).parallel().sorted().toArray();
        long streamEndTime = System.nanoTime();
        long streamDuration = (streamEndTime - streamStartTime) / 1_000_000;
        System.out.println("Parallel stream sort finished. Duration: " + streamDuration + " ms");
        
        // Let's check the number of threads used by the default ForkJoinPool.
        // This is a simple way to see how many cores the system is using.
        System.out.println("\nNumber of threads in the common Fork/Join pool: " + ForkJoinPool.commonPool().getParallelism());
    }

    /**
     * Helper method to generate an array of a given size with random integers.
     *
     * @param size The number of elements in the array.
     * @return A new array populated with random integers.
     */
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        return random.ints(size).toArray();
    }
}
```