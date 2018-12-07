package ds.stackviastack;

import java.util.Stack;

public class Main {
    
    public static void main(String[] args) {
        
        // A Stack is synchronized since it extends Vector       
        Stack<String> stack = new Stack<>();
        
        stack.push("Rafael Nadal");
        stack.push("Roger Federer");
        stack.push("David Ferer"); // last in, so first out
                
        // David Ferer
        System.out.println("Pop from stack: " + stack.pop());
    }    
    
}
