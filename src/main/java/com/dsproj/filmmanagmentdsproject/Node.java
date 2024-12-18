/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsproj.filmmanagmentdsproject;

/**
 *
 * @author Ali Badalov 220315106
 */
public class Node<K, V>
{
    //Using generic variables to make this work for any type of variable.
    K key; //Generic key
    V value; //Generic value
    Node next;
    
    //Constructor
    Node(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
}
