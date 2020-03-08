package com.sainath.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentModificationExTest {
    public static void main(String[] args) {

        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "Sainath");
        map.put(3, "Saurabh");
        map.put(4, "Shahid");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Current key = " + entry.getKey());
            if ("Sainath".equals(entry.getValue())) {
                map.put(2, "Parkar");
            }
        }
        System.out.println(map);

        List<String> langs = new ArrayList<>();
        langs.add("Java");
        langs.add("PHP");
        langs.add("Python");
        langs.add("Go");

        List<String> subLangs = langs.subList(0, 2);

        System.out.println(langs.equals(subLangs));
        System.out.println("langs hc = " + langs.hashCode() + ", subLangs hc = " + subLangs.hashCode());

        System.out.println("langs = " + langs);
        System.out.println("sublangs = " + subLangs);

        langs.set(1, "C#");

        System.out.println("langs = " + langs);
        System.out.println("sublangs = " + subLangs);

        //langs.add("Javascript");
        subLangs.add("Javascript");

        System.out.println("langs = " + langs);
        System.out.println("sublangs = " + subLangs);

        TreeSet<String> treeSet = new TreeSet<>();
        //treeSet.add(null);
        treeSet.add("Gracenote");
        treeSet.add("A");
        treeSet.add("company");
        //treeSet.add(null);
        System.out.println(treeSet);

        TreeSet<Emp> ts = new TreeSet<>((o1, o2) -> {
            System.out.println("Comparing this = " + o1.getId() + " with o = " + o2.getId());
            return o2.getId() - o1.getId();
        });
        ts.add(new Emp(2));
        ts.add(new Emp(3));
        ts.add(new Emp(1));
        ts.add(new Emp(0));
        System.out.println(ts);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.offer(5);
        System.out.println(stack);

        TreeSet t = new TreeSet();
        t.add(10);
        t.add(20);
        System.out.println(t);
    }
}

class Emp implements Comparable<Emp> {
    private int id;

    public Emp(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Emp o) {
        System.out.println("Comparing this = " + id + " with o = " + o.id);
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}