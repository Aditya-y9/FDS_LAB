package LAB6;

/**
 * An abstract class that implements the TreeInterface and provides default implementations for some of its methods.
 * @param <E> the type of elements stored in the tree
 */
public abstract class AbstractTree<E> implements TreeInterface<E>{

    /**
     * Returns true if the specified position has one or more child positions.
     * @param p the position to check
     * @return true if the specified position has one or more child positions
     */
    public boolean isInternal(Position<E> p){
        return numChildren(p) > 0;
    }

    /**
     * Returns true if the specified position has no child positions.
     * @param p the position to check
     * @return true if the specified position has no child positions
     */
    public boolean isExternal(Position<E> p){
        return numChildren(p) == 0;
    }

    /**
     * Returns true if the specified position is the root of the tree.
     * @param p the position to check
     * @return true if the specified position is the root of the tree
     */
    public boolean isRoot(Position<E> p){
        return p == root();
    }

    /**
     * Returns true if the tree contains no elements.
     * @return true if the tree contains no elements
     */
    public boolean isEmpty(){
        return size() == 0;
    }

    public int numChildren(Position<E> p){
        int count = 0;
        for(Position<E> child : children(p)){
            count++;
        }
        return count;
    }
}