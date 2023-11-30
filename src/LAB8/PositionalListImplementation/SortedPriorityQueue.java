package LAB8.PositionalListImplementation;
import LAB8.*;

import LAB5.LinkedPositionalList;
import LAB5.Position;
import java.util.Comparator;

public class SortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V>{

    // Positional List to store entries at Position
    private LinkedPositionalList<Entry<K,V>> list = new LinkedPositionalList<>();

    public SortedPriorityQueue(){
        // no arguments for natural ordering of key(Default comparator)
        super();
    }

    

    public SortedPriorityQueue(Comparator<K> comp){
        // uses our own ordering for our keys.
        super(comp);
    }

    public Entry<K,V> insert(K key, V value) throws IllegalArgumentException{
        checkKey(key);

        Entry<K,V> newest = new Entry<>(key,value);

        Position<Entry<K,V>> walk = list.last();


        // while
        // 1. you have not reached the end of the list
        // 2. newest entry is less than left element
        while(walk!=null && compare(newest,walk.getElement())<0){
            // iterate over and over
            walk = list.before(walk);
        }

        // if list over while walking
        if(walk==null){
            list.addFirst(newest);
        }

        // add after the element found
        // can also use addBefore(walk.next(),newest)
        else{
            list.addAfter(walk, newest);
        }
        return newest;
    }

    public Entry<K,V> min(){
        if(list.isEmpty()){
            return null;
        }
        return list.first().getElement();
    }

    public Entry<K,V> removeMin(){
        if(list.isEmpty()){
            return null;
        }
        return list.remove(list.first());
    }

    public int size(){
        return list.size();
    }
    

}
