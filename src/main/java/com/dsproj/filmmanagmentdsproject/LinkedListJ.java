package com.dsproj.filmmanagmentdsproject;
// Jalil Guliyev 220315102
public class LinkedListJ<T> {
    private Node<T> head;
    private Node<T> tail; // Tail pointer to optimize adding to the end of the list
    private int size = 0;

    // Adds a new element to the end of the linked list
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot add null data.");
        }

        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode; // If the list is empty, the new node becomes the head
            tail = newNode; // The tail is also the new node
        } else {
            tail.next = newNode; // Link the new node at the end
            tail = newNode; // Update the tail to the new node
        }
        size++;
    }

    // Removes an element from the linked list
    public void remove(T data) {
        if (head == null || data == null) return; // If the list is empty or data is null, do nothing

        if (head.data.equals(data)) {
            head = head.next; // If the head is the element to remove, update the head
            if (head == null) {
                tail = null; // If the list becomes empty, reset the tail
            }
            size--;
            return;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next; // Traverse the list to find the element
        }

        if (current.next != null) {
            current.next = current.next.next; // Skip the node to remove it
            if (current.next == null) {
                tail = current; // Update the tail if the last element was removed
            }
            size--;
        }
    }

    // Checks if the list contains a specific element
    public boolean contains(T data) {
        if (data == null) return false;
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) return true;
            current = current.next;
        }
        return false;
    }

    // Returns the size of the linked list
    public int size() {
        return size;
    }

    // Gets the element at a specific index (0-based)
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next; // Traverse to the desired index
        }
        return current.data;
    }

    // Displays all elements in the linked list
    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data); // Print the data of each node
            current = current.next; // Move to the next node
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            result.append(current.data.toString()).append(" -> ");
            current = current.next;
        }
        result.append("null");
        return result.toString();
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