package com.sainath.test;

import java.util.Scanner;

public class SwitchTest {

    public SwitchTest() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        switch (x) {
            case 10:
                System.out.println("case matched for 10");
            case 11:
                System.out.println("case matched for 11");
            default:
                System.out.println("default case");
        }
    }
}
