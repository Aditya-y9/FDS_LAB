package LAB6;

import java.util.*;
import java.util.Iterator;

/**
 * LinkedBinaryTree represents a binary tree implementation using linked nodes.
 * It provides methods for adding, removing, and traversing the tree.
 *
 * @param <E> the type of elements stored in the tree
 */
public class BinaryTree<E> {


    public static class Node<E> implements Position<E> {


        public E element; // element at the node
        // references to other linked nodes
        public Node<E> parent;
        public Node<E> left;
        public Node<E> right;

        public Node(E e, Node<E> parent, Node<E> left, Node<E> right) {
            // typical Binary node
            this.element = e;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }



        @Override
        // from Position interface
        public E getElement() {
            return element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }



        public void setElement(E e) {
            this.element = e;
        }

        public void setParent(Node<E> p) {
            this.parent = p;
        }

        public void setLeft(Node<E> l) {
            this.left = l;
        }

        public void setRight(Node<E> r) {
            this.right = r;
        }

    }


    protected Node<E> createNode(E e, Node<E> parent, Node<E> left_node, Node<E> right_node) {
        // jus a helper method to create a node instead of writing the constructor again and again
        return new Node<>(e, parent, left_node, right_node);
    }

    public Node<E> root = null;
    public int size = 0;



    public Node<E> validate(Position<E> p) throws IllegalArgumentException {
        // 1, check DT
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");

        
        Node<E> posNode = (Node<E>) p; // typecast

        // ik that my defunct node will have its parent as itself
        if (posNode.getParent() == posNode) // check for defunct node
            throw new IllegalArgumentException("p is no longer a valid position");
        return posNode;
    }



    public void addLeft(Position<E> p, Position<E> n) {
        // everywhere we take positon as input in fn as arg
        Node<E> node = validate(p);
        Node<E> left = validate(n);
        node.setLeft(left);
    }
    
    public void addRight(Position<E> p, Position<E> n) {
        Node<E> node = validate(p);
        Node<E> right = validate(n);
        node.setRight(right);
    }

    public Position<E> root() {
        return root;
    }

