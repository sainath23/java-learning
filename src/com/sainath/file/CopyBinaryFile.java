package com.sainath.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

public class CopyBinaryFile {
    public static void main(String[] args) throws URISyntaxException {
        File inputFile = new File(CopyBinaryFile.class.getResource("/video.mp4").toURI());
        File outputFile = new File("video1.mp4");

        System.out.println(inputFile.exists());

        try(FileInputStream fis = new FileInputStream(inputFile); FileOutputStream fos = new FileOutputStream(outputFile);) {

            byte[] bytes = new byte[1024];
            int readByte = 0;

            while ((readByte = fis.read(bytes)) != -1) {
                System.out.println(String.format("Reading %s bytes", readByte));
                fos.write(bytes, 0, readByte);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
