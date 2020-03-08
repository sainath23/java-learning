package com.sainath.collections;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) throws IOException {
        Set<String> set = new HashSet<>();

        System.out.println(set.add("Sainath"));
        System.out.println(set.add("Sainath"));
        System.out.println(set.contains("Sainath"));

        Map<String, String> map = new HashMap<>();
        System.out.println(map.put("sainath", "Engineer"));
        System.out.println(map.put("sainath", "Developer"));
        //ObjectOutputStream o = new ObjectOutputStream();
    }
}
