package com.sainath.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class MapFilterReduceDemo1 {
    public static void main(String[] args) {
        // Computer avg of age of Students whose age < 15
        Student sainath = new Student(1, "Sainath", 14);
        Student gaurav = new Student(2, "Gaurav", 8);
        Student saurabh = new Student(3, "Saurabh", 20);
        Student shahid = new Student(4, "Shahid", 13);
        Student pratik = new Student(5, "Pratik", 18);
        Student vinod = new Student(6, "Vinod", 15);

        List<Student> studentList = new ArrayList<>();
        studentList.add(sainath);
        studentList.add(gaurav);
        studentList.add(saurabh);
        studentList.add(shahid);
        studentList.add(pratik);
        studentList.add(vinod);
        studentList.forEach(System.out::println);

        oldWay(studentList);

        OptionalDouble avg = studentList.stream().mapToInt(Student::getAge).filter(age -> age <= 15).average();
        System.out.println(avg.getAsDouble());

        Optional<Integer> optional = studentList.stream().map(Student::getAge).filter(age -> age <= 15).max(Comparator.naturalOrder());
        System.out.println(optional.get());
        System.out.println(studentList.stream().filter(student -> student.getAge() <= 15).max(Comparator.comparingInt(Student::getAge)));


        Stream<String> stringStream = Stream.generate(() -> "one").limit(10);
        stringStream.forEach(System.out::println);

        Stream<String> stringStream1 = Stream.iterate("+", s -> s + "+");
        stringStream1.limit(5).forEach(System.out::println);

        ThreadLocalRandom.current().ints().limit(100).map(i -> Math.abs(i % 100)).forEach(System.out::println);
    }

    public static void oldWay(List<Student> list) {
        int ageSum = 0;
        int studentCount = 0;

        for (Student s : list) {
            if (s.getAge() <= 15) {
                ageSum += s.getAge();
                studentCount++;
            }
        }

        int avg = 0;
        if (studentCount > 0) {
            avg = ageSum / studentCount;
        }
        System.out.println(avg);
    }
}
