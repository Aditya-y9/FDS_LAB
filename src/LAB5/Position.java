package LAB5;

/**
 * An interface representing a position in a data structure that stores elements of type T.
 * A position is a holder object that stores a single element and allows it to be accessed and potentially modified.
 * 
 * @param <T> the type of element stored in the position
 */
public interface Position<T> {

    /**
     * Returns the element stored at this position.
     * 
     * @return the element stored at this position
     * @throws IllegalStateException if the position is no longer valid (e.g., the element has been removed from the data structure)
     */
    T getElement() throws IllegalStateException;

}