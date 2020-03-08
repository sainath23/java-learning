package com.sainath.test;

public class FIndSystemInfo {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int cpus = runtime.availableProcessors();
        System.out.println("Total CPU = " + cpus);

    }
}
