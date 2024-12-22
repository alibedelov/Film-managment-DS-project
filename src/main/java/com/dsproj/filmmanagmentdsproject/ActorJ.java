package com.dsproj.filmmanagmentdsproject;
// Jalil Guliyev 220315102
public class ActorJ {
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
        filmsParticipated.add(film);
    }

    // Removes a film from the actor's filmography
    public void removeFilm(FilmJ film) {
        filmsParticipated.remove(film);
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

    public LinkedListJ<FilmJ> getFilmsParticipated() {
        return filmsParticipated;
    }
}