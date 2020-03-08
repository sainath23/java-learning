package com.sainath.oops;

import java.util.ArrayList;

public class OverloadingTest {
    static int a;
    static char b;
    int x;
    public static void test(String str) {
        System.out.println(str);
    }
    public static void test(Object obj) {
        System.out.println(obj);
    }
    public static void main(String[] args) {
        test(null);
        ArrayList<String> al = new ArrayList<>(10);
        al.add("Sai");
        System.out.println(a + " " + b + " --");
        OverloadingTest ot = new OverloadingTest();
        ot.x = 10;
        System.out.println(ot.x);

        //AbstractClassDemo acd = new AbstractClassDemo();

        int[][] queries = new int[5][3];
        System.out.println(queries.length);
    }
}
