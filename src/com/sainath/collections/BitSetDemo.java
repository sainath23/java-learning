package com.sainath.collections;

import java.util.Arrays;
import java.util.BitSet;

public class BitSetDemo {
    private final String str;

    public BitSetDemo() {
        str = "";
    }

    public static void main(String[] args) {
        BitSet b1 = new BitSet(4);
        BitSet b2 = new BitSet(4);

        b1.set(0, true);
        b1.set(1, true);
        b1.set(2, true);
        b1.set(3, true);

        b2.set(0, true);
        b2.set(1, true);
        b2.set(2, true);
        b2.set(3, true);
        System.out.println(b1);
        b1.and(b2);
        System.out.println(b1.stream().count());
    }
}
