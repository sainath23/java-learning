package com.sainath.exceptions;

import java.io.IOException;

public class MethodOverridingTest {
    class A {
        void m1() throws Exception {

        }
    }

    class B extends  A {
        @Override
        void m1() {
            //super.m1();
        }
    }

    interface Iter1 {
        void m2();
    }

    class Iter1Impl implements Iter1 {
        @Override
        public void m2() throws RuntimeException {

        }
    }
}
