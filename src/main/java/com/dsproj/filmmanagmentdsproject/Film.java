/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsproj.filmmanagmentdsproject;

/**
 *
 * @author Fatma Alsaghir 220315105
 */
public class Film {
    String name;
    String uniqueID;
    String genre;
    int releaseYear;
    String totalRevenue;
    StringList reviews = new StringList();  // Custom String list
    DoubleList ratings = new DoubleList();  // Custom Double list

    public Film(String name, String uniqueID, String genre, int releaseYear, String totalRevenue) {
        this.name = name;
        this.uniqueID = uniqueID;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.totalRevenue = totalRevenue;
    }

    // Method to add a rating
    public void addRating(double rating) {
        ratings.add(rating);
    }

    // Method to add a review
    public void addReview(String review) {
        reviews.add(review);
    }

    // Method to get reviews as an array
    public String[] getReviews() {
        return reviews.toArray();  // Converts StringList to a String array
    }

    // Method to get ratings as an array of primitive doubles
    public double[] getRatings() {
        return ratings.toArray();  // Converts DoubleList to a primitive double array
    }

    // Example to display film details
    @Override
    public String toString() {
        return "Film: " + name + " | Genre: " + genre + " | Year: " + releaseYear + " | Revenue: " + totalRevenue;
    }
}


