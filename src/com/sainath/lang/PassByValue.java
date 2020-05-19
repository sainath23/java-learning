package com.sainath.lang;

public class PassByValue {

    public static void main(String[] args) {
        int[] a = {3, 4, 5};
        int[] b = modify(a);

        System.out.print(a[0] + a[1] + a[2] + " " + a[2] + a[1]);
        System.out.print(b[0] + b[1] + b[2]);
    }

    public static int[] modify(int[] c) {
        c[1] = 10;
        return c;
    }
}
