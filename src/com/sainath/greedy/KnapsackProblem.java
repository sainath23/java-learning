package com.sainath.greedy;

import java.util.Arrays;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] wt = {10, 40, 20, 30};
        int[] val = {60, 40, 100, 120};
        int capacity = 50;

        ItemValue[] itemValues = new ItemValue[wt.length];
        for (int i = 0; i < wt.length; i++) {
            itemValues[i] = new ItemValue(wt[i], val[i], i);
        }

        Arrays.sort(itemValues, (o1, o2) -> o2.cost.compareTo(o1.cost));
        //System.out.println(Arrays.toString(itemValues));
        double maxProfit = 0;
        for (ItemValue itemValue : itemValues) {
            if (capacity - itemValue.wt >= 0) {
                maxProfit += itemValue.val;
                capacity -= itemValue.wt;
            } else {
                double fraction = (double) capacity / (double) itemValue.wt;
                maxProfit += (fraction * itemValue.val);
                capacity = (int) (capacity - (itemValue.wt * fraction));
                break;
            }
        }
        System.out.println("Max profit = " + maxProfit);
    }

    private static class ItemValue {
        Double cost;
        int wt;
        int val;
        int index;

        ItemValue(int wt, int val, int index) {
            this.wt = wt;
            this.val = val;
            this.index = index;
            cost = (double) val / wt;
        }

        @Override
        public String toString() {
            return "ItemValue{" +
                    "cost=" + cost + "}";
        }
    }
}
