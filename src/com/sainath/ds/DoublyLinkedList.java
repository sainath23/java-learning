package com.sainath.ds;

public class DoublyLinkedList<T> {

    // Node representation
    private class Node<T> {
        Node<T> prev;
        Node<T> next;
        T data;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "prev=" + prev +
                    ", next=" + next +
                    ", data=" + data +
                    '}';
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Add element at last or tail of DLL
     * @param data
     */
    public void add(T data) {
        if (head == null) {
            head = new Node<>(data);
            tail = head;
            size = 1;
        } else {
            Node<T> node = new Node<>(data);
            node.prev = tail;
            tail.next = node;
            tail = node;
            size++;
        }
    }

    /**
     * Add element at given index
     * @param index
     * @param data
     */
    public void add(int index, T data) {
        int i = 1;
        Node<T> node = new Node<>(data);
        Node<T> currentNode = head;
        while (i <= index) {
            currentNode = currentNode.next;
            i++;
        }
        node.prev = currentNode.prev;
        node.next = currentNode;
        currentNode.prev.next = node;
        currentNode.prev = node;
        if (index == size)
            tail = node;
        size++;
    }

    public void remove(T data) {
        Node<T> currentNode = head;
        while (currentNode.data != data) {
            currentNode = currentNode.next;
        }
        if (currentNode == head) {
            head = head.next;
            head.prev = null;
            size--;
            return;
        }
        if (currentNode == tail) {
            tail = tail.prev;
            tail.next = null;
            size--;
            return;
        }
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
        size--;
    }

    public void display() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public int size() {
        return size;
    }
}
