package com.sainath.exceptions;

public class TryFinallyTest {

    static boolean test() {
        try {
            return true;
        } finally {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(test());
    }
}
