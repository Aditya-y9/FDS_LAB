package LAB6;

public class Q1 {
    public static void main(String[] args){
        GeneralTree<String> tree = new GeneralTree<String>();
        Position<String> root = tree.addRoot("Electronics R' Us");
        Position<String> Sales = tree.addChild(root, "Sales");
        Position<String> RnD = tree.addChild(root, "R&D");
        Position<String> Purchasing = tree.addChild(root, "Purchasing");
        Position<String> Manufacturing = tree.addChild(root, "Manufacturing");
    }
}
