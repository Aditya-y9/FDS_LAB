package LAB6;

import java.util.ArrayList;
import java.util.List;

/**
 * A general tree data structure that stores elements of type E. Each node in the tree can have an arbitrary number of
 * children. The tree is represented using a linked structure where each node stores a reference to its parent and a list
 * of references to its children. The tree supports operations to add a root, add a child to a node, and attach a tree as
 * a subtree to a node. It also supports a method to display the tree in a hierarchical format.
 *
 * @param <E> the type of elements stored in the tree
 */
public class GeneralTree<E> {

    /**
     * A node in the GeneralTree data structure that stores an element of type E, a reference to its parent node, and a list
     * of references to its children nodes.
     *
     * @param <E> the type of element stored in the node
     */
    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private List<Node<E>> children;

        Node(E e, Node<E> p) {
            this.element = e;
            this.parent = p;
            this.children = new ArrayList<>();
        }

        @Override
        /**
         * @return the element stored in the node
         */
        public E getElement() {
            return this.element;
        }

        /**
         * @return the parent node of the current node
         */
        public Node<E> getParent() {
            return this.parent;
        }

        /**
         * @return the list of children nodes of the current node
         */
        public List<Node<E>> getChildren() {
            return this.children;
        }

        /**
         * @return true if the current node is a leaf node, false otherwise
         */
        public boolean isLeaf() {
            return this.children.size() == 0;
        }

        /**
         * Sets the parent node of the current node to the specified node.
         *
         * @param p the node to be set as the parent node of the current node
         */
        public void setParent(Node<E> p) {
            this.parent = p;
        }

        /**
         * Adds the specified node as a child node of the current node.
         *
         * @param child the node to be added as a child node of the current node
         */
        public void addChild(Node<E> child) {
            this.children.add(child);
        }
    }

    /**
     * Creates a new node with the specified element and parent node.
     *
     * @param e the element to be stored in the node
     * @param parent the parent node of the node to be created
     * @return the newly created node
     */
    protected Node<E> createNode(E e, Node<E> parent) {
        return new Node<>(e, parent);
    }

    private Node<E> root;
    private int size;

    /**
     * Constructs an empty GeneralTree data structure.
     */
    GeneralTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Returns the node corresponding to the specified position.
     *
     * @param p the position of the node to be returned
     * @return the node corresponding to the specified position
     * @throws IllegalArgumentException if the specified position is not a valid position in the GeneralTree data structure
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        Node<E> posNode = (Node<E>) p; // typecast
        if (posNode.getParent() == posNode) // check for defunct node
            throw new IllegalArgumentException("p is no longer a valid position");
        return posNode;
    }

    /**
     * Returns the number of nodes in the GeneralTree data structure.
     *
     * @return the number of nodes in the GeneralTree data structure
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns true if the GeneralTree data structure is empty, false otherwise.
     *
     * @return true if the GeneralTree data structure is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Adds a root node to the GeneralTree data structure with the specified element.
     *
     * @param e the element to be stored in the root node
     * @return the position of the newly added root node
     * @throws IllegalStateException if the GeneralTree data structure is not empty
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!this.isEmpty())
            throw new IllegalStateException("Tree is not empty");
        this.root = createNode(e, null);
        this.size = 1;
        return root;
    }

    /**
     * Adds a child node to the specified parent node in the GeneralTree data structure with the specified element.
     *
     * @param p the position of the parent node to which the child node is to be added
     * @param e the element to be stored in the child node
     * @return the position of the newly added child node
     * @throws IllegalArgumentException if the specified position is not a valid position in the GeneralTree data structure
     */
    public Position<E> addChild(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> child = createNode(e, node);
        node.addChild(child);
        this.size++;
        return child;
    }

    /**
     * Attaches the specified GeneralTree data structure as a subtree to the specified parent node in the current GeneralTree data structure.
     *
     * @param p the position of the parent node to which the specified GeneralTree data structure is to be attached
     * @param t the GeneralTree data structure to be attached as a subtree
     * @throws IllegalArgumentException if the specified position is not a valid position in the GeneralTree data structure
     */
    public void attach(Position<E> p, GeneralTree<E> t) throws IllegalArgumentException {
        Node<E> node = validate(p);
        this.size += t.size() - 1;
        if (!t.isEmpty()) {
            t.root.setParent(node);
            node.addChild(t.root);
            t.root = null;
            t.size = 0;
        }
    }

    /**
     * Displays the GeneralTree data structure in a hierarchical format starting from the specified position.
     *
     * @param p the position of the node from which the tree is to be displayed
     * @param level the level of indentation for the current node
     * @param label the prefix label for the current node
     * @throws IllegalArgumentException if the specified position is not a valid position in the GeneralTree data structure
     */
    public void display(Position<E> p, int level, String label) throws IllegalArgumentException {
        Node<E> node = validate(p);
        for (int i = 0; i < level; ++i)
            System.out.print("  ");
        System.out.print(label + " " + node.getElement() + "\n");
        if (!node.isLeaf()) {
            for (int i = 0; i < node.getChildren().size(); ++i) {
                String lab = label + (i + 1) + ".";
                display(node.getChildren().get(i), level + 1, lab);
            }
        }
    }

}
