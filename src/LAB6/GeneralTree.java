package LAB6;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;



/**
 * A general tree implementation of the TreeInterface<E> interface.
 * The tree is composed of nodes that can have an arbitrary number of children.
 * @param <E> the type of element stored in the tree
 * @author Aditya Yedurkar
 * @version 1.5
 * @since 2023-11-09
 */
public class GeneralTree<E> extends AbstractTree<E> implements Iterable<E>, TreeInterface<E>{

    /**
     * Creates a new node with the given element and parent.
     * @param e the element to store in the new node
     * @param parent the parent of the new node
     * @return the new node
     */
    protected Node<E> createNode(E e, Node<E> parent) {
        return new Node<>(e, parent);
    }

    private Node<E> root;
    private int size;

    /**
     * Creates an empty general tree.
     */
    GeneralTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Validates the given position and returns the corresponding node.
     * @param p the position to validate
     * @return the corresponding node
     * @throws IllegalArgumentException if the position is not valid
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
     * Replaces the element at the given position with the given element.
     * @param v the position of the element to replace
     * @param e the new element to store at the position
     * @return the old element that was replaced
     * @throws IllegalStateException if the position is not valid
     */
    @Override
    public E replace(Position<E> v, E e) throws IllegalStateException {
        Node<E> node = validate(v);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    /**
     * Returns the root position of the tree.
     * @return the root position of the tree
     * @throws IllegalStateException if the tree is empty
     */
    @Override
    public Position<E> root() throws IllegalStateException {
        return this.root;
    }

    /**
     * Returns the parent position of the given position.
     * @param v the position whose parent to return
     * @return the parent position of the given position
     * @throws IllegalArgumentException if the position is not valid
     */
    @Override
    public Position<E> parent(Position<E> v) throws IllegalArgumentException {
        Node<E> node = validate(v);
        return node.getParent();
    }

    /**
     * Returns an iterable collection of the children positions of the given position.
     * @param v the position whose children to return
     * @return an iterable collection of the children positions of the given position
     * @throws IllegalArgumentException if the position is not valid
     */
    @Override
    public Iterable<Position<E>> children(Position<E> v) throws IllegalArgumentException {
        Node<E> node = validate(v);
        List<Position<E>> snapshot = new ArrayList<>(node.getChildren().size());
        for (Position<E> child : node.getChildren()) {
            snapshot.add(child);
        }
        return snapshot;
    }

    /**
     * Returns true if the given position has one or more children, false otherwise.
     * @param v the position to check
     * @return true if the given position has one or more children, false otherwise
     * @throws IllegalArgumentException if the position is not valid
     */
    @Override
    public boolean isInternal(Position<E> v) throws IllegalArgumentException {
        Node<E> node = validate(v);
        return !node.isLeaf();
    }

    /**
     * Returns true if the given position has no children, false otherwise.
     * @param v the position to check
     * @return true if the given position has no children, false otherwise
     * @throws IllegalArgumentException if the position is not valid
     */
    @Override
    public boolean isExternal(Position<E> v) throws IllegalArgumentException {
        Node<E> node = validate(v);
        return node.isLeaf();
    }

    /**
     * Returns true if the given position is the root of the tree, false otherwise.
     * @param v the position to check
     * @return true if the given position is the root of the tree, false otherwise
     * @throws IllegalArgumentException if the position is not valid
     */
    @Override
    public boolean isRoot(Position<E> v) throws IllegalArgumentException {
        Node<E> node = validate(v);
        return node == this.root;
    }

    /**
     * Returns an iterator over the elements of the tree.
     * @return an iterator over the elements of the tree
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    /**
     * Returns an iterable collection of all positions in the tree.
     * @return an iterable collection of all positions in the tree
     */
    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }

    /**
     * Returns the number of nodes in the tree.
     * @return the number of nodes in the tree
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns true if the tree is empty, false otherwise.
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Adds a new root node with the given element to the tree.
     * @param e the element to store in the new root node
     * @return the position of the new root node
     * @throws IllegalStateException if the tree is not empty
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!this.isEmpty())
            throw new IllegalStateException("Tree is not empty");
        this.root = createNode(e, null);
        this.size = 1;
        return root;
    }

    /**
     * Adds a new child node with the given element to the given position.
     * @param p the position to add the new child node to
     * @param e the element to store in the new child node
     * @return the position of the new child node
     * @throws IllegalArgumentException if the position is not valid
     */
    public Position<E> addChild(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> child = createNode(e, node);
        node.addChild(child);
        this.size++;
        return child;
    }

