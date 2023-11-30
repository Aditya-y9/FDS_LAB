package LAB8.HeapsImplementation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import LAB8.*;

/**
 * Implementation of a priority queue using a heap data structure.
 * The elements in the priority queue are ordered based on their priority.
 *
 * @param <K> The type of keys stored in the priority queue.
 * @param <V> The type of values stored in the priority queue.
 */
public class HeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V>{

    // initiate empty AL of entries
    ArrayList<Entry<K,V>> heap = new ArrayList<>();

    // call to default comparator
    public HeapPriorityQueue(){
        super();
    }

    // call to our own defined comparator
    public HeapPriorityQueue(Comparator comp){
        super(comp);
    }

    /**
     * Checks if the priority queue is empty.
     * @return true if the priority queue is empty, false otherwise.
     */
    public boolean isEmpty(){
        return heap.size()==0;
    }

    /**
     * Returns the number of elements in the priority queue.
     *
     * @return The number of elements in the priority queue.
     */
    public int size(){
        return heap.size();
    }

    /**
     * Returns the index of the parent of the element at index j.
     *
     * @param j The index of the element.
     * @return The index of the parent of the element at index j.
     */
    protected int parent(int j){
        return (j-1)/2;
    }

    /**
     * Returns the index of the left child of the element at index j.
     *
     * @param j The index of the element.
     * @return The index of the left child of the element at index j.
     */
    protected int left(int j){
        return 2*j+1;
    }

    /**
     * Returns the index of the right child of the element at index j.
     *
     * @param j The index of the element.
     * @return The index of the right child of the element at index j.
     */
    protected int right(int j){
        return 2*j+2;
    }

    /**
     * Checks if the element at index j has a left child.
     *
     * @param j The index of the element.
     * @return true if the element has a left child, false otherwise.
     */
    protected boolean hasLeft(int j){
        return (left(j)<heap.size());
    }

    /**
     * Checks if the element at index j has a right child.
     *
     * @param j The index of the element.
     * @return true if the element has a right child, false otherwise.
     */
    protected boolean hasRight(int j){
        return (right(j)<heap.size());
    }

    /**
     * Swaps the elements at indices i and j in the heap.
     *
     * @param i The index of the first element.
     * @param j The index of the second element.
     */
    protected void swap(int i,int j){
        // store contents of index i in temp entry
        Entry<K,V> temp = heap.get(i);

        // heap.set(index? , Entry)
        heap.set(i,heap.get(j));
        heap.set(j,temp);
    }

    /**
     * Restores the heap order property by moving the element at index j up the heap.
     *
     * @param j The index of the element.
     */
    protected void upheap(int j){
        while(j>0){
            int p=parent(j);
            if(compare(heap.get(j),heap.get(p))>=0){
                break;
            }
            // if not in heap order, swap them
            swap(j,p);
            // consider parent now
            j=p;
        }
    }

    /**
     * Restores the heap order property by moving the element at index j down the heap.
     *
     * @param j The index of the element.
     */
    protected void downheap(int j){

        // while left child exists
        while(hasLeft(j)){

            // store the left index
            int leftindex = left(j);

            // assume left to be smaller
            int SmallChildIndex = leftindex;

            // only if node has a right child
            if(hasRight(j)){

                // store to compare
                int rightindex = right(j);
                
                // if left is not small
                if(compare(heap.get(leftindex), heap.get(rightindex))>=0){
                    SmallChildIndex = rightindex;
                }
            }
            // if parent is not smaller than smallest child of left and right
            if(compare(heap.get(SmallChildIndex),heap.get(j))>=0){
                break;
            }

            // otherwise swap parent and smallest child
            swap(j, SmallChildIndex);
            
            // continue same algorithm for child
            j = SmallChildIndex;
        }

    }

    /**
     * Returns the minimum element in the priority queue.
     *
     * @return The minimum element in the priority queue, or null if the priority queue is empty.
     */
    public Entry<K,V> min(){
        if(heap.isEmpty()){
            return null;
        }
        // O(1) as min is always at root of heap DS
        return heap.get(0);
    }


    /**
     * Inserts a new element with the given key and value into the priority queue.
     *
     * @param key The key of the new element.
     * @param value The value of the new element.
     * @return The entry representing the new element.
     * @throws IllegalArgumentException if the key is invalid.
     */
    public Entry<K,V> insert(K key, V value) throws IllegalArgumentException{
        checkKey(key);
        
        // make a new entry
        Entry<K,V> novel = new Entry<>(key, value);

        // add to end
        heap.add(novel);

        // upheap last index (leaf)
        upheap(heap.size()-1);

        return novel;
    }

    /**
     * Removes and returns the minimum element from the priority queue.
     *
     * @return The minimum element in the priority queue, or null if the priority queue is empty.
     */
    public Entry<K,V> removeMin(){
        if(heap.isEmpty()){
            return null;
        }

        Entry<K,V> temp = heap.get(0);

        // put leaf to root to avoid cutting into two trees
        swap(0,heap.size()-1);

        // remove our copied root , but at leaf
        heap.remove(heap.size()-1);

        // adjust our own created problem of putting leaf to node
        downheap(0);

        // return node
        return temp;
    }

    /**
     * Returns a list of all entries in the priority queue.
     *
     * @return A list of all entries in the priority queue.
     */
    public List<Entry<K,V>> entries(){
        return heap;
    }
}

