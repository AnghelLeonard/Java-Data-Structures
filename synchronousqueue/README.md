# Synchronous Queue (is more of a handoff)

**What kind of problems are commonly solved via synchronous-queues:**

- handoff problems
- useful in problems where you need a BlockingQueue, but you don't really want a queue
- any problem where insert only when someone will receive it at that moment itself
- pipeline of stages

**Java Synchronous Queue Implementations**

- java.util.concurrent.SynchronousQueue, thread-safe, [example]()
