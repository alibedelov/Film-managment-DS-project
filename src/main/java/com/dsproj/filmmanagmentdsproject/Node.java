/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsproj.filmmanagmentdsproject;

/**
 *
 * @author Ali Badalov 220315106
 */
public class Node<T>
{
    //Using generic variables to make this work for any type of variable.
    T data; //Generic value
    Node next;
    
    //Constructor
    Node(T data)
    {
        this.data = data;
    }
}
