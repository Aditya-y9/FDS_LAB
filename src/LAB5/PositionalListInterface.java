package LAB5;
public interface PositionalListInterface<T>{
    int size();
    boolean isEmpty();
    PositionInterface<T> first();
    PositionInterface<T> last();
    PositionInterface<T> before(PositionInterface<T> p) throws IllegalArgumentException;
    PositionInterface<T> after(PositionInterface<T> p) throws IllegalArgumentException;
    PositionInterface<T> addFirst(T e);
    PositionInterface<T> addLast(T e);
    PositionInterface<T> addBefore(PositionInterface<T> p, T e) throws IllegalArgumentException;
    PositionInterface<T> addAfter(PositionInterface<T> p, T e) throws IllegalArgumentException;
    T set(PositionInterface<T> p, T e) throws IllegalArgumentException;
    T remove(PositionInterface<T> p) throws IllegalArgumentException;
}
