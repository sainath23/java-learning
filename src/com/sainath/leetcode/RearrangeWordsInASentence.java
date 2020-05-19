package com.sainath.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://leetcode.com/problems/rearrange-words-in-a-sentence/
public class RearrangeWordsInASentence {

    public static void main(String[] args) {
        String str = "Leetcode is cool";
        System.out.println(arrangeWords(str));
    }

    public static String arrangeWords(String text) {
        String[] words = text.toLowerCase().split("\\s");

        List<String> list = new ArrayList<>(Arrays.asList(words));

        list.sort(Comparator.comparingInt(String::length));

        String result = String.join(" ", list);

        return Character.toUpperCase(result.charAt(0)) + result.substring(1);

    }
}
