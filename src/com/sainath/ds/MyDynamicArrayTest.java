package com.sainath.ds;

public class MyDynamicArrayTest {

    public static void main(String[] args) {
        DynamicArray<Integer> da = new DynamicArray<>();
        System.out.println(da.getLength());
        for(int i = 10; i <= 100; i = i + 10) {
            da.add(i);
        }
        System.out.println(da.getLength());
        da.removeAt(0);
        System.out.println(da.getLength());
        System.out.println(da.get(7));
    }
}
