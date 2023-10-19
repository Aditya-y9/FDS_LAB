import java.util.*;
class LinkedListJCF{
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();

        list.addFirst(1);

        list.add(2);

        list.addFirst(4);
        list.addLast(5);

        System.out.println(list.getFirst());
        
        System.out.println(list.removeLast());
        
        System.out.println(list.isEmpty());
        
        System.out.println(list.size());
        
        System.out.println(list.get(0));
        System.out.println(list.peek());
    }
}