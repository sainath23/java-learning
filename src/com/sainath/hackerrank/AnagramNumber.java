package com.sainath.hackerrank;

public class AnagramNumber {
    public static void main(String[] args) {
        String s = "0003187671";
        String first = s.substring(0, s.length() / 2);
        String second = s.substring(s.length() / 2);
        System.out.println(first + " - " + second);
        int count = 0;
        String newStr = "";
        for (int i = 0; i < second.length(); i++) {
            newStr = first.replace(second.charAt(i), 'X');
        }

        for (int i = 0; i < newStr.length(); i++) {
            if (newStr.charAt(i) != 'X') count++;
        }
        System.out.println(newStr);
        System.out.println(count);

    }
}
