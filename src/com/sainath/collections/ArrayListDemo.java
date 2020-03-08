package com.sainath.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for(int i = 10; i <= 101; i = i + 10) {
            list.add(i);
        }

        System.out.println(list);
        list.removeIf(el -> el == 40);
        System.out.println(list);

        ArrayList<Integer> list2 = new ArrayList<>(list);
        System.out.println(list2);

        list2.remove(Integer.valueOf(100));
        System.out.println(list2);

        System.out.println("Before removeAll: " + list);

        List<Integer> list3 = new ArrayList<>();
        list3.add(10);
        list3.add(20);
        list3.add(110);
        //list.removeAll(list3);

        System.out.println("After removeAll: " + list);
        list.retainAll(list3);
        System.out.println("After retainAll: " + list);
        list.add(1, 30);
        System.out.println("After adding 30 at 1" + list);
        list.set(1, 40);
        System.out.println("After setting 40 at 1" + list);

        Animal a = new Dog();
        a.speak();
    }
}

class Animal {
    public Animal() {
        System.out.println("I am in animal");
    }
    public void speak() {
        System.out.println("Animal speak");
    }
}

class Dog extends Animal {
    public Dog() {
        System.out.println("I am in dog");
    }

    @Override
    public void speak() {
        System.out.println("Dog speak");
        super.speak();
    }
}
