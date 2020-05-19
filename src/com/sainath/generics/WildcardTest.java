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

        List<Object> list = new ArrayList<>();
        doSomething(list);
        List<MyBox> myBoxes = new ArrayList<>();
        doMoreThings(myBoxes);
        List<MyInteger> myIntegers = new ArrayList<>();
        m2(myIntegers);

        List<? extends String> strings = new ArrayList<>();
        List<? extends Object> objects = new ArrayList<>();
        objects = strings;

        List<? extends Integer> integers = new ArrayList<>();
        List<? extends Number> numbers = new ArrayList<>();
        numbers = integers;
        List<? extends Object> objects1 = new ArrayList<String>();
    }

    public static void doSomething(List<? super Box> list) {
    }

    public static void doMoreThings(List<? super BigBox> list) {}

    interface Box {
    }

    static class MyBox {
    }

    static class BigBox extends MyBox implements Box {
    }

    public static void m1(List<?> list) {
        for (Object o : list) {

        }
    }

    public static void m2(List<? extends MyNumber> list) {
        //list.add(new MyNumber());
    }

    static class MyNumber {}
    static class MyInteger extends MyNumber {}

    public static void m3(List<? super Integer> list) {
        Number n = 10;
        //list.add(n); // Error
        list.add(new Integer(1));
    }

}
