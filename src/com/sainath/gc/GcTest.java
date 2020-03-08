package com.sainath.gc;

public class GcTest {

    private String objName;

    public GcTest(String objName) {
        this.objName = objName;
    }

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("1: " + runtime.totalMemory());
        System.out.println("2: " + runtime.freeMemory());
        show();
        /*GcTest gcTest = new GcTest("gctest");
        gcTest = null;*/
        for (int i = 0; i <=20_00_000000; i++) {
            GcTest gcTest = new GcTest("obj " + i);
            gcTest = null;
        }
        System.out.println("3: " + runtime.freeMemory());
        runtime.gc();
        System.out.println("4: " + runtime.freeMemory());
    }

    public static void show() {
        GcTest obj1 = new GcTest("obj1");
        display();
    }

    public static void display() {
        GcTest obj2 = new GcTest("obj1");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        //AnotherClass.doSomething();
        System.out.println(Thread.currentThread().getName() + " = " + this.objName + " successfully garbage collected...");
    }


}