package com.sainath.ds;

import java.util.EmptyStackException;

public class MyStackDemo {

    class MyStack<T> {
        private T[] arr;
        private int capacity;
        private int top;

        public MyStack(int size) {
            this.arr = (T[]) new Object[size];
            this.capacity = size;
            this.top = -1;
        }

        // Push top of the stack
        public void push(T t) {
            if (isFull()) {
                throw new StackOverflowError("Stack size exceeded...");
            }
            top++;
            arr[top] = t;
        }

        // Pop top of the stack
        public T pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            T t = peek();
            arr[top] = null;
            top--;
            return t;
        }

        public T peek() {
            return arr[top];
        }

        public boolean isFull() {
            return top == capacity - 1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public int size() {
            return top + 1;
        }
    }

    public static void main(String[] args) {
        MyStackDemo msd = new MyStackDemo();
        MyStack<Integer> stack = msd.new MyStack<>(5);
        System.out.println("Initially stack size = " + stack.size());

        stack.push(100);
        stack.push(200);
        stack.push(300);
        stack.push(400);
        stack.push(500);

        System.out.println("stack size after inserting 5 elements = " + stack.size());
        System.out.println("top of the stack = " + stack.peek());
        System.out.println("Pop = " + stack.pop());
        System.out.println("Pop = " + stack.pop());
        stack.push(600);
        System.out.println("top of the stack = " + stack.peek());
        System.out.println("stack size = " + stack.size());
    }
}
