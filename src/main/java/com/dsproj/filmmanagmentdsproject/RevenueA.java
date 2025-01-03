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
    private final LinkedListJ<FilmJ> allFilms;

    public RevenueA(LinkedListJ<FilmJ> allFilms) {
        this.revenueStack = new LinkedListJ<>();
        this.screeningQueue = new LinkedListJ<>();
        this.allFilms = allFilms;
    }

    private FilmJ getFilmForScreening(FilmScreening screening) {
        int filmId = screening.getFilmId(); 
        for (FilmJ film : allFilms) {
            if (film.getFilmId() == filmId) {
                return film;
            }
        }
        return null;
    }
    
    public void enqueueScreening(FilmScreening screening) {
        screeningQueue.add(screening);
    }

    public void processScreenings() {
        while (!screeningQueue.isEmpty()) {
            FilmScreening screening = screeningQueue.get(0);
            double revenue = screening.calculateRevenue(); 
            FilmJ film = getFilmForScreening(screening);  
            if (film != null) {
                film.setTotalRevenue(film.getTotalRevenue() + revenue); 
                
                // Calculate combined popularity from revenue
                double popularityFromRevenue = film.getTotalRevenue() / 1000000.0;
                film.updatePopularity(popularityFromRevenue);
                film.updateRank(); 
            }
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

    public LinkedListJ<Double> getLastNRevenues(int n) {
        LinkedListJ<Double> lastNRevenues = new LinkedListJ<>();
        int startIndex = Math.max(0, revenueStack.size() - n); 
        for (int i = startIndex; i < revenueStack.size(); i++) {
            lastNRevenues.add(revenueStack.get(i));
        }
        return lastNRevenues;
    }
}
