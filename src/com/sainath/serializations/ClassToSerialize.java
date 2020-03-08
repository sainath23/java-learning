package com.sainath.serializations;

import java.io.Serializable;

public class ClassToSerialize implements Serializable {
    //private static final long serialVersionUID = 4799287591930153135L;

    private int x = 10;
    private String str = "Sainath";
    private transient String password = "password";
    //private int y = 20;

    /*public void display() {
        System.out.println("This is a display method");
    }*/

    public int getX() {
        return x;
    }

    public String getStr() {
        return str;
    }

    public String getPassword() {
        return password;
    }

    /*public int getY() {
        return y;
    }*/
}
