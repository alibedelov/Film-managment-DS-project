package com.dsproj.filmmanagmentdsproject;
// Jalil Guliyev 220315102
public class HashTableJ<K, V> {
    private LinkedListJ<Entry<K, V>>[] table; // Array of linked lists for collision handling
    private int size; // Capacity of the hash table

    // Constructor to initialize the hash table with a given capacity
    public HashTableJ(int capacity) {
        table = new LinkedListJ[capacity];
        size = capacity;
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedListJ<>(); // Initialize each index with a linked list
        }
    }

    // Inserts or updates a key-value pair in the hash table
    public void put(K key, V value) {
        int index = hashFunction(key); // Compute the hash index
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update the value if the key exists
                return;
            }
        }
        table[index].add(new Entry<>(key, value)); // Add a new entry if the key does not exist
    }

    // Retrieves the value associated with a given key
    public V get(K key) {
        int index = hashFunction(key); // Compute the hash index
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value; // Return the value if the key is found
            }
        }
        return null; // Return null if the key is not found
    }

    // Computes the hash index for a given key
    private int hashFunction(K key) {
        return Math.abs(key.hashCode()) % size;
    }

    // Inner class representing a key-value pair
    private static class Entry<K, V> {
        K key; // Key of the entry
        V value; // Value of the entry

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
