package com.sainath.test;

public class SwitchCaseTest {

    public static void main(String[] args) {
        char[] chArr = {'A', 'B', 'C'};

        for (char ch : chArr) {
            switch (ch) {
                case 'A':
                    System.out.println(ch);
                    break;
                case 'B':
                    System.out.println(ch);
                    break;
            }
        }
    }
}
