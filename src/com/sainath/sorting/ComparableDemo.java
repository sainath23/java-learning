package com.sainath.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableDemo {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(5, "Sainath"));
        employees.add(new Employee(2, "Gaurav"));
        employees.add(new Employee(1, "Akshay"));
        employees.add(new Employee(4, "Chetan"));
        employees.add(new Employee(3, "Pratik"));

        System.out.println("Using comparable (sort by id)");
        System.out.println("Before sorting: " + employees);
        Collections.sort(employees);
        System.out.println("After sorting: " + employees);

        System.out.println("\n\nUsing compartor (sort by name)");
        System.out.println("Before sorting: " + employees);
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("After sorting: " + employees);

    }
}

