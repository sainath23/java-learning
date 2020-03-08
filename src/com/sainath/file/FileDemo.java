package com.sainath.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("test1.txt");
        System.out.println(file.isFile());
        boolean isFileCreated = file.createNewFile();
        System.out.println(isFileCreated);
        System.out.println(file.isFile());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.canWrite());
        FileWriter fw = new FileWriter(file);
        fw.write("Sainath");
        fw.close();
        FileReader fr = new FileReader(file);

        int ch;
        while ((ch = fr.read()) != -1) {
            System.out.print((char)ch);
        }
        System.out.println();


        //System.out.println((char)fr.read());

    }
}
