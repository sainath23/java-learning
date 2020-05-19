package com.sainath.test;

public class RunningSumX {

    public static void main(String[] args) {
        //int[] arr = {-5, 4, -2, 3, 1, -1, -6, -1, 0, -5};
        int[] arr = {-5, -5, -6, 5, -1};
        //System.out.println(findX(arr));
        System.out.println(findXWhile(arr));
    }

    public static int findXWhile(int[] arr) {
        int x = 1;

        while (true) {
            int runningSum = x;
            for (Integer num : arr) {
                if (runningSum < 1) {
                    break;
                }
                runningSum += num;
            }
            if (runningSum >= 1) {
                break;
            }
            x++;
        }

        return x;
    }
}
