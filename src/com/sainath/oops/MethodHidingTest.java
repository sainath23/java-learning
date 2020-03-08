package com.sainath.oops;

public class MethodHidingTest {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        A a1 = new B();
        B b1 = null;

        a.m1();
        b.m1();
        a1.m1();
        b1.m1();

        System.out.println("\n");

        a.m2();
        b.m2();
        a1.m2();
    }
}

class A {
    public static void m1() {
        System.out.println("A class m1");
    }

    public void m2() {
        System.out.println("A class m2");
    }
}

class B extends A {
    public static void m1() {
        System.out.println("B class m1");
    }

    @Override
    public void m2() {
        System.out.println("B class m2");
    }
}
