/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsproj.filmmanagmentdsproject;

/**
 *
 * @author Fatma Alsaghir 220315105
 */
public class Main {
    public static void main(String[] args) {
        // Create a Film object
        Film film = new Film("Inception", "ID1", "Sci-Fi", 2010, "$829,895,144");

        // Add ratings and reviews
        film.addRating(5.0);  // Adds a rating 
        film.addRating(4.5);  // Adds a rating of
        film.addReview("Amazing movie!");  // Adds a review
        film.addReview("Mind-blowing concept!");  // Adds another review

        // Get reviews and ratings as arrays
        String[] reviews = film.getReviews();  // Get all reviews as an array
        double[] ratings = film.getRatings();  // Get all ratings as an array

        // Print reviews
        System.out.println("Reviews:");
        for (String review : reviews) {
            System.out.println(review);  // Prints each review
        }

        // Print ratings
        System.out.println("\nRatings:");
        for (double rating : ratings) {
            System.out.println(rating);  // Prints each rating
        }
    }
}

  
