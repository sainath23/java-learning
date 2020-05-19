package com.sainath.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FirstNonRepeatingCharacter {

    public static int firstUniqChar(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!charCountMap.containsKey(s.charAt(i))) {
                charCountMap.put(s.charAt(i), 1);
            } else {
                charCountMap.put(s.charAt(i), charCountMap.get(s.charAt(i)) + 1);
            }
        }
        System.out.println(charCountMap);

        int index = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            int charIndex = s.indexOf(entry.getKey());
            if (entry.getValue() == 1 && charIndex < index) {
                index = charIndex;
            }
        }

        return index;
    }

    public static int firstUniqCharArray(String s) {
        char[] charFreqArr = new char[256];
        for (int i = 0; i < s.length(); i++) {
            charFreqArr[s.charAt(i)]++;
        }

        int index = -1;
        for (int i = 0; i < charFreqArr.length; i++) {
            if (charFreqArr[s.charAt(i)] == 1) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqCharArray(s));
    }

    static class IndexCount {
        int index, count;

        public IndexCount(int index) {
            this.index = index;
            this.count = 1;
        }

    }

    public static int firstUniqCharOOP(String s) {
        Map<Character, IndexCount> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), new IndexCount(i));
            } else {
                map.get(s.charAt(i)).count++;
            }
        }
        int index = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)).count == 1 && map.get(s.charAt(i)).index < index) {
                index = map.get(s.charAt(i)).index;
            }
        }
        return index == Integer.MAX_VALUE ? -1 : index;
    }
}
