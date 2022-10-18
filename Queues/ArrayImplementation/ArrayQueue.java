package Queues.ArrayImplementation;

public class ArrayQueue {
    private Employee[] queue;
    private int front;
    private int back;

    // Constructor
    public ArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    // Adds an item to the back of the queue
    public void add(Employee employee) {
        if (back == queue.length) {
            // Need to resize the backing array
            Employee[] newArray = new Employee[2 * queue.length];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }

        queue[back] = employee;
        back++;
    }

    // Removes an item from the front of the queue
    public Employee remove() {
        if (size() == 0) {
            return null;
        }

        Employee employee = queue[front];
        queue[front] = null;
        front++;

        if (size() == 0) {
            front = 0;
            back = 0;
        }

        return employee;
    }

    // Returns the item at the front of the queue
    public Employee peek() {
        if (size() == 0) {
            return null;
        }

        return queue[front];
    }

    // Returns the size of the queue
    public int size() {
        return back - front;
    }

    // Prints the queue
    public void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }
}
