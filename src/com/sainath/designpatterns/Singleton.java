package com.sainath.designpatterns;

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {
    private static volatile Singleton INSTANCE;

    private Singleton() {
        if (Singleton.INSTANCE != null) {
            throw new InstantiationError("Object already exists");
        }
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

    protected Object readResolve() {
        return INSTANCE;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
