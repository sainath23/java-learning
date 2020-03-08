package com.sainath.oops;

public class ExtendsTest extends SubClass {

    @Override
    public void m1() {
        System.out.println("Overridden m1");
    }

    public static void main(String[] args) {
        ((SubClass) new ExtendsTest()).m1();
    }
}

class SubClass {

    public void m1() {
        System.out.println("sub class m1");
    }
}