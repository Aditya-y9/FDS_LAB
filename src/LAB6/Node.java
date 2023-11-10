package LAB6;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private List<Node<E>> children;

        Node(E e, Node<E> p) {
            this.element = e;
            this.parent = p;
            this.children = new ArrayList<>();
        }

        @Override
        public E getElement() {
            return this.element;
        }

        public void setElement(E e) {
            this.element = e;
        }

        public Node<E> getParent() {
            return this.parent;
        }

        public List<Node<E>> getChildren() {
            return this.children;
        }

        public boolean isLeaf() {
            return this.children.size() == 0;
        }

        public void setParent(Node<E> p) {
            this.parent = p;
        }

        public void addChild(Node<E> child) {
            this.children.add(child);
        }
    }