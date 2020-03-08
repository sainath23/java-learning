package com.sainath.collections;

import java.util.LinkedList;

public class LLStack {
    private static LinkedList<Integer> stack = new LinkedList<>();

    public static void main(String[] args) {
        stack.push(100);
        stack.push(200);
        stack.push(300);
        stack.push(400);
        stack.push(500);

        System.out.println("Initial stack:\n" + stack);
        System.out.println("Popping element from stack:\n" + stack.pop());
        System.out.println("After pop: \n" + stack);
    }
}
