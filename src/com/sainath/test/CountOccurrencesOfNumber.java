package com.sainath.test;

import java.util.Arrays;
import java.util.Scanner;

public class CountOccurrencesOfNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(s.next());
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int Q = s.nextInt();
        while(Q > 0) {
            int num = s.nextInt();
            long count = Arrays.stream(arr).filter(x -> x == num).count();
            /*for(int i=0; i<N; i++) {
                int arri = arr[i];
                if(arri == num) {
                    count++;
                }
            }*/
            if(count > 0) {
                System.out.println(count);
            } else {
                System.out.println("NOT PRESENT");
            }

            Q--;
        }
    }
}
