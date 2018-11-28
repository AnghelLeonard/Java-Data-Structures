package ds.stackviaconcurrentlinkeddeque;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {
    
    public static void main(String[] args) {
        
        // A ConcurrentLinkedDeque implementation can be used as a Stack (Last-In-First-Out) 
        Deque<String> stack = new ConcurrentLinkedDeque<>();
        
        stack.push("Rafael Nadal");
        stack.push("Roger Federer");
        stack.push("David Ferer");
        
        System.out.println("First in stack: " + stack.getFirst());
        System.out.println("Pop from stack: " + stack.pop());
    }    
}

