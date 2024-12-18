/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsproj.filmmanagmentdsproject;

/**
 *
 * @author Ali Badalov 220315106
 */
public class Heap<T>
{
    interface CompareFunction<U> {
        int compare(U o1, U o2); //Comparing function to use in heap
    }
    
    T[] heap; //our heap
    int size; //size of the heap
    CompareFunction<T> comparator; //the comparator
    
    public Heap(int capacity, CompareFunction<T> comparator)
    {
        this.heap = (T[]) new Object[capacity]; //making generic array
        this.size = 0;
        this.comparator = comparator;
    }
    
    public void Insert(T item)
    {
        if(size >= heap.length)//checking if we have enough size or not
            throw new IllegalStateException("Heap is full"); //throwing error
        heap[size] = item;
        size++;
        heapifyUp(size - 1);
    }
    
    public T ExtractRoot()
    {
        if(size == 0)
            throw new IllegalStateException("Heap is empty");
        T root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return root;
    }
    
    void heapifyUp(int index)
    {
        while(index > 0)
        {
            int parentIndex = (index - 1) / 2;
            if(comparator.compare(heap[index], heap[parentIndex]) > 0)
            {
                swap(index, parentIndex);
                index = parentIndex;
            }
            else
                break;
        }
    }
    
    void heapifyDown(int index)
    {
        int leftChild, rightChild, largest;
        while(index < size / 2)
        {
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
            largest = index;
            
            if(leftChild < size && comparator.compare(heap[leftChild], heap[largest]) > 0)
                largest = leftChild;
            if(rightChild < size && comparator.compare(heap[rightChild], heap[largest]) > 0)
                largest = rightChild;
            
            if(largest != index)
            {
                swap(index, largest);
                index = largest;
            }
            else
                break;
        }
    }
    
    void swap(int a, int b)
    {
        T temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
}
