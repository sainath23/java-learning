package com.sainath.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DoubleTheNumber {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            list.add(i);
        }
        System.out.println(list);

        // Old way
        List<Integer> doubleNumbersOld = new ArrayList<>();
        for (Integer i : list) {
            doubleNumbersOld.add(i * 2);
        }
        System.out.println("Even old way = " + doubleNumbersOld);

        List<Integer> doubleNumbersNew = list.stream().map(num -> num * 2).collect(Collectors.toList());
        System.out.println("Even new way = " + doubleNumbersNew);

        System.out.println(list.stream().min((i1, i2) -> i1 - i2));
        System.out.println(list.stream().max((i1, i2) -> i1 - i2));
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        Integer[] arr = list.stream().toArray(Integer[]::new);
        System.out.println(Stream.of(arr).count());
    }
}
