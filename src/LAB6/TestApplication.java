package LAB6;
import java.util.*;


public class TestApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        GeneralTree<String> tree = new GeneralTree<>();
        System.out.println("---------------Tree ADT initialized succqessfully--------------");
        int choice = 0;
while(choice != 11){
        System.out.println(
                "\n0. Visualize Tree"
                + "\n1. Add Root"
                + "\n2. Add Child"
                + "\n3. Attach"
                + "\n4. Display"
                + "\n5. Find Siblings"
                + "\n6. List leaves"
                + "\n7. List Internal Nodes"
                + "\n8. List Edges"
                + "\n9. Path for a given node");

        System.out.println("Enter your choice: ");
        try{
            choice = sc.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input, Please enter a number");
            sc.next();
            continue;
        }
        switch(choice){
            case 0:
                printTree(tree.validate(tree.root()), " ");
                break;
            case 1:
                System.out.println("Enter the element of the root: ");
                try{
                    String root = sc.next();
                    tree.addRoot(root);
                }
                catch(IllegalStateException e){
                    System.out.println("Tree is not empty");
                }
                catch(InputMismatchException e){
                    System.out.println("Invalid input, Please enter a string");
                }
                break;
            case 2:
                System.out.println("Enter the element of the parent: ");
                try{
                String parent = sc.next();
                System.out.println("Enter the element of the child: ");
                String child = sc.next();
                Position<String> p = tree.find(parent);
                tree.addChild(p, child);
                }
                catch(IllegalArgumentException e){
                    System.out.println("Invalid input, Please enter a string");
                }
                catch(InputMismatchException e){
                    System.out.println("Invalid input, Please enter a string");
                }
                catch(Exception e){
                    System.out.println("Error: "+e.getMessage());
                }
                break;
            case 3:
                System.out.println("Enter the element of the parent: ");
                try{
                String parent1 = sc.next();
                System.out.println("Enter the element of the tree to attach: ");
                String tree1 = sc.next();
                Position<String> p1 = tree.find(parent1);
                Position<String> t1 = tree.find(tree1);
                tree.attach(p1, t1);
                }
                catch(IllegalArgumentException e){
                    System.out.println("Invalid input, Please enter a string");
                }
                catch(InputMismatchException e){
                    System.out.println("Invalid input, Please enter a string");
                }
                catch(Exception e){
                    System.out.println("Error: "+e.getMessage());
                }
                break;
            case 4:
                try{
                    Position<String> r1 = tree.root();
                    String root1 = r1.getElement();
                    tree.display(r1, 0, root1);
                }
                catch(Exception e){
                    System.out.println("Error: "+e.getMessage());
                }
                break;
            case 5:
                System.out.println("Enter the element of the node: ");
                try{
                String node = sc.next();
                Position<String> n = tree.find(node);
                if(n == null) {
                    System.out.println("Node not found");
                    break;
                }
                if(tree.isRoot(n)) {
                    System.out.println("Root has no siblings");
                    break;
                }
                if(tree.siblings(n) == null) {
                    System.out.println("No siblings");
                    break;
                }
                Iterable<Position<String>> siblings = tree.siblings(n);
                for(Position<String> s : siblings) {
                    System.out.println(s.getElement());
                }
                }
                catch(IllegalArgumentException e){
                    System.out.println("Invalid input, Please enter a string");
                }
                catch(InputMismatchException e){
                    System.out.println("Invalid input, Please enter a string");
                }
                catch(Exception e){
                    System.out.println("Error: "+e.getMessage());
                }
                break;
            case 6:
                try{
                Iterable<Position<String>> leaves = tree.leaves();
                for(Position<String> l : leaves) {
                    System.out.println(l.getElement());
                }
            }
            catch(Exception e){
                System.out.println("Error: "+e.getMessage());
            }
                break;
            case 7:
            try{
                Iterable<Position<String>> internalNodes = tree.internalNodes();
                for(Position<String> i : internalNodes) {
                    System.out.println(i.getElement());
                }
            }
            catch(Exception e){
                System.out.println("Error: "+e.getMessage());
            }
                break;
            case 8:
            try{
                Iterable<Position<String>> edges = tree.edges();
                for(Position<String> e : edges) {
                    System.out.println(e.getElement());
                }
            }
            catch(Exception e){
                System.out.println("Error: "+e.getMessage());
            }
                break;
            case 9:
            try{
                System.out.println("Enter the element of the node: ");
                String node1 = sc.next();
                Position<String> n1 = tree.find(node1);
                Iterable<Position<String>> path = tree.path(n1);
                for(Position<String> p2 : path) {
                    System.out.println("       "+p2.getElement()+"       ");
                    System.out.println("--------|||||-------");
                }
            }
            catch(Exception e){
                System.out.println("Error: "+e.getMessage());
            }
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
    public static void printTree(Node<String> node, String indent) {
        System.out.println(indent + node.getElement());
        for (Node<String> child : node.getChildren()) {
            printTree(child, indent + "|--");
        }
    }

    public static void visualizeGeneralTree(Node<String> node) {
        System.out.println(node.getElement());
        for (Node<String> child : node.getChildren()) {
            visualizeGeneralTree(child);
        }
    }
}







          
    
