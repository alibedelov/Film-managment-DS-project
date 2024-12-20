/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsproj.filmmanagmentdsproject;

/**
 *
 * @author Fatma Alsaghir 220315105
 */
public class RevenueManager {
    LinkedListQueue<Film> filmQueue = new LinkedListQueue<>();
    CustomStack<Revenue> revenueHistory = new CustomStack<>();

    public void scheduleFilm(Film film) {
        filmQueue.enqueue(film);
        System.out.println(film.name + " has been scheduled for screening.");
    }

    public void simulateRevenue(double ticketPrice, int viewerCount) {
        if (!filmQueue.isEmpty()) {
            Film film = filmQueue.dequeue();
            double revenue = ticketPrice * viewerCount;
            String revenueStr = String.format("$%,.2f", revenue);

            double currentRevenue = film.totalRevenue.isEmpty() 
                                    ? 0 
                                    : Double.parseDouble(film.totalRevenue.replace("$", "").replace(",", ""));
            String updatedRevenue = String.format("$%,.2f", currentRevenue + revenue);
            film.totalRevenue = updatedRevenue;

            revenueHistory.push(new Revenue(film.uniqueID, ticketPrice, viewerCount));
            System.out.println("Revenue for " + film.name + ": " + revenueStr);
        } else {
            System.out.println("No films in the queue.");
        }
    }

    public void viewRevenueHistory() {
        System.out.println("\nRevenue History:");
        CustomStack<Revenue> tempStack = new CustomStack<>();
        while (!revenueHistory.isEmpty()) {
            Revenue rev = revenueHistory.pop();
            System.out.println(rev);
            tempStack.push(rev);
        }
        while (!tempStack.isEmpty()) {
            revenueHistory.push(tempStack.pop());
        }
    }

    public void editRevenueRecord(String filmID, double newTicketPrice, int newViewerCount) {
        CustomStack<Revenue> tempStack = new CustomStack<>();
        boolean found = false;

        while (!revenueHistory.isEmpty()) {
            Revenue rev = revenueHistory.pop();
            if (rev.getFilmID().equals(filmID) && !found) {
                rev.setTicketPrice(newTicketPrice);
                rev.setViewerCount(newViewerCount);
                found = true;
            }
            tempStack.push(rev);
        }

        while (!tempStack.isEmpty()) {
            revenueHistory.push(tempStack.pop());
        }

        if (found) {
            System.out.println("Revenue record for film ID " + filmID + " has been updated.");
        } else {
            System.out.println("Revenue record for film ID " + filmID + " not found.");
        }
    }

    public void deleteRevenueRecord(String filmID) {
        CustomStack<Revenue> tempStack = new CustomStack<>();
        boolean found = false;

        while (!revenueHistory.isEmpty()) {
            Revenue rev = revenueHistory.pop();
            if (rev.getFilmID().equals(filmID) && !found) {
                found = true;
            } else {
                tempStack.push(rev);
            }
        }

        while (!tempStack.isEmpty()) {
            revenueHistory.push(tempStack.pop());
        }

        if (found) {
            System.out.println("Revenue record for film ID " + filmID + " has been deleted.");
        } else {
            System.out.println("Revenue record for film ID " + filmID + " not found.");
        }
    }

    public void filmsWithRevenueExceedingThreshold(double threshold, LinkedListQueue<Film> allFilms) {
        System.out.println("\nFilms with revenue exceeding $" + threshold + ":");
        LinkedListQueue<Film> tempQueue = new LinkedListQueue<>();

        while (!allFilms.isEmpty()) {
            Film film = allFilms.dequeue();
            double totalRevenue = Double.parseDouble(film.totalRevenue.replace("$", "").replace(",", ""));
            if (totalRevenue > threshold) {
                System.out.println(film.name + " (Revenue: " + film.totalRevenue + ")");
            }
            tempQueue.enqueue(film);
        }

        while (!tempQueue.isEmpty()) {
            allFilms.enqueue(tempQueue.dequeue());
        }
    }

    public void generateRevenueReport(LinkedListQueue<Film> allFilms) {
        double totalRevenue = 0;
        double highestRevenue = 0;
        String highestRevenueFilm = "";
        LinkedListQueue<Film> tempQueue = new LinkedListQueue<>();

        System.out.println("\nRevenue Report:");
        while (!allFilms.isEmpty()) {
            Film film = allFilms.dequeue();
            double filmRevenue = Double.parseDouble(film.totalRevenue.replace("$", "").replace(",", ""));
            totalRevenue += filmRevenue;

            if (filmRevenue > highestRevenue) {
                highestRevenue = filmRevenue;
                highestRevenueFilm = film.name;
            }

            tempQueue.enqueue(film);
        }

        while (!tempQueue.isEmpty()) {
            allFilms.enqueue(tempQueue.dequeue());
        }

        System.out.println("Total Revenue: $" + String.format("%,.2f", totalRevenue));
        System.out.println("Highest Revenue: " + highestRevenueFilm + " ($" + String.format("%,.2f", highestRevenue) + ")");
    }
}
