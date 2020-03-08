package com.sainath.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindEven {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            list.add(i);
        }
        System.out.println(list);

        // Old way
        List<Integer> evenNumbersOld = new ArrayList<>();
        for (Integer i : list) {
            if (i % 2 == 0) {
                evenNumbersOld.add(i);
            }
        }
        System.out.println("Even old way = " + evenNumbersOld);

        List<Integer> evenNumbersNew = list.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        System.out.println("Even new way = " + evenNumbersNew);
    }
}
