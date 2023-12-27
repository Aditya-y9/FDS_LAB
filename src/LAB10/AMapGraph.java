package LAB10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AMapGraph<W> {
    private Map<Vertex, List<Edge<W>>> vertices;
    private List<Edge<W>> edges;
    private Map<Vertex, Map<Vertex, Edge<W>>> adjacencyMap;

    public AMapGraph() {
        this.vertices = new HashMap<>();
        this.edges = new ArrayList<>();
        this.adjacencyMap = new HashMap<>();
    }

    public int numVertices() {
        return vertices.size();
    }

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
        Edge<W> edge = new Edge<>(u, v, weight);
        edges.add(edge);

        vertices.computeIfAbsent(u, k -> new ArrayList<>()).add(edge);
        vertices.computeIfAbsent(v, k -> new ArrayList<>()).add(edge);

        adjacencyMap.computeIfAbsent(u, k -> new HashMap<>()).put(v, edge);
        adjacencyMap.computeIfAbsent(v, k -> new HashMap<>()).put(u, edge);
    }

    public void removeEdge(Edge<W> e) {
        edges.remove(e);
        vertices.get(e.getSrc()).remove(e);
        vertices.get(e.getDest()).remove(e);

        adjacencyMap.get(e.getSrc()).remove(e.getDest());
        adjacencyMap.get(e.getDest()).remove(e.getSrc());
    }

    public Map<Vertex, Map<Vertex, Edge<W>>> getAdjacencyMap() {
        return adjacencyMap;
    }
}