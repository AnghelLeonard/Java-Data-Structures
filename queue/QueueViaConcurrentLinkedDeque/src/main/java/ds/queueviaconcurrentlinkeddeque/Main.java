package ds.queueviaconcurrentlinkeddeque;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {
    
    public static void main(String[] args) {
        
        // An ConcurrentLinkedDeque implementation can be used as a Queue
        Deque<String> queue = new ConcurrentLinkedDeque<>();
        
        // insert to the back/tail (enqueue)
        queue.offer("Rafael Nadal"); 
        queue.offer("Roger Federer"); 
        queue.offer("David Ferer"); 
        
        // polling from the front/head (dequeue)
        System.out.println(queue.poll()); // Rafael Nadal
        System.out.println(queue.poll()); // Roger Federer
    }
    
}
