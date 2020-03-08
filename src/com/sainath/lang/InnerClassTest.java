package com.sainath.lang;

public class InnerClassTest {

    final static int y = 10;

    public static void main(String[] args) {
        class InClass {
            InClass() {
                System.out.println("Inside inn class");
            }
        }

        Object obj = new TestClass().new TestPrivate();
        ((TestClass.TestPrivate) obj).pm();

        Object o = new String("Sainath");

        System.out.println(o.getClass().getCanonicalName());
    }

    static class TestClass {
        private class TestPrivate {
            void pm() {
                System.out.println("Inside pm");
            }
        }
    }

    void m2() {

    }
}

interface TT {
    int x = 10;
    public abstract void m1();
}