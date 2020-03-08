package com.sainath.designpatterns;

public class BreakSingletonByClone implements Cloneable {
    private static BreakSingletonByClone instance;

    private BreakSingletonByClone() {
    }

    public static BreakSingletonByClone getInstance() {
        if (instance == null) {
            synchronized (BreakSingletonByClone.class) {
                if (instance == null) {
                    instance = new BreakSingletonByClone();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        BreakSingletonByClone c1 = BreakSingletonByClone.getInstance();
        BreakSingletonByClone c2 = (BreakSingletonByClone) c1.clone();

        System.out.println(c1);
        System.out.println(c2);
    }
}
