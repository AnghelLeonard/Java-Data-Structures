package ds.queueviasynchronousqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private static BlockingQueue<String> queue = new SynchronousQueue<>();

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(() -> {
            
            try {
                logger.log(Level.INFO, "Consume element: {0}", queue.take());
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        });

        // take a sleep
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        // only this will be enqueue, since there is a single consumer waiting
        queue.offer("Rafael Nadal");
        // the following two will not be enqueue
        queue.offer("Roger Federer");
        queue.offer("David Ferer"); 
        
        // this will return 0, since after removing the queue head is becomes empty
        logger.info(() -> "Queue size: " + queue.size());

        executor.shutdown();
    }

}
