package com.sainath.streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMergeMethodDemo {

    public static void main(String[] args) {
        Map<String, List<Person>> map1 = buildMap();
        Map<String, List<Person>> map2 = buildMap2();

        map2.forEach((k, v) -> {
            System.out.println("k = " + k);
            map1.merge(k, v, (existingV, newV) -> {
                System.out.println(existingV + " " + newV);
               existingV.addAll(newV);
               return existingV;
            });
        });
        System.out.println(map1);
    }

    public static Map<String, List<Person>> buildMap() {
        List<Person> mumbaiPeople = new ArrayList<>();
        mumbaiPeople.add(new Person("Sainath"));
        mumbaiPeople.add(new Person("Pratik"));

        List<Person> punePeople = new ArrayList<>();
        punePeople.add(new Person("Vinod"));
        punePeople.add(new Person("Chetan"));
        punePeople.add(new Person("Akshay"));

        List<Person> thanePeople = new ArrayList<>();
        thanePeople.add(new Person("Saurabh"));
        thanePeople.add(new Person("Gaurav"));

        Map<String, List<Person>> cityPeopleMap = new HashMap<>();
        cityPeopleMap.put("Mumbai", mumbaiPeople);
        cityPeopleMap.put("Pune", punePeople);
        cityPeopleMap.put("Thane", thanePeople);
        return cityPeopleMap;
    }

    public static Map<String, List<Person>> buildMap2() {
        List<Person> mumbaiPeople = new ArrayList<>();
        mumbaiPeople.add(new Person("Amit"));

        List<Person> punePeople = new ArrayList<>();
        punePeople.add(new Person("Govind"));
        punePeople.add(new Person("Nagnath"));

        List<Person> naviMumbaiPeople = new ArrayList<>();
        naviMumbaiPeople.add(new Person("Omkar"));
        naviMumbaiPeople.add(new Person("Mukesh"));

        Map<String, List<Person>> cityPeopleMap = new HashMap<>();
        cityPeopleMap.put("Mumbai", mumbaiPeople);
        cityPeopleMap.put("Pune", punePeople);
        cityPeopleMap.put("Navi Mumbai", naviMumbaiPeople);
        return cityPeopleMap;
    }

    private static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
