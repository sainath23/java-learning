package com.sainath.lang;

import java.io.Closeable;
import java.io.IOException;

public class CloseableDemo {

    static class MyResource implements Closeable {

        public MyResource() throws IOException {
        }

        @Override
        public void close() throws IOException {
            System.out.println("Closing the resource");
        }
    }

    public static void main(String[] args) {
        try(MyResource m1 = new MyResource()) {
            System.out.println("Inside try");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
