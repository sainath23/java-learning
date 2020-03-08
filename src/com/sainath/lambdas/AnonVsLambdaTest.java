package com.sainath.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnonVsLambdaTest {
    private int x = 100;
    private int abc = 500;

    public void anonInnerClassTest(int a, int b) {
        MyFunctionalI m = new MyFunctionalI() {
            int x = 200;
            @Override
            public int doSomething(int a, int b) {
                System.out.println(this);
                System.out.println(AnonVsLambdaTest.this);
                return a + b + this.x + AnonVsLambdaTest.this.x + abc + x;
            }
        };
        System.out.println("anonInnerClassTest = " + m.doSomething(a, b));
    }

    public void lambdaTest(int a1, int b1) {
        int d = 10;
        MyFunctionalI m = (a, b) -> {
            int x = 200;
          return a + b + this.x + d;
        };
        System.out.println("lambdaTest = " + m.doSomething(a1, b1));
    }

    public static void main(String[] args) {
        AnonVsLambdaTest t = new AnonVsLambdaTest();
        System.out.println(t);
        t.anonInnerClassTest(10, 20);
        t.lambdaTest(10, 20);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream().map(i -> i * 2).filter(i -> i == 0).collect(Collectors.toList());
    }

}

interface MyFunctionalI {
    int doSomething(int a, int b);
}
