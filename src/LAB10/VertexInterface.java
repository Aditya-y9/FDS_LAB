package LAB10;

/**
 * An interface representing a vertex in a graph.
 *
 * @param <V> The type of the element associated with the vertex.
 */
public interface VertexInterface<V> {

    /**
     * Gets the element associated with the vertex.
     *
     * @return The element associated with the vertex.
     */
    V getVertex();
}