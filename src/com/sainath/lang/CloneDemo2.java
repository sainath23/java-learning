package com.sainath.lang;

public class CloneDemo2 implements Cloneable {

    private int num1 = 10;
    private int num2 = 20;

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneDemo2 c1 = new CloneDemo2();
        CloneDemo2 c2 = (CloneDemo2) c1.clone();

        System.out.println("Before change c1 = " + c1);
        System.out.println("Before change c2 = " + c2);

        c1.num1 = 100;
        c1.num2 = 200;

        System.out.println("After change c1 = " + c1);
        System.out.println("After change c2 = " + c2);
    }

    @Override
    public String toString() {
        return "CloneDemo2{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                '}';
    }
}
