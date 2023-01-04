package Heaps.ArrayImplementation;

public class MaxHeap {
    private int[] heap;
    private int size;

    // Constructor
    public MaxHeap(int capacity) {
        heap = new int[capacity];
    }

    // peek the root node
    public int peek() {
        // if the heap is empty, throw an exception
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        // return the root node
        return heap[0];
    }

    // insert a value into the heap
    public void insert(int value) {
        // if the heap is full, throw an exception
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }

        // insert the value at the next empty index
        heap[size] = value;

        // fix the heap above the inserted value
        fixHeapAbove(size);

        // increment the size
        size++;
    }

    // delete a value from the heap
    public int delete(int index) {
        // if the heap is empty, throw an exception
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        // save the value to be deleted and its parent
        int parent = getParent(index);
        int deletedValue = heap[index];

        // swap the deleted value with the last value in the heap (the rightmost leaf)
        // to maintain a complete binary tree
        heap[index] = heap[size - 1];

        // if the node to be deleted is the root node (ie cant be moved up anymore) or
        // less than its parent, fix the heap by traversing down
        if (index == 0 || heap[index] < heap[parent]) {
            fixHeapBelow(index, size - 1);
        }
        // if the node to be deleted is greater than its parent, fix the heap by
        // traversing up
        else {
            fixHeapAbove(index);
        }

        // decrement the size
        size--;

        // return the deleted value
        return deletedValue;
    }

    // fix the heap above the index
    private void fixHeapAbove(int index) {
        int value = heap[index];

        // while the node isnt the root and the value is greater than the parent, swap
        // the value with the parent and update the index of the value
        while (index > 0 && value > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        heap[index] = value;
    }

    // fix the heap below the index
    private void fixHeapBelow(int index, int lastHeapIndex) {
        int childToSwap;

        // traversing down the heap until it reaches the last element in the heap
        while (index <= lastHeapIndex) {
            int leftChild = getLeftChild(index);
            int rightChild = getRightChild(index);

            // if there is a left child...
            if (leftChild <= lastHeapIndex) {
                // if there is no right child, we need to swap with the left child
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                }
                // if there is a right child, we need to swap with the child with the greater
                // value
                else {
                    childToSwap = (heap[leftChild] > heap[rightChild]) ? leftChild : rightChild;
                }

                // if the value is less than the child, swap the value with the child
                if (heap[index] < heap[childToSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                }
                // if the value is greater than the child, we dont need to swap
                else {
                    break;
                }

                // update the index of the swapped value
                index = childToSwap;
            }
            // if there is no left child, we dont need to swap
            else {
                break;
            }
        }
    }

    // check if the heap is full
    public boolean isFull() {
        return size == heap.length;
    }

    // check if the heap is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // gets the index of the parent node
    public int getParent(int index) {
        return (index - 1) / 2;
    }

    // gets the index of the left child node
    public int getLeftChild(int index) {
        return index * 2 + 1;
    }

    // gets the index of the right child node
    public int getRightChild(int index) {
        return index * 2 + 2;
    }

    // print the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
