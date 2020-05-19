package com.sainath.multithreading;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.print(1 + " ");
        synchronized (args) {
            System.out.print(2 + " ");
            args.wait();
        }
        System.out.println(3);
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        //map.put()
    }
}
