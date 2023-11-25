package LAB6;


import java.util.*;


public class Q3 {

    
    public static void main(String[] args) {


        // initialize the tree
        BinaryTree<String> exp = new BinaryTree<>();

        // create the root
        Position<String> roo = exp.addRoot("-");

        // create the left and right child of root
        Position<String> left = exp.addLeft(roo, "/");
        Position<String> right = exp.addRight(roo, "+");

        // create the left and right child of left child
        // create new tree
        BinaryTree<String> exp1 = new BinaryTree<>();
        Position<String> root1 = exp1.addRoot("*");
        Position<String> left1 = exp1.addLeft(root1, "+");
        exp1.addRight(root1, "3");
        exp1.addLeft(left1, "3");
        exp1.addRight(left1, "1");

        BinaryTree<String> exp2 = new BinaryTree<>();
        Position<String> root2 = exp2.addRoot("+");
        Position<String> left2 = exp2.addLeft(root2, "-");
        exp2.addRight(root2, "2");
        exp2.addLeft(left2, "9");
        exp2.addRight(left2, "5");


        // attach the left and right child of left child
        exp.attach(left, exp1, exp2);


        // create the left and right child of right child
        BinaryTree<String> exp3 = new BinaryTree<>();
        Position<String> root3 = exp3.addRoot("*");
        exp3.addLeft(root3, "3");
        Position<String> right3 = exp3.addRight(root3, "-");
        exp3.addLeft(right3, "7");
        exp3.addRight(right3, "4");

        BinaryTree<String> exp4 = new BinaryTree<>();
        exp4.addRoot("6");

        // attach the left and right child of right child
        exp.attach(right, exp3, exp4);

        // print the tree in inorder
        exp.Inorder(roo);

    }
}
