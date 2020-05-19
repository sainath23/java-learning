package com.sainath.serializations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ParentClassNotSerialized {
    static class Animal /*implements Serializable*/ {
        String animalName = "Animal";
        Animal() {
            System.out.println("Animal constructor called...");
        }
    }

    static class Dog extends Animal implements Serializable {
        String name = "Dog";
    }

    public static void main(String[] args) throws Exception {
        Dog d = new Dog();
        d.animalName = "My Animal";
        d.name = "My Dog";
        System.out.println("Animal name = " + d.animalName + ", Dog name = " + d.name);

        File file = new File("serialization_inheritance.txt");

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(d);

        System.out.println("\nDe-serializing....\n");

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Dog d1 = (Dog) ois.readObject();

        System.out.println("Animal name = " + d1.animalName + ", Dog name = " + d1.name);
    }
}
