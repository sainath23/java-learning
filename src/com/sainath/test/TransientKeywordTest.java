package com.sainath.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TransientKeywordTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        XYZ xyz = new XYZ();
        System.out.println(xyz.hashCode());
        FileOutputStream fos = new FileOutputStream("test.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(xyz);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.txt"));
        XYZ xyz1 = (XYZ) ois.readObject();
        System.out.println(xyz1.username);
        System.out.println(xyz1.password);
        System.out.println(xyz1.amt);
        System.out.println(xyz1.hashCode());
    }
}

class XYZ implements Serializable {
    String username = "sainath";
    transient String password = "password";
    transient int amt = 1000;
}
