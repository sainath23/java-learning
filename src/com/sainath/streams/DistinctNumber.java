package com.sainath.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DistinctNumber {

    public static void main(String[] args) {
        int[] numbers = {7, 3, 0, 0, 1, 2, 2, 5};
        //Stream.of(numbers).distinct().sorted().limit(3).forEach(System.out::println);
        // This will not work as Stream.of() expect T type (object) and it array is one object

        IntStream.of(numbers).distinct().sorted().limit(3).forEach(System.out::println);
    }
}
