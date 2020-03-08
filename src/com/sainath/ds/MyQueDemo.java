package com.sainath.ds;

public class MyQueDemo {

    class MyQueue<T> {
        private T[] arr;
        private int capacity;
        private int start;
        private int end;

        public MyQueue(int size) {
            arr = (T[]) new Object[size];
            capacity = size;
            start = -1;
            end = -1;
        }

        public void enqueue(T t) {
            if (isFull()) throw new RuntimeException("Queue is full");

            end++;
            arr[end] = t;
        }

        public T dequeue() {
            if (isEmpty()) throw new RuntimeException("Queue is empty");

            T t = peek();
            arr[start] = null;
            start++;
            return t;
        }

        public T peek() {
            return arr[start];
        }

        public boolean isFull() {
            return start == end;
        }

        public boolean isEmpty() {
            return start == -1 && end == -1;
        }
    }

    public static void main(String[] args) {

    }

    public String m1() {
        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
        }

        return null;
    }
}
