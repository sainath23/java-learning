package com.sainath.interf;

public class InterfaceDemo implements A {

    public static void main(String[] args) {
        InterfaceDemo id = new InterfaceDemo();
        id.show();
    }
}

interface A {
    default void show() {
        System.out.println("A interface show method");
    }
}

interface B {
    default void show() {
        System.out.println("B interface show method");
    }
}
