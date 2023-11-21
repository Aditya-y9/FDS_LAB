package LAB6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Q1{
    public GeneralTree<String> tree = new GeneralTree<String>();

    public GeneralTree<String> readTreeFromFile(String address) {
        try {
            // creating the File object
            File myObj = new File(address);

            // passing the file object to the scanner to process
            Scanner myReader = new Scanner(myObj);

            // initialize the root and parent
            Node<String> root = null;
            Node<String> parent = null;

            // while loop till the end of the file
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int level = countLeadingSpaces(data) / 4; // Assuming each level is indented by 4 spaces
                data.trim();
                if (level == 0) {
                    root = (Node<String>) tree.addRoot(data.trim());
                    parent = root;
                } else {
                    while (level <= tree.depth(parent)) {
                        parent = parent.getParent();
                    }
                    parent = (Node<String>) tree.addChild(parent, data.trim());
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return tree;
    }
    public int countLeadingSpaces(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isWhitespace(s.charAt(i)))
                count++;
            else
                break;
        }
        return count;
    }

    public static void printTree(Node<String> node, String prefix, String index, GeneralTree<String> tree) {
        boolean p = false;
        if(node == tree.root()){
            System.out.println(prefix + node.getElement());
            p = true;
        }
        if(!p){
        System.out.println(prefix + index + ": " + node.getElement());
        }
        for (int i = 0; i < node.getChildren().size(); i++) {
            Node<String> child = node.getChildren().get(i);
            printTree(child, prefix + "  ", index + "." + (i + 1),tree);        
        }
    
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        GeneralTree<String> tree = q1.readTreeFromFile("C:\\Users\\MSHOME\\Desktop\\Newfolder\\FDS_LAB\\src\\LAB6\\Q1.txt");
        Node<String> root = (Node<String>) tree.root();
        printTree(root, " ", "1", tree);
    }
}
   