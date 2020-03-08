package com.sainath.generics;

import java.util.ArrayList;
import java.util.List;

public class BoundedTypeDemo {
    public static void main(String[] args) {
        BoundType<A> cBoundType = new BoundType<>(new C());
        cBoundType.test();

        Runnable r1 = () -> {};
        List<Runnable> list = new ArrayList<>();
        list.add(r1);
        m1(list);

        List<? extends Number> list1 = new ArrayList<>();
        //list1.add(new Integer(10));
       // m2(list1);

    }

    public static List<?> m1(List<? super Runnable> list) {
        return new ArrayList<>();
    }

    public static String m2(List<? extends A> list) {
        return "";
    }
}

class BoundType<T extends A> {
    private T obj;

    public BoundType(T obj) {
        this.obj = obj;
    }

    public void test() {
        this.obj.display();
    }
}

class A {
    public void display() {
        System.out.println("Inside A's display");
    }
}

class B extends A {
    @Override
    public void display() {
        System.out.println("Inside B's display");
    }
}

class C extends A {
    @Override
    public void display() {
        System.out.println("Inside C's display");
    }
}

class X {
    public void display() {
        System.out.println("Inside X's display");
    }
}