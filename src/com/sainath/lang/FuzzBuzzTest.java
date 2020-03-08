package com.sainath.lang;

import java.util.Scanner;

public class FuzzBuzzTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n % 3 == 0 & n % 5 == 0) {
            System.out.println("FuzzzBuzz");
        } else if (n % 3 == 0) {
            System.out.println("Fuzzz");
        } else if (n % 5 == 0) {
            System.out.println("Buzz");
        }

        System.out.println("\n\nfalse false = " + (false & false));
        System.out.println("false true = " + (false & true));
        System.out.println("true false = " + (true & false));
        System.out.println("true true = " + (true & true));
    }
}
