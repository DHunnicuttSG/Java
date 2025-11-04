Here's a short course on Java threads, with exercises and examples.

### **Module 1: Introduction to Threads**

A **thread** is a lightweight sub-process. It's the smallest unit of a program that can be scheduled for execution. In Java, threads are managed by the Java Virtual Machine (JVM). Multithreading allows a program to handle multiple tasks concurrently, improving performance and responsiveness.

#### **Creating Threads**

There are two primary ways to create a thread in Java:

1.  **Implementing the `Runnable` Interface:** This is the preferred method because it allows you to separate the task (the `run()` method) from the thread's execution mechanism. This is useful for object-oriented design and when a class already inherits from another class.

    ```java
    public class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello from a thread created by implementing Runnable!");
        }
    }

    // In your main method or another class
    Thread thread = new Thread(new MyTask());
    thread.start();
    ```

2.  **Extending the `Thread` Class:** This is a simpler approach but can be less flexible. If your class needs to inherit from another class, you can't use this method as Java doesn't support multiple inheritance.

    ```java
    public class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from a thread created by extending Thread!");
        }
    }

    // In your main method or another class
    MyThread myThread = new MyThread();
    myThread.start();
    ```

#### **Thread Lifecycle**

A thread goes through several states during its life:

  * **NEW:** The thread has been created but not yet started.
  * **RUNNABLE:** The thread is executing or ready to be executed by the JVM's thread scheduler.
  * **BLOCKED:** The thread is waiting for a monitor lock to enter a synchronized block.
  * **WAITING:** The thread is waiting indefinitely for another thread to perform a particular action.
  * **TIMED\_WAITING:** The thread is waiting for a specified period of time.
  * **TERMINATED:** The thread has completed its execution.

-----

### **Module 2: Concurrency and Synchronization**

When multiple threads access shared resources, issues like data corruption can occur. **Synchronization** is the mechanism used to control access to shared resources and prevent these issues.

#### **The `synchronized` Keyword**

The `synchronized` keyword in Java is used to create **critical sections**—blocks of code that can only be executed by one thread at a time. This prevents race conditions.

  * **Synchronized Method:** When a method is declared as `synchronized`, the entire method body becomes a critical section. The lock is on the object instance (`this`).

    ```java
    public synchronized void incrementCounter() {
        // Only one thread can execute this method at a time
        counter++;
    }
    ```

  * **Synchronized Block:** This provides finer-grained control. You can specify a specific object to lock on.

    ```java
    public void someMethod() {
        synchronized (this) {
            // This block is locked on the 'this' object
            counter++;
        }
    }
    ```

#### **Race Conditions**

A **race condition** occurs when the outcome of a program depends on the unpredictable sequence or timing of events. In multithreading, this happens when multiple threads try to read and write a shared resource simultaneously.

#### **Volatile Keyword**

The `volatile` keyword guarantees that a variable's value is always read from and written to main memory, not from a thread's local cache. This ensures visibility of changes across threads. It doesn't, however, provide atomicity.

```java
public class MyVolatileExample {
    public volatile boolean isRunning = true;

    public void stopRunning() {
        isRunning = false;
    }
}
```

-----

### **Module 3: Advanced Concepts and the `java.util.concurrent` package**

The `java.util.concurrent` package introduced in Java 5 provides a powerful set of tools for building robust and scalable concurrent applications.

#### **The `ExecutorService`**

The `ExecutorService` is a high-level API for managing and executing threads. It separates thread creation from task execution, making it easier to manage a pool of threads.

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Create a fixed-size thread pool
ExecutorService executor = Executors.newFixedThreadPool(10);

// Submit a task to the pool
executor.submit(() -> System.out.println("Task executed by a thread pool!"));

// Shut down the executor after all tasks are completed
executor.shutdown();
```

-----

### **Exercises**

#### **Exercise 1: Thread Creation**

**Task:** Create a class named `PrintTask` that implements `Runnable`. The `run()` method should print the numbers from 1 to 5, with a one-second pause between each number (use `Thread.sleep(1000)`). In your `main` method, create two `PrintTask` instances and run them on separate threads.

#### **Exercise 2: Synchronization**

**Task:** Create a class named `Counter` with a private integer `count` and a synchronized method `increment()`. Create a `main` method where you:

1.  Create a `Counter` object.
2.  Create two threads, and in each thread's `run()` method, loop 10,000 times, calling the `increment()` method on the same `Counter` object.
3.  Print the final value of the counter. The result should be exactly 20,000. If it's less, remove the `synchronized` keyword and see the race condition in action.

#### **Exercise 3: ExecutorService**

**Task:** Refactor Exercise 1 to use an `ExecutorService`. Create a fixed-size thread pool and submit your `PrintTask` instances to it. Don't forget to shut down the executor.