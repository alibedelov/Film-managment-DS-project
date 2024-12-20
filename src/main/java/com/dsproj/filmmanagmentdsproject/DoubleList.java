/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsproj.filmmanagmentdsproject;

/**
 *
 * @author Fatma Alsaghir 220315105
 */
public class DoubleList {
    private double[] data;
    private int size;

    public DoubleList() {
        this.data = new double[10];  // Initial capacity of 10
        this.size = 0;
    }

    public void add(double value) {
        if (size == data.length) {
            // Resize the array if it exceeds the capacity
            double[] newData = new double[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[size++] = value;
    }

    public double[] toArray() {
        double[] result = new double[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }

    public int size() {
        return size;
    }
}
