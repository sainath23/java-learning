package com.sainath;

public class GreetingLambda {
    public static void main(String[] args) {
        Greeting greeting = () -> System.out.println("Hello World");
        greeting.greet();

        int x = 10;
        DoubleMe doubleMe = a -> a*2;
        System.out.println(doubleMe.result(x));

        MultiplyMe multiplyMe = (a, b) -> a*b;
        System.out.println(multiplyMe.result(10, 10));
    }
}

@FunctionalInterface
interface Greeting {
    void greet();
}

interface DoubleMe {
    int result(int a);
}

interface MultiplyMe {
    int result(int x, int y);
}