package LAB6;

import java.lang.Iterable;
import java.util.Iterator;

public interface TreeInterface<E> extends Iterable<E> {
        /**
         * Returns the number of nodes in the tree.
         */
        public int size();
        /**
         * Returns whether the tree is empty.
         */
        public boolean isEmpty();
        /**
         * Returns an iterator of the elements stored in the tree.
         */
        public Iterator<E> iterator();
        /**
         * Returns an iterable collection of the positions of the tree.
         */
        public Iterable<Position<E>> positions();
        /**
         * Replaces the element stored at a given position.
         */
        public E replace(Position<E> v, E e) throws IllegalStateException;
        /**
         * Returns the root of the tree.
         */
        public Position<E> root() throws IllegalStateException;
        /**
         * Returns the parent of a given position.
         */
        public Position<E> parent(Position<E> v) throws IllegalArgumentException;
        /**
         * Returns an iterable collection of the children of a given position.
         */
        public Iterable<Position<E>> children(Position<E> v) throws IllegalArgumentException;
        /**
         * Returns whether a given position has any children.
         */
        public boolean isInternal(Position<E> v) throws IllegalArgumentException;
        /**
         * Returns whether a given position is the root of the tree.
         */
        public boolean isExternal(Position<E> v) throws IllegalArgumentException;
        /**
         * Returns whether a given position is a leaf.
         */
        public boolean isRoot(Position<E> v) throws IllegalArgumentException;


}
