package com.sainath.concurrentcollection;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteALDemo {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            Integer i = iterator.next();

            // iterator.remove() will produce UnsupportedOperationException
            //if (i == 300)
            //    iterator.remove();
            System.out.println(i);
        }
    }
}
