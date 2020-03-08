package com.sainath.hackerrank;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndValidString {
    // Complete the isValid function below.
    static String isValid(String s) {
        // abcdefghhgfedecba

        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(freqMap.containsKey(s.charAt(i))) {
                freqMap.put(s.charAt(i), freqMap.get(s.charAt(i)) + 1);
            } else {
                freqMap.put(s.charAt(i), 1);
            }
        }
        System.out.println(freqMap);
        System.out.println(freqMap.values());
        Collection<Integer> values = freqMap.values();
        Map<Integer, Integer> valuesCountMap = new HashMap<>();

        for(Integer i : values) {
            if(valuesCountMap.containsKey(i)) {
                valuesCountMap.put(i, valuesCountMap.get(i) + 1);
            } else {
                valuesCountMap.put(i, 1);
            }
        }

        System.out.println(valuesCountMap);
        if (valuesCountMap.size() == 1) return "YES";
        if(valuesCountMap.size() > 2) return "NO";
        if(valuesCountMap.containsKey(1) && valuesCountMap.get(1) == 1) return "YES";
        int diff = 0;
        for(Integer i : valuesCountMap.keySet()) {
            diff = Math.abs(diff - i);
        }
        System.out.println(diff);
        return diff == 1 && valuesCountMap.containsValue(1) ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        System.out.println(result);

        scanner.close();
    }
}
