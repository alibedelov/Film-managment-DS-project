/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsproj.filmmanagmentdsproject;

/**
 *
 * @author DELL
 */
public class StringList {
    private String[] data;
    private int size;

    public StringList() {
        this.data = new String[10];  // Initial capacity of 10
        this.size = 0;
    }

    public void add(String value) {
        if (size == data.length) {
            // Resize the array if it exceeds the capacity
            String[] newData = new String[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[size++] = value;
    }

    public String[] toArray() {
        String[] result = new String[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }

    public int size() {
        return size;
    }
}
   
