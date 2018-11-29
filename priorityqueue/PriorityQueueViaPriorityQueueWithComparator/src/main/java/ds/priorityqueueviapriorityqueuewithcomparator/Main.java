package ds.priorityqueueviapriorityqueuewithcomparator;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        Queue<String> queue = new PriorityQueue<>((t1, t2) -> t1.length() - t2.length());

        // enqueue
        queue.offer("Maria");
        queue.offer("Ion");
        queue.offer("Alberto");
        queue.offer("Kahn");
        queue.offer("Tyler");

        // dequeue
        // Ion
        System.out.println("Poll: " + queue.poll());

        // Kahn, Maria, Tyler, Alberto
        while (!queue.isEmpty()) {
            System.out.println("Remove: " + queue.remove());
        }
    }

}
