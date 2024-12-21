/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsproj.filmmanagmentdsproject;

/**
 *
 * @author Ali Badalov 220315106
 */
public class HashTable<K, V> //adding K and V to make it generic
{
    LinkedList<Entry>[] table; //linked list to store variables
    int capacity; //maximum capacity of the hash table
    int size; //the size of our hash table
    
    public HashTable(int capacity)
    {
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
        this.size = 0;
        
        for(int i = 0; i < capacity; i++) //initializing each bucket
        {
            table[i] = new LinkedList<>();
        }
    }
    
    private int hash(K key) //hash function
    {
        return Math.abs(key.hashCode()) % capacity;
    }
    
    public void put(K key, V value) //inserting or updating key-value pair
    {
        int bucketIndex = hash(key);
        LinkedList<Entry> bucket = table[bucketIndex];
        
        //checking if the key already exists or not
        Node<Entry> current = bucket.getHead(); //setting node to head of the list
        while(current != null) //looking trough the linked list
        {
            if(current.data.key.equals(key))
            {
                current.data.value = value; // assigning the value
                return;
            }
            current = current.next;
        }
        bucket.Add(new Entry(key, value)); //adding the key if it doesn't exist
        size++; //increasing the size
    }
    
    public V get(K key) //returning a value with specific key
    {
        int bucketIndex = hash(key);
        LinkedList<Entry> bucket = table[bucketIndex];
        
        Node<Entry> current = bucket.getHead(); //setting node to get head of the list
        while(current != null) //looking through the list again
        {
            if(current.data.key.equals(key))
                return (V) current.data.value; //if found, returning it
            current = current.next;
        }
        
        return null; //not found, returning null
    }
    
    //removing key-value pair
    public boolean remove(K key)
    {
        int bucketIndex = hash(key);
        LinkedList<Entry> bucket = table[bucketIndex];
        
        //getting nodes
        Node<Entry> current = bucket.getHead();
        Node<Entry> prev = null;
        
        while(current != null) //looking through the list
        {
            if(current.data.key.equals(key)) //found it
            {
                if(prev == null) //checking if its head
                    bucket.setHead(current.next); //removing the head
                else
                    prev.next = current.next; //bypasing the value
                size--; //reducing the size
                return true;
            }
            prev = current; 
            current = current.next; //going through
        }
        return false; //key not found
    }
    
    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    //printing the table out
    public void printTable()
    {
        for(int i = 0; i < capacity; i++)
        {
            System.out.println("Bucket " + i + ": "); //printing each bucket and values
            table[i].printList();
            System.out.println();
        }
    }
}
