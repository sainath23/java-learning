package com.sainath.test;

public class ReverseNumber {

    public static void main(String[] args) {
        int input = 54321;
        int reversed = 0;
        while (input != 0) {
            reversed = (reversed * 10) + input % 10;
            input = input / 10;
        }
        System.out.println(reversed);
    }
}
