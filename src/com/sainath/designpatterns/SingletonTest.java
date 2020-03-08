package com.sainath.designpatterns;

public class SingletonTest {
    private static SingletonTest singletonTest;

    private SingletonTest() {}

    private static SingletonTest getInstance() {
        if (singletonTest == null) {
            synchronized (SingletonTest.class) { // Class level lock
                if (singletonTest == null) { // double check...
                    singletonTest = new SingletonTest();
                }
            }
        }
        return singletonTest;
    }
}