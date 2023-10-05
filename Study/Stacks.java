public class Stacks{
    static class Node{
        int data;
        // because next points to next instance of itself
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class Stack{
        // top of stack
        public Node head;
        public static boolean isEmpty(){
            return head==null;
        }

        public static void push(int data){
            Node  newnode = new Node(data);
            if(isEmpty()){
                head = newnode;
                return;
            }
            else{
                // insertion at head
                newnode.next = head;
                head = newnode;
            }

        }
        public static int pop(){
            int top = head.data;
        }


    }
}
