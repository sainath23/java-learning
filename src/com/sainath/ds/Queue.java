package com.sainath.ds;

public class Queue {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<Integer> front;
    private Node<Integer> rear;
    private int length = 0;

    private int getLength() {
        return length;
    }

    private boolean isEmpty() {
        return length == 0;
    }

    private void enqueue(Integer data) {
        Node<Integer> tempNode = new Node<>(data);
        if (isEmpty()) {
            front = tempNode;
        } else {
            rear.next = tempNode;
        }
        rear = tempNode;
        length++;
    }

    private int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        length--;

        return data;
    }

    private void display() {
        if (isEmpty()) {
            System.out.println("null");
            return;
        }
        Node<Integer> currentNode = front;
        while (currentNode != null) {
            System.out.print(currentNode.data + " => ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("After inserting five nodes length = " + queue.length);
        queue.display();

        System.out.println("Enqueue 60");
        queue.enqueue(60);
        queue.display();

        System.out.println("After dequeue => " + queue.dequeue());
        queue.display();

        System.out.println("After dequeue all");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.display();

        System.out.println("Trying to dequeue empty queue");
        queue.dequeue();
    }
}
