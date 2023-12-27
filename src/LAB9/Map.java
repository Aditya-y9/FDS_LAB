package LAB9;
import java.lang.Iterable;

public interface Map<K, V> {

    // get the size of the map
    int size();

    // check if the map is empty
    boolean isEmpty();

    // get the value associated to the key 'k' (return null if the entry is not found)
    V get(K key);

    // put the value 'v' in the associated key 'k' and return the previous value
    V put(K key, V value);

    // remove entry with key 'k' and return its value (if entry doesn't exist, return null)
    V remove(K key);

    // get an iterable collection of all the keys
    Iterable<K> keySet();

    // get an iterable collection of all the values
    Iterable<V> values();

    // get an iterable collection of all the entries
    Iterable<Entry<K, V>> entrySet();

}
