package com.sainath.oops;

public class OverridingTest extends Test {

    public String t1() {
        System.out.println("OverridingTest t1()");
        return "";
    }

    static void m2() {
        System.out.println("OT m2");
    }

    public static void main(String[] args) {
        OverridingTest t = new OverridingTest();
        //t.t1();
        t.m2();
    }
}

class Test {
    protected Object t1() {
        System.out.println("Test t1()");
        return "";
    }

    static void m2() {
        System.out.println("Test static");
    }
}