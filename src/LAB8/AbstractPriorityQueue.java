package LAB8;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K,V> implements PriorityQueueInterface<K,V> {
    // variavle 
    private Comparator<K> comp;

    // assigning desired comparator
    public AbstractPriorityQueue(Comparator<K> c){
        comp = c;
    }

    public AbstractPriorityQueue(){
        this(new DefaultComparator<>());
    }

    protected int compare(Entry<K,V> a,Entry<K,V> b){
        return comp.compare(a.getKey(),b.getKey());
    }


    // validate method
    protected boolean checkKey(K key) throws IllegalArgumentException{
        try{
            return (comp.compare(key, key)==0);
        }
        catch(ClassCastException e){
            throw new IllegalArgumentException("Incompatiable Key");
        }
    }

    public boolean isEmpty(){
        return size() == 0;
    }
}
