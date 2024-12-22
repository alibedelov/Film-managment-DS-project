/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsproj.filmmanagmentdsproject;

/**
 *
 * @author Ali Badalov 220315106
 */
public class Recommendations 
{
    HashTable<String, LinkedList<FilmJ>> genreTable;
    
    public Recommendations(int capacity) //constructor
    {
        this.genreTable = new HashTable<>(capacity);
    }
    
    public void addFilmByGenre(String genre, FilmJ film) //adding films by genre
    {
        LinkedList<FilmJ> films = genreTable.get(genre); //making linked list for films
        if(films == null)
        {
            films = new LinkedList<>();
            genreTable.put(genre, films); //putting them into table
        }
        films.Add(film);
    }
    
    public LinkedList<FilmJ> getRecommendations(String genre) //getting recommendations
    {
        return genreTable.get(genre);
    }
    
    public boolean removeFilmByGenre(String genre, FilmJ film) //removing film by genre
    {
        LinkedList<FilmJ> films = genreTable.get(genre);
        if(films == null)
            return false; //coulnd't find the genre
        
        //traversing and removing the film
        Node<FilmJ> current = films.getHead();
        Node<FilmJ> prev = null;
        
        while(current != null) //going trough the list
        {
            if(current.data.equals(film)) //found it
            {
                if(prev == null) //is it the head?
                    films.setHead(current.next); //then remove it
                else
                    prev.next = current.next; //bypass the value
                return true;
            }
            prev = current;
            current = current.next;
        }
        
        return false;
    }
    
    public void printRecommendations() //print the recommendations
    {
        genreTable.printTable();
    }
}
