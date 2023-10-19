public interface QueueInterface<T>{
    // add element e to back of queue
    public void enqueue(T item);

    // remove and return element from front of queue
    public T dequeue();

    // return true if queue is empty
    public boolean isEmpty();

    // return number of elements in queue
    public int size();

    // return element at front of queue without removing it
    public T first();
}



