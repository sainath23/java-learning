package com.sainath.serializations;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternalizationDemo {
    static class Student implements Externalizable {
        private transient String name;
        private int age;
        private int id;
        private String location;

        public Student() { // Required otherwise we will get RE InvalidClassException
                            // No arg constructor is required because JVM has to create
                            // a separate new object and then it will call readExternal() method
            System.out.println("No-arg constructor called...");
        }

        public Student(String name, int age, String location, int id) {
            this.name = name;
            this.age = age;
            this.location = location;
            this.id = id;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(name); // Even though name is transient this code will save its state
            out.writeInt(age);
            out.writeObject(location);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            name = (String) in.readObject();
            age = in.readInt();
            location = (String) in.readObject();
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", id=" + id +
                    ", location='" + location + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        Student student = new Student("Sainath", 26, "Mumbai", 1234);
        System.out.println(student);

        File file = new File("externalization.txt");

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(student);

        System.out.println("\nDe-serializing....\n");

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student student1 = (Student) ois.readObject();

        System.out.println(student1.toString());
    }
}
