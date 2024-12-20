/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsproj.filmmanagmentdsproject;

/**
 *
 * @author Fatma Alsaghir 220315105
 */
public class Revenue {
    private String filmID; // Mutable
    private double ticketPrice;
    private int viewerCount;

    public Revenue(String filmID, double ticketPrice, int viewerCount) {
        this.filmID = filmID;
        this.ticketPrice = ticketPrice;
        this.viewerCount = viewerCount;
    }

    public String getFilmID() {
        return filmID;
    }

    public void setFilmID(String filmID) {
        this.filmID = filmID; // Allows modification
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getViewerCount() {
        return viewerCount;
    }

    public void setViewerCount(int viewerCount) {
        this.viewerCount = viewerCount;
    }
}
