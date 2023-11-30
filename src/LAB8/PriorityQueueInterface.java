package LAB8;
public interface PriorityQueueInterface<K,V>{

    int size();
    boolean isEmpty();

    // insert generic entry (key,value)
    Entry<K,V> insert(K key,V value) throws IllegalArgumentException;

    // return min (not rem)
    Entry<K,V> min();

    // remove min seedha
    Entry<K,V> removeMin();
}