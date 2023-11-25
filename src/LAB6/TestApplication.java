package LAB6;

/**
 * The TestApplication class provides a command-line interface for testing the
 * GeneralTree data structure. It allows the user to perform various operations
 * on the tree, such as adding a root, adding a child, finding siblings, listing
 * leaves, listing internal nodes, listing edges, and finding the path for a
 * given node. The user can also visualize the tree using the printTree method.
 *
 * This class uses the GeneralTree class to create and manipulate the tree.
 *
 * To use this class, simply run the main method and follow the prompts.
 * @author Aditya Yedurkar
 * @version 1.0
 * @since 2023-11-09
 */
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


/**
 * This class provides a command-line interface for interacting with a
 * GeneralTree data structure. It allows the user to perform various operations
 * on the tree, such as adding nodes, finding siblings, and listing leaves.
 */
public class TestApplication {

  /**
   * The main method of the program. It initializes a GeneralTree object and
   * provides a menu-driven interface for interacting with it.
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);


    // GeneralTree object is created
    GeneralTree<String> tree = new GeneralTree<>();
    int choice = 0;
    while (choice != 11) {
            System.out.println(
        "<-------------------------------------------------------------------------------->");
      System.out.println("\n0. Visualize Tree"
                         + "\n1. Add Root"
                         + "\n2. Add Child"
                         + "\n3. Subtree Rooted at given node"
                         + "\n4. Find Siblings"
                         + "\n5. List leaves"
                         + "\n6. List Internal Nodes"
                         + "\n7. List Edges"
                         + "\n8. Path for a given node"
                         + "\n9. Depth of the node"
                         + "\n10. Height of the Tree"
                         + "\n11. Exit the program"
                         + "\n12. Get Size of Tree");

      System.out.print("Enter your choice: ");
      try {
        choice = sc.nextInt();
      } catch (InputMismatchException e) {
        System.out.println(
            "Invalid input, Please enter a valid number to indicate your choice");

        // clearing the buffer
        sc.next();
        continue;
      }
      switch (choice) {
      case 0:
        try {
          // print from root
          printTree(tree.validate(tree.root()), " ", "0");
        } catch (Exception e) {
          // get message from exception
          System.out.println("Error: " + e.getMessage());
        }
        break;
      case 1:
        System.out.println("Enter the element of the root: ");
        try {
          String root = sc.next();
          // add root element
          tree.addRoot(root);
          System.out.println("Root element " + root + " added successfully");
        } catch (IllegalStateException e) {
          System.out.println(
              "Tree already has a root and the tree is not empty");
        } catch (InputMismatchException e) {
          System.out.println("Invalid input, Please enter a string");
        }
        break;
      case 2:
        System.out.println("Enter the element of the parent: ");
        try {
          String parent = sc.next();

          // if tree is empty
          if(tree.isEmpty()){
            System.out.println("Tree is empty, Please add a root first");
            break;
          }
          System.out.println("Enter the element of the child: ");
          String child = sc.next();

          // find parent by element
          Position<String> p = tree.find(parent);
          // add child to parent
          tree.addChild(p, child);

          System.out.println("Child element " + child + " added to Parent " +
                             parent + " element successfully");
        } catch (IllegalArgumentException e) {
          System.out.println(
              "No such parent node found, Please enter a valid parent node");
        } catch (InputMismatchException e) {
          System.out.println("Invalid input, Please enter a string");
        } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
        }
        break;
      case 3:
      if(tree.isEmpty()){
        System.out.println("Tree is empty, Please add a root first");
        break;
      }
        System.out.println("Enter the element of the node: ");
        try {
          String node = sc.next();

          // find node by element
          Position<String> n = tree.find(node);

          // if node not found
          if (n == null) {
            System.out.println("Node not found");
            break;
          }

          // print subtree from node
          printTree(tree.validate(n), " ","0");

        // exception handling
        } catch (IllegalArgumentException e) {
          System.out.println("No such node found, Please enter a valid node");
        } catch (InputMismatchException e) {
          System.out.println("Invalid input, Please enter a string");
        } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
        }
        break;
      case 4:

        System.out.println("To find siblings of the node,");
        System.out.println("Enter the element of the node: ");
        try {
        if(tree.isEmpty()){
        System.out.println("Tree is empty, Please add a root first");
        break;
      }
          String node = sc.next();

          // find node by element
          Position<String> n = tree.find(node);

          // if node not found
          if (n == null) {
            System.out.println("Node not found");
            break;
          }

          // if node is root
          if (tree.isRoot(n)) {
            System.out.println("Root has no siblings!");
            break;
          }

          // get siblings of node
          Iterable<Position<String>> siblings = tree.siblings(n);

          System.out.println("Siblings of the node are: ");

          if (siblings == null) {
            System.out.println("Given Node has no siblings!");
            break;
          }

          // iterate over siblings
          for (Position<String> s : siblings) {
            // print siblings
            System.out.println(s.getElement() + " is a sibling of " +
                               n.getElement());
          }

        // exception handling
        } catch (IllegalArgumentException e) {
          System.out.println("No such node found, Please enter a valid node");
        } catch (InputMismatchException e) {
          System.out.println("Invalid input, Please enter a string");
        } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
        }
        break;
        case 5:

        try {
    if(tree.isEmpty()){
        System.out.println("Tree is empty, Please add a root first");
        break;
      }
          System.out.println("Leaves of the tree are: ");

          // get leaves of tree
          Iterable<Position<String>> leaves = tree.leaves();

          // iterate over leaves
          for (Position<String> l : leaves) {
          System.out.println(l.getElement());
          }
        }
        // exception handling 
        catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
        }
        break;
        case 6:
        try {
      if(tree.isEmpty()){
        System.out.println("Tree is empty, Please add a root first");
        break;
      }
          // get internal nodes of trees
          System.out.println("Internal nodes of the tree are: ");

          // iterate over internal nodes
          Iterable<Position<String>> internalNodes = tree.internalNodes();
          for (Position<String> i : internalNodes) {
          System.out.println(i.getElement());
          }
        }
        // exception handling 
        catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
        }
        break;
        case 7:
        try {
      if(tree.isEmpty()){
        System.out.println("Tree is empty, Please add a root first");
        break;
      }
          System.out.println("Edges of the tree are: ");

          // get edges of tree
          Iterable<Position<String>> edges = tree.edges();

          // iterate over edges
          for (Position<String> edge : edges) {
          // print edges
          Position<String> parent = tree.parent(edge);

          // 
          Position<String> child = edge;
          if (parent != null && child != null) {
            System.out.println(parent.getElement() + " <--> " +
                     child.getElement());
          }
          }
        } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
        }

        break;
        case 8:
        try {
          if(tree.isEmpty()){
        System.out.println("Tree is empty, Please add a root first");
        break;
      }
          System.out.println("To find path of the node,");
          System.out.println("Enter the element of the node: ");
          String node1 = sc.next();
          // find node by element
          Position<String> n1 = tree.find(node1);
          // a sequence of nodes and edges connecting a node with a descendant
          Iterable<Position<String>> path = tree.getPath(n1);
          for (Position<String> p2 : path) {
          System.out.println("       " + p2.getElement() + "       ");
          System.out.println("-----|||||-----");
          }
          if(n1.equals(null)){
            System.out.println("No node found");
          }


        }
        catch (IllegalArgumentException e) {
          System.out.println(
              "No such node found, Please enter a valid element of the node");
        }
        catch (InputMismatchException e) {
          System.out.println("Invalid input, Please enter a string");
        } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
        }
        break;
        case 9:
        System.out.println("Enter the element of the node: ");
        try {
          if(tree.isEmpty()){
        System.out.println("Tree is empty, Please add a root first");
        break;
      }
          String node2 = sc.next();

          // find node by element
          Position<String> n2 = tree.find(node2);

          n2 = (Node<String>)n2;

          // if node not found
          System.out.println("Depth of the node is: " + tree.depth(n2));
        }
        // exception handling 
        catch (IllegalArgumentException e) {
          System.out.println(
              "No such node found, Please enter a valid element of the node");
        } catch (InputMismatchException e) {
          System.out.println("Invalid input, Please enter a string");
        } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
        }
        break;
      case 10:
        try {
          if(tree.isEmpty()){
        System.out.println("Tree is empty, Please add a root first");
        break;
      }
          // get height of tree
          System.out.println("Height of the tree is: " + (tree.height()));
        }
        // exception handling 
        catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
        }
        break;

      case 11:
        System.out.println(
            "Exiting the program.....,Thank you for using the program");
        break;
      default:
        System.out.println("Invalid choice");
        break;

      case 12:
      if(tree.isEmpty()){
        System.out.println("Tree is empty, Size = 0 ");
        break;
      }
        try {
          // get size of tree
          System.out.println("Size of the tree is: " + (tree.size()));
        }
        // exception handling 
        catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
        }
        break;
      }
    }
  }

  /**
   * This method prints the tree in a hierarchical format, with each node
   * @param node The root node of the tree to be printed.
   * @param indent The indentation to be used for the current node.
   * @param index The index of the current node.
   */
public static void printTree(Node<String> node, String indent, String index) {

  // element at first argument is printed first
  // main printer
  System.out.println(indent + "+--" + index + " : " + node.getElement());

  // children of the node are stored in a list
  List<Node<String>> children = node.getChildren();

  // for each child, the printTree method is called recursively
  for (int i = 0; i < children.size() - 1; i++) {

    // get will return the element at the specified index
    // children ----> children ----> children ----> children recursively till leaf node
    printTree(children.get(i), indent + "|  ", index + "." + (i + 1));
  }


  // is like our base case it will stop if @ leaf node ------> no children
  if (children.size() > 0) {
    printTree(children.get(children.size() - 1), indent + "   ", index + "." + children.size());
  }
}

}
