package com.sainath.serializations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TransientDemo implements Serializable {
    private static int VERSION = 10;
    private static transient int num1 = 100;
    private final int num2 = 200;
    private final transient int num3 = 300;
    private transient int num4 = 400;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TransientDemo demo = new TransientDemo();

        File file = new File("serialization.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(demo);

        FileInputStream fis = new FileInputStream("serialization.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        TransientDemo obj = (TransientDemo) ois.readObject();
        System.out.println("[Only static] VERSION = " + obj.VERSION);
        System.out.println("[Static transient] num1 = " + obj.num1);
        System.out.println("[Only final] num2 = " + obj.num2);
        System.out.println("[Final transient] num3 = " + obj.num3);
        System.out.println("[Only transient] num4 = " + obj.num4);
    }

}
