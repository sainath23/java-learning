package com.sainath.lang;

public class StaticNestedClassDemo {

    public static void outerMethod() {
        System.out.println("Outer class method");
    }

    static class StaticInnerClass {
        public static void main(String[] args) {
            System.out.println("Static inner class main method...");
            outerMethod();
        }
    }
}
