package lab4;

/**
 * The Stack interface represents a stack data structure.
 * It contains methods for adding, removing, and accessing elements in the stack.
 * @param <T> the type of elements in the stack
 */
public interface stack<T> {

    /**
     * Returns the number of elements in the stack.
     * @return the number of elements in the stack
     */
    int size();

    /**
     * Returns true if the stack is empty, false otherwise.
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Inserts an element at the top of the stack.
     * @param e the element to be inserted
     */
    void push(T e);

    /**
     * Returns, but does not remove, the element at the top of the stack.
     * @return the element at the top of the stack, or null if the stack is empty
     */
    T top();

    /**
     * Removes and returns the element at the top of the stack.
     * @return the element at the top of the stack, or null if the stack is empty
     */
    T pop();
}