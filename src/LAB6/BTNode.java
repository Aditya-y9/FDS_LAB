package LAB6;


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
}