package com.sainath.ds;

import java.util.LinkedList;
import java.util.Scanner;

public class BalancedParenthesisStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String str = sc.nextLine();
            withoutStack(str);
        }
    }

    public static void withoutStack(String s) {
        while (s.length() != (s = s.replaceAll("\\(\\)|\\[\\]|\\{\\}", "")).length());
        System.out.println(s.isEmpty());
    }

    public static void withStack(String str) {
        //System.out.println(str);
        LinkedList<Character> stack = new LinkedList<>();
        boolean isValid = true;

        for (int i = 0; i < str.length(); i++) {
            if ('(' == str.charAt(i) || '[' == str.charAt(i) || '{' == str.charAt(i)) {
                //System.out.println("Pushing -> " + str.charAt(i));
                stack.push(str.charAt(i));
            } else if (')' == str.charAt(i)) {
                if (stack.isEmpty()) {
                    isValid = false;
                    break;
                }
                char ch = stack.pop();
                //System.out.println("Popped -> " + ch);

                if (!stack.isEmpty() && ch != '(') {
                    isValid = false;
                    break;
                }
            } else if (']' == str.charAt(i)) {
                if (stack.isEmpty()) {
                    isValid = false;
                    break;
                }
                char ch = stack.pop();
                //System.out.println("Popped -> " + ch);

                if (!stack.isEmpty() && ch != '[') {
                    isValid = false;
                    break;
                }
            } else if ('}' == str.charAt(i)) {
                if (stack.isEmpty()) {
                    isValid = false;
                    break;
                }
                char ch = stack.pop();
                //System.out.println("Popped -> " + ch);

                if (!stack.isEmpty() && ch != '{') {
                    isValid = false;
                    break;
                }
            }
        }
        //System.out.println(stack);
        System.out.println(stack.isEmpty() && isValid);
    }
}
