package com.sainath.lang;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EqualsHashcodeTest {
    // If two objects are having same hashcode it does not mean that both objects are equal
    // If two objects are equals then it is mandatory that both object must produce same hashcode
    public static void main(String[] args) {
        Company c1 = new Company(101, "Google", "Banglore");
        Company c2 = new Company(101, "Google", "Banglore");
        Company c3 = new Company(102, "Microsoft", "Hyderabad");
        Company c4 = new Company(103, "Amazon", "Hyderabad");

        Set<Company> cSet = new HashSet<>();
        cSet.add(c1);
        cSet.add(c2);
        cSet.add(c3);
        cSet.add(c4);

        //cSet.forEach(c -> System.out.println(c));

        Map<Company, Company> map = new HashMap<>();
        map.put(c1, c1);
        map.put(c2, c2);
        map.put(c3, c2);
        map.put(c4, c2);

        //map.forEach((k, v) -> System.out.println(k + " => " + v));

        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 11);
        map1.put(2, 11);
        System.out.println(map1.hashCode());

        Map<Integer, Integer> map2 = new HashMap<>();
        map1.put(1, 11);
        map1.put(2, 11);
        System.out.println(map2.hashCode());

        System.out.println(map1.equals(map2));
    }
}
