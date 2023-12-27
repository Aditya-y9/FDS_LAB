package LAB9;

import java.util.ArrayList;
import java.util.Random;

/**
 * Abstract class for the HashMap data structure
 * A HashMap is a data structure that stores key-value pairs
 * It is an implementation of the Map ADT
 * It uses a hash-table as the underlying data structure
 * The hash-table is an array of buckets (chains)
 * Each bucket is a data structure that stores key-value pairs
 * The hash-table is indexed by the hash-value of the key
 * The hash-value is computed using a hash-function
 * The hash-function is a function that maps the key to an integer in the range [0, N-1] where N is the size of the hash-table
 * The hash-function is implemented in the hashValue() method
 * The hash-function used is the MAD (Multiply-Add-Divide) method
 * The hash-table is resized when the load factor (n/N) exceeds 0.5
 * The hash-table is resized to a new capacity of 2N - 1
    * @param <K> the key type
    * @param <V> the value type
 */

public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {

    protected int n = 0; // current number of entries in the HashMap
    protected int capacity; // size of the hash table
    private final int prime; // prime factor
    private final long scale, shift; // shifting and scaling factors

    // two input arguments constructor
    AbstractHashMap(int cap, int p) {
        this.capacity = cap;
        this.prime = p;
        Random rand = new Random();
        // we know that range of scale is [1, prime - 1] and range of shift is [0, prime]
        this.scale = rand.nextInt(this.prime - 1) + 1;
        this.shift = rand.nextInt(this.prime);
        createTable();
    }

    // one input argument constructor redirecting to the two-args constructor with a default prime
    AbstractHashMap(int cap) {
        // delegate to the two-args constructor with a default prime
        this(cap, 65537);
    }

    // default constructor redirecting to the one-arg constructor with a default capacity and prime
    // which then redirects to the two-args constructor with a default prime
    AbstractHashMap() {
        // delegate to the one-arg constructor with a default capacity
        this(20);
    }

    // abstract methods to be implemented in the subclasses
    protected abstract void createTable();

    protected abstract V bucketGet(int h, K k);

    protected abstract V bucketPut(int h, K k, V v);

    protected abstract V bucketRemove(int h, K k);


    // hash function
    // MAD approach
    // h(k) = (|k| * scale + shift) mod prime mod capacity
    // where |k| is the absolute value of the key's hash code
    // scale and shift are randomly generated integers in the range [0, prime - 1] and [0, prime] respectively
    private int hashValue(K k) {
        // return the hash-value using the MAD method
        return (int) ((Math.abs(k.hashCode() * this.scale + this.shift) % this.prime) % this.capacity);
    }
    


    private void resize(int newCap) {
        // resize the hash-table when the number of entries in the hash-map start to exceed the hash-table's capacity

        ArrayList<Entry<K, V>> temp = new ArrayList<>(this.n); // store the current hash-map

        // deep-copy the current hash-map to the temp array
        for (Entry<K, V> entry : entrySet()) {
            temp.add(entry);
        }

        // create a new hash-map and update the corresponding size attributes
        this.capacity = newCap;
        createTable(); // based on the new capacity attribute
        this.n = 0;

        // copy back the previously stored entries in the old hash-map
        for (Entry<K, V> entry : temp) {
            this.put(entry.getKey(), entry.getValue());
        }
    }


    public int size() {
        return this.n; // return current number of entries in the HashMap
    }

    public V get(K k) {
        return bucketGet(hashValue(k), k);
    }

    public V remove(K k) {
        return bucketRemove(hashValue(k), k);
    }

    public V put(K k, V v) {
        V temp = bucketPut(hashValue(k), k, v);

        // check the load factor alpha (n/N) if it is within the required limits (less than 0.5) - if not, then resize the hash-map with a new capacity
        if (this.n / this.capacity > 1 / 2) {

            // resize the hash-map with a new capacity equal to 2N - 1
            resize(2 * this.capacity - 1);
        }

        return temp;
    }

}
