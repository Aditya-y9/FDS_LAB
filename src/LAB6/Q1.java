package LAB6;
// for filehandling in java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Q1 class represents a program that reads a tree structure from a file and prints the tree.
 * It contains methods to read the tree from a file, count leading spaces in a string, and print the tree.
 */
public class Q1{
    // The tree to read from the file
    public GeneralTree<String> tree = new GeneralTree<String>();

    /**
     * The readTreeFromFile method reads the tree from a file.
     * @param address the address of the file to read the tree from.
     * @return the tree read from the file.
     */
    public GeneralTree<String> readTreeFromFile(String address) {
        try {
            // creating the File object
            File myObj = new File(address);

            // passing the file object to the scanner to set the file to read from
            Scanner myReader = new Scanner(myObj);

            // initialize the root and parent
            Node<String> root = null;
            Node<String> parent = null;

            // while loop till the end of the file
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int level = countLeadingSpaces(data) / 4; // Knowing tha each new child is indented by 4 spaces
                data.trim();

                // if the level is 0, add the root, else add the child to the parent node
                if (level == 0) {
                    // add the root
                    root = (Node<String>) tree.addRoot(data.trim());

                    // set the parent to the root
                    parent = root;
                } else {

                    // go up the tree till the level of the parent is one less than the current level
                    while (level <= tree.depth(parent)) {
                        parent = parent.getParent();
                    }

                    // add the child to the parent
                    parent = (Node<String>) tree.addChild(parent, data.trim());
                }
            }


            // close the scanner objt
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            // e.printStackTrace() instead of printing the error e.getMessage()
            e.printStackTrace();
        }
        return tree;
    }
    /**
     * The countLeadingSpaces method counts the number of leading spaces in a string.
     * @param s the string to count the leading spaces in.
     * @return the number of leading spaces in the string.
     */
    public int countLeadingSpaces(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // increment the count till the character is a space
            if (Character.isWhitespace(s.charAt(i)))
                count++;
            else
                break;
        }
        return count;
    }

    /**
     * The printTree method prints the tree.
     * @param node the node to start printing from.
     * @param prefix the prefix to print before the node.
     * @param index the index of the node.
     * @param tree the tree to print.
     */
    public static void printTree(Node<String> node, String prefix, String index, GeneralTree<String> tree) {
        // flag to check if the node is the root
        boolean p = false;
        if(node == tree.root()){
            // print the root in a special way
            System.out.println(prefix + node.getElement());
            // set the flag to true
            p = true;
        }
        if(!p){
        // print the node recursively by getting their children also
        System.out.println(prefix + index + ": " + node.getElement());
        }
        for (int i = 0; i < node.getChildren().size(); i++) {
            Node<String> child = node.getChildren().get(i);
            printTree(child, prefix + "  ", index + "." + (i + 1),tree);        
        }
    
    }

    public static void main(String[] args) {
        // Q1 class obj to call the methods
        Q1 q1 = new Q1();

        // read the tree from the file
        GeneralTree<String> tree = q1.readTreeFromFile("C:\\Users\\MSHOME\\Desktop\\Newfolder\\FDS_LAB\\src\\LAB6\\Q1.txt");

        // print the tree, get root to start printing from it
        Node<String> root = (Node<String>) tree.root();
        printTree(root, " ", "1", tree);
    }
}
   