package com.sainath.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-priority-queue/problem
public class HackerRankPriorityQueu {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        Queue<Student> priorityQueue = new PriorityQueue<>((s1, s2) -> {
            if (s1.getCgpa() == s2.getCgpa() && s1.getName().equals(s2.getName())) return s1.getId() - s2.getId();
            if (s1.getCgpa() == s2.getCgpa()) return s1.getName().compareTo(s2.getName());
            else return Double.compare(s2.getCgpa(), s1.getCgpa());
        });

        for(String event : events) {
            String[] arr = event.split("\\s");
            if ("ENTER".equals(arr[0])) {
                Student student = new Student(Integer.parseInt(arr[3]), arr[1], Double.parseDouble(arr[2]));
                priorityQueue.offer(student);
            } else if ("SERVED".equals(event)) {
                Student student = priorityQueue.poll();
                System.out.println("Served: " + student);
            }
        }
        System.out.println(priorityQueue);
        List<Student> students = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            students.add(priorityQueue.poll());
        }
        return students;
    }
}

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }
}
