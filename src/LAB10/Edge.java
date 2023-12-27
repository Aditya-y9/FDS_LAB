package LAB10;

public class Edge<W> {
    private Vertex src, dest;
    private W weight;

    public Edge(Vertex src, Vertex dest, W weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public Vertex getSrc() {
        return src;
    }

    public Vertex getDest() {
        return dest;
    }

    public W getWeight() {
        return weight;
    }

    public void setSrc(Vertex src) {
        this.src = src;
    }

    public void setDest(Vertex dest) {
        this.dest = dest;
    }

    public void setWeight(W weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + src + "," + dest + "," + weight + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Edge))
            return false;
        Edge e = (Edge) obj;
        return (this.src.equals(e.src) && this.dest.equals(e.dest) && this.weight.equals(e.weight));
    }

    @Override
    public int hashCode() {
        return (this.src.hashCode() + this.dest.hashCode() + this.weight.hashCode());
    }

}
