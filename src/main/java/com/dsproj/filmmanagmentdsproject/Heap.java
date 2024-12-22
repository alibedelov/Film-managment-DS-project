/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsproj.filmmanagmentdsproject;

/**
 *
 * @author Ali Badalov 220315106
 */
public class Heap
{
    FilmJ[] heap; //Film array to store the heap
    int size; //size of the heap
    int capacity; //maximum capacity of the heap
    
    
    public Heap(int capacity) //Heap constructor
    {
        this.capacity = capacity;
        this.heap = new FilmJ[capacity];
        this.size = 0;
    }
    
    private int getParent(int index) //getting the index of the parent node
    {
        return(index - 1) / 2;
    }
    
    private int getLeftChild(int index) //getting the left child
    {
        return 2 * index + 1;
    }
    
    private int getRightChild(int index) //getting the right child
    {
        return 2 * index + 2;
    }
    
    private void swap(int a, int b) //swapping 2 elements
    {
        FilmJ tempFilm = heap[a];
        heap[a] = heap[b];
        heap[b] = tempFilm;
    }
    
    
    public void insert(FilmJ film) //inserting new film to heap
    {
        if (size == capacity) 
        {
            System.out.println("Oh no, heap is full!");
            return;
        }
        heap[size] = film; // inserting to the end
        size++;

        // Heapify-up
        int currentIndex = size - 1;
        while (currentIndex > 0 && compareFilms(heap[currentIndex], heap[getParent(currentIndex)]) > 0) 
        {
            swap(currentIndex, getParent(currentIndex));
            currentIndex = getParent(currentIndex);
        }
    }
    
    public FilmJ removeTop() //remove the most popular film
    {
        if(size == 0)
        {
            System.out.println("Hey, the heap is empty!");
            return null;
        }
        
        FilmJ top = heap[0];
        heap[0] = heap[size - 1];
        size--;
        
        heapifyDown(0);
        
        return top;
    }
    
    private void heapifyDown(int index)
    {
        int largest = index;
        int leftChild = getLeftChild(index);
        int rightChild = getRightChild(index);
        
        // comparing with left child
        if (leftChild < size && compareFilms(heap[leftChild], heap[largest]) > 0) 
        {
            largest = leftChild;
        }

        // comparing with right child
        if (rightChild < size && compareFilms(heap[rightChild], heap[largest]) > 0) 
        {
            largest = rightChild;
        }

        // swapping and recursing if needed
        if (largest != index) 
        {
            swap(index, largest);
            heapifyDown(largest);
        }
    }
    
    private int compareFilms(FilmJ f1, FilmJ f2) //moment of truth. The tie-breaker
    {
        if (f1.getTotalRevenue() != f2.getTotalRevenue()) 
        {
            return Double.compare(f1.getTotalRevenue(), f2.getTotalRevenue());
        }
        return Integer.compare(f2.getReleaseYear(), f1.getReleaseYear()); // Older films get higher rank in tie
    }

    public void printHeap() //printing the heap for list view
    {
        for (int i = 0; i < size; i++) 
        {
            System.out.println(heap[i]);
        }
    }
}
