package com.sainath.streams;

import java.util.HashMap;
import java.util.Map;

public class MapNewMethodsDemo {

    public static void main(String[] args) {
        Map<String, String> empAddr = new HashMap<>();
        empAddr.put("Sainath", "Jogeshwari");
        empAddr.put("Shahid", "Malad");
        empAddr.put("Gaurav", "Andheri");
        empAddr.put("Vinod", "Pune");

        System.out.println(empAddr);
        System.out.println(empAddr.getOrDefault("Pratik", "Not found"));
        System.out.println(empAddr.getOrDefault("Sainath", "Not found"));
        empAddr.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));
        System.out.println(empAddr.putIfAbsent("Pratik", "Goregaon"));
        System.out.println(empAddr);

        empAddr.compute("Vinod", (k, v) -> k + v);
        System.out.println(empAddr);

        empAddr.compute("Abhishek", (k, v) -> k + v);
        System.out.println(empAddr);

        empAddr.computeIfAbsent("Aditya", s -> s.toUpperCase());
        System.out.println(empAddr);
    }
}
