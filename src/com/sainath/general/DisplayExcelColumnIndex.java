package com.sainath.general;

import java.util.Arrays;
import java.util.Scanner;

public class DisplayExcelColumnIndex {

    public static void main(String[] args) {
        String[] columnIndexes = new String[26];
        int a = 'A';
        int z = 'Z';
        System.out.println(a + " " + z);

        for (int i = 0; i < 26; i++) {
            columnIndexes[i] = Character.toString((char) (i + 65));
        }
        System.out.println(Arrays.toString(columnIndexes));
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        if (index >= 1 && index <= 26) {
            System.out.println(columnIndexes[index - 1]);
        } else {
            int quotient = index / 26;
            int reminder = index % 26;

        }
    }
}
