package com.sainath.test;

// Java is always pass by value
public class PassByValueAndReference {
    private String str = "ABC";

    public static void main(String[] args) {
        String s = "Sainath";
        modifyStr(s);
        System.out.println(s);
        PassByValueAndReference o = new PassByValueAndReference();
        o.callme();
    }

    public static void modifyStr(String s) {
        s = "Parkar";
    }

    public void callme() {
        modifyStr1(str);
        System.out.println(str);
    }

    public void modifyStr1(String s) {
        s = "XYZ"; // will not modify
        //str = "XYZ"; // Will modify
    }
}
