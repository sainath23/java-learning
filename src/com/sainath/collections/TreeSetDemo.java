package com.sainath.collections;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();

        set.add(10);
        set.add(1);
        set.add(4);
        set.add(6);

        System.out.println(set);
    }
}
