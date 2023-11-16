package LAB6;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




/**
 * A general tree implementation of the TreeInterface<E> interface.
 * The tree is composed of nodes that can have an arbitrary number of children.
 * @param <E> the type of element stored in the tree
 * @author Aditya Yedurkar
 * @version 1.5
 * @since 2023-11-09
 * 
 * 
 * 
 * 
 * General Tree class extends the AbstractTree class and implements the TreeInterface indirectly.
 */
public class GeneralTree<E> extends AbstractTree<E>{

    /**
     * Creates a new node with the given element and parent.
     * @param e the element to store in the new node
     * @param parent the parent of the new node
     * @return the new node
     */
    protected Node<E> createNode(E e, Node<E> parent) {

        // call node constructor
        // copy paste arguments
        return new Node<>(e, parent);
    }


    /**
     * A node of a general tree.
     * 
     * Attributes root and size
     */
    private Node<E> root;
    private int size;

    /**
     * Creates an empty general tree.
     * 
     * 
     * Empty constructor
     * initially root is null and size is 0 
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

        // if the data type of the position is not a node, throw an exception
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        Node<E> posNode = (Node<E>) p; // kinda typecast

        // if the parent of the node is the node itself, throw an exception
        // generally, this means that the node is defunct
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
        // type cast the position to a node and check if it is valid
        Node<E> node = validate(v);

        // return the earlier element
        // store till return
        E temp = node.getElement();

        // set the new element
        node.setElement(e);

        // return the old element
        return temp;
    }

    /**
     * Returns the root position of the tree.
     * @return the root position of the tree
     * @throws IllegalStateException if the tree is empty
     */
    @Override
    public Position<E> root() throws IllegalStateException {
        // if the tree is empty, throw an exception
        if (this.isEmpty())
            throw new IllegalStateException("Tree is empty");

        // root is already stored, so return it
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
        // type cast the position to a node and check if it is valid
        Node<E> node = validate(v);


        // if the parent is the null, throw an exception
        // this case applies only to the root
        if (node.getParent() == null)
            throw new IllegalArgumentException("p is the root, so no parent");
        
        // return the parent
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

        // thorw an exception if the position is not valid
        Node<E> node = validate(v);

        // create a new list of positions
        // size equal to the number of children
        List<Position<E>> snapshot = new ArrayList<>(node.getChildren().size());

        // leaf nodes have no children
        // so ignore them
        if(node.isLeaf()){
            throw new IllegalArgumentException("p is a leaf node"); 
        }

        // add all the children to the list
        // travel list of children and add to snapshot
        

        // travel and use getChildern() method at the node
        // getChildern() method returns a list of children
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

        // to throw an exception if the position is not valid
        Node<E> node = validate(v);


        // easier approach used, only internal nodes are not leaf nodes
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
        // to throw an exception if the position is not valid
        Node<E> node = validate(v);

        // return true if the node is a leaf
        // easy , only leaf nodes are external
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
        // to throw an exception if the position is not valid
        Node<E> node = validate(v);


        // return true if the node is the root
        return node == this.root;
    }



    /**
     * Returns an iterator of the elements stored in the tree.
     * @return an iterator of the elements stored in the tree
     */
    public Iterator<E> iterator() {
        // get the positions and store the elements in a list
        // use the positions() method
        Iterable<Position<E>> positions = positions();


        // initialize an arraylist to store the elements
        List<E> elements = new ArrayList<>(size());

        // add the elements to the list
        for (Position<E> position : positions) {
            elements.add(position.getElement());
        }

        // return the iterator of the elements
        return elements.iterator();
    }

    /**
     * Returns an iterable collection of all positions in the tree.
     * @return an iterable collection of all positions in the tree
     */
    @Override
    public Iterable<Position<E>> positions() {
        // empty list to store the positions
        List<Position<E>> positions = new ArrayList<>();

        // if the tree is not empty, add the positions
        if (!isEmpty()) {
            preorderSubtree(this.root(), positions);
        }
        return positions;
    }

    /**
     * Adds positions of the subtree rooted at Position p to the given snapshot.
     */
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        // preorder hai toh pehla node add as a root
        snapshot.add(p); // for preorder, we add position p before exploring subtrees

