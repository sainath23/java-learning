package com.sainath.serializations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CustomizedSerializationDemo {

    static class Account implements Serializable {
        private String name = "Sainath";
        private transient String password = "mypassword";
        private transient int pin = 1234;

        // Add following callback methods with exact signature.
        // These methods executed automatically by JVM when you serialize
        // and deserialize the object ex. oos.writeObject(obj) and ois.readObject()
        private void writeObject(ObjectOutputStream oos) throws Exception {
            oos.defaultWriteObject(); // Performs default serialization
            String ePassword = 123 + password;
            int ePin = 4444 + pin;
            oos.writeObject(ePassword);
            oos.writeInt(ePin);
        }

        private void readObject(ObjectInputStream ois) throws Exception {
            ois.defaultReadObject(); // Performs default deserialization

            // Order of deserialization must be same as serialization
            String ePassword = (String) ois.readObject();
            int ePin = ois.readInt();

            password = ePassword.substring(3);
            pin = ePin - 4444;
        }
    }

    public static void main(String[] args) throws Exception {
        Account account = new Account();
        System.out.println("Before serialization: name = " + account.name + ", password = " + account.password + ", pin = " + account.pin);

        File file = new File("custom_serialization.txt");

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(account);

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Account account1 = (Account) ois.readObject();
        System.out.println("After serialization: name = " + account1.name + ", password = " + account1.password + ", pin = " + account1.pin);
    }
}
