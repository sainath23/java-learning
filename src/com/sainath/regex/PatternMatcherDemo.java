package com.sainath.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherDemo {
    public static void main(String[] args) {
        String regex = "[ab]";
        String key = "abcdefab";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(key);
        int count = 0;
        while (matcher.find()) {
            count++;
        }

        System.out.println(count);

    }
}
