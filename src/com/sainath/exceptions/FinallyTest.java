package com.sainath.exceptions;

import java.util.ArrayList;
import java.util.List;

public class FinallyTest {

    static int x = 10 / 0;

    public static void main(String[] args) {
        System.out.println("Sainath" + null);
        System.out.println(new StringBuilder("Sai ").append("sss").append('s').append(false));

        for (int i = 10; i-- > 0;) {
            System.out.println(i);
        }

        {
            List<String> list = new ArrayList<>();
            System.out.println("in block");
        }

        try {
            System.exit(0);
            int x = 10 / 0;
            throw new Exception();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            //System.exit(0);
        } finally {
            System.out.println("Iam in finally...");
        }
    }

    public static void m1() throws Throwable {
        System.out.println("in m1");
    }
}
interface Test {
    int x = 10;
    abstract void m1();
}
