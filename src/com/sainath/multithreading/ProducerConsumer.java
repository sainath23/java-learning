package com.sainath.multithreading;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Runnable pRunnable = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ProducerThread pt = new ProducerThread();
            pt.produce(list);
        };

        Runnable cRunnable = () -> {
            ConsumerThread pt = new ConsumerThread();
            try {
                pt.consume(list);
                /*for (int i = 0; i < 5; i++) {
                    if (i % 2 == 0)
                        System.out.print("+");
                    else
                        System.out.print("-");
                }
                System.out.println();

                String str = "jSainath";
                String ch = str.substring(0,1);
                Character.isUpperCase(str.charAt(0));

                if (ch.matches("\\d")) {
                    System.out.println(ch + " is digit");
                } else if (ch.matches("[A-Z]")) {
                    System.out.println(ch + " is uppercase");
                } else if (ch.matches("[a-z]")) {
                    System.out.println(ch + " is lowercase");
                }

                String[] arr = {"aD0aclsdkf3lksD", "wqwqwassdsdsdsdxdsaD", "434dsdsdsDS", "dsdEd"};
                String password = "";
                int length = 0;
                String pattern = "[A-Za-z]+";
                for (String pass : arr) {
                    if (pass.matches(pattern) && pass.length() > length) {
                        System.out.println("Curr = " + pass);
                        password = pass;
                        length = pass.length();
                    }
                }
                System.out.println("Longest password: " + password);*/
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread pThread = new Thread(pRunnable);
        Thread cThread = new Thread(cRunnable);

        pThread.start();
        cThread.start();
    }

}

class ConsumerThread {

    public void consume(List<Integer> queue) throws InterruptedException {

        synchronized (queue) {
            if (queue.isEmpty()) {
                System.out.println("Consumer is waiting...");
                queue.wait();
                System.out.println("Consumer gets notification...");
            }

            queue.forEach(System.out::println);
            System.out.println("Consumer completed...");
        }
    }
}

class ProducerThread {
    public void produce(List<Integer> queue) {
        synchronized (queue) {
            System.out.println("Producer going to produce...");
            for (int i = 1; i <=10000; i++) {
                queue.add(i);
            }
            queue.notify();
            System.out.println("Producer sent notification...");
        }
    }
}