package com.sainath.leetcode;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://leetcode.com/problems/remove-k-digits/
public class RemoveKDigits {
    public static void main(String[] args) {
        //System.out.println(removeKdigits("1432219", 3)); // 1219
        //System.out.println(removeKdigits("10200", 1)); // 200
        //System.out.println(removeKdigits("10", 2)); // 0
        //System.out.println(removeKdigits("5648", 1)); // 0
        //System.out.println(removeKdigits("112", 1)); // 11
        System.out.println(removeKdigits("1234567890", 9)); // 0

        IntStream.of(1,2,3,4).boxed().collect(Collectors.toList());
    }

    public static String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) return "";
        if (num.length() == k) return "0";

        LinkedList<Integer> stack = new LinkedList<>();
        char[] numChars = num.toCharArray();
        StringBuilder number = new StringBuilder();

        for (char numChar : numChars) {

            while (k > 0 && !stack.isEmpty() && stack.peek() != null && stack.peek() > Character.getNumericValue(numChar)) {
                //System.out.println("Popping = " + stack.peek());
                stack.pop();
                k--;
            }
            stack.push(Character.getNumericValue(numChar));

        }
        //System.out.println(stack);
        for(int i = 0; i < k; i++){
            stack.pop();
        }

        while (!stack.isEmpty()) {
            number.append(stack.pop());
        }
        //System.out.println(number);
        number.reverse();

        while (number.length() > 1 && number.charAt(0) == '0') {
            number.deleteCharAt(0);
        }
        return number.toString();
    }
}
