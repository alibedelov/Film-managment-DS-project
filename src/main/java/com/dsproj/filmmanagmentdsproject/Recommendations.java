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
    HashTable<String, LinkedList<Film>> genreTable;
    
    public Recommendations(int capacity) //constructor
    {
        this.genreTable = new HashTable<>(capacity);
    }
    
    public void addFilmByGenre(String genre, Film film) //adding films by genre
    {
        LinkedList<Film> films = genreTable.get(genre); //making linked list for films
        if(films == null)
        {
            films = new LinkedList<>();
            genreTable.put(genre, films); //putting them into table
        }
        films.Add(film);
    }
    
    public LinkedList<Film> getRecommendations(String genre) //getting recommendations
    {
        return genreTable.get(genre);
    }
    
    public boolean removeFilmByGenre(String genre, Film film) //removing film by genre
    {
        LinkedList<Film> films = genreTable.get(genre);
        if(films == null)
            return false; //coulnd't find the genre
        
        //traversing and removing the film
        Node<Film> current = films.getHead();
        Node<Film> prev = null;
        
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
