package com.sainath.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TestDemo {
    public static void main(String[] args) {
        int h = 10;
        System.out.println(h >>> 16);

        System.out.println("hashcode = " + Objects.hashCode(10));
        System.out.println("hashcode = " + Integer.valueOf(10).hashCode());
        System.out.println(16 % 15);

        Map<Integer, String> map = new HashMap<>();
        System.out.println(map.remove(12));
    }
}
