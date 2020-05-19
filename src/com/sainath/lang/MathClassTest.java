package com.sainath.lang;

public class MathClassTest {

    public static void main(String[] args) {
        float f = 2.3f;
        System.out.println(Math.ceil(f));
        System.out.println(Math.round(f));

        float x = 2.5f;
        System.out.println(Math.ceil(x));
        System.out.println(Math.round(x));

        int i = ((int)Math.ceil(f)) * ((int)Math.round(x));
        System.out.println("i = " + i);
    }
}
