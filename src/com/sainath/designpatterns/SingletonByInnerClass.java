package com.sainath.designpatterns;

// Inner classes are not loaded until they are referred.
// This means that on the first call to getInstance, the class
// loader will load the SingletonHolder class.
// On load the static INSTANCE member will be initialized.
// So we eagerly initialize on demand.
public class SingletonByInnerClass {
    private SingletonByInnerClass() {}

    private static class SingletonHolder {
        private static final SingletonByInnerClass INSTANCE = new SingletonByInnerClass();
    }

    public static SingletonByInnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
