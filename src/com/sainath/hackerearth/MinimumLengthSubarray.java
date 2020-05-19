package com.sainath.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
2
7 5
3 4 7 2 1 6 2   -> Min length sub array whose sum is div by 5 = [7, 2, 1] length = 3
8 14
7 4 1 2 2 9 8 9 -> Min length sub array whose sum is div by 14 = [7, 4, 1, 2] length = 4
 */
public class MinimumLengthSubarray {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T > 0) {
            String[] line = br.readLine().split("\\s");
            int N = Integer.parseInt(line[0]);
            int K = Integer.parseInt(line[1]);
            line = br.readLine().split("\\s");
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            System.out.println(findMinSubarrayLengthEfficient(arr, K, N));
            T--;
        }
    }

    public static int findMinSubarrayLength(int[] arr, int K, int N) {
        int count = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int sum = 0;
            int tempCount = 0;
            for (int j = i; j < N; j++) {
                tempCount++;
                sum += arr[j];
                if (Math.abs(sum) % K == 0) {
                    if (tempCount < count) {
                        count = tempCount;
                    }
                    break;
                }
            }
        }

        return count;
    }

    public static int findMinSubarrayLengthEfficient(int[] arr, int K, int N) {
        int[] mod = new int[N];

        int cumSum = 0;
        for (int i = 0; i < N; i++) {
            cumSum += arr[i];

            mod[i] = ((cumSum % K) + K) % K;
        }
        System.out.println(Arrays.toString(mod));
        int count = 0;
        for (int i = 0; i < mod.length; i++) {
            if (mod[i] == 1) {
                count++;
            }
        }
        return count;
    }
}
