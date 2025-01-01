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
    private final LinkedListJ<FilmScreening> screeningQueue;

    public RevenueA() {
        this.revenueStack = new LinkedListJ<>();
        this.screeningQueue = new LinkedListJ<>();
    }
    public void enqueueScreening(FilmScreening screening) {
        screeningQueue.add(screening);
    }
    public void processScreenings() {
        while (!screeningQueue.isEmpty()) {
            FilmScreening screening = screeningQueue.get(0);
            double revenue = screening.calculateRevenue(); // Calculate revenue using FilmScreening's method
            addScreening(revenue);
            screeningQueue.remove(screening);
        }
    }
    public void addScreening(double revenue) {
        revenueStack.add(revenue);
    }
    public void displayRevenueHistory() {
        System.out.println("Revenue History:");
        revenueStack.display();
    }
    public double getTotalRevenue() {
        double totalRevenue = 0.0;
        for (int i = 0; i < revenueStack.size(); i++) {
            totalRevenue += revenueStack.get(i);
        }
        return totalRevenue;
    }
    public void clearRevenueHistory() {
        revenueStack = new LinkedListJ<>();
        System.out.println("Revenue history has been cleared");
    }
}
