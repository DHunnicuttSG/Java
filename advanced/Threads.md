# Java Concurrency: Threads, Parallelism, and Multithreading

Welcome to this in-depth module on Java concurrency! Over the next eight hours, we will explore how to write programs that can perform multiple tasks at the same time, which is essential for building high-performance and responsive applications. We'll start with the basic concepts and move on to the advanced tools and techniques used in professional development.

## Hour 1 & 2: Understanding Threads and Their Lifecycle

### What is a Thread?

A thread is the smallest unit of execution within a process. Think of a program as a factory; a process is the entire factory, while threads are the individual workers on the assembly line. A single-threaded program has only one worker, while a multi-threaded program has many, allowing it to complete tasks more efficiently.

* Concurrency vs. Parallelism:

    * Concurrency is about dealing with many things at once. A single-core processor can be concurrent by switching between tasks very quickly (context switching), giving the illusion of simultaneous execution.

    * Parallelism is about doing many things at once. This requires multiple processors or cores, where each thread can truly execute at the exact same time.
    
    Creating and Starting Threads
    
    There are two primary ways to create a thread in Java:
    
    1. Implementing the Runnable interface: This is the preferred method because it separates the task logic from the thread itself, allowing a single Runnable object to be executed by multiple threads.
    
    2. Extending the Thread class: This is less common because Java does not support multiple inheritance, so you can't extend another class at the same time.
    
```java    
/*
 * Example demonstrating how to create and start threads using both methods.
 */
// Method 1: Implementing the Runnable interface
class MyRunnableTask implements Runnable {
    private String taskName;

    public MyRunnableTask(String name) {
        this.taskName = name;
    }

    @Override
    public void run() {
        System.out.println("Starting task: " + taskName + " on thread: " + Thread.currentThread().getName());
        try {
            // Simulate work
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            System.out.println(taskName + " was interrupted.");
        }
        System.out.println("Finished task: " + taskName);
    }
}

// Method 2: Extending the Thread class
class MyThreadTask extends Thread {
    private String taskName;

    public MyThreadTask(String name) {
        super(name);
        this.taskName = name;
    }

    @Override
    public void run() {
        System.out.println("Starting task: " + taskName + " on thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(taskName + " was interrupted.");
        }
        System.out.println("Finished task: " + taskName);
    }
}

public class ThreadCreationDemo {
    public static void main(String[] args) {
        // Create a thread using the Runnable interface
        Thread t1 = new Thread(new MyRunnableTask("Runnable Task 1"));
        
        // Create a thread by extending the Thread class
        Thread t2 = new MyThreadTask("Thread Class Task 2");
        
        // Start the threads. This invokes the run() method in a new thread of execution.
        t1.start();
        t2.start();
        
        System.out.println("Main thread has launched tasks and is now finished.");
    }
}
```

Thread States

A thread can exist in one of six states. Understanding these states is crucial for debugging and managing concurrent programs.

* NEW: The thread has been created but not yet started.
* RUNNABLE: The thread is ready to run and is waiting for the CPU.
* BLOCKED: The thread is waiting to acquire a monitor lock (e.g., waiting for a synchronized block).
* WAITING: The thread is waiting indefinitely for another thread to perform a specific action, such as calling notify() or notifyAll().
* TIMED_WAITING: The thread is waiting for another thread to perform an action for a specified amount of time.
* TERMINATED: The thread has finished its execution.

## Hour 3 & 4: The Problem of Concurrency and Synchronization

### The Dangers of Shared Data

When multiple threads access and modify the same data simultaneously, you can run into serious problems.

* Race Condition: Occurs when the outcome of a program depends on the unpredictable order of execution of multiple threads.
* Deadlock: A situation where two or more threads are blocked forever, waiting for each other to release a resource.

**The synchronized Keyword**

The synchronized keyword provides a built-in mechanism for thread safety by ensuring that only one thread can execute a block of code at a time. It uses an intrinsic lock (or monitor lock).

```java
/*
 * Example demonstrating a race condition and how to fix it with `synchronized`.
 */
class Counter {
    private int count = 0;

    // This method is NOT thread-safe. Multiple threads can access and modify 'count' at the same time.
    public void increment() {
        count++;
    }

    // This method is thread-safe using the 'synchronized' keyword.
    // Only one thread can execute this method at a time.
    public synchronized void synchronizedIncrement() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class SyncDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment(); // Race condition here!
                // counter.synchronizedIncrement(); // Use this to fix the race condition.
            }
        };

        // Create two threads to increment the counter
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        // The expected result is 2000, but due to the race condition, it will likely be less.
        System.out.println("Final count (unsynchronized): " + counter.getCount());
    }
}
```

