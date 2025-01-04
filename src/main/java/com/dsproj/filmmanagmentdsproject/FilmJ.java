package com.dsproj.filmmanagmentdsproject;
// Jalil Guliyev 220315102
public class FilmJ implements Comparable<FilmJ> {
    private String name; 
    private int filmId;
    private String genre; 
    private int releaseYear; 
    private double totalRevenue; 
    private final LinkedListJ<ActorJ> actorList; 
    private double popularity; 
    double averageRating;
    static final double Revenue_Weight = 0.7f;
    static final double Feedback_Weight = 0.3f;
    double minRevenue = 100000000f;
    double maxRevenue = 5000000000f;
    int feedbackCount = 0;

    // Constructor to initialize the film details
    public FilmJ(String name, int filmId, String genre, int releaseYear, double totalRevenue) {
        this.name = name;
        this.filmId = filmId;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.totalRevenue = totalRevenue; 
        this.actorList = new LinkedListJ<>(); 
        this.popularity = 0.0; 
        this.averageRating = 1f;
        updatePopularity();
    }

    // Adds an actor to the film's actor list
    public void addActor(ActorJ actor) {
        if (!actorList.contains(actor)) {
            actorList.add(actor);
            actor.addFilm(this); 
        }
    }

    // Removes an actor from the film's actor list
    public void removeActor(ActorJ actor) {
        if (actorList.contains(actor)) {
            actorList.remove(actor);
            actor.removeFilm(this); 
        }
    }

     // Checks if an actor is part of the film
    public boolean hasActor(ActorJ actor) {
        return actorList.contains(actor);
    }

     // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }
    
    public void setAverageRating(double averageRating)
    {
        this.averageRating = averageRating;
    }
    
    public double getAverageRating()
    {
        return this.averageRating;
    }
    
    public void increaseFeedbackCount()
    {
        feedbackCount++;
    }
    
    public int getFeedbackCount()
    {
        return feedbackCount;
    }

    // Method to update popularity based on average rating
    public void updatePopularity() 
    {
        double normalizedRevenue = (totalRevenue - minRevenue) / (maxRevenue - minRevenue);
        double normalizedFeedback = (averageRating - 1) / (10 - 1);
        double temp = (Revenue_Weight * normalizedRevenue) + (Feedback_Weight * normalizedFeedback);
        this.popularity = Math.round(temp * 100.0) / 100.0;
    }

    public void getActors() {
        this.actorList.display();
    }
    
    @Override
    public int compareTo(FilmJ otherFilm) {
        return this.name.compareTo(otherFilm.name); // Compare by name for sorting
    }

    @Override
    public String toString() {
        return "Film Name: " + name + ", ID: " + filmId + ", Genre: " + genre + 
               ", Release Year: " + releaseYear + ", Revenue: " + totalRevenue + ", Popularity: " + popularity;
    }
}
