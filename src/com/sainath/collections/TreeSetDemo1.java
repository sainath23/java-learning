package com.sainath.collections;

import java.util.Objects;
import java.util.Optional;
import java.util.TreeSet;

public class TreeSetDemo1 {
    static class Box implements Comparable<Box> {
        private String name;

        public Box(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Box box = (Box) o;
            return Objects.equals(name, box.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public int compareTo(Box o) {
            return this.name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return "Box{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        Box b1 = new Box("ABC");
        Box b2 = new Box("XYZ");
        TreeSet<Box> set = new TreeSet<>();
        set.add(b1);
        set.add(b2);
        System.out.println(set);

        b2.name = "ABC";
        System.out.println(set);
        System.out.println(b1.hashCode() + " - " + b2.hashCode());
        System.out.println(b1.equals(b2));

        set.forEach(box -> {
            System.out.println(box.hashCode());
        });

        Optional<String> optional = Optional.of("Hello");
        //Class
    }
}
