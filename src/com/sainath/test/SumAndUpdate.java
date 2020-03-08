package com.sainath.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SumAndUpdate {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();

        String[] inputs = line.split("\\s");
        List<Integer> list = new ArrayList<>();

        int initialSum = 0;
        for (String s : inputs) {
            initialSum += Integer.parseInt(s);
            list.add(Integer.parseInt(s) * N);
        }
        Collections.sort(list);
        //System.out.println(initialSum);
        int largestSum = 0;
        for (Integer sum : list) {
            if (sum > initialSum) {
                largestSum = sum;
                break;
            }
        }
        System.out.println(largestSum / N);

    }
}
