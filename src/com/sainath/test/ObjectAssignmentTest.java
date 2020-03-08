package com.sainath.test;

import java.util.Arrays;

public class ObjectAssignmentTest {

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40};
        int[] b = {50, 60};

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        a = b;
        b = a;

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
