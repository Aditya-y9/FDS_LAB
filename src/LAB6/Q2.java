package LAB6;
import java.io.*;
import java.text.DateFormat;
import java.util.Iterator;
import java.lang.Iterable;
public class Q2 {
    public static void main(String[] args){
        // a file object to store the path of the directory

        // we req a file object to get the directory or file classification
        File f = new File(".\\LAB6");

        // create a directory tree object
        DirecTree dir = new DirecTree();

        // add file object to our directory tree
        DirecTree.Node r = dir.addRoot(f);
        System.out.println("Directory of " + f.getName());

      ;
      System.out.println("Files: ");
      Iterable<DirecTree.Node> children = r.getSubdir();
      Iterator<DirecTree.Node> childrenIterator = children.iterator();
      while (childrenIterator.hasNext()) {
          DirecTree.Node child = childrenIterator.next();
          System.out.println(child.name);
      }
        
        // showcase an interface.
        System.out.println("Date\t"+ "    " + "Time\tType\tSize\tName");
        dir.printDirectory(r);
        System.out.println("          " + r.getDircounter() +  " Dir(s)          " + String.format("%,d", dir.dirSize)+ " bytes");  
        System.out.println("          " + r.getFilecounter() +  " File(s)        " + (f.getFreeSpace() - dir.dirSize) + " bytes free");

      }
}
