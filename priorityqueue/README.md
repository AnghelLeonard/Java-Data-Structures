
# Priority Queue (PQ)

**What kind of problems are commonly solved via priority queues:**

- If you need to handle something with a higher priority first, regardless of what order the items arrive, you use a PQ
- Minimum Spanning Tree (MST) algorithms
- Lossless data compression algorithms
- Sweep Line algorithm
- Get "next best/worst" element
- Event-Driven simulations
- Dijkstra's shortest path algorithm

# Java Priority Queue Implementations

- java.util.PriorityQueue, not thread-safe, based on natural order (example) or explicit Comparator (example)
- java.util.concurrent.PriorityBlockingQueue, thread-safe, based  on natural or explicit Comparator
