package com.sainath.test;
// 10 = X. 50 = L, 100 = C, 500 = D, 1000 = M
public class IntegerToRoman {
    public static void main(String[] args) {
        String[] units =        {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens =         {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds =     {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands =    {"", "M", "MM", "MMM"}; // upto 3000

        int num = 24;
        String roman = thousands[num / 1000] + hundreds[(num % 1000) / 100] + tens[(num % 100) / 10] + units[num % 10];
        System.out.println(roman);
    }
}
