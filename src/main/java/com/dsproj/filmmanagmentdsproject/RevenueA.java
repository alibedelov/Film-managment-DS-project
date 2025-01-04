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
    private final LinkedListJ<Double> revenueStack;
    private final LinkedListJ<FilmScreening> screeningQueue;
    private final LinkedList<FilmJ> allFilms;

    public RevenueA(LinkedList<FilmJ> allFilms) {
        this.revenueStack = new LinkedListJ<>();
        this.screeningQueue = new LinkedListJ<>();
        this.allFilms = allFilms;
    }

    private FilmJ getFilmById(int filmId) {
        for (int i = 0; i < allFilms.size(); i++) {
            FilmJ film = allFilms.get(i);
            if (film.getFilmId() == filmId) {
                return film;
            }
        }
        return null; // returns null if no film matches the ID
    }

    public void enqueueScreening(FilmScreening screening) {
        screeningQueue.add(screening);
    }

    public void processScreenings() {
        while (!screeningQueue.isEmpty()) {
            FilmScreening screening = screeningQueue.get(0);
            double revenue = screening.calculateRevenue();
            FilmJ film = getFilmById(screening.getFilm().getFilmId());
            if (film != null) {
                film.addRevenue(revenue);  // Add revenue to the film's total revenue
            }
            addScreening(revenue);  //Add the revenue to the revenue history
            screeningQueue.remove(screening);  // Remove the processed screening
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
            totalRevenue += revenueStack.get(i);  //Sum up all revenue in the stack
        }
        return totalRevenue;
    }

    public void clearRevenueHistory() {
        revenueStack.clear();  // Clear the revenue history
        System.out.println("Revenue history has been cleared");
    }

    public LinkedListJ<Double> getLastNRevenues(int n) {
        LinkedListJ<Double> lastNRevenues = new LinkedListJ<>();
        int startIndex = Math.max(0, revenueStack.size() - n);
        for (int i = startIndex; i < revenueStack.size(); i++) {
            lastNRevenues.add(revenueStack.get(i));  //Get the last N revenues
        }
        return lastNRevenues;
    }
}   
