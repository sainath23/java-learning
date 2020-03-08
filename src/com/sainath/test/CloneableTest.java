package com.sainath.test;

public class CloneableTest implements Cloneable {

    public int x = 20;

    public static void main(String[] args) throws CloneNotSupportedException {

        CloneableTest ct1 = new CloneableTest();

        CloneableTest ct2 = (CloneableTest) ct1.clone();

        System.out.println(ct1.hashCode());
        System.out.println(ct2.hashCode());
    }
}
