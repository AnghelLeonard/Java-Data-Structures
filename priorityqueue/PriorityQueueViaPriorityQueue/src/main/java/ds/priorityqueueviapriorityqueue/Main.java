package ds.priorityqueueviapriorityqueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    
    public static void main(String[] args) {
        
        Queue<Integer> queue = new PriorityQueue<>();
        
        // enqueue
        queue.offer(150);
        queue.offer(100);
        queue.offer(850);
        queue.offer(20);
        queue.offer(200);

        // dequeue
        // 20
        System.out.println("Poll: " + queue.poll());
                
        // 100, 150, 200, 850
        while (!queue.isEmpty()) {
            System.out.println("Remove: " + queue.remove());
        }
    }
    
}

