package com.sainath.lang;

import java.util.ArrayList;
import java.util.List;

public class CloneDeepCopy {

    static class University implements Cloneable {
        private String name;
        private int regNo;
        private List<String> departments;

        public University(String name, int regNo, List<String> departments) {
            this.name = name;
            this.regNo = regNo;
            this.departments = departments;
        }

        @Override
        public String toString() {
            return "University{" +
                    "name='" + name + '\'' +
                    ", regNo=" + regNo +
                    ", departments=" + departments +
                    '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            University copy = (University) super.clone();
            List<String> departmentsCopy = new ArrayList<>(copy.departments);
            copy.departments = departmentsCopy;
            return copy;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        List<String> list = new ArrayList<>();
        list.add("Computer Engineering");
        list.add("Electronics Engineering");
        list.add("Mechanical Engineering");
        list.add("Civil Engineering");
        University u1 = new University("Mumbai University", 1234, list);
        University u2 = (University) u1.clone();

        System.out.println(u1);
        System.out.println(u2);
        System.out.println("\n");

        u2.name = "Pune Univeristy";
        u2.regNo = 5678;
        u2.departments.remove(0);

        System.out.println(u1);
        System.out.println(u2);
        System.out.println("\n");
        System.out.println(u1.departments.equals(u2.departments));
    }
}
