package com.dsproj.filmmanagmentdsproject;
// Jalil Guliyev 220315102
public class ActorJ implements Comparable<ActorJ> {
    private String name; // Actor's name
    private int actorId; // Unique identifier for the actor
    private LinkedListJ<FilmJ> filmsParticipated; // Custom linked list of films the actor has participated in

    // Constructor to initialize the actor details
    public ActorJ(String name, int actorId) {
        this.name = name;
        this.actorId = actorId;
        this.filmsParticipated = new LinkedListJ<>(); // Initialize the film list
    }

    // Adds a film to the actor's filmography
    public void addFilm(FilmJ film) {
        if (!filmsParticipated.contains(film)) {
            filmsParticipated.add(film);
            film.addActor(this); // Ensure the film knows about this actor
        }
    }

    // Removes a film from the actor's filmography
    public void removeFilm(FilmJ film) {
        if (filmsParticipated.contains(film)) {
            filmsParticipated.remove(film);
            film.removeActor(this); // Ensure the film's list is updated
        }
    }

    // Checks if the actor participated in a specific film
    public boolean hasFilm(FilmJ film) {
        return filmsParticipated.contains(film);
    }

    // Getter and setter methods for the actor's attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }
    
    public void getFilmsParticipated() //added by Ali Badalov 220315106
    {
        filmsParticipated.display();
    }

    @Override
    public String toString() {
        return "Actor Name: " + name + ", ID: " + actorId;
    }

    // Implement Comparable for sorting actors by name (required for BST search functionality)
    @Override
    public int compareTo(ActorJ other) {
        return this.name.compareTo(other.name); // Compare actors by name
    }
}