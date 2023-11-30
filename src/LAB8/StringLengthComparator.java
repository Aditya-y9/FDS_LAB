package LAB8;
// C----> Comparability k1<=k2 or k2<=k1
// A----> Antisymmetric if k1<=k2 and k2<=k1 then k1=k2
// T----> Transitive if k1<=k2 and k2<=k3 then k1<=k3

// signature k1.compareTo(k2)
// i<0 if k1<k2
// i=0 if k1==k2
// i>0 if k1>k2

import java.util.Comparator;


public class StringLengthComparator implements Comparator<String>{
    // method signature from Comparator
    public int compare(String a,String b){

        // priority based on stringn length
        if (a.length() < b.length()){
            return -1;
        }
        else if(a.length()==b.length()){
            return 0;
        }
        else{
            return 1;
        }
    }
}
