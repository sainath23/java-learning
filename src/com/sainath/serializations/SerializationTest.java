package com.sainath.serializations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;

public class SerializationTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File file = new File("test.txt");
        System.out.println(file.isFile());

        ClassToSerialize st = new ClassToSerialize();

        /*FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(st);*/

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ClassToSerialize st1 = (ClassToSerialize) ois.readObject();
        /*System.out.println(st1.getX());
        System.out.println(st1.getStr());
        System.out.println(st1.getPassword());*/
        //System.out.println(st1.getY());
        //Collections.synchronizedList()
    }

}
