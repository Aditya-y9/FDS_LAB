package LAB5;
import LAB5.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.Iterable;


/**
 * This class implements the PositionalListInterface and provides a linked list implementation of it.
 * It contains a private static class Node which implements the Position interface and is used to represent each element in the list.
 * The class also contains methods to add, remove, and modify elements in the list, as well as iterators to traverse the list.
 */
public class LinkedPositionalList<T> implements PositionalListInterface<T> {

 
    private static class Node<T> implements Position<T> {

        private T element; 
        private Node<T> prev;
        private Node<T> next; 

        // parameterized constructor for the Node
        public Node(T e, Node<T> p, Node<T> n) {
            this.element = e;
            this.prev = p;
            this.next = n;
        }

   

        public T getElement() throws IllegalStateException {
            if (next == null) 
                throw new IllegalStateException("Position is no longer valid");
            else
                return element;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public Node<T> getNext() {
            return next;
        }
        public void setElement(T e) {
            this.element = e;
        }

        public void setNext(Node<T> n) {
            this.next = n;
        }

        public void setPrev(Node<T> p) {
            this.prev = p;
        }
    }

    private int size;
    private Node<T> header; 
    private Node<T> trailer;

    public LinkedPositionalList() {
        this.size = 0;
        this.trailer = new Node<>(null, null, null);
        this.header = new Node<>(null, null, this.trailer);
        this.trailer.setPrev(this.header); 
    }

   
    private Node<T> validateNode(Position<T> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Passed position is invalid");
        Node<T> node = (Node<T>) p; 
        if (node.getNext() == null) 
            throw new IllegalArgumentException("The passed node is defunct");
        return node;
    }

     
        private Position<T> position(Node<T> node) {
            if (node == this.header || node == this.trailer)
                return null;
            else
                return node;
        }

        private Position<T> addBetween(T t, Node<T> predecessor, Node<T> successor) {
            Node<T> newNode = new Node<>(t, predecessor, successor);
            predecessor.setNext(newNode);
            successor.setPrev(newNode);
            ++this.size;
            return position(newNode);
        }

        public int size() {
            return this.size;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public Position<T> first() {
            return position(this.header.getNext());
        }

        public Position<T> last() {
            return position(this.trailer.getPrev());
        }

        public Position<T> before(Position<T> p) throws IllegalArgumentException {
            Node<T> node = validateNode(p);
            return position(node.getPrev());
        }

        public Position<T> after(Position<T> p) throws IllegalArgumentException {
            Node<T> node = validateNode(p);
            return position(node.getNext());
        }

        @Override
        public Position<T> addFirst(T t) {
            return addBetween(t, this.header, this.header.getNext());
        }

        @Override
        public Position<T> addLast(T t) {
            return addBetween(t, this.trailer.getPrev(), this.trailer);
        }

        @Override
        public Position<T> addBefore(Position<T> p, T t) throws IllegalArgumentException {
            Node<T> node = validateNode(p);
            return addBetween(t, node.getPrev(), node);
        }

        @Override
        public Position<T> addAfter(Position<T> p, T t) throws IllegalArgumentException {
            Node<T> node = validateNode(p);
            return addBetween(t, node, node.getNext());
        }

        @Override
        public T set(Position<T> p, T t) throws IllegalArgumentException {
            Node<T> node = validateNode(p);
            T temp = node.getElement();
            node.setElement(t);
            return temp;
        }

        @Override
        public T remove(Position<T> p) throws IllegalArgumentException {
            Node<T> node = validateNode(p);
            T temp = node.getElement(); 
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            size--;
            // unlink node
            node.setPrev(null);
            node.setNext(null);
            node.setElement(null);
            return temp;
        }
        private class PositionIterator implements Iterator<Position<T>> {

            private Position<T> cursor = first();
            Position<T> recent = null;

            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public Position<T> next() throws NoSuchElementException {
                if (cursor == null)
                    throw new NoSuchElementException("No element found");
                else {
                    recent = cursor;
                    cursor = after(cursor);
                    return recent;
                }
            }

            @Override
            public void remove() throws IllegalStateException {
                if (recent == null)
                    throw new IllegalStateException("No element can be removed");
                LinkedPositionalList.this.remove(recent);
                recent = null;
            }
        }

        private class PositionIterable implements Iterable<Position<T>> {

            public Iterator<Position<T>> iterator() {
                return new PositionIterator();
            }
        }

        public Iterable<Position<T>> positions() {
            return new PositionIterable();
        }

        private class ElementIterator implements Iterator<T> {

            Iterator<Position<T>> posIterator = new PositionIterator();

            @Override
            public boolean hasNext() {
                return posIterator.hasNext();
            }

            @Override
            public T next() {
                return posIterator.next().getElement();
            }

            @Override
            public void remove() {
                posIterator.remove();
            }
        }
        public Iterator<T> iterator() {
            return new ElementIterator();
        }
    }
