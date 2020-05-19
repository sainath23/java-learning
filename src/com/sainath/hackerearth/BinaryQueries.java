package com.sainath.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/range-query-2/description/
public class BinaryQueries {

    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split("\\s");
        int N = Integer.parseInt(firstLine[0]);
        int Q = Integer.parseInt(firstLine[1]);
        String secondLine = br.readLine();
        String[] elements = secondLine.split("\\s");
        int[] binary = new int[N];
        for(int i = 0; i < N; i++) {
            binary[i] = Integer.parseInt(elements[i]);
        }
        while(Q > 0) {
            String[] queryStr = br.readLine().split("\\s");
            //System.out.println(Arrays.toString(queryStr));

            switch(queryStr[0]) {
                case "1":
                    if(binary[Integer.parseInt(queryStr[1]) - 1] == 0) {
                        binary[Integer.parseInt(queryStr[1]) - 1] = 1;
                    } else {
                        binary[Integer.parseInt(queryStr[1]) - 1] = 0;
                    }
                    break;
                case "0":
                    int L = Integer.parseInt(queryStr[1]) - 1;
                    int R = Integer.parseInt(queryStr[2]) - 1;
                    //binary = binary.substring(L, R+1);
                    System.out.println(Arrays.toString(binary));
                    System.out.println(binary[R] == 0 ? "EVEN" : "ODD");
                    break;
            }

            Q--;
        }

    }
}
/*
0001 1
0010 2
0011 3
0100 4
0101 5
0110 6
0111 7
1000 8

 */