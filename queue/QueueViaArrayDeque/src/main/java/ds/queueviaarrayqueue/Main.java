package ds.queueviaarrayqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    
    public static void main(String[] args) {
        
        // An ArrayDeque implementation can be used as a Queue
        Deque<String> queue = new ArrayDeque<>();
        
        // insert to the back/tail (enqueue)
        queue.offer("Rafael Nadal"); 
        queue.offer("Roger Federer"); 
        queue.offer("David Ferer"); 
        
        // polling from the front/head (dequeue)
        System.out.println(queue.poll()); // Rafael Nadal
        System.out.println(queue.poll()); // Roger Federer
    }
    
}
