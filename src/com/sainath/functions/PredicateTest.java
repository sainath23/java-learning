package com.sainath.functions;

import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {
        Predicate<Integer> p = i -> i > 100;
        p = p.and(i -> i % 2 == 0);
        System.out.println(p.test(101));
        System.out.println(p.test(102));
    }
}
