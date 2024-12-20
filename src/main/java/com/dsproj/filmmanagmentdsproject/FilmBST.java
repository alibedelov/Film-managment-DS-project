/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsproj.filmmanagmentdsproject;

/**
 *
 * @author Fatma Alsaghir 220315105
 */
public class FilmBST {
    private BSTNode root;

    // Insert a film into the tree
    public void insert(Film film) {
        root = insertRec(root, film);
    }

    private BSTNode insertRec(BSTNode root, Film film) {
        if (root == null) {
            root = new BSTNode(film);  // Create a new node for the film
            return root;
        }
        if (film.name.compareToIgnoreCase(root.film.name) < 0) {
            root.left = insertRec(root.left, film);  // Insert into the left subtree
        } else if (film.name.compareToIgnoreCase(root.film.name) > 0) {
            root.right = insertRec(root.right, film);  // Insert into the right subtree
        }
        return root;
    }

    // Search for a film by name
    public Film search(String name) {
        return searchRec(root, name);
    }

    private Film searchRec(BSTNode root, String name) {
        if (root == null || root.film.name.equalsIgnoreCase(name)) {
            return root != null ? root.film : null;  // Return the film if found, or null
        }
        if (name.compareToIgnoreCase(root.film.name) < 0) {
            return searchRec(root.left, name);
        }
        return searchRec(root.right, name);
    }

    // Delete a film from the tree
    public void delete(String name) {
        root = deleteRec(root, name);
    }

    private BSTNode deleteRec(BSTNode root, String name) {
        if (root == null) {
            return root;
        }

        if (name.compareToIgnoreCase(root.film.name) < 0) {
            root.left = deleteRec(root.left, name);
        } else if (name.compareToIgnoreCase(root.film.name) > 0) {
            root.right = deleteRec(root.right, name);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.film = minValue(root.right);
            root.right = deleteRec(root.right, root.film.name);
        }
        return root;
    }

    private Film minValue(BSTNode root) {
        Film minValue = root.film;
        while (root.left != null) {
            minValue = root.left.film;
            root = root.left;
        }
        return minValue;
    }

    // In-order traversal (left, root, right)
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.film);
            inorderRec(root.right);
        }
    }

    // Pre-order traversal (root, left, right)
    public void preorder() {
        preorderRec(root);
    }

    private void preorderRec(BSTNode root) {
        if (root != null) {
            System.out.println(root.film);
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Post-order traversal (left, right, root)
    public void postorder() {
        postorderRec(root);
    }

    private void postorderRec(BSTNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.println(root.film);
        }
    }

    // Level-order traversal (Breadth-First Search)
    public void levelOrder() {
        if (root == null) return;
        CustomQueue queue = new CustomQueue();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            BSTNode current = queue.dequeue();
            System.out.println(current.film);
            if (current.left != null) queue.enqueue(current.left);
            if (current.right != null) queue.enqueue(current.right);
        }
    }

    // Get films in a certain range of names or ratings
    public void getFilmsInRange(String minName, String maxName) {
        getFilmsInRangeRec(root, minName, maxName);
    }

    private void getFilmsInRangeRec(BSTNode root, String minName, String maxName) {
        if (root != null) {
            if (root.film.name.compareToIgnoreCase(minName) >= 0 && root.film.name.compareToIgnoreCase(maxName) <= 0) {
                System.out.println(root.film);
            }
            if (root.film.name.compareToIgnoreCase(minName) > 0) {
                getFilmsInRangeRec(root.left, minName, maxName);
            }
            if (root.film.name.compareToIgnoreCase(maxName) < 0) {
                getFilmsInRangeRec(root.right, minName, maxName);
            }
        }
    }

    // Custom Queue Implementation for Level-Order Traversal
    public class CustomQueue {
        private QueueNode front, rear;

        public CustomQueue() {
            front = rear = null;
        }

        public void enqueue(BSTNode filmNode) {
            QueueNode newNode = new QueueNode(filmNode);
            if (rear == null) {
                front = rear = newNode;
                return;
            }
            rear.next = newNode;
            rear = newNode;
        }

        public BSTNode dequeue() {
            if (front == null) return null;
            QueueNode temp = front;
            front = front.next;
            if (front == null) rear = null;
            return temp.node;
        }

        public boolean isEmpty() {
            return front == null;
        }

        private class QueueNode {
            BSTNode node;
            QueueNode next;

            public QueueNode(BSTNode node) {
                this.node = node;
                this.next = null;
            }
        }
    }

    // BSTNode class, which holds a Film object
    private class BSTNode {
        Film film;
        BSTNode left, right;

        public BSTNode(Film film) {
            this.film = film;
            this.left = null;
            this.right = null;
        }
    }
}

   