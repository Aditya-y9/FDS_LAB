package LAB5;

/**
 * This class represents a node in a doubly linked list. It implements the Position interface and stores an element of type T, 
 * as well as references to the previous and next nodes in the list. It provides methods to get and set the element, 
 * previous node, and next node.
 * @param <T> the type of element stored in the node
 */
public class Node<T> implements Position<T> {

    private T element; 
    private Node<T> prev;
    private Node<T> next; 

    /**
     * Constructs a new Node object with the given element, previous node, and next node.
     * @param e the element to be stored in the node
     * @param p the previous node in the list
     * @param n the next node in the list
     */
    public Node(T e, Node<T> p, Node<T> n) {
        this.element = e;
        this.prev = p;
        this.next = n;
    }

    /**
     * Returns the element stored in this node.
     * @return the element stored in this node
     * @throws IllegalStateException if the position is no longer valid
     */
    public T getElement() throws IllegalStateException {
        if (next == null) 
            throw new IllegalStateException("Position is no longer valid");
        else
            return element;
    }

    /**
     * Returns the previous node in the list.
     * @return the previous node in the list
     */
    public Node<T> getPrev() {
        return prev;
    }

    /**
     * Returns the next node in the list.
     * @return the next node in the list
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Sets the element stored in this node to the given element.
     * @param e the new element to be stored in this node
     */
    public void setElement(T e) {
        this.element = e;
    }

    /**
     * Sets the next node in the list to the given node.
     * @param n the new next node in the list
     */
    public void setNext(Node<T> n) {
        this.next = n;
    }

    /**
     * Sets the previous node in the list to the given node.
     * @param p the new previous node in the list
     */
    public void setPrev(Node<T> p) {
        this.prev = p;
    }
}
