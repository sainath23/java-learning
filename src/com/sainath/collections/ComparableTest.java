package com.sainath.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest {

    private class Movie implements Comparable<Movie> {
        private int year;
        private String name;

        public Movie(int year, String name) {
            this.year = year;
            this.name = name;
        }

        @Override
        public int compareTo(Movie o) {
            System.out.println("this year = " + this.year + " compareTo year = " + o.year);
            return this.year - o.year;
        }

        @Override
        public String toString() {
            return "Movie{" +
                    "year=" + year +
                    ", name=" + name +
                    '}';
        }
    }

    public static void main(String[] args) {
        ComparableTest ct = new ComparableTest();
        Movie abc = ct.new Movie(2010, "ABC Movie");
        Movie xyz = ct.new Movie(2000, "XYZ Movie");
        Movie pqr = ct.new Movie(2018, "PQR Movie");
        Movie mno = ct.new Movie(1999, "MNO Movie");

        List<Movie> list = new ArrayList<>();
        list.add(abc);
        list.add(xyz);
        list.add(pqr);
        list.add(mno);

        System.out.println("Movie list before sort: " + list);

        Collections.sort(list);

        System.out.println("Movie list after sort: " + list);

        System.out.println(Collections.binarySearch(list, abc));
    }
}
