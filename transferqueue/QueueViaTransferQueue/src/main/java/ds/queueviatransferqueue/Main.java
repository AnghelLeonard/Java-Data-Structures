package ds.queueviatransferqueue;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private static TransferQueue<String> queue = new LinkedTransferQueue<>();

    public static void main(String[] args) {

        // prepare 5 producers as threads
        // these will use transfer() in order to block until the elements are consumed
        // at this moment there are no consumers, so 5 threads will produce 5 of 10 elements
        // and block until they are free by consumers; once the elements starts to be consumed
        // they will continue to produce the remaining 5 elements
        ExecutorService executorProducer = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorProducer.execute(() -> {

                try {
                    String element = UUID.randomUUID().toString();
                    logger.log(Level.INFO, "Thread: {0}, Produce element: {1}",
                            new Object[]{Thread.currentThread().getName(), element});

                    queue.transfer(element);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();                    
                }
            });
        }
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();           
        };        

        // prepare 3 consumers as threads        
        ExecutorService executorConsumer = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            executorConsumer.execute(() -> {

                try {
                    logger.log(Level.INFO, "Thread: {0}, Consume element: {1}",
                            new Object[]{Thread.currentThread().getName(), queue.take()});
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();                   
                }
            });
        }

        executorProducer.shutdown();
        executorConsumer.shutdown();

    }

}
