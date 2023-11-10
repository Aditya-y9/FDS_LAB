package LAB6;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import LAB6.Position;
import LAB6.AbstractTree;
import LAB6.Node;
import LAB6.TreeInterface;


public class GeneralTree<E> extends AbstractTree<E> implements Iterable<E>, TreeInterface<E>{
    protected Node<E> createNode(E e, Node<E> parent) {
        return new Node<>(e, parent);
    }

    private Node<E> root;
    private int size;

    GeneralTree() {
        this.root = null;
        this.size = 0;
    }

    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        Node<E> posNode = (Node<E>) p; // typecast
        if (posNode.getParent() == posNode) // check for defunct node
            throw new IllegalArgumentException("p is no longer a valid position");
        return posNode;
    }


    @Override
    public E replace(Position<E> v, E e) throws IllegalStateException {
        Node<E> node = validate(v);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    @Override
    public Position<E> root() throws IllegalStateException {
        return this.root;
    }

    @Override
    public Position<E> parent(Position<E> v) throws IllegalArgumentException {
        Node<E> node = validate(v);
        return node.getParent();
    }

    @Override
    public Iterable<Position<E>> children(Position<E> v) throws IllegalArgumentException {
        Node<E> node = validate(v);
        List<Position<E>> snapshot = new ArrayList<>(node.getChildren().size());
        for (Position<E> child : node.getChildren()) {
            snapshot.add(child);
        }
        return snapshot;
    }
  

    @Override
    public boolean isInternal(Position<E> v) throws IllegalArgumentException {
        Node<E> node = validate(v);
        return !node.isLeaf();
    }

    @Override
    public boolean isExternal(Position<E> v) throws IllegalArgumentException {
        Node<E> node = validate(v);
        return node.isLeaf();
    }

    @Override
    public boolean isRoot(Position<E> v) throws IllegalArgumentException {
        Node<E> node = validate(v);
        return node == this.root;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }



    

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!this.isEmpty())
            throw new IllegalStateException("Tree is not empty");
        this.root = createNode(e, null);
        this.size = 1;
        return root;
    }

    public Position<E> addChild(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> child = createNode(e, node);
        node.addChild(child);
        this.size++;
        return child;
    }

    public void attach(Position<E> p,Position<E> t){
        Node<E> node = validate(p);
        Node<E> tree = validate(t);
        if(node.isLeaf()){
            node.addChild(tree);
            this.size += tree.getChildren().size();
        }
    }

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

    public Iterable<Position<E>> leaves() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!this.isEmpty())
            preorderLeaves(this.root, snapshot);
        return snapshot;
    }

    public void preorderLeaves(Position<E> p, List<Position<E>> snapshot) {
        Node<E> node = validate(p);
        if (node.isLeaf())
            snapshot.add(node);
        else {
            for (Position<E> child : node.getChildren())
                preorderLeaves(child, snapshot);
        }
    }

    public Iterable<Position<E>> internalNodes() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!this.isEmpty())
            preorderInternalNodes(this.root, snapshot);
        return snapshot;
    }

    public void preorderInternalNodes(Position<E> p, List<Position<E>> snapshot) {
        Node<E> node = validate(p);
        if (!node.isLeaf())
            snapshot.add(node);
        for (Position<E> child : node.getChildren())
            preorderInternalNodes(child, snapshot);
    }

    public Iterable<Position<E>> edges() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!this.isEmpty())
            preorderEdges(this.root, snapshot);
        return snapshot;
    }

    public void preorderEdges(Position<E> p, List<Position<E>> snapshot) {
        Node<E> node = validate(p);
        if (!node.isLeaf()) {
            for (Position<E> child : node.getChildren()) {
                snapshot.add(child);
                preorderEdges(child, snapshot);
            }
        }
    }

    public Iterable<Position<E>> path(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!this.isEmpty())
            preorderPath(this.root, p, snapshot);
        return snapshot;
    }

    public Iterable<Position<E>> preorderPath(Position<E> p, Position<E> q, List<Position<E>> snapshot) {
        Node<E> node = validate(p);
        Node<E> qNode = validate(q);
    
        if(node==root()){
            snapshot.add(node);
        }
        if (!node.isLeaf()) {
            for (Position<E> child : node.getChildren()) {
                if (child == qNode) {
                    snapshot.add(child);
                    return snapshot;
                }
                preorderPath(child, q, snapshot);
            }
        }
        return snapshot;
    }

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
    public Position<E> find(E e){
        return find(this.root, e);
    }
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
