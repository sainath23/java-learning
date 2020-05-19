package com.sainath.leetcode;

import java.util.LinkedList;

//https://leetcode.com/problems/longest-valid-parentheses/
public class LongestValidParentheses {

    public static void main(String[] args) {
        //System.out.println(longestValidParentheses(")()())")); // 4
        //System.out.println(longestValidParentheses("(()")); // 2
        //System.out.println(longestValidParentheses("()(()")); // 2
        //System.out.println(longestValidParentheses("())(())())()()()()")); // 8
        System.out.println(longestValidParentheses("((()))")); // 6

    }

    public static int longestValidParentheses(String s) {
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        char[] charArr = s.toCharArray();

        for(int i = 0; i < charArr.length; i++) {
            if(charArr[i] == '(')  {
                stack.push(i);
            } else {
                stack.pop();

                if(stack.size() == 0) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
