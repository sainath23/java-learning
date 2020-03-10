package com.sainath.ds;

import java.util.Objects;

public class MyHashTable<K, V> {

    private Node<K, V>[] table;
    private int capacity;

    static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public MyHashTable(int capacity) {
        this.table = (Node<K, V>[]) new Node<?, ?>[capacity];
        this.capacity = capacity;
    }

    public MyHashTable() {
        this.capacity = 16;
        this.table = (Node<K, V>[]) new Node<?, ?>[capacity];
    }

    public void put(K key, V value) {
        // if key == null
        if (key == null) throw new NullPointerException("Key cannot be null");

        // Calculate hash code
        int hashCode = Objects.hashCode(key);
        //System.out.println("key = " + key + " hascode = " + hashCode);

        // find table index
        int index = hashCode % (capacity - 1);
        //System.out.println("Key = " + key + " Index = " + index);

        // check if key is present at that index. If present replace the value
        // Else add new entry
        Node<K, V> current = table[index];

        // If current is null then add
        if (current == null) {
            table[index] = new Node<>(hashCode, key, value, null);
            return;
        }

        Node<K, V> tempNode = current;
        while (tempNode != null) {
            if (tempNode.key.hashCode() == hashCode) {
                tempNode.value = value;
                return;
            }
            tempNode = tempNode.next;
        }
        Node<K, V> newNode = new Node<>(hashCode, key, value, current);
        table[index] = newNode;
    }

    public V remove(K key) {
        if (key == null) throw new NullPointerException("Key is null");

        // Find hashcode
        int hashCode = Objects.hashCode(key);

        // Find index
        int index = hashCode % (capacity - 1);

        Node<K, V> current = table[index];

        if (current == null) return null;

        if (current.key.hashCode() == hashCode && current.key.equals(key)) {
            V value = current.value;
            table[index] = current.next;
            //current = null;
            return value;
        }

        // Find prev of node to be deleted
        Node<K, V> prevNode = null;

        while (current.next != null) {
            if (current.next.key.hashCode() == hashCode && current.next.key.equals(key)) {
                prevNode = current;
            }
            current = current.next;
        }

        if (prevNode != null) {
            V value = prevNode.next.value;
            prevNode.next = prevNode.next.next;
            return value;
        }

        return null;
    }

    public void iterate() {
        for(Node<K, V> node : table) {
            while (node != null) {
                System.out.println(String.format("Key = %s, Value = %s", node.key, node.value));
                node = node.next;
            }
        }
    }

    public static void main(String[] args) {
        MyHashTable<Integer, String> hashTable = new MyHashTable<>();
        hashTable.put(1, "Sainath");
        hashTable.put(2, "Parkar");
        hashTable.put(3, "XYZ");
        hashTable.put(16, "QWERTY");
        hashTable.iterate();
        hashTable.remove(1);
        hashTable.iterate();
    }
}
