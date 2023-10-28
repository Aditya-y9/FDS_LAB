package LAB5;
import LAB5.*;
/**
 * An interface for a positional list, which is a list where each element has a position.
 * @param <T> the type of element held in the list
 */
public interface PositionalListInterface<T> {

    /**
     * Returns the number of elements in the list.
     * @return the number of elements in the list
     */
    int size();

    /**
     * Returns whether the list is empty.
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the first position in the list.
     * @return the first position in the list
     */
    Position<T> first();

    /**
     * Returns the last position in the list.
     * @return the last position in the list
     */
    Position<T> last();

    /**
     * Returns the position before the given position.
     * @param p the position to find the predecessor of
     * @return the position before the given position
     * @throws IllegalArgumentException if the position is not valid
     */
    Position<T> before(Position<T> p) throws IllegalArgumentException;

    /**
     * Returns the position after the given position.
     * @param p the position to find the successor of
     * @return the position after the given position
     * @throws IllegalArgumentException if the position is not valid
     */
    Position<T> after(Position<T> p) throws IllegalArgumentException;

    /**
     * Inserts an element at the beginning of the list.
     * @param e the element to insert
     * @return the position of the newly inserted element
     */
    Position<T> addFirst(T e);

    /**
     * Inserts an element at the end of the list.
     * @param e the element to insert
     * @return the position of the newly inserted element
     */
    Position<T> addLast(T e);

    /**
     * Inserts an element before the given position.
     * @param p the position to insert the element before
     * @param e the element to insert
     * @return the position of the newly inserted element
     * @throws IllegalArgumentException if the position is not valid
     */
    Position<T> addBefore(Position<T> p, T e) throws IllegalArgumentException;

    /**
     * Inserts an element after the given position.
     * @param p the position to insert the element after
     * @param e the element to insert
     * @return the position of the newly inserted element
     * @throws IllegalArgumentException if the position is not valid
     */
    Position<T> addAfter(Position<T> p, T e) throws IllegalArgumentException;

    /**
     * Replaces the element at the given position with the given element.
     * @param p the position of the element to replace
     * @param e the new element to store at the given position
     * @return the old element that was replaced
     * @throws IllegalArgumentException if the position is not valid
     */
    T set(Position<T> p, T e) throws IllegalArgumentException;

    /**
     * Removes the element at the given position.
     * @param p the position of the element to remove
     * @return the element that was removed
     * @throws IllegalArgumentException if the position is not valid
     */
    T remove(Position<T> p) throws IllegalArgumentException;
}
