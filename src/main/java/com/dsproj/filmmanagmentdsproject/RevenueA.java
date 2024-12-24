/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsproj.filmmanagmentdsproject;

/**
 *
 * @author Fatma Alsaghir 220315105
 */
public class RevenueA {
    private LinkedListJ<Double> revenueStack; 
    private LinkedListJ<FilmScreening> screeningQueue;

    public RevenueA() {
        this.revenueStack = new LinkedListJ<>();
        this.screeningQueue = new LinkedListJ<>();
    }

    // Add a new film screening to the queue
    public void enqueueScreening(FilmScreening screening) {
        screeningQueue.add(screening);  
    }

    // Process the screenings and calculate revenue
    public void processScreenings() {
        while (!screeningQueue.isEmpty()) {
            FilmScreening screening = screeningQueue.get(0);  
            double revenue = screening.getViewerCount() * screening.getTicketPrice(); 
            addScreening(revenue); 
            screeningQueue.remove(screening);  
        }
    }

    // Add revenue to the stack
    public void addScreening(double revenue) {
        revenueStack.add(revenue);  
    }

    // Display all revenue history
    public void displayRevenueHistory() {
        System.out.println("Revenue History:");
        revenueStack.display();
    }

    // Calculate total revenue from all screenings
    public double getTotalRevenue() {
        double totalRevenue = 0.0;
        for (int i = 0; i < revenueStack.size(); i++) {
            totalRevenue += revenueStack.get(i);  // Sum all revenues
        }
        return totalRevenue;
    }

    // Clear revenue history
    public void clearRevenueHistory() {
        revenueStack = new LinkedListJ<>();
        System.out.println("Revenue history has been cleared");
    }
}

