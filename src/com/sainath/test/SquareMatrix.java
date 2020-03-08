package com.sainath.test;

import java.util.Arrays;
import java.util.Scanner;
/*
{A#A#K,A#S#K,A#K#K}
ASK
op -> 4
 */
public class SquareMatrix {

    public static void main(String args[] ) throws Exception {

        //Write code here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[][] matrix = new String[N][];

        for(int i = 0; i < N; i++) {
            String str = sc.next();
            //System.out.println("str: " + str);
            String[] strArr = str.split("#");
            matrix[i] = strArr;
        }
        String searchString = sc.next();
        for(String[] sArr: matrix) {
            for (String s : sArr) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        if (searchString.length() > N) {
            System.out.println(0);
            System.exit(0);
        }

        System.out.println(findWordInMatrix(matrix, searchString));
    }

    public static int findWordInMatrix(String[][] matrix, String key) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

                // horizontal
                int horizontalCount = 0;
                outer: for (int k = 0; k < key.length(); k++) {
                    for (int x = j; x < matrix.length; x++) {
                        if (matrix[i][x].equals(Character.toString(key.charAt(k))))
                            horizontalCount++;
                        else
                            break outer;
                    }
                }
                if (horizontalCount == key.length()) {
                    System.out.println("H count match");
                    count++;
                }

                // vertical
                int verticalCount = 0;
                outer: for (int k = 0; k < key.length(); k++) {
                    for (int x = i; x < matrix.length; x++) {
                        if (matrix[x][j].equals(Character.toString(key.charAt(k))))
                            verticalCount++;
                        else
                            break outer;
                    }
                }
                if (verticalCount == key.length()) {
                    System.out.println("V count match");
                    count++;
                }

                // diagonal
                /*int diagonalCount = 0;
                outer: for (int k = 0; k < key.length(); k++) {
                    for (int x = i; x < matrix.length; x++) {
                        if (matrix[x][j].equals(Character.toString(key.charAt(k))))
                            verticalCount++;
                        else
                            break outer;
                    }
                }
                if (verticalCount == key.length())
                    count++;*/
            }
        }

        return count;
    }

}
