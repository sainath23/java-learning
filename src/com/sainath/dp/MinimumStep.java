package com.sainath.dp;

/*
Given an integer n, return the minimum steps to minimize to 1

Available steps:
-Decrement n by 1
-If n is divisible by 2, then divide by 2
-If n is divisible by 3, then divide by 3

Ex.
10 => 3 steps (10 => 9 => 3 => 1)
15 => 4 steps (15 => 5 => 4 => 2 => 1)

 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumStep {
    public static void main(String[] args) {
        int n = 10000;
        int[] dp = new int[n + 1];
        System.out.println(minimumNoStepsTabular(n, dp));
    }

    public static int minimumNoStepsTabular(int n, int[] dp) {
        Arrays.fill(dp, n);
        dp[1] = 0;

        for (int i = 1; i < n; i++) {
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            if (i * 2 <= n)
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            if (i * 3 <= n)
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
        }
        return dp[n];
    }

    public static int minimumNoStepsMemo(int n, int[] dp) {
        //System.out.println(n);
        if (n <= 1) {
            return 0;
        }

        //return min(1 + minimumNoSteps(n - 1), n % 2 == 0 ? 1 + minimumNoSteps(n / 2) : 0, n % 3 == 0 ? 1 + minimumNoSteps(n / 3) : 0);

        if (dp[n] != 0) {
            return dp[n];
        }

        int result = minimumNoStepsMemo(n - 1, dp);
        if (result % 2 == 0) {
            result = Math.min(result, minimumNoStepsMemo(n / 2, dp));
        }
        if (result % 3 == 0) {
            result = Math.min(result, minimumNoStepsMemo(n / 3, dp));
        }
        dp[n] = result + 1;
        //System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    // 10 -> 5 -> 4 -> 2 -> 1
    public static int minimumNoSteps(int n) {
        //System.out.println(n);
        if (n <= 1) {
            return 0;
        }

        //return min(1 + minimumNoSteps(n - 1), n % 2 == 0 ? 1 + minimumNoSteps(n / 2) : 0, n % 3 == 0 ? 1 + minimumNoSteps(n / 3) : 0);

        int result = minimumNoSteps(n - 1);
        if (result % 2 == 0) {
            result = Math.min(result, minimumNoSteps(n / 2));
        }
        if (result % 3 == 0) {
            result = Math.min(result, minimumNoSteps(n / 3));
        }
        return result + 1;
    }

    public static int min(int a, int b, int c) {
        if (a == 0 && b == 0 && c == 0) {
            return 0;
        }
        int min;
        if (a > 0) {
            min = a;
        } else if (b > 0) {
            min = b;
        } else {
            min = c;
        }

        if (a != 0 && min > a) {
            min = a;
        } else if (b != 0 && min > b) {
            min = b;
        } else if (c != 0 && min > c) {
            min = c;
        }
        return min;
    }
}
