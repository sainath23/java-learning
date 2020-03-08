package com.sainath.interf;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DefaultMethodTest extends HappyClass implements HappyService {

    /*@Override
    public void beHappy() {
        System.out.println("I am always be happy...");
    }*/

    public void iamHappy() {
        //HappyService.super.beHappy();
        beHappy();
    }

    public static void main(String[] args) {
        DefaultMethodTest dmt = new DefaultMethodTest();
        dmt.beHappy();
        dmt.iamHappy();
        HappyService.myHappy();

        /*HappyService hs = new HappyService() {};
        hs.beHappy();*/
    }
}

interface HappyService {
    int x = 10;
    default void beHappy() {
        System.out.println("Always be happy...");
    }

    default void beHappy(int x) {

    }

    static void myHappy() {
        System.out.println("Static method");
    }

    //void happyTest();
}

interface MyHappyService {
    default void beHappy() {
        System.out.println("My Happy beHappy");
    }

}

class HappyClass {

    public static void myTest() {

    }
}