package LAB5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.Iterable;

/**
 * This class implements the PositionalListInterface and provides a linked list implementation of it.
 * It contains a private static class Node which implements the Position interface and is used to represent each element in the list.
 * The class also contains methods to add, remove, and modify elements in the list, as well as iterators to traverse the list.
 * 
 * 
 * @author Aditya Yedurkar
 * @version 1.0
 * @since 28-10-2023
 */

/**
 * A doubly linked list implementation of the PositionalList interface.
 * 
 * @param <T> the type of elements held in this collection
 */
public class LinkedPositionalList<T> implements PositionalListInterface<T> {

    private int size;
    
    // store sentinel nodes
    private Node<T> header;
    private Node<T> trailer;

    /**
     * Constructs an empty linked positional list.
     */
    public LinkedPositionalList() {
        this.size = 0;
        this.trailer = new Node<>(null, null, null);
        this.header = new Node<>(null, null, this.trailer);
        this.trailer.setPrev(this.header);
    }

    /**
     * Validates that the given position is a valid node in the list.
     * 
     * @param p the position to be validated
     * @return the node corresponding to the given position
     * @throws IllegalArgumentException if the position is not a valid node in the
     *                                  list
     */
    private Node<T> validateNode(Position<T> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Passed position is invalid");
        // type cast to generic type
        Node<T> node = (Node<T>) p;

        // check if node is defunct

        // cause at most next can be trailer
        if (node.getNext() == null)
            throw new IllegalArgumentException("The passed node is defunct");
        return node;
    }

    /**
     * Returns the position corresponding to the given node, or null if the node is
     * the header or trailer.
     * 
     * @param node the node to be converted to a position
     * @return the position corresponding to the given node, or null if the node is
     *         the header or trailer
     */
    private Position<T> position(Node<T> node) {

        // no position for sentinel nodes
        if (node == this.header || node == this.trailer)
            return null;
        else
            // return position of node
            // convert node to position

            // implicit type cast
            // automatically done by compiler
            return node;
    }

    /**
     * Adds a new node with the given element between the given predecessor and
     * successor nodes.
     * 
     * @param t           the element to be stored in the new node
     * @param predecessor the node that will be the predecessor of the new node
     * @param successor   the node that will be the successor of the new node
     * @return the position of the newly added node
     */
    private Position<T> addBetween(T t, Node<T> predecessor, Node<T> successor) {
        Node<T> newNode = new Node<>(t, predecessor, successor);

        // predecessor ------> newNode <------- successor

        // link predecessor and successor to newNode

        // predecessor ------> newNode
        predecessor.setNext(newNode);
        

        // newNode <------- successor
        successor.setPrev(newNode);
        ++this.size;
        return position(newNode);
    }

    /**
     * Returns the number of elements in the list.
     * 
     * @return the number of elements in the list
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns true if the list is empty, false otherwise.
     * 
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns the position of the first element in the list, or null if the list is
     * empty.
     * 
     * @return the position of the first element in the list, or null if the list is
     *         empty
     */
    public Position<T> first() {
        // first node is header---------->first element
        return position(this.header.getNext());
    }

    /**
     * Returns the position of the last element in the list, or null if the list is
     * empty.
     * 
     * @return the position of the last element in the list, or null if the list is
     *         empty
     */
    public Position<T> last() {
        // last node is last element<----------trailer
        return position(this.trailer.getPrev());
    }

    /**
     * Returns the position of the element immediately before the given position.
     * 
     * @param p the position whose predecessor is to be returned
     * @return the position of the element immediately before the given position
     * @throws IllegalArgumentException if the given position is not a valid node in
     *                                  the list
     */
    public Position<T> before(Position<T> p) throws IllegalArgumentException {
        // throw exception 
        Node<T> node = validateNode(p);
        // return position of node <------- predecessor
        return position(node.getPrev());
    }

    /**
     * Returns the position of the element immediately after the given position.
     * 
     * @param p the position whose successor is to be returned
     * @return the position of the element immediately after the given position
     * @throws IllegalArgumentException if the given position is not a valid node in
     *                                  the list
     */
    public Position<T> after(Position<T> p) throws IllegalArgumentException {
        // throw exception
        Node<T> node = validateNode(p);
        // return position of node -------> successor
        return position(node.getNext());
    }

    /**
     * Adds a new element to the beginning of the list.
     * 
     * @param t the element to be added
     * @return the position of the newly added element
     */
    @Override
    public Position<T> addFirst(T t) {
        // header --------> first element
        // header --------> newNode <-------- first element
        return addBetween(t, this.header, this.header.getNext());
    }

    /**
     * Adds a new element to the end of the list.
     * 
     * @param t the element to be added
     * @return the position of the newly added element
     */
    @Override
    public Position<T> addLast(T t) {
        // last element --------> trailer
        // last element --------> newNode <-------- trailer
        return addBetween(t, this.trailer.getPrev(), this.trailer);
    }

    /**
     * Adds a new element immediately before the given position.
     * 
     * @param p the position before which the new element is to be added
     * @param t the element to be added
     * @return the position of the newly added element
     * @throws IllegalArgumentException if the given position is not a valid node in
     *                                  the list
     */
    @Override
    public Position<T> addBefore(Position<T> p, T t) throws IllegalArgumentException {
        // throw exception
        Node<T> node = validateNode(p);
        // return position of node <------- newNode <------- node
        return addBetween(t, node.getPrev(), node);
    }

