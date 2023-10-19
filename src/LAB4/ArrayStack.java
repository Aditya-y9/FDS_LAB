package lab4;

/**
 * The ArrayStack class represents a stack data structure implemented using an array.
 * It contains methods for adding, removing, and accessing elements in the stack.
 * @param <T> the type of elements in the stack
 */
public class ArrayStack<T> implements stack<T> {
    private int top = -1;
    private T[] data;

    /**
     * Constructs a new ArrayStack with the given capacity.
     * @param capacity the maximum number of elements the stack can hold
     */
    public ArrayStack(int capacity){
        data = (T[]) new Object[capacity];
    }

    /**
     * Returns the number of elements in the stack.
     * @return the number of elements in the stack
     */
    public int size(){
        return (top+1);
    }

    /**
     * Returns true if the stack is empty, false otherwise.
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty(){
        return (top==-1);
    }

    /**
     * Inserts an element at the top of the stack.
     * @param t the element to be inserted
     * @throws IllegalStateException if the stack is full
     */
    public void push(T t) throws IllegalStateException{
        if(size()==data.length){
            throw new IllegalStateException("Array size is full");
        }
        // increment first as it is -1 earlier and insert data.
        data[++top]=t;
    }

    /**
     * Returns, but does not remove, the element at the top of the stack.
     * @return the element at the top of the stack, or null if the stack is empty
     */
    public T top(){
        if (isEmpty()){
            return null;
        }
        return data[top];
    }

    /**
     * Removes and returns the element at the top of the stack.
     * @return the element at the top of the stack, or null if the stack is empty
     */
    public T pop(){
        if (isEmpty()){
            return null;
        }
        T temp = data[top];
        data[top]=null;
        top--;
        return temp;
    }
}