package com.sainath.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FactorialDemo {

    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(findFactorial(N));
    }

    public static int findFactorial(int n) {
        if(n <= 2) {
            return n;
        }
        return n * findFactorial(n - 1);
    }
}
