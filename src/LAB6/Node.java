package LAB6;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a node in a tree data structure.
 * 
 * @param <E> the type of element stored in the node
 */
public class Node<E> implements Position<E> {
    // inherit the getElement() method from Position<E>

    private E element;
    private Node<E> parent;
    private List<Node<E>> children;

    /**
     * Constructs a new node with the given element and parent.
     * 
     * @param e the element to store in the node
     * @param p the parent of the node
     */
    Node(E e, Node<E> p) {
        this.element = e;
        this.parent = p;
        // children should be a list of nodes
        // list children of each node as a property
        this.children = new ArrayList<>();
    }

    /**
     * Returns the element stored in the node.
     * 
     * @return the element stored in the node
     * @throws IllegalStateException if the element is null
     */
    @Override
    // just being safe here, as position<E> is not even a class so no problem
    // whatsoever
    // no point in even overriding this method.
    public E getElement() throws IllegalStateException {
        if (this.element == null) {
            throw new IllegalStateException("Element is null");
        }
        return this.element;
    }

    /**
     * Sets the element stored in the node to the given element.
     * 
     * @param e the new element to store in the node
     */
    public void setElement(E e) {
        // no point in returning older element
        this.element = e;
    }

    /**
     * Returns the parent of the node.
     * 
     * @return the parent of the node
     */
    public Node<E> getParent() {
        return this.parent;
    }

    /**
     * Returns a list of the children of the node.
     * 
     * @return a list of the children of the node
     */
    public List<Node<E>> getChildren() {
        // returns list of child nodes
        return this.children;
    }

    /**
     * Returns true if the node is a leaf (i.e., has no children), false otherwise.
     * 
     * @return true if the node is a leaf, false otherwise
     */
    public boolean isLeaf() {
        // if list of children is empty, node is a leaf
        return this.children.size() == 0;
    }

    /**
     * Sets the parent of the node to the given node.
     * 
     * @param p the new parent of the node
     */
    public void setParent(Node<E> p) {
        // set parent node
        // again, no point in returning older parent node
        this.parent = p;
    }

    /**
     * Adds the given node as a child of this node.
     * 
     * @param child the node to add as a child
     */
    public void addChild(Node<E> child) {
        // add child node to list of children
        // list is a property of each node
        this.children.add(child);
    }
}
