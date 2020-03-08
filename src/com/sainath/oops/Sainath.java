package com.sainath.oops;

public class Sainath extends Person {

    @Override
    public int getAge() {
        return super.getAge();
    }

    public static void main(String[] args) {
        Person p = new Sainath();

        System.out.println("Age " + p.getAge());
    }
}
