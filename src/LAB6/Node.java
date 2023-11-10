package LAB6;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A class representing a node in a tree data structure.
 * @param <E> the type of element stored in the node
 */
public class Node<E> implements Position<E> {
    private E element;
    private Node<E> parent;
    private List<Node<E>> children;

    /**
     * Constructs a new node with the given element and parent.
     * @param e the element to store in the node
     * @param p the parent of the node
     */
    Node(E e, Node<E> p) {
        this.element = e;
        this.parent = p;
        this.children = new ArrayList<>();
    }

    /**
     * Returns the element stored in the node.
     * @return the element stored in the node
     */
    @Override
    public E getElement() {
        return this.element;
    }

    /**
     * Sets the element stored in the node to the given element.
     * @param e the new element to store in the node
     */
    public void setElement(E e) {
        this.element = e;
    }

    /**
     * Returns the parent of the node.
     * @return the parent of the node
     */
    public Node<E> getParent() {
        return this.parent;
    }

    /**
     * Returns a list of the children of the node.
     * @return a list of the children of the node
     */
    public List<Node<E>> getChildren() {
        return this.children;
    }

    /**
     * Returns true if the node is a leaf (i.e., has no children), false otherwise.
     * @return true if the node is a leaf, false otherwise
     */
    public boolean isLeaf() {
        return this.children.size() == 0;
    }

    /**
     * Sets the parent of the node to the given node.
     * @param p the new parent of the node
     */
    public void setParent(Node<E> p) {
        this.parent = p;
    }

    /**
     * Adds the given node as a child of this node.
     * @param child the node to add as a child
     */
    public void addChild(Node<E> child) {
        this.children.add(child);
    }
}
