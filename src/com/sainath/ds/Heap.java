package com.sainath.ds;

import java.util.Arrays;

// Max heap = Parent node is greater than its children
// Min heap = Parent node is less than ita children

// This is a max heap implementation
public class Heap {

    private int[] values;
    private int size;

    public Heap(int maxHeight) {
        values = new int[(int) Math.pow(2, maxHeight) - 1]; // Height of heap is 2^n - 1
    }

    private void swap(int index1, int index2) {
        int temp = values[index1];
        values[index1] = values[index2];
        values[index2] = temp;
    }

    public void add(int value) {
        if (size == values.length) {
            throw new RuntimeException("Heap overflow");
        }

        values[size] = value;
        bubbleUp(size);
        size++;
    }

    public int extract() {
        if (size == 0) {
            throw new RuntimeException("Heap underflow");
        }

        int extractMax = values[0];
        values[0] = values[size - 1];
        values[size - 1] = 0;
        bubbleDown(0);
        size--;
        return extractMax;
    }

    // Following method ensures that parent is at right location.
    // 1. Check if index == 0 to stop the recursion.
    // 2. Find parent index and check if parent is less than child.
    // 3. Recursively swap both if parent is greater than child till parent index reach to 0.
    private void bubbleUp(int index) {
        if (index == 0) {
            return;
        }
        int parentIndex = (index - 1) / 2; // In heap parent index is (index - 1) / 2
        if (values[parentIndex] < values[index]) {
            swap(index, parentIndex);
            bubbleUp(parentIndex);
        }
    }

    // Following method ensures that parent is at right location after removal of first element.
    // 1. Find right and left children.
    // 2. Find which child is greater.
    // 3. If the element is less than greater child then swap both and continue recursion till find its correct position.
    private void bubbleDown(int index) {
        int greaterChild;
        int leftChildIndex = (index * 2) + 1;
        int rightChildIndex = (index * 2) + 2;

        if (rightChildIndex < size && values[rightChildIndex] > values[leftChildIndex]) {
            greaterChild = rightChildIndex;
        } else if (leftChildIndex < size) {
            greaterChild = leftChildIndex;
        } else {
            return;
        }

        if (values[index] < values[greaterChild]) {
            swap(index, greaterChild);
            bubbleDown(greaterChild);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(3);
        heap.add(100);
        heap.add(200);
        heap.add(50);
        heap.add(150);
        heap.add(350);
        heap.add(210);
        heap.add(175);
        //heap.add(500); // Heap overflow
        System.out.println(Arrays.toString(heap.values));
        System.out.println(heap.extract());
        System.out.println(Arrays.toString(heap.values));
    }
}
