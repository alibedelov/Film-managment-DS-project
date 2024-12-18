/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsproj.filmmanagmentdsproject;

/**
 *
 * @author Ali Badalov 220315106
 */
public class LinkedList<K, V> //added K for key and V for value to make it generic
{
    Node head; //Head of the linked list
    
    LinkedList()
    {
        head = null; //if its newly initialized, make head null
    }
    
    public void Add(K key, V value) //adding variable to the linked list with key
    {
        if(head == null)
        {
            head = new Node(key, value); //if the node is null, make this variable the head
            return;
        }
        //head is not null, continueing the proccess.
        Node current = head;
        
        while(current.next != null) //going until we find the last node in the linked list
        {
            if(current.key.equals(key)) 
            {
                current.value = value; //if key exists, lets update it
                return;
            }
            current = current.next;
        }
        
        if(current.key.equals(key)) //again if key exists update it
            current.value = value;
        else
            current.next = new Node(key, value); //key doesnt exist, add new node
    }
    
    public V GetValue(K key) //getting value from the linked list
    {
        Node current = head;
        while(current != null) //going til the end
        {
            if(current.key.equals(key)) 
                return (V) current.value; //if found the value we are looking for, return it
            current = current.next; //go til the end
        }
        return null; //couldn't find it, returning null
    }
    
    public boolean ContainsKey(K key) //checking if we have the key
    {
        return GetValue(key) != null; //returning true or false depending if key exists or not
    }
}
