package LAB6;
import java.util.*;
import LAB6.BinaryTree.Node;
class Print {
    public static <T> void printNode(Node<String> node) {
        // get the height of the tree
        int maxLevel = Print.maxLevel(node);

        // print the tree
        printNodeInternal(Collections.singletonList(node), 1, maxLevel);
    }
    public static <T> void printNodeUsingIterator(Node<String> node) {
        // get the height of the tree
        int maxLevel1 = Print.maxLevel(node);

        // print the tree
        printNodeInternal(Collections.singletonList(node), 1, maxLevel1);
    }

    private static <T> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {

        // list of nodes at the current level
        // empty or all null nodes
        if (nodes.isEmpty() || Print.isAllElementsNull(nodes))
            return;

        // calculate the floor value to print the spaces
        int floor = maxLevel - level;
        int edgelines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        // calculate the number of spaces before the first node
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;

        // calculate the number of spaces between the nodes
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        // print the spaces before the first node
        Print.printWhitespaces(firstSpaces);

        // print the actual nodes in the current level
        List<Node<T>> newNodes = new ArrayList<Node<T>>();
        // for each node in the current level
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.element);

                // add the left and right child of the current node
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                // add null nodes to the newNodes list
                newNodes.add(null);
                newNodes.add(null);
                // print " " to denote the null nodes
                System.out.print(" ");
            }

            // print the spaces between the nodes at the current level
            Print.printWhitespaces(betweenSpaces);
        }
        System.out.println("");
        
        for (int i = 1; i <= edgelines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                Print.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    Print.printWhitespaces(edgelines + edgelines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    Print.printWhitespaces(1);

                Print.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    Print.printWhitespaces(1);
                // indent the spaces
                Print.printWhitespaces(edgelines + edgelines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T> int maxLevel(Node<T> node) {
        if (node == null)
            return 0;

        return Math.max(Print.maxLevel(node.left), Print.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {

        // iterate over the list
        // check with each element is null
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
