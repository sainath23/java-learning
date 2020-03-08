package com.sainath.generics;

import java.util.ArrayList;
import java.util.List;

public class WildcardTest {

    public static void main(String[] args) {

        List<? extends Number> list1 = new ArrayList<>();
        List<? extends Number> list2 = new ArrayList<Integer>();
        List<? extends Number> list3 = new ArrayList<Double>();

        list2.add(null);

        List<? super Number> list4 = new ArrayList<>();
        List<? super Integer> list5 = new ArrayList<Number>();
        List<? super Double> list6 = new ArrayList<Number>();
        List<? super Number> list7 = new ArrayList<Object>();
        list7.add(10);
        System.out.println(list7.get(0) instanceof Integer);
    }
}
