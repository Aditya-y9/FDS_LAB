package LAB10;

public class Vertex<T> {
    private T element;
    private int id;

    public Vertex(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public int getId() {
        return id;
    }



}   