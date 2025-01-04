/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsproj.filmmanagmentdsproject;

/**
 *
 * @author Fatma Alsaghir 220315105
 */
public class ViewerFeedback {
    private static class Feedback {
        String filmName;
        String review;
        int rating;

       public Feedback(FilmJ film, String review, int rating) {
            if (rating < 1 || rating > 10) {
                throw new IllegalArgumentException("Rating must be between 1 and 10");
            }
            this.filmName = film.getName();
            this.review = review;
            this.rating = rating;
        }

        @Override
        public String toString() {
            return "Film : " + filmName + " Rating: " + rating + "/10, Review: " + review;
        }
    }

    private final LinkedListJ<Feedback> feedbackList;
    private int totalRating;

    public ViewerFeedback() {
        this.feedbackList = new LinkedListJ<>();
        this.totalRating = 0;
    }

    // Method to add feedback and update film popularity and rank
    public void addFeedback(FilmJ film, String review, int rating) {
        if (rating < 1 || rating > 10) {
            throw new IllegalArgumentException("Rating must be between 1 and 10");
        }
        feedbackList.add(new Feedback(film, review, rating));
        totalRating += rating;
        film.increaseFeedbackCount();
        double averageRating = (double) totalRating / film.getFeedbackCount();
        
        // Calculate combined popularity
        double popularityFromRating = averageRating;
        film.setAverageRating(averageRating);
        film.updatePopularity();
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
