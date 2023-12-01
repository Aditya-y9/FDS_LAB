package LAB6;
import java.io.*;
// Date format to print the date in the required format
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Iterator;
import java.lang.Iterable;

public class DirecTree{

    static class Node {
        // node attributes
        // no generics used as name is a string and size is a long for each directory
        public String name;
        private int type;
        public long size;
        private Date date;
        private int Filecounter;
        private int Dircounter;

        // like list of subdirectories(children)
        private List<Node> subdirect;

        Node(String name, int type, long size, long time) {
            // directory details in node.
            this.name = name;
            this.type = type;
            this.size = size;


            // new date object to store the last modified date
            // from java.util.Date
            date = new Date(time);

            // initialize the list of subdirectories(children)
            subdirect = new ArrayList<>();
        }

        public List<Node> getSubdir() {
            // return the list of subdirectories(children)
            return subdirect;
        }

        public void addSubDirect(File f) {
            // type to understand if the file is a directory or not
            // to get the leaf node(end file) type is 0
            int t = 0;
            
            // add only if the directory is not a leaf node
            if (f.isDirectory()){
                Dircounter++;
                t = 1;
            }
            else{
                Filecounter++;
            }

            // make a new node
            Node n = new Node(f.getName(), t, f.length(), f.lastModified());

            // append the node to the list of children
            this.subdirect.add(n);
        }

        public int getFilecounter(){
            // return the number of files in the directory
            return Filecounter; 
        }

        public int getDircounter(){
            // return the number of directories in the directory
            return Dircounter;
        }

        public void print() {
            // date format to print the date in the required format
            // class Dateformat formats the date in the given pattern
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");

            // if the type is 1, it is a directory
            // initialize to empty string
            String typeLabel = "";
            if (this.type == 1){
                // a directory!
                Dircounter++;
                typeLabel = "<DIR>";
            }
            else{
                // got a file!
                Filecounter++;
                typeLabel = "<FILE>";
            }

            // print the details of the node
            System.out.println(dateFormat.format(this.date) + "\t" + typeLabel + "\t" + String.format("%,d", this.size) + "\t" + this.name);
        }

    }

    private Node rootDirect;
    public int dirSize = 0;

    public Node addRoot(File r) {
        dirSize += r.length();
        // if the file is a directory, type is 1
        int t = 0;

        // File object's isDirectory() method returns true if the file is a directory
        if (r.isDirectory()){
            // to accept subdirectories as well to this node.
            t = 1;
        }

        // make a new node to store the root directory
        this.rootDirect = new Node(r.getName(), t, r.length(), r.lastModified());

        // if the file is a directory, add its children
        if (t == 1) {
            // array of files in the directory

            File[] contents = r.listFiles();

            // add each file to the root directories SUBDIRECTORIES(children)
            // addSubDirect() method adds the file to the list of children
            // Object.requireNonNull() method checks if the object is null or not
            for (int i = 0; i < Objects.requireNonNull(contents).length; ++i) {
                dirSize += contents[i].length();
                // add the file to the root directory
                this.rootDirect.addSubDirect(contents[i]);
            }
        }
        return this.rootDirect;
    }

    void printDirectory(Node r) {
        // print the details of the given Directory first
        r.print();

        // then move to its Subdirectories and print their details
        for (Node c : r.getSubdir())
            // print on each subdirectory
            c.print();
    }
}
