package com.sainath.multithreading;

public class WaitDemo {
    
    public static void main(String[] args) {
        System.out.print("1 ");
        synchronized (args) {
            System.out.print("2 ");
            try {
                args.wait();
            } catch (InterruptedException e) {}
        }
        System.out.print("3 ");
    }
}
