package com.sainath.ds;

public class DynamicArray<T> {
    private T[] arr;
    private int length; // size for users array
    private int capacity; // actual length of array

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
    }

    public DynamicArray() {
        this.capacity = 10;
        this.arr = (T[]) new Object[capacity];
    }

    public void add(T data) {
        if (length + 1 >= capacity) {
            // create new array with double capacity and add element
            T[] newArr = (T[]) new Object[capacity * 2];
            for (int i = 0; i < length; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[++length] = data;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException("Given index: " + index + " does not exists");
        }
        T data = arr[index];
        T[] newArr = (T[]) new Object[--capacity];
        for (int i = 0, j = 0; i < length; i++, j++) {
            if (i == index) {
                j--;    // skipping removal index by decrementing j
            } else {
                newArr[j] = arr[i];
            }
        }
        arr = newArr;
        length--;
        return data;
    }

    public int getLength() {
        return length;
    }

    public T get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Given index: " + index + " does not exists");
        }
        return arr[index];
    }
}
