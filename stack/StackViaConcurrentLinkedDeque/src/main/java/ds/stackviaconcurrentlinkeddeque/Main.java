package ds.stackviaconcurrentlinkeddeque;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    // A ConcurrentLinkedDeque implementation can be used as a Stack (Last-In-First-Out) 
    // Switch to ArrayDeque to see how pop is trying to pop
    // the same item in different threads because ArrayDeque is not thread-safe
    private static Deque<Integer> stack = new ConcurrentLinkedDeque<>();

    public static void main(String[] args) {

        logger.info("Push ...");

        // push values for 0 to 10 using a single thread
        for (int i = 0; i < 10; i++) {
            logger.log(Level.INFO,
                    "Push item{0},[{1}]",
                    new Object[]{i, Thread.currentThread().getName()});

            stack.push(i);
        }

        logger.info("Pop ... ");

        // pop values using 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    // log or throw
                }

                logger.log(Level.INFO,
                        "Pop item {0}, [{1}]",
                        new Object[]{stack.pop(), Thread.currentThread().getName()});
            });
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
        }

        logger.info("Finished all threads");

    }
}
