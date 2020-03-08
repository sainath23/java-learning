package com.sainath.multithreading;

import java.util.Map;
import java.util.concurrent.*;

/*
* Problem: There are three APIs which provides prices for one product.
* Your job is to call those APIs concurrently and fetch prices.
* Your job should wait max of 3 seconds.
 */
public class ScatterAndGatherProblemCountDownLatch {

    private class Task implements Runnable {
        private int productId;
        private String websiteName;
        private Map<String, Integer> websitePriceMap;
        private CountDownLatch countDownLatch;

        public Task(int productId, String websiteName, Map<String, Integer> websitePriceMap, CountDownLatch countDownLatch) {
            this.productId = productId;
            this.websiteName = websiteName;
            this.websitePriceMap = websitePriceMap;
            this.countDownLatch = countDownLatch;
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
                countDownLatch.countDown();
            } else if ("Flipkart".equals(websiteName)) {
                // Some logic to find productId on flipkart.
                // Here I am going to sleep to mimic
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                websitePriceMap.put(websiteName, 12000);
                countDownLatch.countDown();
            } else if ("Snapdeal".equals(websiteName)) {
                // Some logic to find productId on snapdeal.
                // Here I am going to sleep to mimic
                try {
                    Thread.sleep(1000); // Play with sleep values
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                websitePriceMap.put(websiteName, 8000);
                countDownLatch.countDown();
            }
        }
    }

    public void test() throws InterruptedException {
        Map<String, Integer> websitePriceMap = new ConcurrentHashMap<>();
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        threadPool.execute(new Task(1, "Amazon", websitePriceMap, countDownLatch));
        threadPool.execute(new Task(1, "Flipkart", websitePriceMap, countDownLatch));
        threadPool.execute(new Task(1, "Snapdeal", websitePriceMap, countDownLatch));

        threadPool.shutdown();

        // One way to wait till 3 seconds is using Thread.sleep(3000) but it is inefficient i.e.
        // What if all APIs return in 2 seconds ? we forcefully have to wait till 3 using sleep method
        // We can use countDownLatch set to 3 and pass it to job.
        // We can call await method till 3 seconds. await with time unit wait till time, or interrupt or
        // if countDownLatch count is 0 within specified time let's say in 2 seconds

        long startTime = System.currentTimeMillis();
        countDownLatch.await(3, TimeUnit.SECONDS);
        long endTime = System.currentTimeMillis();
        long takenTime = (endTime - startTime) / 1000;

        System.out.println("Total time taken = " + takenTime + " seconds");
        System.out.println("Prices = " + websitePriceMap);
        System.out.println("Final latch count = " + countDownLatch.getCount());
    }

    public static void main(String[] args) throws InterruptedException {
        ScatterAndGatherProblemCountDownLatch problem = new ScatterAndGatherProblemCountDownLatch();
        problem.test();
    }
}
