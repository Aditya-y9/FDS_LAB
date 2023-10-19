import java.util.*;
public class StackJCF {
    public static void main(String[] args){

        // important line to define stack using java collection framework
        Stack<Integer> s = new Stack<>();

        // push
        s.push(1);
        s.push(2);


        // peek or top
        int r = s.peek();
        System.out.println(r);


        // pop remove and return
        System.out.println(s.pop());

        System.out.println(s.isEmpty());

        System.out.println(s.size());

        s.clear();

        System.out.println(s.size());

    }
}
