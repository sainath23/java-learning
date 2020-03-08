package com.sainath.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String s = br.readLine();
        //System.out.println(Long.parseLong(s));
        int[] a = { 9, 5, 4, 9 };
        int[] b =    { 2, 1, 4 };

        int[] result = new int[a.length];
        int i = a.length - 1, j = b.length-1, k = a.length-1;
        int sum = 0, carry = 0;

        while (j >= 0) {
            System.out.println(String.format("Sum = %s carry = %s", sum, carry));
            sum = a[i] + b[j] + carry;
            result[k] = sum % 10;
            System.out.println(String.format("sum = %s result[k] = %s", sum, result[k]));
            carry = sum / 10;
            i--;
            j--;
            k--;
        }
        while (i >= 0) {
            sum = a[i] + carry;
            result[k] = sum % 10;
            carry = sum / 10;
            i--;
            k--;
        }
        int ans = 0;
        if (carry == 1)
            ans = 10;

        for (i = 0; i < a.length; i++) {
            ans += result[i];
            ans *= 10;
        }

        System.out.println(ans / 10);
    }
}
