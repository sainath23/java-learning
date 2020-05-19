package com.sainath.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ObjectClassDump {
    public static void main(String[] args) {
        Class<?> objClass = Object.class;
        System.out.println(objClass.hashCode());

        Method[] methods = objClass.getDeclaredMethods();
        int count = 1;
        for(Method m : methods) {
            System.out.println((count++) + " " + m);
        }

        Constructor<?>[] constructors = objClass.getDeclaredConstructors();
        for(Constructor<?> c : constructors) {
            System.out.println(c);
            c.setAccessible(false);
        }
    }
}