    public int size() {
        return size;
    }

    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }


    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }


    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }



    // add root to an empty tree, set the root element as the passed element
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!this.isEmpty())
            throw new IllegalStateException("Tree is not empty");
        this.root = createNode(e, null, null, null);
        this.size = 1;
        return root;
    }

    public Position<E> add(E e) {
        return addRoot(e);
    }

    // add left child to a passed position, if not already present
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException, IllegalStateException {
        Node<E> node = validate(p);

        // check if the node already has a left child
        if (node.getLeft() != null)
            throw new IllegalStateException("Passed node p already has a left child");
        Node<E> l = createNode(e, node, null, null);

        // set the left child
        node.setLeft(l);
        ++this.size;
        return l;
    }

    // add right child to a passed position, if not already present
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException, IllegalStateException {
        Node<E> node = validate(p);
        if (node.getRight() != null)
            throw new IllegalStateException("Passed node p already has a right child");
        Node<E> r = createNode(e, node, null, null);
        node.setRight(r);
        ++this.size;
        return r;
    }

    // set element at a passed position with the passed element, and return the old element
    public E set(Position<E> p, E e) throws IllegalArgumentException {

        // return like temp pop() method
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    // attach passed trees t1 and t2 as left and right sub-trees resp to the passed position
    public void attach(Position<E> p, BinaryTree<E> t1, BinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        size += t1.size() + t2.size();

        // validate that t1 is not empty
        if (!t1.isEmpty()) {
            // attach the subtree with the given tree at the given node
            t1.root.setParent(node);
            node.setLeft(t1.root);
            // dissolve the independent subtree units
            t1.root = null;
            t1.size = 0;
        }
        // validate that t2 is not empty
        if (!t2.isEmpty()) {
            // attach the subtree with the given tree at the given node
            t2.root.setParent(node);
            node.setRight(t2.root);
            // dissolve the independent subtree units
            t2.root = null;
            t2.size = 0;
        }
    }

    public int numChildren(Position<E> p) throws IllegalArgumentException {

        // unlike general tree, here 2 children at max
        Node<E> node = validate(p);
        int count = 0;
        if (node.getLeft() != null)
            count++;
        if (node.getRight() != null)
            count++;
        return count;
    }

    // remove a node associated with the passed position, and replace it with its child(if any)
    public E remove(Position<E> p) throws IllegalArgumentException, IllegalStateException {
        Node<E> node = validate(p);
        E temp = node.getElement(); // value to return

        // if 2 children are present, not possible to replace
        if (numChildren(p) == 2)
            throw new IllegalStateException("The position p has 2 children");

        // 1 or 0 children case - if left node is null, take the right node
        Node<E> child_to_replace = (node.getLeft() != null) ? node.getLeft() : node.getRight();

        // in case the right child is not null
        if (child_to_replace != null)
            child_to_replace.setParent(node.getParent());

        // if the node to be removed is root
        if (node == root)
            this.root = child_to_replace;

            // if the node isn't root
        else {
            // check if the left or right node is going to replace the removed node
            if (child_to_replace == node.getLeft()) {
                node.getParent().setLeft(child_to_replace);
            } else {
                node.getParent().setRight(child_to_replace);
            }
        }

        size--;

        // allow the JVM garbage collector to recognize the defunct node
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);
        node.setElement(null);

        return temp;
    }

    // this class is the corresponding element Iterator implementation adapted to position Iterator
    public class ElementIterator implements Iterator<E> {

        Iterator<Position<E>> positionIterator = positions().iterator();

        @Override
        public boolean hasNext() {
            return positionIterator.hasNext();
        }

        @Override
        public E next() {
            return positionIterator.next().getElement(); // returns the next element
        }

        @Override
        public void remove() {
            positionIterator.remove();
        }
    }

    // return iterator of all elements in the tree
    public Iterator<E> iterator() {
        return new ElementIterator();
    }



    // PREORDER TRAVERSAL
    // add positions of a subtree rooted at passed position p to a passed ArrayList in preorder manner - first the node, then its children
    public void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p);
        for (Position<E> c : children(p))
            preorderSubtree(c, snapshot);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // return an iterable of positions of the tree in preorder fashion
    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        // call the recursive subroutine for the root node (i.e. entire tree preorder)
        if (!isEmpty())
            preorderSubtree(root(), snapshot);
        return snapshot;
    }

    public List<Position<E>> children(Position<E> p) {
        Node<E> node = validate(p);
        List<Position<E>> children = new ArrayList<>(2);
        Iterable<Position<E>> it = positions();
        Iterator<Position<E>> iter = it.iterator();
        if (iter.hasNext()) {
            Position<E> next = iter.next();
            if (next == node.getLeft())
                children.add(next);
            if (next == node.getRight())
                children.add(next);
        }
        return children;
    }

    // add positions of a subtree rooted at passed position p to a passed ArrayList in postorder manner - first the children, then the node
    public void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c : children(p))
            postorderSubtree(c, snapshot);
        snapshot.add(p);
    }

    // return an iterable of positions of the tree in preorder fashion
    public Iterable<Position<E>> postorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        // call the recursive subroutine for the root node (i.e. entire tree postorder)
        if (!isEmpty())
            postorderSubtree(root(), snapshot);
        return snapshot;
    }

    // add positions of a subtree rooted at passed position p to a passed ArrayList in postorder manner: inorder pattern is - LEFT, NODE, RIGHT
    public void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        if (left(p) != null)
            inorderSubtree(left(p), snapshot);
        snapshot.add(p);
        if (right(p) != null)
            inorderSubtree(right(p), snapshot);
    }

    // return an iterable of positions of the tree in an inorder fashion
    public Iterable<Position<E>> inorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        // call the recursive subroutine for the root node (i.e. entire tree inorder)
        if (!isEmpty())
            inorderSubtree(root(), snapshot);
        return snapshot;
    }

    // make inorder traversal the default iterable for the tree
    public Iterable<Position<E>> positions() {
        return inorder();
    }

    // BFS TRAVERSAL
    // we use a queue ADT (its FIFO nature) to add nodes in a level-order
    // we use Java collections Deque for implementing that
    public Iterable<Position<E>> BFS() {
        List<Position<E>> snapshot = new ArrayList<>();

        if (!this.isEmpty()) {
            // we use a deque to add nodes in a level-order
            Deque<Position<E>> levelOrder = new ArrayDeque<>();
            levelOrder.addFirst(this.root);


            while (!levelOrder.isEmpty()) {
                Position<E> next = levelOrder.removeFirst();
                // add the node to the snapshot
                snapshot.add(next);

                // add the children of the node to the queue
                for (Position<E> child : children(next)) {
                    levelOrder.addLast(child);
                }
            }
        }
        return snapshot;
    }

    public void Inorder(Position<E> p) {
        // recursive on left node of root
        if (left(p) != null) {
            System.out.print("(");
            Inorder(left(p));
        }

        // print root
        System.out.print(p.getElement());

        // recursive on right node of root
        if (right(p) != null) {
            Inorder(right(p));
            System.out.print(")");
        }
    }

}
