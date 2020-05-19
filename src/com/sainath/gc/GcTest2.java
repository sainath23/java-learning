package com.sainath.gc;

public class GcTest2 {

    public static void main(String[] args) throws InterruptedException {
        String s = new String("SA");
        s = null;
        System.gc();
        Thread.sleep(1000);
        System.out.println("sain");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finazlin");
    }
}
