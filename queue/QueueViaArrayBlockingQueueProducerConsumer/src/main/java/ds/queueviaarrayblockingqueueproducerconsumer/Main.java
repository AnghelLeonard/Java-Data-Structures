package ds.queueviaarrayblockingqueueproducerconsumer;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int QUEUE_MAX_SIZE = 20;
    private static final int PRODUCER_THREADS = 3;
    private static final int CONSUMER_THREADS = 2;
    private static final String PRODUCER_THREAD_NAME = "producer-stack-%d";
    private static final String CONSUMER_THREAD_NAME = "consumer-stack-%d";

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(QUEUE_MAX_SIZE);

    private static ExecutorService producerPool
            = Executors.newFixedThreadPool(
                    PRODUCER_THREADS,
                    new ThreadFactoryBuilder().setNameFormat(PRODUCER_THREAD_NAME).build()
            );

    private static ExecutorService consumerPool
            = Executors.newFixedThreadPool(
                    CONSUMER_THREADS,
                    new ThreadFactoryBuilder().setNameFormat(CONSUMER_THREAD_NAME).build()
            );

    private static class Producer implements Runnable {

        private final BlockingQueue<Integer> queue;

        public Producer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                int randomInt = produce();

                try {
                    queue.put(randomInt);

                    TimeUnit.MILLISECONDS.sleep(randomInt);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        public Integer produce() {
            String threadName = Thread.currentThread().getName();
            int randomInt = ThreadLocalRandom.current().nextInt(1, 1001);

            System.out.printf("[%s] produced: %s\n", threadName, randomInt);

            return randomInt;
        }

    }

    private static class Consumer implements Runnable {

        private final BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Integer randomInt = queue.take();
                    consume(randomInt);

                    TimeUnit.MILLISECONDS.sleep(randomInt / 10);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        public void consume(Integer value) {

            String threadName = Thread.currentThread().getName();
            System.out.printf("[%s] produced: %s\n", threadName, value);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting producers ...");
        Producer p1 = new Producer(queue);
        Producer p2 = new Producer(queue);
        Producer p3 = new Producer(queue);
        Producer p4 = new Producer(queue);

        producerPool.execute(p1);
        producerPool.execute(p2);
        producerPool.execute(p3);
        producerPool.execute(p4);

        System.out.println("Starting consumers ...");
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);
        Consumer c4 = new Consumer(queue);

        consumerPool.execute(c1);
        consumerPool.execute(c2);
        consumerPool.execute(c3);
        consumerPool.execute(c4);

        consumerPool.shutdown();
        producerPool.shutdown();
        producerPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        consumerPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }

}
