package lab4;

/**
 * The ArrayQueue class represents a queue data structure implemented using an array.
 * It contains methods for adding, removing, and accessing elements in the queue.
 * @param <T> the type of elements in the queue
 */
public class ArrayQueue<T> implements Queue<T> {
    private T[] data;
    private int front = 0;
    private int rear = 0;
    private int size = 0;

    /**
     * Constructs a new ArrayQueue with the given capacity.
     * @param capacity the maximum number of elements the queue can hold
     */
    public ArrayQueue(int capacity){
        data = (T[]) new Object[capacity];
    }

    /**
     * Returns the number of elements in the queue.
     * @return the number of elements in the queue
     */
    public int size(){
        return size;
    }

    /**
     * Returns true if the queue is empty, false otherwise.
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty(){
        return (size==0);
    }

    /**
     * Inserts an element at the rear of the queue.
     * @param t the element to be inserted
     * @throws IllegalStateException if the queue is full
     */
    public void enqueue(T t) throws IllegalStateException{
        if(size==data.length){
            throw new IllegalStateException("Array size is full");
        }
        data[rear]=t;
        rear = (rear+1)%data.length;
        size++;
    }

    /**
     * Returns, but does not remove, the element at the front of the queue.
     * @return the element at the front of the queue, or null if the queue is empty
     */
    public T first(){
        if (isEmpty()){
            return null;
        }
        return data[front];
    }

    /**
     * Removes and returns the element at the front of the queue.
     * @return the element at the front of the queue, or null if the queue is empty
     */
    public T dequeue(){
        if (isEmpty()){
            return null;
        }
        T temp = data[front];
        data[front]=null;
        front = (front+1)%data.length;
        size--;
        return temp;
    }
}