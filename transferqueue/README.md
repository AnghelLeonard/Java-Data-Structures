# Transfer Queue

**What kind of problems are commonly solved via transfer queues:**

- useful for any problem in this common scenario: any producer should wait until any consumer receives the element (we say that the element is transfered from producer to consumer)

**Java Transfer Queue Implementations**

- java.util.concurrent.TransferQueue, thread-safe, [example](https://github.com/AnghelLeonard/Java-Data-Structures/tree/master/transferqueue/QueueViaTransferQueue)
