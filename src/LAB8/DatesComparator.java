package LAB8;
import java.util.Date;
import java.util.Comparator;
/**
 * A comparator for comparing Date objects.
 */
public class DatesComparator implements Comparator<Date> {

    /**
     * Compares two Date objects
     * @param a the first Date object to compare
     * @param b the second Date object to compare
     * @return a negative integer if a is less than b, zero if a is equal to b, or a positive integer if a is greater than b
     * @throws ClassCastException if the objects being compared are not of type Date
     */
    public int compare(Date a, Date b) throws ClassCastException {
        // typecast to Comparable for Date class
        return ((Comparable<Date>) a).compareTo(b);
    }
}

