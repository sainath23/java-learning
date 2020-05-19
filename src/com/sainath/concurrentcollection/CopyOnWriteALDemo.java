package com.sainath.concurrentcollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteALDemo {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        list.addIfAbsent(500);
        list.add(2000);
        System.out.println(list);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1000);
        list2.add(2000);
        list2.add(3000);

        list.addAllAbsent(list2);
        System.out.println(list);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            Integer i = iterator.next();

            // iterator.remove() will produce UnsupportedOperationException
            //if (i == 300)
            //    iterator.remove();
            System.out.println(i);
        }

        List<String> list3 = new CopyOnWriteArrayList<>();
        List<String> syncList = Collections.synchronizedList(list3);
        list3.add("ABC");
        list3.add("XYZ");
        list3.add("PQR");
        Iterator<String> itr = list3.iterator();
        list3.add("MNO");
        while (itr.hasNext()) {
            String str = itr.next();
            System.out.println(str);
        }
    }
}
