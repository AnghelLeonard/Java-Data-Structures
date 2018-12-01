package ds.disjointsetpathcompression;

public class Main {

    public static void main(String[] args) {

        DisjointSet set = new DisjointSet(12);

        set.union(8, 11);
        set.union(0, 7);
        set.union(0, 1);
        set.union(0, 8);        
        set.union(4, 2);
        set.union(4, 3);
        set.union(4, 9);
        set.union(4, 6);
        set.union(0, 4);        
        
        // no path compression
        System.out.println("Parent: 0");
        set.printFromRoot(0); // 0 <- 8 <- 11
        
        System.out.println("--------------------------------");
        
        // calling find now will cause path compression
        set.find(11);
                
        System.out.println("Parent: 0");
        set.printFromRoot(0); // 0 <- 11                
    }

}
