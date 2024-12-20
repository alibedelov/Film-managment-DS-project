/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsproj.filmmanagmentdsproject;

/**
 *
 * @author Fatma Alsaghir 220315105
 * @param <T>
 */
public class CustomStack<T> {
    private Node top;

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Pushes data onto the stack
    public void push(T data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // Pops data from the stack
    public T pop() {
        if (top == null) return null;  // Stack is empty
        T data = top.data;
        top = top.next;
        return data;
    }

    // Peeks at the top element without removing it
    public T peek() {
        if (top == null) return null;  // Stack is empty
        return top.data;
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Returns the size of the stack
    public int size() {
        int count = 0;
        Node current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Clears the stack (optional)
    public void clear() {
        top = null;
    }

    // For testing purposes, print all elements in the stack
    public void printStack() {
        Node current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
    