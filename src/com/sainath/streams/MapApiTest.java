package com.sainath.streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

// putIfAbsent, putIfPresent, compute, computeIfAbsent,
public class MapApiTest {
    public static void main(String[] args) {
        Person p1 = new Person("Sainath", 26);
        Person p2 = new Person("Saurabh", 25);
        Person p3 = new Person("Gaurav", 27);
        Person p4 = new Person("Shahid", 24);
        Person p5 = new Person("Pratik", 24);
        Person p6 = new Person("Vinod", 25);

        City mumbai = new City("Mumbai");
        City pune = new City("Pune");
        City thane = new City("Thane");

        Map<City, List<Person>> map = new HashMap<>();
        map.computeIfAbsent(mumbai, city -> new ArrayList<>()).add(p1);
        map.computeIfAbsent(mumbai, city -> new ArrayList<>()).add(p2);
        map.compute(mumbai, ((city, people) -> {if(people!= null) people.add(p3); return people;}));

        System.out.println(map.getOrDefault(mumbai, new ArrayList<>()));
        System.out.println(map.getOrDefault(pune, new ArrayList<>()));
    }

    private static class City {
        String name;

        public City() {
        }

        public City(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            City city = (City) o;
            return Objects.equals(name, city.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "City{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    private static class Person {
        String name;
        int age;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
