package com.sainath.lambdas;

import java.util.Objects;
import java.util.function.Predicate;

public class FunctionPackageTest {

    public static void main(String[] args) {
        Predicate<String> p1 = s -> s.length() > 10;
        Predicate<String> p2 = s -> s.length() < 20;

        Predicate<String> p3 = p1.and(p2);

        System.out.println(p3.test("SAINATH PARKAR"));

        MyPredicate<Integer> mp1 = i -> i > 100;
        MyPredicate<Integer> mp2 = i -> i < 200;
        MyPredicate<Integer> mp3 = mp1.or(mp2);
        System.out.println(mp3.test(150));
        MyPredicate<String> mp4 = MyPredicate.isEqual("Sainath");
        System.out.println(mp4.test("Sainath"));
    }

    @FunctionalInterface
    interface MyPredicate<T> {
        boolean test(T t);

        default MyPredicate<T> and(MyPredicate<T> other) {
            MyPredicate<T> p = t -> test(t) && other.test(t);
            return p;
        }

        default MyPredicate<T> or(MyPredicate<T> other) {
            return t -> test(t) || other.test(t);
        }

        static <T> MyPredicate<T> isEqual(Object obj) {
            return obj == null ? Objects::isNull : obj::equals;
        }
    }
}
