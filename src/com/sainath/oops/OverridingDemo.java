package com.sainath.oops;

import java.io.IOException;

public class OverridingDemo {
    class A {
        void show() throws IOException {

        }

        void display() throws Throwable {

        }
    }

    class B extends A {
        void show() {

        }

        void display() throws Throwable {

        }
    }
}
