package com.sainath.collections;

import java.util.LinkedList;

public class MyHashSet {
    private static LinkedList<String>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[16];
        for(int i=0; i<16; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private static int hashCode(String value) {
        return value.length();
    }

    private static void add(String value) {
        int index = hashCode(value) % 16;
        buckets[index].add(value);
    }
}
