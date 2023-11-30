package LAB8.PositionalListImplementation;
import LAB8.*;
import LAB5.LinkedPositionalList;
import LAB5.Position;
import java.util.Comparator;



public class UnsortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V>{


    // PositionalLsit of entries
    private LinkedPositionalList<Entry<K,V>> list = new LinkedPositionalList<>();

    // empty priority queue (natural ordering , default comparator)
    public UnsortedPriorityQueue(){
        super();
    }


    // ordering by given comparator
    public UnsortedPriorityQueue(Comparator<K> comp){
        super(comp);
    }


    // O(n)
    private Position<Entry<K,V>> findMin(){
        // start from first position
        Position<Entry<K,V>> small = list.first();

        // iterate over list of positions
        for(Position<Entry<K,V>> walk : list.positions()){

            // entry is element at position
            if(compare(walk.getElement(),small.getElement())<0){
                small = walk;
            }
        }

        return small;
    }


    public Entry<K,V> insert(K key, V value) throws IllegalArgumentException{
        // validate
        checkKey(key);

        // make a new entry to add last
        Entry<K,V> newest = new Entry<>(key,value);
        
        // adding entry to last of PositionalList
        // our LAB5 addLast will take entry as an element
        // make a position of it
        // and then add between last and trailer position(node)
        list.addLast(newest);

        return newest;

    }

    public Entry<K,V> min(){

        if(list.isEmpty()){
            return null;
        }

        // return entry at position
        return findMin().getElement();
    }

    public Entry<K,V> removeMin(){
        if(list.isEmpty()){
            return null;
        }

        // remove entry wala position from the list
        // dont worry, remove retruns element(Entry<K,V) at position
        // and not the Position<Entry<K,V>>
        return list.remove(findMin());

    }

    public int size(){
        return list.size();
    }

}
