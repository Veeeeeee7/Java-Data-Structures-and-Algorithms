package Stacks.LinkedListImplementation;

import java.util.LinkedList;

public class LinkedStack {
    private LinkedList<Employee> stack;

    // Constructor
    public LinkedStack() {
        stack = new LinkedList<Employee>();
    }

    // Push method: adds an item to the top of the stack
    public void push(Employee employee) {
        stack.push(employee);
    }

    // Pop method: removes an item from the top of the stack
    public Employee pop() {
        return stack.pop();
    }

    // Peek method: returns the item at the top of the stack
    public Employee peek() {
        return stack.peek();
    }

    // printStack method: prints the stack
    public void printStack() {
        for (Employee employee : stack) {
            System.out.println(employee);
        }
    }
}
