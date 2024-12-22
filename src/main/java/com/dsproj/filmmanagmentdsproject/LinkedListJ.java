package com.dsproj.filmmanagmentdsproject;
// Jalil Guliyev 220315102
public class LinkedListJ<T> {
    private Node<T> head;

    // Adds a new element to the end of the linked list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode; // If the list is empty, the new node becomes the head
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next; // Traverse to the end of the list
            }
            current.next = newNode; // Link the new node at the end
        }
    }

    // Removes an element from the linked list
    public void remove(T data) {
        if (head == null) return; // If the list is empty, do nothing

        if (head.data.equals(data)) {
            head = head.next; // If the head is the element to remove, update the head
            return;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next; // Traverse the list to find the element
        }

        if (current.next != null) {
            current.next = current.next.next; // Skip the node to remove it
        }
    }

    // Displays all elements in the linked list
    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data); // Print the data of each node
            current = current.next; // Move to the next node
        }
    }

    // Inner class representing a node in the linked list
    private static class Node<T> {
        T data; // Data stored in the node
        Node<T> next; // Reference to the next node

        Node(T data) {
            this.data = data;
            this.next = null; // Initialize the next reference as null
        }
    }
}
