package com.sainath.lang;

public class StringDemo {
    public static void main(String[] args) {
        String str = "Sainath";
        System.out.println(str.contains("S"));

        StringBuilder sb = new StringBuilder("Sainath");
        System.out.println(sb.indexOf("ss"));
        String a = "ABC"; // Creates only one obj in SCP
        String b = "ABC"; // Obj is already created in SCP so refer that obj
        System.out.println(a == b); // true
        String c = new String("ABC"); // It created two objects one in heap and second in SCP
        System.out.println(a == c); // false
        c = c.intern(); // Interning String object. Now 'c' will point String from SCP
        System.out.println(a == c); // true

        String s = null;
        // System.out.println(s.concat("ABC")); // throws NLP Exc
        System.out.println(s + " ABC" + 1 + 'a');

        String name = "Java"; // Create one obj in SCP
        // When you use concat() method concatenated string is only placed in heap not in SCP
        // This is because concat() is a runtime method call
        name = name.concat(" Programming Language"); // Creates one new concatenated obj in heap
                                                    // because of runtime method call
                                                    // and create one literal obj " Programming Language" in SCP
        String phrase = "Java Programming Language"; // Create one obj in SCP
        System.out.println(name == phrase); // false

        name = name.intern();
        System.out.println(name == phrase); // true
    }
}
