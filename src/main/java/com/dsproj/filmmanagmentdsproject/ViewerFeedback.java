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
    private static class Feedback {
        String review;
        int rating;

        public Feedback(String review, int rating) {
            if (rating < 1 || rating > 10) {
                throw new IllegalArgumentException("Rating must be between 1 and 10.");
            }
            this.review = review;
            this.rating = rating;
        }

        @Override
        public String toString() {
            return "Rating: " + rating + "/10, Review: " + review;
        }
    }

    private final LinkedListJ<Feedback> feedbackList;
    private int totalRating;
    private int feedbackCount;

    public ViewerFeedback() {
        this.feedbackList = new LinkedListJ<>();
        this.totalRating = 0;
        this.feedbackCount = 0;
    }

    // Method to add feedback and update film popularity
    public void addFeedback(FilmJ film, String review, int rating) {
        if (rating < 1 || rating > 10) {
            throw new IllegalArgumentException("Rating must be between 1 and 10.");
        }
        feedbackList.add(new Feedback(review, rating));
        totalRating += rating;
        feedbackCount++;

        // Calculate average rating and update the film's popularity
        double averageRating = (double) totalRating / feedbackCount;
        film.updatePopularity(averageRating);  // Update the film's popularity based on average rating
    }

    // Method to display all feedback
    public void displayFeedback() {
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback available");
        } else {
            feedbackList.display();
        }
    }
}
