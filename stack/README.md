# Stack

**What kind of problems are commonly solved via stacks (LIFO, Last-In-First-Out):**

- Almost any kind of problems that are naturally represented as piles (e.g., books, plates, letters, containers, etc)
- Implement undo/redo feature that is so common in desktop applications
- Support recursion algorithms by storing the function calls
- Postfix, infix and prefix conversions
- The stock span problem
- Solving problems that requires matching pairs (e.g., open-close brackets (balanced parentheses in an expression), open-close quotes, open-close tags)
- Depth First Search (DFS) on a graph
- Given an array, print the Next Greater Element (NGE) for every element
- Print next greater number of Q queries
- Next Greater Frequency Element
- Number of NGEs to the right
- Maximum product of indexes of next greater on left and right
- The Celebrity Problem
- Expression Evaluation
- Arithmetic Expression Evalution
- Iterative Tower of Hanoi

# Java Stack Implementations

- java.util.Stack, but prefer java.util.Deque since Stack relies on the synchronized Vector (Stack methods are synchronized)
- java.util.ArrayDeque (**not thread-safe** stack alike) [example](https://github.com/AnghelLeonard/Data-Structures/tree/master/stack/StackViaArrayDeque)
- java.util.concurrent.ConcurrentLinkedDeque (**thread-safe** stack alike) [example](https://github.com/AnghelLeonard/Data-Structures/tree/master/stack/StackViaConcurrentLinkedDeque)
