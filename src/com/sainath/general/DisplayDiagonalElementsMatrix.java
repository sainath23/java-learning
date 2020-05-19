package com.sainath.general;

import java.util.Random;

public class DisplayDiagonalElementsMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                Random random = new Random();
                int x = random.nextInt(50);
                matrix[i][j] = x;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][i]);
        }
    }
}
