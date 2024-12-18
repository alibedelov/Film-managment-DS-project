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
    LinkedList<K, V>[] table; //linked list to store variables
    int size; //the capacity of our hash table
    
    public HashTable(int size)
    {
        this.size = size; // setting the size
        table = new LinkedList[size]; //setting the table
        for(int i = 0; i < size; i++)
        {
            table[i] = new LinkedList<>(); // linked lists for each slot to store values
        }
    }
    
    private int hashFunction(K key)
    {
        return Math.abs(key.hashCode()) % size; //the hash function to store the values
    }
    
    public void Put(K key, V value) //the function to put the values into hash table
    {
        int index = hashFunction(key); //getting the index with hash function
        table[index].Add(key, value); //adding value to hash table.
        //We are using linear probing to avoid collisions, that's why we are using linked list.
    }
    
    public V Get(K key) //getting the key
    {
        int index = hashFunction(key); //get index with hash function
        return table[index].GetValue(key); //return the value with key
    }
    
    public boolean containsKey(K key) //check if key exists
    {
        return Get(key) != null; //return true or false accordingly
    }
}
