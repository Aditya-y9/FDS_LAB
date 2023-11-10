package LAB5;

import LAB6.Position;

/**
 * This class represents a node in a doubly linked list. It implements the Position interface and stores an element of type T, 
 * as well as references to the previous and next nodes in the list. It provides methods to get and set the element, 
 * previous node, and next node.
 * @param <T> the type of element stored in the node
 */
public class Node1<T> implements Position<T> {

    private T element; 
    private Node1<T> prev;
    private Node1<T> next; 

    /**
     * Constructs a new Node object with the given element, previous node, and next node.
     * @param e the element to be stored in the node
     * @param p the previous node in the list
     * @param n the next node in the list
     */
    public Node1(T e, Node1<T> p, Node1<T> n) {
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
        // NEXT NULL THEREFORE THE NODE IS TAILER SENTINEL
        if (next == null) 
        try {
            throw new IllegalStateException("Position is no longer valid");
        } catch (IllegalStateException e) {
            IllegalStateException ise = new IllegalStateException("Position is no longer valid");
            ise.initCause(e);
            throw ise;
        }
        else
            return element;
    }

    /**
     * Returns the previous node in the list.
     * @return the previous node in the list
     */
    public Node1<T> getPrev() {
        return this.prev;
    }

    /**
     * Returns the next node in the list.
     * @return the next node in the list
     */
    public Node1<T> getNext() {
        return this.next;
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
    public void setNext(Node1<T> n) {
        this.next = n;
    }

    /**
     * Sets the previous node in the list to the given node.
     * @param p the new previous node in the list
     */
    public void setPrev(Node1<T> p) {
        this.prev = p;
    }
}
