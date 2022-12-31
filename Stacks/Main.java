package Stacks;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        /*
         * Stacks
         */

        Stack<Node> stack = new Stack<>();

        // Add elements to the end of the stack using push()
        stack.push(new Node(2));
        stack.push(new Node(8));
        stack.push(new Node(5));

        // Remove elements from the end of the stack using pop()
        stack.pop(); // removes 5

        // Peek at the last element in the stack
        System.out.println(stack.peek().data);
    }
}
