package com.sainath.oops;

public abstract class AbstractClassDemo {
    int x;
}

class Demo extends AbstractClassDemo {
    public Demo() {
        this.x = 10;
        super.x = 200;

        System.out.println();
    }
}

