/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsproj.filmmanagmentdsproject;

/**
 *
 * @param <T>
 * @Fatma Alsaghir 220315105
 */
public class FilmScreening {
    FilmJ film;
    private long viewerCount;
    private double ticketPrice;
    public FilmScreening(FilmJ film, long viewerCount, double ticketPrice) {
        if (viewerCount < 0) {
            throw new IllegalArgumentException("Viewer count can't be a negative number");
        }
        if (ticketPrice <= 0) {
            throw new IllegalArgumentException("Ticket price must be greater than zero");
        }
        this.viewerCount = viewerCount;
        this.ticketPrice = ticketPrice;
        this.film = film;
    }

    public long getViewerCount() {
        return viewerCount;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public double calculateRevenue() {
        return viewerCount * ticketPrice;
    }
    
    public FilmJ getFilm()
    {
        return this.film;
    }

    @Override
    public String toString() {
        return String.format("Film Screening Details:\n" +
                "Viewer Count: %d\n" +
                "Ticket Price: $%.2f\n" +
                "Total Revenue: $%.2f",
                viewerCount, ticketPrice, calculateRevenue());
    }
}
