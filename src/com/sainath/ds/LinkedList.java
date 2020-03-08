package com.sainath.ds;

import java.util.Scanner;

public class LinkedList {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private static Node<Integer> head;

    public static void main(String[] args) {
        // 100 -> 200 -> 300 -> 400 -> 500
        head = new Node<>(100);
        Node<Integer> second = new Node<>(200);
        Node<Integer> third = new Node<>(300);
        Node<Integer> fourth = new Node<>(400);
        Node<Integer> fifth = new Node<>(500);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        System.out.println("Display initial LL");
        display();

        System.out.println("\nSize of initial LL = " + size());

        System.out.println("\nInserting 50 at beginning");
        Node<Integer> newHeadNode = new Node<>(50);
        newHeadNode.next = head;
        head = newHeadNode;
        display();

        System.out.println("\nInserting 600 at end");
        insertAtEnd(new Node<>(600));
        display();

        System.out.println("\nInserting 450 between 400 and 500");
        Integer newData = 400;
        insertBetween(new Node<>(450), newData);
        display();

        System.out.println("\nSearch 450 from the LL and get index");
        Integer searchData = 450;
        System.out.println("450 found at index = " + search(searchData));

        int index = 4;
        System.out.println("\nData at index 4 = " + get(index));

        System.out.println("Before reverse:");
        display();
        reverse();
        System.out.println("After reverse");
        display();
    }

    private static void display() {
        // Iterate over linked list and print data
        Node<Integer> current = head;
        while(current != null) {
            System.out.print(current.data + " => ");
            current = current.next;
        }
        System.out.println("null");
    }

    private static void insertAtEnd(Node<Integer> node) {
        Node<Integer> current = head;
        while (current != null) {
            if (current.next == null) {
                current.next = node;
                break;
            }
            current = current.next;
        }
    }

    private static void insertBetween(Node<Integer> node, Integer data) {
        Node<Integer> current = head;
        while (true) {
            if(current.data.equals(data)) {
                node.next = current.next;
                current.next = node;
                break;
            }
            current = current.next;
        }
    }

    private static int search(Integer data) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(data))
                return index;
            index++;
            current = current.next;
        }
        return -1;
    }

    private static Integer get(int index) {
        if (index > size()) {
            return -1;
        }
        Node<Integer> current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }
        return -1;
    }

    private static int size() {
        if (head == null)
            return 0;

        Node current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    private static void reverse() {
        if(head == null) {
            return;
        }

        Node<Integer> current = head;
        Node<Integer> next = null;
        Node<Integer> previous = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }
}