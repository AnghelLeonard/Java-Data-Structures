package ds.binarysearchtree;

public class Main {

    public static void main(String[] args) {
        
        /*        
              40
            /    \
          30      45
         /  \    /  \
        15  33  42  56
       / \      /     \    
      5  17    41      67
        
        */

        BinaryTree<Integer> bt = new BinaryTree<>();
        
        bt.add(40);
        bt.add(30);
        bt.add(45);
        bt.add(15);
        bt.add(33);
        bt.add(42);
        bt.add(56);
        bt.add(5);
        bt.add(17);
        bt.add(41);
        bt.add(67);             
                  
        System.out.println("Root: " + bt.root());
        System.out.println("Height: " + bt.height());
        System.out.println("Min: " + bt.min());
        System.out.println("Max: " + bt.max());
        
        bt.print(BinaryTree.TraversalOrder.LEVEL);
        
        bt.delete(33);
        bt.print(BinaryTree.TraversalOrder.LEVEL);
        
        bt.delete(45);
        bt.print(BinaryTree.TraversalOrder.LEVEL);
        
        System.out.println("\n" + bt.asList(BinaryTree.TraversalOrder.IN));
        
    }
}