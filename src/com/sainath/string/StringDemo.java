package com.sainath.string;

public class StringDemo {
    public static void main(String[] args) {
        String s1 = new String("Sainath");
        String s2 = "Saiinath";
        String s3 = new String("Sainath");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        String s4 = new String();
        System.out.println(s4.length());
        System.out.println("".equals(s4));
        String s5 = new String(new char[]{'a', 'b'});
        System.out.println(s5);
        String s6 = new String("sainath");
        String s7 = s6.toLowerCase();
        System.out.println(s6 == s7);
        StringBuffer sb = new StringBuffer();
        System.out.println("Initial cap: " + sb.capacity());
        sb.append("qwertyuiopasdfgh");
        //System.out.println(sb.length());
        System.out.println("after adding 16 char cap: " + sb.capacity());
        System.out.println(sb.hashCode());
        sb.append("z");
        System.out.println("after adding 17 char cap: " + sb.capacity());
        System.out.println(sb.hashCode());
        System.out.println(sb.toString());
    }
}
