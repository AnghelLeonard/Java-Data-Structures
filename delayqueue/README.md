# Delay Queue

**What kind of problems are commonly solved via delay-queues:**

- for implementing Timers
- for orchestrating threads that wants to process multiple delayed events their proper order
- rate limiting problems (e.g., For a limit of N events per minute, place each event into a delay queue with a specific delay)
- control flow of a processes (e.g., process X take at least 50s to finish, so don't take the next process from the queue for at least this time)
- control a service (e.g., delay downloads for non-registered users for 30s, while for registered delay only 10s)
- messages batching and/or priorities
- simulate a complex process that takes time (e.g., simulating a cooking process)

