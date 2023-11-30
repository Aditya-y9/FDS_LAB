package LAB6;
import LAB6.BinaryTree.Node;

public class Q4 {

    private static Node<String> test1() {
        Node<String> root = new Node<String>("+", null, null,null);
        Node<String> n11 = new Node<String>("*", root, null,null);
        Node<String> n12 = new Node<String>("-", root, null,null);
        Node<String> n21 = new Node<String>("a", null, null,null);
        Node<String> n22 = new Node<String>("b", null, null,null);
        Node<String> n23 = new Node<String>("c", null, null,null);
        Node<String> n24 = new Node<String>("d",    null, null,null);
        Node<String> n31 = new Node<String>("e", null, null,null);
        Node<String> n32 = new Node<String>("f", null, null,null);
        Node<String> n33 = new Node<String>("g", null, null,null);
        Node<String> n34 = new Node<String>("h", null, null,null);
        Node<String> n35 = new Node<String>("i", null, null,null);
        Node<String> n36 = new Node<String>("j", null, null,null);
        Node<String> n37 = new Node<String>("k", null, null,null);
        Node<String> n38 = new Node<String>("l", null, null,null);


        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;

        n21.left = n31;
        n21.right = n32;
        n22.left = n33;
        n22.right = n34;
        n23.left = n35;
        n23.right = n36;
        n24.left = n37;
        n24.right = n38;

        return root;
    }
    public static void main(String[] args) {
        Print.printNodeUsingIterator(test1());
    }
}



