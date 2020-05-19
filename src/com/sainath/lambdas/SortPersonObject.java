package com.sainath.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortPersonObject {
    static class Person {
        String firstName;
        String lastName;
        int age;

        public Person() {
        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        Person sainath = new Person("Sainath", "Parkar", 26);
        Person saurabh = new Person("Saurabh", "Mestry", 26);
        Person pratikS = new Person("Pratik", "Sutar", 24);
        Person pratikK = new Person("Pratik", "Khadtale", 24);
        Person gaurav = new Person("Gaurav", "Rasal", 27);
        Person shahid = new Person("Shahid", "Ansari", 23);

        List<Person> list = new ArrayList<>();
        list.add(sainath);
        list.add(saurabh);
        list.add(pratikK);
        list.add(pratikS);
        list.add(gaurav);
        list.add(shahid);

        System.out.println("Before sort:\n" + list);

        Comparator<Person> sortByAge = Comparator.comparing(p -> p.age); //(p1, p2) -> p1.age - p2.age;
        Comparator<Person> sortByFirstName = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
        Comparator<Person> sortByLastName = (p1, p2) -> p1.lastName.compareTo(p2.lastName);

        //Collections.sort(list, sortByAge);
        //System.out.println("\n\nSort by Age:\n" + list);

        // Sort by age asc. If age is equal then sort by first name asc. if both equal then sort by last name asc.
        //Collections.sort(list, Comparator.comparing(Person::getAge).thenComparing(Person::getFirstName).thenComparing(Person::getLastName));
        /*Collections.sort(list, Comparator.comparing(person -> ((Person) person).getAge())
                                        .thenComparing(person -> ((Person) person).getFirstName())
                                        .thenComparing(person -> ((Person) person).getLastName()));*/
        Collections.sort(list, sortByAge.thenComparing(sortByFirstName).thenComparing(sortByLastName));
        System.out.println("\n\nSort by Age then first and last:\n" + list);
    }
}
