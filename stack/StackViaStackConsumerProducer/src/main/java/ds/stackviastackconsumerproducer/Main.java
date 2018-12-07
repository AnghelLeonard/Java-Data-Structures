package ds.stackviastackconsumerproducer;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int PRODUCER_THREADS = 3;
    private static final int CONSUMER_THREADS = 2;
    private static final String PRODUCER_THREAD_NAME = "producer-stack-%d";
    private static final String CONSUMER_THREAD_NAME = "consumer-stack-%d";

    private static Stack<Integer> stack = new Stack<>();

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

        private final Stack<Integer> stack;

        public Producer(Stack<Integer> stack) {
            this.stack = stack;
        }

        @Override
        public void run() {
            while (true) {
                int randomInt = produce();

                stack.push(randomInt);

                try {
                    TimeUnit.SECONDS.sleep(randomInt / 100 / 2);
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

        private final Stack<Integer> stack;

        public Consumer(Stack<Integer> stack) {
            this.stack = stack;
        }

        @Override
        public void run() {
            while (true) {
                Integer randomInt = stack.pop();
                consume(randomInt);

                try {
                    TimeUnit.SECONDS.sleep(randomInt / 100);
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
        Producer p1 = new Producer(stack);
        Producer p2 = new Producer(stack);
        Producer p3 = new Producer(stack);
        Producer p4 = new Producer(stack);
                
        producerPool.execute(p1);
        producerPool.execute(p2);
        producerPool.execute(p3);
        producerPool.execute(p4);
               
        // give some time to push some numbers in the stack
        // this avoids EmptyStackException
        TimeUnit.SECONDS.sleep(5);        

        System.out.println("Starting consumers ...");
        Consumer c1 = new Consumer(stack);
        Consumer c2 = new Consumer(stack);
        
        consumerPool.execute(c1);
        consumerPool.execute(c2);
                
        consumerPool.shutdown();
        producerPool.shutdown();
        producerPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);                
        consumerPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }

}
