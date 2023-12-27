package LAB10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import LAB10.Vertex;


/**
 * An Class representing a graph.
 * @param <W> The type of the element associated with edges.
 * @param <V> The type of the element associated with vertices.
 * @param <E> The type of the element associated with edges.
 * A graph is a set of vertices and a set of edges connecting pairs of distinct vertices.
 * Each edge is associated with a weight.
 * A graph may be undirected, in which case edges are unordered pairs of vertices,
 * or directed, in which case edges are ordered pairs of vertices.
 * We say that a directed edge points from the first vertex in the pair and points to the second vertex in the pair.
 * We say that a directed edge points from the first vertex in the pair and points to the second vertex in the pair.
 * The vertices are represented by objects of type V, and the weights are represented by objects of type W.
 */

public class Graph<W> {
    // A map from vertices to lists of outgoing edges.
    private Map<Vertex, List<Edge<W>>> vertices;
    private List<Edge<W>> edges;

    // Constructs an empty graph.
    public Graph() {
        this.vertices = new HashMap<>();
        this.edges = new ArrayList<>();
    }

    // Returns the number of vertices in the graph.
    public int numVertices() {
        return vertices.size();
    }

    // Returns iterable collection of all vertices of the graph.
    public List<Vertex> vertices() {
        return new ArrayList<>(vertices.keySet());
    }

    public int numEdges() {
        return edges.size();
    }

    public List<Edge<W>> edges() {
        return new ArrayList<>(edges);
    }

    public Edge<W> getEdge(Vertex u, Vertex v) {
        for (Edge<W> edge : edges) {
            if (edge.getSrc().equals(u) && edge.getDest().equals(v)) {
                return edge;
            }
        }
        return null;
    }

    public boolean hasEdge(Vertex u, Vertex v) {
        return getEdge(u, v) != null;
    }

    public List<Vertex> endVertices(Edge<W> e) {
        List<Vertex> endVertices = new ArrayList<>();
        endVertices.add(e.getSrc());
        endVertices.add(e.getDest());
        return endVertices;
    }

    public Vertex opposite(Vertex v, Edge<W> e) {
        if (v.equals(e.getSrc())) {
            return e.getDest();
        } else if (v.equals(e.getDest())) {
            return e.getSrc();
        } else {
            throw new IllegalArgumentException("Vertex is not incident to this edge");
        }
    }

    public int outDegree(Vertex v) {
        return vertices.getOrDefault(v, new ArrayList<>()).size();
    }

    public int inDegree(Vertex v) {
        int count = 0;
        for (List<Edge<W>> edgesList : vertices.values()) {
            for (Edge<W> edge : edgesList) {
                if (edge.getDest().equals(v)) {
                    count++;
                }
            }
        }
        return count;
    }

    public List<Edge<W>> outgoingEdges(Vertex v) {
        return new ArrayList<>(vertices.getOrDefault(v, new ArrayList<>()));
    }

    public List<Edge<W>> incomingEdges(Vertex v) {
        List<Edge<W>> incomingEdges = new ArrayList<>();
        for (List<Edge<W>> edgesList : vertices.values()) {
            for (Edge<W> edge : edgesList) {
                if (edge.getDest().equals(v)) {
                    incomingEdges.add(edge);
                }
            }
        }
        return incomingEdges;
    }

    public void insertVertex(Vertex x) {
        vertices.put(x, new ArrayList<>());
    }


    public void insertEdge(Vertex u, Vertex v, W weight) {
        Edge<W> edge = new Edge<W>(u, v, weight);
        edges.add(edge);
        
        vertices.computeIfAbsent(u, k -> new ArrayList<>()).add(edge);
        vertices.computeIfAbsent(v, k -> new ArrayList<>()).add(edge);
    }

    public void removeVertex(Vertex v) {
        vertices.remove(v);
        edges.removeIf(edge -> edge.getSrc().equals(v) || edge.getDest().equals(v));
        for (List<Edge<W>> edgesList : vertices.values()) {
            edgesList.removeIf(edge -> edge.getDest().equals(v));
        }
    }

    public void removeEdge(Edge<W> e) {
        edges.remove(e);
        vertices.get(e.getSrc()).remove(e);
        vertices.get(e.getDest()).remove(e);
    }




}