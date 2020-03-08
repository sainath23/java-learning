package com.sainath.collections;

import java.util.LinkedList;
import java.util.Stack;

public class MyStack {
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        stack.add(100);
        stack.add(200);
        stack.add(300);
        stack.add(400);
        stack.add(500);
        System.out.println("Initial stack:\n" + stack);
        System.out.println("Popping element from stack:\n" + stack.pop());
        System.out.println("After pop: \n" + stack);
        stack.isEmpty();
    }
}
