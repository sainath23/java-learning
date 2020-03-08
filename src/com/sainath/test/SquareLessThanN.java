package com.sainath.test;

import java.util.Scanner;

public class SquareLessThanN {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = 1;

        for(int i = 2; i < n; i++) {
            int result = (i * i) % n;

            if (result > m && result < n) {
                m = result;
            }
        }

        System.out.println("result = " + m);
    }
}
