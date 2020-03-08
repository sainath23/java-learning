package com.sainath.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    private static String S1 = "";
    private String s2 = "";

    public void m1() {
        String s2 = "";
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Sainath");
        list.add("Parkar");
        list.add("XYZ");
        test(list);
        String s2 = "";
        String S1 = "";
        GenericTest.S1 = "";

        System.out.println(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void test(List list) {
        list.add(10);
        list.add(10.5);
        list.add(true);
    }

    public static <T> List<T> test1(T t) {
        return null;
    }

    public static <T> List<T> test2(List<T> t) {
        return null;
    }
}
