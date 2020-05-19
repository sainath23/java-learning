package com.sainath.lang;

/*
* 1. Identification of static members (static block, variables and methods) top to bottom.
*       If variable assign default value (Read Indirectly Write Only)
* 2. Execution of static variables and blocks top to bottom
* 3. Execution of main method
 */
public class EverythingStaticDemo {

    static int m2() {
        System.out.println("Inside m2");
        return 200;
    }

    static int a = 10;
    static int x = m2();

    static {
        m1();
        System.out.println("Static block 1");
    }

    public static void main(String[] args) {
        m1();
        System.out.println("Main method");
        System.out.println("x = " + x);
    }

    static void m1() {
        System.out.println("b = " + b);
    }

    static {
        System.out.println("Static block 2");
    }

    static int b = 20;
}
