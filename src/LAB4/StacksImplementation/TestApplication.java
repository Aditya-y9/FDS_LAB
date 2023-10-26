package LAB4.StacksImplementation;
import LAB4.*;

import java.lang.reflect.Array;

public class TestApplication {
    public static void main(String[] args) {
        // Create a new ArrayStack with a capacity of 10
        ArrayStack<String> stack = new ArrayStack<String>(10);

        // Add some elements to the stack
        stack.push("Hello");
        stack.push("World");
        stack.push("!");

        // Print the size of the stack
        System.out.println(stack.size());

        // Print whether the stack is empty
        System.out.println(stack.isEmpty());

        // Print the top element of the stack
        System.out.println(stack.top());

        // Pop an element from the stack
        System.out.println(stack.pop());

        // Pop an element from the stack
        System.out.println(stack.pop());

        // Pop an element from the stack
        System.out.println(stack.pop());


        ArrayQueue<String> queue = new ArrayQueue<String>(10);

        queue.enqueue("Hello");
        queue.enqueue("World");
        queue.enqueue("!");


        System.out.println(queue.size());

        System.out.println(queue.isEmpty());

        System.out.println(queue.first());

        System.out.println(queue.dequeue());

    }
}