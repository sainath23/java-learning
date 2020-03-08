package com.sainath.reflections;

import java.lang.reflect.Method;

public class ReflectionTest {

    public static void main(String[] args) {
        Class<Student> student = Student.class;
        Method[] methods = student.getDeclaredMethods();
        /*for (Method m : methods) {
            System.out.println(m.getName());
        }*/


        Class<Object> objectClass = Object.class;
        Method[] methods1 = objectClass.getDeclaredMethods();
        for (Method m : methods1) {
            System.out.println(m.getName());
        }
    }
}

class Student {
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}