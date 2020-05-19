package com.sainath.serializations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationMutipleObj {

    static class Dog implements Serializable {
        public String name = "Dog";
    }

    static class Cat implements Serializable {
        public String name = "Cat";
    }

    static class Fish implements Serializable {
        public String name = "Fish";
    }

    public static void main(String[] args) throws Exception {
        Dog d = new Dog();
        Cat c = new Cat();
        Fish f = new Fish();

        File file = new File("serialization2.txt");

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(d);
        oos.writeObject(c);
        oos.writeObject(f);

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        while (fis.available() > 0) {
            Object obj = ois.readObject();
            if (obj instanceof Dog) {
                System.out.println(((Dog)obj).name);
            } else if (obj instanceof Cat) {
                System.out.println(((Cat)obj).name);
            } else if (obj instanceof Fish) {
                System.out.println(((Fish)obj).name);
            }
        }
    }
}
