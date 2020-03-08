package com.sainath.ds;

import java.util.LinkedList;

/*
Given a string made of brackets: () [] {} determine whether the brackets properly match
[{}] -> valid
(()()) -> valid
{] -> Invalid
[()]))() -> Invalid
[]{}({}) -> Valid
 */
public class BracketSequenceStack {

    public static void main(String[] args) {
        //String str = "[[{}]()]";
        String str = "[{})[]";
        char[] chArr = str.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        boolean match = true;
        for (char ch : chArr) {
            // { ]
            if (match) {
                switch (ch) {
                    case '(':
                    case '{':
                    case '[':
                        stack.push(ch);
                        break;
                    case ')':
                        match = !stack.isEmpty() && '(' == stack.pop();
                        break;
                    case '}':
                        match = !stack.isEmpty() && '{' == stack.pop();
                        break;
                    case ']':
                        match = !stack.isEmpty() && '[' == stack.pop();
                        break;
                }
            } else {
                break;
            }
        }

        System.out.println("Brackets match = " + (match && stack.isEmpty()));
    }
}
