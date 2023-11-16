package LAB6;

/**
 * An abstract class that implements the TreeInterface and provides default
 * implementations for SOME, not all of its methods.
 * @param <E> the type of elements stored in the tree
 */
public abstract class AbstractTree<E> implements TreeInterface<E> {

  /**
   * Returns true if the specified position has one or more child positions.
   * @param p the position to check
   * @return true if the specified position has one or more child positions
   */
  public boolean isInternal(Position<E> p) {
    // if the node has children, it is internal
    return numChildren(p) > 0;

    // have also implemented the LEAF LOGIC APPROACH IN GeneralTree.java
  }

  /**
   * Returns true if the specified position has no child positions.
   * @param p the position to check
   * @return true if the specified position has no child positions
   */
  public boolean isExternal(Position<E> p) {
    // if the node has no children, it is external
    return numChildren(p) == 0;

    // have also implemented the LEAF LOGIC APPROACH IN GeneralTree.java
  }

  /**
   * Returns true if the specified position is the root of the tree.
   * @param p the position to check
   * @return true if the specified position is the root of the tree
   */
  public boolean isRoot(Position<E> p) {
    // if the node is the root, it is the root
    return p == root();

    // stored root logic in overridden root() method in GeneralTree.java
  }

  /**
   * Returns true if the tree contains no elements.
   * @return true if the tree contains no elements
   */
  public boolean isEmpty() { return size() == 0; }

  /**
   * Returns the number of children of the specified position.
   * @param p
   * @return the number of children of the specified position
   */
  public int numChildren(Position<E> p) {
    int count = 0;

    // children(p) returns an iterable collection of the children of the
    // specified position (p) basically the list of children is stored with each
    // node
    for (Position<E> child : children(p)) {
      // long cut
      count++;
    }
    return count;
  }
}