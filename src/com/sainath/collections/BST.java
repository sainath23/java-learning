package com.sainath.collections;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class BST {

    private class Node {
        int value;
        Node leftChild;
        Node rightChild;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root = null;

    private Set<Integer> visited = new HashSet<>();

    private boolean add(Node node, int value) {
        if(root == null) {
            root = new Node(value);
            return true;
        }

        if (node.value == value) {
            return false;
        } else if (node.value > value) {
            if (node.leftChild == null) {
                node.leftChild = new Node(value);
                return true;
            }
            return add(node.leftChild, value);
        } else {
            if (node.rightChild == null) {
                node.rightChild = new Node(value);
                return true;
            }
            return add(node.rightChild, value);
        }
    }

    private boolean remove(Node node, Node parent, int value) {
        // If toot is null then throw exception
        if (root == null) {
            throw new NoSuchElementException(value + " does not exist!");
        }

        // If value is less than node visit left subtree
        if (value < node.value) {
            return remove(node.leftChild, node, value);
        } else if (value > node.value) { // If value is greater than node then visit right
            return remove(node.rightChild, node, value);
        } else { // value is matched
            if (node.leftChild != null && node.rightChild != null) { // If both children of node is not null
                node.value = maxValue(node.leftChild); // Find max value of left subtree
                remove(node.leftChild, node, node.value);
            } else if (node == parent.leftChild) { // If node is a left child of parent then update parent left child
                parent.leftChild = node.leftChild != null ? node.leftChild : node.rightChild;
            } else { // If node is a right child of parent then update parent right child
                parent.rightChild = node.leftChild != null ? node.leftChild : node.rightChild;
            }
            return true;
        }
    }

    private int maxValue(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int max = node.value;
        int leftMax = maxValue(node.leftChild);
        int rightMax = maxValue(node.rightChild);

        if (leftMax > max) {
            max = leftMax;
        } else if (rightMax > max) {
            max = rightMax;
        }
        return max;
    }

    // Inorder traversal
    private void traverse(Node node) {
        if (node == null) {
            return;
        }
        traverse(node.leftChild);
        System.out.println(node.value);
        traverse(node.rightChild);
    }

    private void bfs(Node node) {
        if (node == null) return;
        System.out.println(visited);

        if (node == root) {
            System.out.println(node.value);
            visited.add(node.value);
        }

        if (node.leftChild != null && visited.contains(node.leftChild.value)) {
            System.out.println(node.leftChild.value);
            visited.add(node.leftChild.value);
        }
        if (node.rightChild != null && visited.contains(node.rightChild.value)) {
            System.out.println(node.rightChild.value);
            visited.add(node.rightChild.value);
        }
        bfs(node.leftChild);
        bfs(node.rightChild);
    }

    public int height(Node node) {
        if (node == null) return 0;

        int lHeight = height(node.leftChild);
        int rHeight = height(node.rightChild);

        if (lHeight > rHeight) return lHeight + 1;
        else return rHeight + 1;
    }

    public static void main(String[] args) {
        /*BST bst = new BST();
        bst.add(bst.root, 1);
        bst.add(bst.root, 2);
        bst.add(bst.root, 3);
        bst.add(bst.root, 4);
        bst.add(bst.root, 5);*/
        //bst.traverse(bst.root);
        /*
                    10
                  /    \
                 5      20
                /      /
               2      15
         */
        //System.out.println("Before root = " + bst.root.value);
        //bst.remove(bst.root, bst.root, 10);
        //System.out.println("After root = " + bst.root.value);
        //bst.traverse(bst.root);

        //System.out.println();

        //bst.bfs(bst.root);

        BST bst = new BST();
        bst.root = bst.new Node(1);
        bst.root.leftChild = bst.new Node(2);
        bst.root.rightChild = bst.new Node(3);
        bst.root.leftChild.leftChild = bst.new Node(4);
        bst.root.leftChild.rightChild = bst.new Node(5);
        bst.root.leftChild.rightChild.leftChild = bst.new Node(6);

        //bst.traverse(bst.root);

        System.out.println(bst.height(bst.root));

        //bst.bfs(bst.root);
    }
}
