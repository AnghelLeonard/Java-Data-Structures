package ds.stackviadeque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    
    public static void main(String[] args) {
        
        // An ArrayDeque implementation can be used as a Stack (Last-In-First-Out) 
        Deque<String> stack = new ArrayDeque<>();
        
        stack.push("Rafael Nadal");
        stack.push("Roger Federer");
        stack.push("David Ferer");
        
        System.out.println("First in stack: " + stack.getFirst()); // David Ferer
        System.out.println("Pop from stack: " + stack.pop()); // David Ferer
    }    
}
