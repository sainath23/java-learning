package com.sainath.lang;

import java.util.Calendar;
import java.util.Date;

final class Student {
    private final int rollNo;
    private final String name;
    private final Date dob;
    private final StringBuilder address;

    public Student(int rollNo, String name, Date dob, StringBuilder address) {
        this.rollNo = rollNo;
        this.name = name;
        this.dob = new Date(dob.getTime());
        this.address = new StringBuilder(address);
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return new Date(dob.getTime());
    }

    public StringBuilder getAddress() {
        return new StringBuilder(address);
    }

    @Override
    public String toString() {
        return "Student{rollNo=" + rollNo + ", name='" + name + '\'' + ", dob=" + dob +
                ", address=" + address + '}';
    }
}

public class ImmutableClassDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1993, Calendar.DECEMBER, 23);
        Date dob = calendar.getTime();
        StringBuilder address = new StringBuilder("Mumbai, India");
        Student student = new Student(101, "Sainath", dob, address);
        System.out.println("Immutable object is created:\n" + student);
        // Make some changes in dob and address
        dob.setTime(System.currentTimeMillis());
        address.append("Hahaha");
        System.out.println("First attempt to break:\n" + student);
        Date date = student.getDob();
        StringBuilder sb = student.getAddress();
        date.setTime(System.currentTimeMillis());
        sb.append("Hello...");
        System.out.println("Second attempt to break:\n" + student);
    }
}