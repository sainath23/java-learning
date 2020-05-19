package com.sainath.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/roy-and-profile-picture/
public class RoyAndProfilePicture {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        while (N > 0) {
            String[] line = br.readLine().split("\\s");
            int W = Integer.parseInt(line[0]);
            int H = Integer.parseInt(line[1]);

            if (W < L || H < L) {
                System.out.println("UPLOAD ANOTHER");
            } else if (W == H) {
                System.out.println("ACCEPTED");
            } else {
                System.out.println("CROP IT");
            }

            N--;
        }
    }
}
