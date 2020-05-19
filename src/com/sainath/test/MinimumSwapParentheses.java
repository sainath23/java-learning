package com.sainath.test;

import java.util.LinkedList;

public class MinimumSwapParentheses {

    public static void main(String[] args) {
        String str = "()))))(()))(()((((()";
        findMinSwap(str);
    }

    public static int findMinSwap(String str) {
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        int countLeft = 0;
        int positionLeft = 0;
        int minSwap = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                countLeft++;
                positionLeft++;
            } else if(str.charAt(i) == ')') {
                countLeft--;
            }

            if (countLeft < 0) {
                //minSwap += stack
            }
        }

        return 0;
    }
}