**The Lock Interface**

The java.util.concurrent.locks.Lock interface provides a more flexible alternative to synchronized. It gives you more control over the locking process.

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SafeCounter {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock(); // Acquire the lock
        try {
            count++;
        } finally {
            lock.unlock(); // Release the lock in a finally block
        }
    }

    public int getCount() {
        return count;
    }
}
```

## Hour 5: Inter-Thread Communication

Sometimes, threads need to communicate with each other. The Object class's wait(), notify(), and notifyAll() methods are the classic way to achieve this.

* wait(): Puts the current thread in a WAITING state, releasing the lock it holds.
* notify(): Wakes up a single waiting thread.
* notifyAll(): Wakes up all waiting threads.

Note: These methods must be called from within a synchronized block.

```java
/*
 * Example of the classic Producer-Consumer problem
 * to demonstrate inter-thread communication.
 */
import java.util.LinkedList;
import java.util.Queue;

class Buffer {
    private Queue<Integer> items = new LinkedList<>();
    private int capacity = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (items.size() == capacity) {
            // Buffer is full, wait for a consumer to take an item
            wait();
        }
        items.add(value);
        System.out.println("Produced: " + value);
        notifyAll(); // Wake up any waiting consumers
    }

    public synchronized int consume() throws InterruptedException {
        while (items.isEmpty()) {
            // Buffer is empty, wait for a producer to add an item
            wait();
        }
        int value = items.remove();
        System.out.println("Consumed: " + value);
        notifyAll(); // Wake up any waiting producers
        return value;
    }
}

public class InterThreadCommunicationDemo {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        // Producer thread
        Runnable producer = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    buffer.produce(i);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {}
        };

        // Consumer thread
        Runnable consumer = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    buffer.consume();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {}
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
```

## Hour 6 & 7: The java.util.concurrent Package

The modern java.util.concurrent package provides a rich set of high-level tools that simplify concurrent programming and are often preferred over lower-level synchronized and wait/notify methods.

### The ExecutorService and Thread Pools

Creating and destroying threads is expensive. A thread pool is a collection of pre-created worker threads that can be reused to execute tasks. ExecutorService is the interface for managing these pools.

* Executors.newFixedThreadPool(int nThreads): Creates a fixed-size thread pool.
* submit(Runnable task): Submits a Runnable task for execution.
* submit(Callable task): Submits a Callable task, which can return a value and throw an exception. It returns a Future object.

```java
/*
 * Example using ExecutorService and Callable/Future.
 */
import java.util.concurrent.*;

public class ExecutorServiceDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Create a thread pool with 2 worker threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Define a task that returns a value (Callable)
        Callable<Integer> sumTask = () -> {
            System.out.println("Calculating sum on thread: " + Thread.currentThread().getName());
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            return sum;
        };

        // Submit the task and get a Future object
        Future<Integer> futureResult = executor.submit(sumTask);

        System.out.println("Main thread is waiting for the result...");

        // Block and wait for the result
        Integer result = futureResult.get(); 

        System.out.println("The sum is: " + result);

        // Shut down the executor service cleanly
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }
}
```

**Atomic Variables and Thread-Safe Collections**

For simple thread-safe operations, you don't always need a full lock. The java.util.concurrent.atomic package provides classes like AtomicInteger that perform atomic (uninterruptible) operations without explicit locking.

Thread-Safe Collections: Collections like ArrayList and HashMap are not thread-safe. Java provides concurrent versions of these collections in the java.util.concurrent package, such as ConcurrentHashMap and CopyOnWriteArrayList.


## Hour 8: Advanced Concurrency Topics

### Deadlocks, Livelocks, and Starvation

* Deadlock: A state where threads are perpetually waiting for resources held by each other. The four conditions for a deadlock are:
    1. Mutual Exclusion: Resources can only be used by one thread at a time.
    2. Hold and Wait: A thread holds a resource while waiting for another.
    3. No Preemption: A thread cannot be forced to release a resource.
    4. Circular Wait: A circular chain of threads waiting for each other's resources.
* Livelock: A situation where threads are not blocked, but they are constantly reacting to each other's actions, leading to no progress.
* Starvation: Occurs when a thread is perpetually denied access to resources it needs, often due to a poor scheduling policy.

### Summary and Next Steps

You've now covered the core concepts of Java concurrency, from the low-level Thread class to the high-level ExecutorService. Remember to always consider thread safety when working with shared data and to prefer the modern tools in java.util.concurrent when possible.

For your next steps, I recommend trying to implement a more complex concurrent application, such as a multi-threaded web server or a parallel sorting algorithm, to put these concepts into practice.