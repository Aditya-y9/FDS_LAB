package LAB9;
import java.util.Iterator;
import java.lang.Iterable;

public abstract class AbstractMap<K, V> implements Map<K, V> {

    // nested MapEntry class
    protected static class MapEntry<K, V> implements Entry<K, V> {


        private K key;
        private V value;


        public MapEntry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        // public getters to implement the interface
        @Override
        public K getKey() {
            return key;
        }
        @Override
        public V getValue() {
            return value;
        }

        // protected setter methods apart from those in the interface
        protected void setKey(K key) {
            this.key = key;
        }
        protected V setValue(V val) {
            V temp = this.value;
            this.value = val;
            return temp;
        }

    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private class KeyIterator implements Iterator<K> {

        // use entrySet iterator
        // entrySet() returns an iterable collection of all the entries
        // .iterator() returns an iterator over the collection
        private final Iterator<Entry<K, V>> entries = entrySet().iterator();

        // implement the iterator interface methods
        @Override
        public boolean hasNext() {
            // if there is a next entry, key is available
            return entries.hasNext();
        }

        @Override
        public K next() {
            // we are concerned with the keys only
            return entries.next().getKey();
        }



    }

    private class KeyIterable implements Iterable<K> {

        // implement the iterable interface methods

        @Override
        public Iterator<K> iterator() {
            return new KeyIterator();
        }

    }

    @Override
    public Iterable<K> keySet() {
        return new KeyIterable();
    }

    // valueSet

    private class valueIterator implements Iterator<V> {

        // use entrySet iterator
        private final Iterator<Entry<K, V>> entries = entrySet().iterator();

        // implement the iterator interface methods
        @Override
        public boolean hasNext() {
            // return if the iterator has a next entry
            return entries.hasNext();
        }

        @Override
        public V next() {
            // return the value of the next entry
            return entries.next().getValue();
        }

    }

    private class ValueIterable implements Iterable<V> {
        @Override
        public Iterator<V> iterator() {
            // valueIterator object created and returned
            return new valueIterator();
        }

    }

    @Override
    public Iterable<V> values() {
        // ValueIterable object created and returned
        return new ValueIterable();
    }

}