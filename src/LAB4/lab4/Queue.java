package lab4;

/**
 * A generic interface for a queue data structure.
 *
 * @param <T> the type of elements held in this queue
 */
public interface Queue<T> {

        /**
         * Returns the number of elements in the queue.
         *
         * @return the number of elements in the queue
         */
        int size();

        /**
         * Tests whether the queue is empty.
         *
         * @return true if the queue is empty, false otherwise
         */
        boolean isEmpty();

        /**
         * Inserts an element at the rear of the queue.
         *
         * @param t the element to be inserted
         */
        void enqueue(T t);

        /**
         * Returns, but does not remove, the first element of the queue.
         *
         * @return the first element of the queue, or null if the queue is empty
         */
        T first();


        
        /**
         * Removes and returns the first element of the queue.
         *
         * @return the first element of the queue, or null if the queue is empty
         */
        T dequeue();
}