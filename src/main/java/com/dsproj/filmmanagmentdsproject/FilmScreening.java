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
    private int viewerCount;
    private double ticketPrice;

    // Constructor to initialize the screening details
    public FilmScreening(int viewerCount, double ticketPrice) {
        this.viewerCount = viewerCount;
        this.ticketPrice = ticketPrice;
    }

    public int getViewerCount() {
        return viewerCount;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}

    
   
