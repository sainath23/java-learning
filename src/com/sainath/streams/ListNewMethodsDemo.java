package com.sainath.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;

public class ListNewMethodsDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
        UnaryOperator<Integer> unaryOperator = i1 -> i1 + 1;
        list.replaceAll(unaryOperator);
        System.out.println(list);
        //list.removeIf(i -> i < 50);
        //list.remove(0);
        //list.add(2000);

        List<Integer> list1 = new ArrayList<>(list);
        System.out.println(list1);
        list1.removeIf(i -> i < 50);
        System.out.println(list1);

        List<String> names = new ArrayList<>();
        names.add("sainath parkar");
        names.add("saurabh mestry");
        names.add("gaurav rasal");
        names.add("pratik sutar");
        names.replaceAll(String::toUpperCase);
        System.out.println(names);
        names.sort(Comparator.naturalOrder());
        System.out.println(names);

        List<String> test = new ArrayList<>();
        test.add("sai");
        test.add("Sai");
        test.add("SAi");
        test.add("SAI");
        test.add("saiN");

        test.sort(Comparator.naturalOrder());
        System.out.println(test);

    }
}
