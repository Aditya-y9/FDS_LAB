package LAB6;
 import java.util.Iterator;
 import java.lang.Iterable;
public class Q4

{
    
    public static void showTrunks(Trunk p)
    {
        if (p == null) {
            return;
        }
 
        showTrunks(p.prev);
        System.out.print(p.str);
    }
 
    public static void printTree(BTNode root, Trunk prev, boolean isLeft)
    {
        if (root == null) {
            return;
        }

        Iterable<BTNode> children = root.children();
        Iterator<BTNode> childrenIterator = children.iterator();
        
 
        String prev_str = "   ";
        Trunk trunk = new Trunk(prev, prev_str);
 
        printTree(root.right, trunk, true);
 
        if (prev == null) {
            trunk.str = "———";
        }
        else if (isLeft) {
            trunk.str = "┌──";
            prev_str = "   |";
        }
        else {
            trunk.str = "└──";
            prev.str = prev_str;
        }
 
        showTrunks(trunk);
        System.out.println(root.data);
 
        if (prev != null) {
            prev.str = prev_str;
        }
        trunk.str = "   |";

        printTree(root.left, trunk, false);
    }
 
    public static void main(String[] args)
    {
        // Construct above tree
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(3);
        root.left.left = new BTNode(4);
        root.left.right = new BTNode(5);
        root.right.left = new BTNode(6);
        root.right.right = new BTNode(7);
        root.left.left.left = new BTNode(8);
        root.left.left.right = new BTNode(9);
        root.left.right.left = new BTNode(10);
        root.left.right.right = new BTNode(11);
        root.right.left.left = new BTNode(12);
        root.right.left.right = new BTNode(13);
        root.right.right.left = new BTNode(14);
        root.right.right.right = new BTNode(15);
 
        // print constructed binary tree
        printTree(root, null, false);
    }
}