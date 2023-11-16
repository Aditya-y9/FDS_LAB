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

    GeneralTree<String> tree = new GeneralTree<>();
    int choice = 0;
    while (choice != 11) {
            System.out.println(
        "<---------------------------------------------------------------------------------------------------------------------------->");
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
                         + "\n11. Exit the program");

      System.out.println("Enter your choice: ");
      try {
        choice = sc.nextInt();
      } catch (InputMismatchException e) {
        System.out.println(
            "Invalid input, Please enter a valid number to indicate your choice");
        sc.next();
        continue;
      }
      switch (choice) {
      case 0:
        try {
          printTree(tree.validate(tree.root()), " ", "0");
        } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
        }
        break;
      case 1:
        System.out.println("Enter the element of the root: ");
        try {
          String root = sc.next();
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
          System.out.println("Enter the element of the child: ");
          String child = sc.next();
          Position<String> p = tree.find(parent);
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
        System.out.println("Enter the element of the node: ");
        try {
          String node = sc.next();
          Position<String> n = tree.find(node);
          if (n == null) {
            System.out.println("Node not found");
            break;
          }
          printTree(tree.validate(n), " ","0");
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
          String node = sc.next();
          Position<String> n = tree.find(node);
          if (n == null) {
            System.out.println("Node not found");
            break;
          }
          if (tree.isRoot(n)) {
            System.out.println("Root has no siblings!");
            break;
          }
          Iterable<Position<String>> siblings = tree.siblings(n);
          System.out.println("Siblings of the node are: ");
          if (siblings == null) {
            System.out.println("Given Node has no siblings!");
            break;
          }
          for (Position<String> s : siblings) {
            System.out.println(s.getElement() + " is a sibling of " +
                               n.getElement());
          }
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
          System.out.println("Leaves of the tree are: ");
          Iterable<Position<String>> leaves = tree.leaves();
          for (Position<String> l : leaves) {
            System.out.println(l.getElement());
          }
        } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
        }
        break;
      case 6:
        try {
          System.out.println("Internal nodes of the tree are: ");
          Iterable<Position<String>> internalNodes = tree.internalNodes();
          for (Position<String> i : internalNodes) {
            System.out.println(i.getElement());
          }
        } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
        }
        break;
      case 7:
        try {
          System.out.println("Edges of the tree are: ");
          Iterable<Position<String>> edges = tree.edges();
          for (Position<String> edge : edges) {
            Position<String> parent = tree.parent(edge);
            Position<String> child = edge;
            if (parent != null && child != null) {
              System.out.println(parent.getElement() + " -> " +
                                 child.getElement());
            }
          }
        } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
        }

        break;
      case 8:
        try {
          System.out.println("To find path of the node,");
          System.out.println("Enter the element of the node: ");
          String node1 = sc.next();
          Position<String> n1 = tree.find(node1);
          Iterable<Position<String>> path = tree.getPath(n1);
          for (Position<String> p2 : path) {
            System.out.println("       " + p2.getElement() + "       ");
            System.out.println("-----|||||-----");
          }

        } catch (InputMismatchException e) {
          System.out.println("Invalid input, Please enter a string");
        } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
        }
        break;
      case 9:
        System.out.println("Enter the element of the node: ");
        try {
          String node2 = sc.next();
          Position<String> n2 = tree.find(node2);
          n2 = (Node<String>)n2;
          System.out.println("Depth of the node is: " + tree.depth(n2));
        } catch (IllegalArgumentException e) {
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
          System.out.println("Height of the tree is: " + tree.height());
        } catch (Exception e) {
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
    printTree(children.get(i), indent + "|  ", index + "." + (i + 1));
  }


  // is like our base case it will stop if @ leaf node ------> no children
  if (children.size() > 0) {
    printTree(children.get(children.size() - 1), indent + "   ", index + "." + children.size());
  }
}

}
