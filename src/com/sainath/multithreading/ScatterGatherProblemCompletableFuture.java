package com.sainath.multithreading;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ScatterGatherProblemCompletableFuture {
    private class Task implements Runnable {
        private int productId;
        private String websiteName;
        private Map<String, Integer> websitePriceMap;

        public Task(int productId, String websiteName, Map<String, Integer> websitePriceMap) {
            this.productId = productId;
            this.websiteName = websiteName;
            this.websitePriceMap = websitePriceMap;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " trying to fetch price for " + websiteName);
            // I have to mimic real behaviour here.
            if ("Amazon".equals(websiteName)) {
                // Some logic to find productId on amazon.
                // Here I am going to sleep to mimic
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                websitePriceMap.put(websiteName, 10000);
            } else if ("Flipkart".equals(websiteName)) {
                // Some logic to find productId on flipkart.
                // Here I am going to sleep to mimic
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                websitePriceMap.put(websiteName, 12000);
            } else if ("Snapdeal".equals(websiteName)) {
                // Some logic to find productId on snapdeal.
                // Here I am going to sleep to mimic
                try {
                    Thread.sleep(4000); // Play with sleep values
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                websitePriceMap.put(websiteName, 8000);
            }
        }
    }

    public void test() {
        Map<String, Integer> websitePriceMap = new ConcurrentHashMap<>();
        CompletableFuture<Void> task1 = CompletableFuture.runAsync(new Task(1, "Amazon", websitePriceMap));
        CompletableFuture<Void> task2 = CompletableFuture.runAsync(new Task(1, "Flipkart", websitePriceMap));
        CompletableFuture<Void> task3 = CompletableFuture.runAsync(new Task(1, "Snapdeal", websitePriceMap));

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);

        long startTime = System.currentTimeMillis();

        try {
            allTasks.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long takenTime = (endTime - startTime) / 1000;

        System.out.println("Total time taken = " + takenTime + " seconds");
        System.out.println("Prices = " + websitePriceMap);
    }

    public static void main(String[] args) {
        ScatterGatherProblemCompletableFuture future = new ScatterGatherProblemCompletableFuture();
        future.test();
    }
}
