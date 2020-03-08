package com.sainath.lambdas;

import java.util.function.Consumer;

// Can be used to replace lambda expressions.
// Only required method to be refer must have
// same args as functional interface's method
// return type and modifiers doesn't matter
public class MethodReferenceTest {

    public static void display(String str) {
        System.out.println(str);
    }

    public void job() {
        System.out.println("Instance method reference");
    }

    public static void main(String[] args) {
        Consumer<String> consumer = MethodReferenceTest::display;
        consumer.accept("Static method reference");

        MethodReferenceTest test = new MethodReferenceTest();
        Runnable r = test::job;
        Thread t = new Thread(r);
        t.start();

        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("Hello world");
    }
}
