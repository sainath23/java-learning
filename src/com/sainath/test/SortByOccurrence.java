package com.sainath.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortByOccurrence {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        sort(list);
    }

    private static void sort(List<Integer> arr) {
        Map<Integer, Integer> freqMap = new TreeMap<>();

        for (Integer n : arr) {
            if (!freqMap.containsKey(n)) {
                freqMap.put(n, 1);
            } else {
                freqMap.put(n, freqMap.get(n) + 1);
            }
        }

        System.out.println(freqMap);

        Map<Integer, List<Integer>> sortedMap = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (!sortedMap.containsKey(entry.getValue())) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < entry.getValue(); i++) {
                    list.add(entry.getKey());
                }
                sortedMap.put(entry.getValue(), list);
            } else {
                List<Integer> list = sortedMap.get(entry.getValue());
                for (int i = 0; i < entry.getValue(); i++) {
                    list.add(entry.getKey());
                }
            }
        }

        System.out.println(sortedMap);
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : sortedMap.entrySet()) {
            result.addAll(entry.getValue());
        }
        System.out.println(result);
    }
}
