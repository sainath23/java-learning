package com.sainath.test;

public class LongestPalindrome {
    private static int resultStart;
    private static int resultLength;

    public static void main(String[] args) {
        //String str = "babad";
        String str = "abcdcba";
        System.out.println(longestPalindrome(str));
    }

    public static String longestPalindrome(String str) {
        if (str.length() < 2) return str;

        for (int start = 0; start < str.length() - 1; start++) {
            expandRange(str, start, start); // odd string case
            expandRange(str, start, start + 1); // even string case
        }
        System.out.println("resultStart = " + resultStart + ", resultLength = " + resultLength);
        return str.substring(resultStart, resultStart + resultLength);
    }

    private static void expandRange(String str, int begin, int end) {
        System.out.println("begin = " + begin + ", end = " + end);
        while (begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }
        if (resultLength < end - begin - 1) {
            resultStart = begin + 1;
            resultLength = end - begin - 1;
        }
    }
}
