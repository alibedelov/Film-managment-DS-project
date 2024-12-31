/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsproj.filmmanagmentdsproject;

/**
 *
 * @author Ftama Alsaghir 220315105
 * @param <T>
 */
public class BST<T extends Comparable<T>> {
    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node<T> root;

    public BST() {
        this.root = null;
    }

    // Insert method to insert films or actors
    public void insert(T data) {
        root = insertRecursive(root, data);
    }

    private Node<T> insertRecursive(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }
        if (data.compareTo(node.data) < 0) {
            node.left = insertRecursive(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insertRecursive(node.right, data);
        } else {
            System.out.println("Duplicate data isn't allowed");
        }
        return node;
    }

    // Search method to return the object if found
    public T search(T data) {
        return searchRecursive(root, data);
    }

    private T searchRecursive(Node<T> node, T data) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.data) == 0) {
            return node.data;
        } else if (data.compareTo(node.data) < 0) {
            return searchRecursive(node.left, data);
        } else {
            return searchRecursive(node.right, data);
        }
    }

    // Update method to replace data in a node
    public void update(T oldData, T newData) {
        if (search(oldData) != null) {
            delete(oldData);
            insert(newData);
        } else {
            System.out.println("Data to update not found");
        }
    }

    // Delete method to remove a node from the tree
    public void delete(T data) {
        root = deleteRecursive(root, data);
    }

    private Node<T> deleteRecursive(Node<T> node, T data) {
        if (node == null) {
            return null;
        }

        if (data.compareTo(node.data) < 0) {
            node.left = deleteRecursive(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = deleteRecursive(node.right, data);
        } else {
            // Node to be deleted found
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            // Node with two children: Get inorder successor
            node.data = findMin(node.right);
            node.right = deleteRecursive(node.right, node.data);
        }
        return node;
    }

    private T findMin(Node<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    // Display the films or actors in in-order traversal
    public void display() {
        displayInOrder(root);
    }

    private void displayInOrder(Node<T> node) {
        if (node != null) {
            displayInOrder(node.left);
            System.out.println(node.data);
            displayInOrder(node.right);
        }
    }

    // Display the films or actors in pre-order traversal
    public void displayPreOrder() {
        displayPreOrderRecursive(root);
    }

    private void displayPreOrderRecursive(Node<T> node) {
        if (node != null) {
            System.out.println(node.data);
            displayPreOrderRecursive(node.left);
            displayPreOrderRecursive(node.right);
        }
    }

    // Display the films or actors in post-order traversal
    public void displayPostOrder() {
        displayPostOrderRecursive(root);
    }

    private void displayPostOrderRecursive(Node<T> node) {
        if (node != null) {
            displayPostOrderRecursive(node.left);
            displayPostOrderRecursive(node.right);
            System.out.println(node.data);
        }
    }
}

