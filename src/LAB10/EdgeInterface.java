package LAB10;

/**
 * An interface representing an edge in a graph.
 *
 * @param <E> The type of the element associated with the edge.
 */
public interface EdgeInterface<E> {

    /**
     * Gets the element associated with the edge.
     *
     * @return The element associated with the edge.
     */
    E getElement();
}