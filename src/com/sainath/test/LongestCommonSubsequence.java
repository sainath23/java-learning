package com.sainath.test;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "aab";
        String str2 = "azb";
        System.out.println(dpLcs(str1, str2));
    }

    public static int lcs(String s1, String s2) {

        if (null == s1 || s1.length() < 1 || null == s2 || s2.length() < 1) {
            return 0;
        }

        String s1Last = s1.substring(s1.length() - 1);
        String s2Last = s2.substring(s2.length() - 1);

        if (s1Last.equals(s2Last)) {
            return 1 + lcs(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1));
        } else {
            return Math.max(lcs(s1.substring(0, s1.length() - 1), s2), lcs(s1, s2.substring(0, s2.length() - 1)));
        }
    }

    public static int dpLcs(String s1, String s2) {
        int[][] dp = new int[s2.length() + 1][s1.length() + 1];

        for (int s2Row = 0; s2Row <= s2.length(); s2Row++) {
            for (int s1Col = 0; s1Col <= s1.length(); s1Col++) {
                if (s2Row == 0 || s1Col == 0) {
                    dp[s2Row][s1Col] = 0;
                } else if (s2.charAt(s2Row - 1) == s1.charAt(s1Col - 1)) {
                    dp[s2Row][s1Col] = 1 + dp[s2Row - 1][s1Col - 1];
                } else {
                    dp[s2Row][s1Col] = Math.max(dp[s2Row - 1][s1Col], dp[s2Row][s1Col-1]);
                }
            }
        }
        for (int i =0; i<dp.length; i++) {
            for (int j = 0; j<dp.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[s2.length()][s1.length()];
    }
}