    /**
     * Attaches the given tree as a subtree to the given position.
     * @param p the position to attach the subtree to
     * @param t the root position of the subtree to attach
     * @throws IllegalArgumentException if the position is not valid or the given tree is empty
     */
    public void attach(Position<E> p,Position<E> t) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> tree = validate(t);
        if(node.isLeaf()){
            node.addChild(tree);
            this.size += tree.getChildren().size();
        }
    }

    /**
     * Returns an iterable collection of the sibling positions of the given position.
     * @param p the position whose siblings to return
     * @return an iterable collection of the sibling positions of the given position
     * @throws IllegalArgumentException if the position is not valid
     */
    public Iterable<Position<E>> siblings(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> parent = node.getParent();
        List<Position<E>> snapshot = new ArrayList<>(parent.getChildren().size());
        for (Position<E> child : parent.getChildren()) {
            if (child != node)
                snapshot.add(child);
        }
        return snapshot;
    }

    /**
     * Returns an iterable collection of the leaf positions in the tree.
     * @return an iterable collection of the leaf positions in the tree
     */
    public Iterable<Position<E>> leaves() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!this.isEmpty())
            preorderLeaves(this.root, snapshot);
        return snapshot;
    }

    /**
     * Adds the leaf positions in the subtree rooted at the given position to the given list.
     * @param p the root position of the subtree
     * @param snapshot the list to add the leaf positions to
     */
    public void preorderLeaves(Position<E> p, List<Position<E>> snapshot) {
        Node<E> node = validate(p);
        if (node.isLeaf())
            snapshot.add(node);
        else {
            for (Position<E> child : node.getChildren())
                preorderLeaves(child, snapshot);
        }
    }

    /**
     * Returns an iterable collection of the internal node positions in the tree.
     * @return an iterable collection of the internal node positions in the tree
     */
    public Iterable<Position<E>> internalNodes() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!this.isEmpty())
            preorderInternalNodes(this.root, snapshot);
        return snapshot;
    }

    /**
     * Adds the internal node positions in the subtree rooted at the given position to the given list.
     * @param p the root position of the subtree
     * @param snapshot the list to add the internal node positions to
     */
    public void preorderInternalNodes(Position<E> p, List<Position<E>> snapshot) {
        Node<E> node = validate(p);
        if (!node.isLeaf())
            snapshot.add(node);
        for (Position<E> child : node.getChildren())
            preorderInternalNodes(child, snapshot);
    }

    /**
     * Returns an iterable collection of the edge positions in the tree.
     * @return an iterable collection of the edge positions in the tree
     */
    public Iterable<Position<E>> edges() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!this.isEmpty())
            preorderEdges(this.root, snapshot);
        return snapshot;
    }

    /**
     * Adds the edge positions in the subtree rooted at the given position to the given list.
     * @param p the root position of the subtree
     * @param snapshot the list to add the edge positions to
     */
    public void preorderEdges(Position<E> p, List<Position<E>> snapshot) {
        Node<E> node = validate(p);
        if (!node.isLeaf()) {
            for (Position<E> child : node.getChildren()) {
                snapshot.add(child);
                preorderEdges(child, snapshot);
            }
        }
    }

    /**
     * Returns an iterable collection of the positions on the path from the root to the given position.
     * @param p the position to find the path to
     * @return an iterable collection of the positions on the path from the root to the given position
     */
    public Iterable<Position<E>> path(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!this.isEmpty())
            preorderPath(this.root, p, snapshot);
        return snapshot;
    }

    /**
     * Adds the positions on the path from the given position to the given target position to the given list.
     * @param p the current position in the traversal
     * @param q the target position to find the path to
     * @param snapshot the list to add the positions on the path to
     * @return the updated list of positions on the path
     */
    public Iterable<Position<E>> preorderPath(Position<E> p, Position<E> q, List<Position<E>> snapshot) {
        Node<E> node = validate(p);
        Node<E> qNode = validate(q);
    
        while(node.getParent() != root){
            snapshot.add(node);
            preorderPath(node.getParent(), qNode, snapshot);
        }
        return snapshot;
    }
    
    /**
     * Returns the number of children of the given position.
     * @param p the position whose number of children to return
     * @return the number of children of the given position
     */
    public int depth(Position<E> p){
        if(isRoot(p)){
            return 0;
        }
        else{
            return 1 + depth(parent(p));
        }
    }


    /**
     * Returns the height of the tree.
     * @param p the position to use as the root of the tree
     * @return the height of the tree
     */
    public int height(){
        int h = 0;
        for(Position<E> p : leaves()){
            if (isExternal(p)){
            h = Math.max(h, 1 + depth(p));
            }
        }
        return h;
    }

    /**
     * Displays the tree with the given position as the root, using the given label for each node.
     * @param p the root position of the tree to display
     * @param level the level of the tree to display
     * @param label the label to use for each node
     * @throws IllegalArgumentException if the position is not valid
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

    /**
     * Returns the position of the node containing the given element, or null if the element is not found.
     * @param e the element to search for
     * @return the position of the node containing the given element, or null if the element is not found
     */
    public Position<E> find(E e){
        return find(this.root, e);
    }

    /**
     * Returns the position of the node containing the given element in the subtree rooted at the given position, or null if the element is not found.
     * @param p the root position of the subtree to search
     * @param e the element to search for
     * @return the position of the node containing the given element in the subtree rooted at the given position, or null if the element is not found
     */
    private Position<E> find(Position<E> p, E e){
        Node<E> node = validate(p);
        if(node.getElement().equals(e)){
            return node;
        }
        if(!node.isLeaf()){
            for(Position<E> child : children(p)){
                Position<E> found = find(child, e);
                if(found != null){
                    return found;
                }
            }
        }
        return null;
    }
}

