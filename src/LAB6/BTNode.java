package LAB6;
import java.util.*;

// A Binary Tree Node
public class BTNode
{
    int data;
    BTNode left, right;
 
    public BTNode() {}
    public BTNode(int data)
    {
        this.data = data;
        this.left = this.right = null;
    }

    List<BTNode> children = new ArrayList<>();
     
    public Iterable<BTNode> children() {
        children.add(left);
        children.add(right);
        return children;
    }
}