package LAB4.QueueImplementation;
import LAB4.*;

public class RoundRobinScheduler {
    public static void main(String[] args) {
        // Create a new ArrayQueue with a capacity of 10
        ArrayQueue<String> queue = new ArrayQueue<>(10);

        // Add some processes to the queue
        queue.enqueue("Process 1");
        queue.enqueue("Process 2");
        queue.enqueue("Process 3");
        queue.enqueue("Process 4");
        queue.enqueue("Process 5");

        // Set the time quantum for the round-robin scheduler
        int timeQuantum = 2;

        // Run the round-robin scheduler
        while (!queue.isEmpty()) {
            // Get the next process from the queue
            String process = queue.dequeue();

            // Run the process for the time quantum
            System.out.println("Running process " + process + " for " + timeQuantum + " seconds...");

            // If the process is not finished, add it back to the queue
            if (Math.random() < 0.5) {
                System.out.println("Process " + process + " not finished, adding back to queue...");
                queue.enqueue(process);
            } else {
                System.out.println("Process " + process + " finished.");
            }
        }
    }
}
    