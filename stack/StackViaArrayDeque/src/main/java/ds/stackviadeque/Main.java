package ds.stackviadeque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    
    public static void main(String[] args) {
        
        // An ArrayDeque implementation can be used as a Stack (Last-In-First-Out, LIFO) 
        // ArrayDeque is not thread-safe
        Deque<String> stack = new ArrayDeque<>();
        
        stack.push("Rafael Nadal");
        stack.push("Roger Federer");
        stack.push("David Ferer");
        
        // Retrieves, but does not remove, the first element of this deque
        System.out.println("First in stack: " + stack.getFirst());       
        
        // Pops an element from the stack represented by this deque. 
        // In other words, removes and returns the first element of this deque.
        System.out.println("Pop from stack: " + stack.pop()); 
    }    
}
