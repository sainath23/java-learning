package com.sainath.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

//https://leetcode.com/problems/reverse-words-in-a-string/
/*
Input: "the sky is blue"
Output: "blue is sky the"

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

 */
public class ReverseWordsInString {

    public static String reverseWords(String s) {
        if (s == null) return null;

        s = s.trim();
        StringBuilder reverse = new StringBuilder();

        String[] words = s.split("\\s");

        //System.out.println(Arrays.toString(words));

        for (int i = words.length-1; i >= 0; i--) {
            if (!"".equals(words[i])) {
                //System.out.println(words[i]);
                if (i != 0)
                    reverse.append(words[i]).append(" ");
                else
                    reverse.append(words[i]);
            }
        }

        return reverse.toString();
    }

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }
}
