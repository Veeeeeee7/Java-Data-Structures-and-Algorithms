package Stacks.ArrayImplementation;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack {

    private Employee[] stack;
    private int top;

    // Constructor
    public ArrayStack(int capacity) {
        stack = new Employee[capacity];
    }

    // Push method: adds an item to the top of the stack
    public void push(Employee employee) {
        if (top == stack.length) {
            // need to resize the backing array (time complexity will be O(n))
            Employee[] newArray = new Employee[2 * stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }

        stack[top++] = employee;
    }

    // Pop method: removes an item from the top of the stack
    public Employee pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        Employee employee = stack[--top];
        stack[top] = null;
        return employee;
    }

    // Peek method: returns the item at the top of the stack
    public Employee peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    // isEmpty method: checks if the stack is empty
    public boolean isEmpty() {
        return top == 0;
    }

    // Size method: returns the size of the stack
    public int size() {
        return top;
    }

    // printStack method: prints the stack
    public void printStack() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
