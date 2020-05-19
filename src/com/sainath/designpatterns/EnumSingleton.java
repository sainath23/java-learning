package com.sainath.designpatterns;

public enum  EnumSingleton {
    INSTANCE("XYZ");

    String value;

    EnumSingleton(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int doSOmething() {
        return 1;
    }
}