    /**
     * Adds a new element immediately after the given position.
     * 
     * @param p the position after which the new element is to be added
     * @param t the element to be added
     * @return the position of the newly added element
     * @throws IllegalArgumentException if the given position is not a valid node in
     *                                  the list
     */
    @Override
    public Position<T> addAfter(Position<T> p, T t) throws IllegalArgumentException {
        Node<T> node = validateNode(p);
        // return position of node -------> newNode -------> node
        return addBetween(t, node, node.getNext());
    }

    /**
     * Replaces the element stored at the given position with the given element.
     * 
     * @param p the position of the element to be replaced
     * @param t the new element to be stored at the given position
     * @return the old element that was replaced
     * @throws IllegalArgumentException if the given position is not a valid node in
     *                                  the list
     */
    @Override
    public T set(Position<T> p, T t) throws IllegalArgumentException {
        // throw exception
        Node<T> node = validateNode(p);

        // store old element
        T temp = node.getElement();
        // replace old element with new element
        node.setElement(t);
        // return deleted element
        return temp;
    }

    /**
     * Removes the element stored at the given position from the list.
     * 
     * @param p the position of the element to be removed
     * @return the element that was removed
     * @throws IllegalArgumentException if the given position is not a valid node in
     *                                  the list
     */
    @Override
    public T remove(Position<T> p) throws IllegalArgumentException {
        Node<T> node = validateNode(p);
        T temp = node.getElement();
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        size--;
        // unlink node
        node.setPrev(null);

        // our condition to check if node is defunct
        node.setNext(null);

        node.setElement(null);
        return temp;
    }

    /**
     * Returns an iterable representation of the list's positions.
     * 
     * @return an iterable representation of the list's positions
     * @see PositionIterable
     * @see PositionIterator
     * @see Iterable
     * @see Iterator
     * @see Position
     * @see NoSuchElementException
     * @see IllegalStateException
     * @see LinkedPositionalList
     * @see PositionalListInterface
     * @see Node
     * @see LAB5
     *      Position Iterator is a private class that implements the Iterator
     *      interface and is used to iterate over the positions in the list.
     */

    private class PositionIterator implements Iterator<Position<T>> {

        /**
         * The cursor is the position of the next element to be returned.
         * The recent is the position of the last element returned.
         */

        // cursor ----> next element to be returned
        // recent ----> last element returned
        private Position<T> cursor = first();
        Position<T> recent = null;

        /**
         * Returns true if the iterator has a next element, false otherwise.
         * 
         * @return true if the iterator has a next element, false otherwise
         */
        @Override
        public boolean hasNext() {
            // cursor is next element to be returned
            // so if cursor is not null, there is a next element
            return cursor != null;
        }

        /**
         * Returns the next element in the iteration.
         * 
         * @return the next element in the iteration
         * @throws NoSuchElementException if there are no more elements in the iteration
         */
        @Override
        public Position<T> next() throws NoSuchElementException {
            if (cursor == null)
                throw new NoSuchElementException("No element found");
            else {
                // change recent to cursor
                recent = cursor;
                // and update cursor to next element
                cursor = after(cursor);
                return recent;
            }
        }

        /**
         * Removes the element returned by the most recent call to next().
         * 
         * @throws IllegalStateException if there is no element to be removed
         */
        @Override
        public void remove() throws IllegalStateException {
            if (recent == null)
                throw new IllegalStateException("No element can be removed");
            LinkedPositionalList.this.remove(recent);
            recent = null;
        }
    }

    /**
     * Position Iterable is a private class that implements the Iterable interface
     * and is used to iterate over the positions in the list.
     */

    private class PositionIterable implements Iterable<Position<T>> {

        public Iterator<Position<T>> iterator() {
            return new PositionIterator();
        }
    }

    /**
     * Returns an iterator of the elements stored in the list.
     * 
     * @return an iterator of the elements stored in the list
     */
    public Iterable<Position<T>> positions() {
        return new PositionIterable();
    }

    /**
     * Element Iterator is a private class that implements the Iterator interface
     * and is used to iterate over the elements in the list.
     */
    private class ElementIterator implements Iterator<T> {
        /**
         * The position iterator used to iterate over the positions in the list.
         */
        Iterator<Position<T>> posIterator = new PositionIterator();

        /**
         * Returns true if the iterator has a next element, false otherwise.
         * 
         * @return true if the iterator has a next element, false otherwise
         */
        @Override
        public boolean hasNext() {
            return posIterator.hasNext();
        }

        /**
         * Returns the next element in the iteration.
         * 
         * @return the next element in the iteration
         * @throws NoSuchElementException if there are no more elements in the iteration
         */
        @Override
        public T next() {
            return posIterator.next().getElement();
        }

        /**
         * Removes the element returned by the most recent call to next().
         * 
         * @throws IllegalStateException if there is no element to be removed
         */
        @Override
        public void remove() throws IllegalStateException {
            if (posIterator.hasNext() == false) {
                throw new IllegalStateException("No element to be removed");
            }
            posIterator.remove();
        }
    }

    /**
     * Returns an iterator of the elements stored in the list.
     * 
     * @return an iterator of the elements stored in the list
     */
    public Iterator<T> iterator() {
        return new ElementIterator();
    }
}