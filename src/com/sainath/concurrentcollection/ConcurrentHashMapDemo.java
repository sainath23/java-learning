package com.sainath.concurrentcollection;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>(32, 0.50f, 42);

        System.out.println(map.putIfAbsent(1, "Sainath"));
        System.out.println(map.putIfAbsent(1, "Parkar"));
        System.out.println(map.putIfAbsent(1, "XYZ"));
        System.out.println(map.remove(1, "ABC"));
        System.out.println(map.replace(1, "Parkar", "Sainath"));
        //System.out.println(map.put(2, null)); // NPE
        System.out.println(Objects.hash(null));
    }
}
