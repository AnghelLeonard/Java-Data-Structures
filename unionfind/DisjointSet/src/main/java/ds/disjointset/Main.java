package ds.disjointset;

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

        System.out.println("Parent: 0");
        set.printFromRoot(0);
        
        // is 4 and 0 friends => true
        System.out.println("Is 4 and 0 friends: " + (set.find(0) == set.find(4)));
        
        // is 4 and 5 friends => false
        System.out.println("Is 4 and 5 friends: " + (set.find(4) == set.find(5)));

    }

}
