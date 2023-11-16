import LAB5.Position;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
public class inorder<E>{
    public Iterable<Position<E>> breadthfirst(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty()){
            Queue<Position<E>> fringe = new LinkedList<>();
            fringe.enqueue(root());
            while(!fringe.isEmpty()){
                Position<E> p = fringe.dequeue();
                snapshot.add(p);
                for(Position<E> c : children(p))
                    fringe.enqueue(c);
            }

        }
        return snapshot;
    }
}
