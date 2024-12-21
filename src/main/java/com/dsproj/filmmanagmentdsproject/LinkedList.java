/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsproj.filmmanagmentdsproject;

/**
 *
 * @author Ali Badalov 220315106
 */
public class LinkedList<T> //making this generic
{
    Node head; //Head of the linked list
    
    LinkedList()
    {
        head = null; //if its newly initialized, make head null
    }
    
    public void Add(T data) //adding variable to the linked list from the head
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    public T Find(T target) //finding value
    {
        Node current = head;
        while(current != null) //going til the end
        {
            if(current.data.equals(target)) 
                return (T) current.data; //if found the value we are looking for, return it
            current = current.next; //go til the end
        }
        return null; //couldn't find it, returning null
    }
    
    public boolean ContainsKey(T data) //checking if we have the key
    {
        return Find(data) != null; //returning true or false depending if key exists or not
    }
    
    public boolean Remove(T target)
    {
        Node current = head;
        Node prev = null;
        
        while(current != null)
        {
            if(current.data.equals(target))
            {
                if(prev == null)
                    head = current.next; //removing the head
                else
                    prev.next = current.next; //bypassing the node
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }
    
    public void printList()
    {
        Node current = head;
        while(current != null)
        {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("Null");
    }
    
    public Node<T> getHead()
    {
        return head;
    }
    
    public void setHead(Node<T> newHead)
    {
        this.head = newHead;
    }
}
