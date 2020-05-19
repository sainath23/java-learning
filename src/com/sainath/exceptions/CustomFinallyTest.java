package com.sainath.exceptions;

public class CustomFinallyTest {

    public static void doStuff() {
        System.out.println("doing something");
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try {
            System.out.println("in main");
            doStuff();
        } catch (Exception e) {
            System.out.println("caught");
        } finally {
            System.out.println("finally");
        }
        System.out.println("end");
    }
}
