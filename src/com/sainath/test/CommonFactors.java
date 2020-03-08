package com.sainath.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CommonFactors {

    public static void main(String[] args) throws IOException {
        /*Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        String[] inputs = line.split("\\s");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        int count = 0;
        int small = 0;
        if (a < b) {
            small = a / 2;
        } else {
            small = b / 2;
        }

        count = 1;

        for (int i = 2; i <= small; i++) {
            if (a % i == 0 && b % i == 0) {
                System.out.println("Matching factor = " + i);
                count++;
            }
        }

        if (a % b == 0 || b % a == 0) count++;

        System.out.println(count);

    }
}
