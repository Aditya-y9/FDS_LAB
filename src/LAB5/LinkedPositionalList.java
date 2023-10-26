package LAB5;

/**
 * A doubly linked list implementation of the PositionListInterface.
 * Each element in the list is stored in a Node object that contains a reference to the element,
 * as well as references to the previous and next nodes in the list.
 * The list is maintained with header and trailer sentinel nodes that do not contain elements.
 * The header node is the first node in the list, and the trailer node is the last node in the list.
 * The size of the list is maintained as an integer value.
 * @ author Aditya Yedurkar
 * @ version 1.0
 *
 * @param <T> the type of element stored in the list
 */
public class LinkedPositionalList <T> implements PositionalListInterface<T> {

    /**
     * Node is a nested class that implements the Position interface.
     * It represents a node in the doubly linked list, containing an element of type T,
     * as well as references to the previous and next nodes in the list.
     *
     * @param <T> the type of element stored in the node
     */
    public static class Node<T> implements PositionInterface<T> {
        private T element;
        private Node<T> prev;
        private Node<T> next;

        /**
         * Constructs a new node with the given element, previous node, and next node.
         *
         * @param e the element to be stored in the node
         * @param p the previous node in the list
         * @param n the next node in the list
         */
        public Node(T e, Node<T> p, Node<T> n) {
            element = e;
            prev = p;
            next = n;
        }

        /**
         * Returns the element stored in the node.
         *
         * @return the element stored in the node
         * @throws IllegalStateException if the node is no longer valid
         */
        public T getElement() throws IllegalStateException {
            if (next == null)
                throw new IllegalStateException("Position no longer valid");
            return element;
        }

        /**
         * Returns the previous node in the list.
         *
         * @return the previous node in the list
         */
        public Node<T> getPrev() {
            return prev;
        }

        /**
         * Returns the next node in the list.
         *
         * @return the next node in the list
         */
        public Node<T> getNext() {
            return next;
        }

        /**
         * Sets the element stored in the node to the given element.
         *
         * @param e the new element to be stored in the node
         */
        public void setElement(T e) {
            element = e;
        }

        /**
         * Sets the previous node in the list to the given node.
         *
         * @param p the new previous node in the list
         */
        public void setPrev(Node<T> p) {
            prev = p;
        }

        /**
         * Sets the next node in the list to the given node.
         *
         * @param n the new next node in the list
         */
        public void setNext(Node<T> n) {
            next = n;
        }
    } 

    private Node<T> header;
    private Node<T> trailer;
    private int size = 0;

    /**
     * Constructs a new empty LinkedPositionalList with header and trailer sentinel nodes.
     */
    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer); 
    }

    /**
     * Validates the given position and returns the corresponding node.
     *
     * @param p the position to be validated
     * @return the node corresponding to the given position
     * @throws IllegalArgumentException if the position is invalid
     */
    private Node<T> validate(PositionInterface<T> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Invalid p");
        Node<T> node = (Node<T>) p; 
        if (node.getNext() == null)
            throw new IllegalArgumentException("p is no longer in the list");
        return node;
    }

    /**
     * Returns the position corresponding to the given node.
     *
     * @param node the node to be converted to a position
     * @return the position corresponding to the given node
     */
    private PositionInterface<T> position(Node<T> node) {
        if (node == header || node == trailer)
            return null;
        return node;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if the list is empty, false otherwise.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the first position in the list.
     *
     * @return the first position in the list
     */
    public PositionInterface<T> first() {
        return position(header.getNext());
    }

    /**
     * Returns the last position in the list.
     *
     * @return the last position in the list
     */
    public PositionInterface<T> last() {
        return position(trailer.getPrev());
    }

    /**
     * Returns the position before the given position.
     *
     * @param p the position whose predecessor is to be returned
     * @return the position before the given position
     * @throws IllegalArgumentException if the position is invalid
     */
    public PositionInterface<T> before(PositionInterface<T> p) throws IllegalArgumentException {
        Node<T> node = validate(p);
        return position(node.getPrev());
    }

    /**
     * Returns the position after the given position.
     *
     * @param p the position whose successor is to be returned
     * @return the position after the given position
     * @throws IllegalArgumentException if the position is invalid
     */
    public PositionInterface<T> after(PositionInterface<T> p) throws IllegalArgumentException {
        Node<T> node = validate(p);
        return position(node.getNext());
    }

    /**
     * Adds a new element with the given value to the list between the given predecessor and successor nodes.
     *
     * @param e the value of the new element to be added
     * @param pred the predecessor node in the list
     * @param succ the successor node in the list
     * @return the position of the new element in the list
     */
    private PositionInterface<T> addBetween(T e, Node<T> pred, Node<T> succ) {
        Node<T> newest = new Node<>(e, pred, succ); 
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }

    /**
     * Adds a new element with the given value to the beginning of the list.
     *
     * @param e the value of the new element to be added
     * @return the position of the new element in the list
     */
    public PositionInterface<T> addFirst(T e) {
        return addBetween(e, header, header.getNext());
    }

    /**
     * Adds a new element with the given value to the end of the list.
     *
     * @param e the value of the new element to be added
     * @return the position of the new element in the list
     */
    public PositionInterface<T> addLast(T e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }

    /**
     * Adds a new element with the given value before the given position in the list.
     *
     * @param p the position before which the new element is to be added
     * @param e the value of the new element to be added
     * @return the position of the new element in the list
     * @throws IllegalArgumentException if the position is invalid
     */
    public PositionInterface<T> addBefore(PositionInterface<T> p, T e) throws IllegalArgumentException {
        Node<T> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    /**
     * Adds a new element with the given value after the given position in the list.
     *
     * @param p the position after which the new element is to be added
     * @param e the value of the new element to be added
     * @return the position of the new element in the list
     * @throws IllegalArgumentException if the position is invalid
     */
    public PositionInterface<T> addAfter(PositionInterface<T> p, T e) throws IllegalArgumentException {
        Node<T> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    /**
     * Replaces the element at the given position with the given value.
     *
     * @param p the position of the element to be replaced
     * @param e the new value of the element
     * @return the old value of the element
     * @throws IllegalArgumentException if the position is invalid
     */
    public T set(PositionInterface<T> p, T e) throws IllegalArgumentException {
        Node<T> node = validate(p);
        T answer = node.getElement();
        node.setElement(e);
        return answer;
    }

    /**
     * Removes the element at the given position from the list.
     *
     * @param p the position of the element to be removed
     * @return the value of the removed element
     * @throws IllegalArgumentException if the position is invalid
     */
    public T remove(PositionInterface<T> p) throws IllegalArgumentException {
        Node<T> node = validate(p);
        Node<T> predecessor = node.getPrev();
        Node<T> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        T answer = node.getElement();
        node.setElement(null); 
        node.setNext(null); 
        node.setPrev(null);
        return answer;
    }
}
