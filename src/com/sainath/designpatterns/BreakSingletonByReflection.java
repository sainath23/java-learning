package com.sainath.designpatterns;

import java.lang.reflect.Constructor;

public class BreakSingletonByReflection {
    public static void main(String[] args) throws Exception {
        //Singleton s1 = Singleton.getInstance();
        Singleton s2 = null;

        Constructor<?> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        s2 = (Singleton) constructor.newInstance();

        Singleton s1 = Singleton.getInstance();

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        System.out.println(enumSingleton.getValue());
        //System.out.println(enumSingleton.doSOmething());
    }
}
