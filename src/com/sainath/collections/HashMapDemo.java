package com.sainath.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        System.out.println(map.put(1, "Sainath"));
        System.out.println(map.put(1, "Parkar"));
        System.out.println(map.put(1, "ABC"));
        System.out.println(map.replace(1, "Sainath"));
        map.put(null, "");
    }
}
