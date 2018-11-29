package ds.queuevialinkedlist;

import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        
        // An LinkedList implementation can be used as a Queue
        // But, prefer ArrayDeque, is better
        Deque<String> queue = new LinkedList<>();

        // insert to the back/tail (enqueue)
        queue.offer("Rafael Nadal"); 
        queue.offer("Roger Federer"); 
        queue.offer("David Ferer"); 
        
        // polling from the front/head (dequeue)
        System.out.println(queue.poll()); // Rafael Nadal
        System.out.println(queue.poll()); // Roger Federer
    }
}