        // travel the children and add them recursively
        for (Position<E> c : children(p)) {
            // when subtree is explored, add the children
            // when subtree is empty, it will not be added
            preorderSubtree(c, snapshot);
        }
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


        // if tree is not empty, throw an exception
        if (!this.isEmpty())
            throw new IllegalStateException("Tree is not empty");

        // create a new root node
        // assign it to the root
        this.root = createNode(e, null);

        // initial root added, so size is 1
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

        // create a new child node aside
        Node<E> child = createNode(e, node);

        // add the child to the parent
        // use the addChild in the "NODE" class
        node.addChild(child);

        // increment the size
        this.size++;

        // return the child node
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
        

        // ArrayList to store the edges
        List<Position<E>> snapshot = new ArrayList<>();

        // if the tree is not empty, add the edges
        // SUBTREE AT LEAF NODE IS EMPTY (BASE CONDITION)
        if (!this.isEmpty())
            // start recursion from the root
            preorderEdges(this.root, snapshot);
        return snapshot;
    }

    /**
     * Adds the edge positions in the subtree rooted at the given position to the given list.
     * @param p the root position of the subtree
     * @param snapshot the list to add the edge positions to
     */
    public void preorderEdges(Position<E> p, List<Position<E>> snapshot) {
        //check for exceptions
        Node<E> node = validate(p);

        // for internal nodes, add the edge
        // link to child
        if (!node.isLeaf()) {
            for (Position<E> child : node.getChildren()) {
                snapshot.add(child);
                // recursice call till leaf nodes in each subtree
                // SUBTREE AT LEAF NODE IS EMPTY (BASE CONDITION)
                preorderEdges(child, snapshot);
            }
        }
    }

    /**
     * Return the path from the root to the given position.
     * @param p the position to return the path to
     * @return the path from the root to the given position
     */
    public List<Position<E>> getPath(Position<E> p) {

    // postorder approach is easier for getting the path to a node

    // to store the path nodes
    List<Position<E>> path = new ArrayList<>();

    // while parent node is not null
    // condition to check root node
    while (p != null) {

        // append the node to the path
        path.add(p);

        // travel up the tree
        p = parent(p);
    }

    // bottom to top -------> top to bottom
    // postorder ----> reverse ----> preorder
    Collections.reverse(path);
    return path;
}

    
    /**
     * Returns the number of children of the given position.
     * @param p the position whose number of children to return
     * @return the number of children of the given position
     */
    public int depth(Position<E> p){


        // root we assume is at depth 0

        // also the base condition for our recursion
        if(isRoot(p)){
            return 0;
        }

        // recursion to find the depth
        else{
            // recursive addition till root node (base condition as above)
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

        // start from every leaf node
        for(Position<E> p : leaves()){

            // leaves are external nodes
            if (isExternal(p)){
            // if the node is a leaf, get the depth and compare it with the current height
            h = Math.max(h, 1 + depth(p));
            }
        }
        // due to max fn in all leaves, h will contain max depth
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

        // check for any exceptions
        Node<E> node = validate(p);

        // print the node
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
     * @return the position of the node containing the given element, or null if the element is not found\
     * Funtion Overloading
     */
    public Position<E> find(E e){
        // helper method to abstract the root argument
        return find(this.root, e);
    }

    /**
     * Returns the position of the node containing the given element in the subtree rooted at the given position, or null if the element is not found.
     * @param p the root position of the subtree to search
     * @param e the element to search for
     * @return the position of the node containing the given element in the subtree rooted at the given position, or null if the element is not found
     */
    private Position<E> find(Position<E> p, E e) throws IllegalArgumentException{

        // throw an exception if it is not valid  
        Node<E> node = validate(p);

        // if the element matches, return the node 
        if(node.getElement().equals(e)){
            return node;
        }

        // if the node is not a leaf, search the children      
        if(!node.isLeaf()){
            for(Position<E> child : children(p)){

                // recursive call to find the element
                // when it finds, it will stop and return the node
                // keep travelling to children
                Position<E> found = find(child, e);
                if(found != null){
                    return found;
                }
            }
        }

        // if no node is found with the element, return null
        return null;
    }
}

