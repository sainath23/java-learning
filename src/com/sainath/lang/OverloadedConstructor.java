package com.sainath.lang;

import java.io.IOException;

public class OverloadedConstructor extends Parent {

    OverloadedConstructor() throws IOException {
    }

    public static void main(String[] args) {
        try {
            OverloadedConstructor o = new OverloadedConstructor();
        } catch (Exception e) {

        }
    }
}

class Parent {
    Parent() throws IOException {

    }
}
