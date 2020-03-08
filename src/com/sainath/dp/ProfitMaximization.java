package com.sainath.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProfitMaximization {

    public static void main(String[] args) {
        //int[] array = {1, 2, 3, 4, 9, 8}; // 1 + 2 + 4 + 8
        //int[] array = {4, 7, 21, 26, 28, 29, 32, 34, 36, 42}; // 7 + 21 + 42
        int[] array = {1, 3, 13, 31, 33, 34, 44, 46, 50, 62, 64, 65, 69, 70, 74, 75, 77, 94, 105, 108, 109,
                        111, 114, 115, 116, 126, 128, 132, 139, 145, 146, 149, 153, 157, 158, 164, 166, 175,
                        178, 187, 188, 195, 197, 198, 201, 204, 207, 208, 209, 210, 212, 218, 222, 237, 242,
                        244, 247, 252, 255, 263, 264, 266, 273, 276, 277, 284, 292, 294, 300, 308, 325, 335,
                        338, 342, 346, 348, 351, 352, 353, 354, 356, 365, 370, 373, 382, 384, 385, 398, 405,
                        410, 426, 427, 428, 447, 448, 455, 457, 459, 465, 497};
        /*int[] array = {35, 219, 218, 405, 494, 437, 26, 30, 308, 321, 72, 231, 155, 383, 147, 5, 60, 217, 91,
                        475, 36, 236, 34, 180, 376, 33, 411, 438, 82, 142, 68, 182, 189, 287, 256, 293, 452, 156,
                        200, 199, 87, 474, 274, 312, 320, 366, 459, 441, 372, 230};*/

        Map<String, Integer> map = new HashMap<>();
        //String key = array[1] + " % " + array[0];
        //map.put(key, array[1] % array[0]);
        System.out.println(findMaxProfit(array, 0, 1, map));
        //System.out.println(findMaxProfitBF(array, 0, 1));
    }

    public static int findMaxProfit(int[] array, int i,  int j, Map<String, Integer> map) {

        if (i == array.length - 1) {
            return array[i];
        }

        if (i > array.length - 1) {
            return 0;
        }

        if (j > array.length - 1) {
            return 0;
        }

        if (array[j] < array[i]) {
            return 0;
        }

        int reminder = array[j] % array[i];

        String key = array[j] + " % " + array[i];
        System.out.println(map);
        if (map.containsKey(key)) {
            if (map.get(key) == 0) {
                return Math.max(array[i] + findMaxProfit(array, j, j + 1, map), findMaxProfit(array, i + 1, j + 1, map));
            } else {
                return Math.max(findMaxProfit(array, i + 1, j + 1, map), findMaxProfit(array, i, j+1, map));
            }
        } else {
            map.put(key, reminder);
            if (reminder == 0) {
                return Math.max(array[i] + findMaxProfit(array, j, j + 1, map), findMaxProfit(array, i + 1, j + 1, map));
            } else {
                return Math.max(findMaxProfit(array, i + 1, j + 1, map), findMaxProfit(array, i, j+1, map));
            }
        }
    }

    // Old
    public static int findMaxProfitBF(int[] array, int i,  int j) {
        if (i == array.length - 1) {
            return array[i];
        }

        if (i > array.length - 1) {
            return 0;
        }

        if (j > array.length - 1) {
            return 0;
        }

        if (array[j] < array[i]) {
            return 0;
        }
        //System.out.println(i + " === " + j);
        int reminder = array[j] % array[i];
        if (reminder == 0) {
            return Math.max(array[i] + findMaxProfitBF(array, j, j + 1), findMaxProfitBF(array, i + 1, j + 1));
        } else {
            return Math.max(findMaxProfitBF(array, i + 1, j + 1), findMaxProfitBF(array, i, j+1));
        }

    }
}
/*
    3 +


 */