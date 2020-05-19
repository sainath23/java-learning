package com.sainath.test;

public class SumOfLargeStrings {
    public static void main(String[] args) {
        String num1 = "056849";
        String num2 = "95684";

        System.out.println(sum(num1, num2));
    }

    public static String sum(String num1, String num2) {
        // Make num1 smaller
        if (num1.length() > num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        // Add leading 0's
        for (int i = 0; i < num2.length() - num1.length(); i++) {
            num1 = '0' + num1;
        }

        String result = "";
        int carry = 0;

        for (int i = num1.length() - 1; i >= 0; i--) {
            int sum = ((int) num1.charAt(i) - '0') + ((int) num2.charAt(i) - '0') + carry;
            result += sum % 10;
            carry = sum / 10;
        }

        result += carry;
        result = new StringBuilder(result).reverse().toString();

        // Remove leading 0's
        result = result.replaceFirst("^0+(?!$)", "");

        return result;
    }
}
