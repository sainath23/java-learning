package com.sainath.coursera.algo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// Given an array nums of n integers,
// are there elements a, b, c in nums such that a + b + c = 0?
// Find all unique triplets in the array which gives the sum of zero.
public class ThreeSumProblem {
    public static void main(String[] args) {
        //int[] numbers = {30, -40, -20, -10, 40, 0, 10, 5};
        int[] numbers = {-1, 0, 1, 2, -1, -4};

        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        int sum = 0;
        int count = 0;
        Set<List<Integer>> resultList = new HashSet<>();
        for(int i = 0; i < numbers.length; i++) {
            int j = i + 1;
            int k = numbers.length - 1;

            while (j < k) {
                int tempSum = numbers[i] + numbers[j] + numbers[k];

                if (tempSum < sum) {
                    j++;
                } else if (tempSum > sum) {
                    k--;
                } else {
                    //System.out.println(tempSum);
                    List<Integer> list = new ArrayList<>();
                    list.add(numbers[i]);
                    list.add(numbers[j]);
                    list.add(numbers[k]);
                    resultList.add(list);
                    count++;
                    j++;
                    k--;
                }
            }
        }

        List<List<Integer>> finalList = new ArrayList<>(resultList);

        System.out.println("triplets = " + count);
        System.out.println("list = " + resultList);
        System.out.println("finalList = " + finalList);
    }
}
