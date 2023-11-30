package LAB8;
import java.util.Comparator;
import java.lang.Comparable;

public class DefaultComparator <E> implements Comparator<E>{
    public int compare(E a,E b) throws ClassCastException{

        // cast 'a' to Comparable(applicable for String,int, float,double,defaults) 
        // use method in Comparable class using 'a' as object.
        return ((Comparable<E>)a).compareTo(b);
    }
}
