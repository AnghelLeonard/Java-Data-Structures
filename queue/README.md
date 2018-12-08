# Queue

**What kind of problems are commonly solved via queues:**

- typicall problems that work based on the "first come first serve" statement
- lineup problems, like a human string aligned to buy tickets to a concert
- Breadth First Search (BFS) graph traversal
- Tracking most recent added elements

# Java Queue Implementations

*java.util.Queue ("single end"): add things to one end and take them from the other (FIFO)*\
*java.util.Deque ("double ended queue"): add things to either end, and take them from either end*\
*java.util.Deque is a subiterface of java.utilQueue*

- java.util.ArrayDeque, **not thread-safe**, [example](https://github.com/AnghelLeonard/Data-Structures/tree/master/queue/QueueViaArrayDeque)
- java.util.concurrent.ArrayBlockingQueue, **thread-safe**, [example](https://github.com/AnghelLeonard/Java-Data-Structures/tree/master/queue/QueueViaArrayBlockingQueueProducerConsumer)
- java.util.concurrent.ConcurrentLinkedDeque and java.util.concurrent.ConcurrentLinkedQueue, **thread-safe**, [example](https://github.com/AnghelLeonard/Data-Structures/tree/master/queue/QueueViaConcurrentLinkedDeque)
- java.util.LinkedList, **not thread-safe and not efficient**, [example](https://github.com/AnghelLeonard/Data-Structures/tree/master/queue/QueueViaLinkedList)

