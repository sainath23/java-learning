package com.sainath.serializations;

import com.sainath.designpatterns.Singleton;

public class BreakSingletonByClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = (Singleton) s1.clone();

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}
