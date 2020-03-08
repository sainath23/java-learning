package com.sainath.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringSpecialAgain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        long result = substrCount(s.length(), s);

        System.out.println(result);
        scanner.close();
    }

    private static long substrCount(int n, String s) {
        List<String> substrList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for(int j = i + 1; j <= n; j++) {
                String substr = s.substring(i, j);
                substrList.add(substr);
            }
        }

        //System.out.println(substrList);
        List<String> specialSubstrList = new ArrayList<>();

        for (String substr : substrList) {
            if (substr.length() == 1) specialSubstrList.add(substr);
            else {
                if (substr.length() == 3 && substr.charAt(0) == substr.charAt(2)) {
                    specialSubstrList.add(substr);
                } else if (substr.length() % 2 == 0 && "".equals(substr.replaceAll(Character.toString(substr.charAt(0)), ""))) {
                    specialSubstrList.add(substr);
                } else {
                    String leftStr = substr.substring(0, substr.length() / 2);
                    String rightStr = substr.substring((substr.length() / 2) + 1);
                    if (leftStr.equals(rightStr)) {
                        specialSubstrList.add(substr);
                    }
                }
            }
        }

        return specialSubstrList.size();
    }
}
