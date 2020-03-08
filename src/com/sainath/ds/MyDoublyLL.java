package com.sainath.ds;

public class MyDoublyLL {

    public static void main(String[] args) {
        DoublyLinkedList<String> dll = new DoublyLinkedList<>();
        dll.add("Sainath");
        dll.add("Parkar");
        dll.add("Engineer");
        dll.add(2, "Hello");
        System.out.println(dll.size());
        dll.display();
        dll.remove("Hello");
        System.out.println(dll.size());
        dll.display();
        dll.remove("Engineer");
        System.out.println(dll.size());
        dll.display();
    }
}
