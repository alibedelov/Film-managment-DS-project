/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dsproj.filmmanagmentdsproject;
import java.util.Scanner;

/**
 *
 * @author Ali Badalov 220315106
 */
public class Main {
    public static void main(String[] args) 
    {
        
        Scanner input = new Scanner(System.in);
        int id = 5;
        int actorId = 18;
        boolean exit = false;
        LinkedList<FilmJ> FilmList = new LinkedList<FilmJ>();
        LinkedList<ActorJ> ActorList = new LinkedList<ActorJ>();;
        RevenueA revenueManager = new RevenueA();
        Heap popularityHeap = new Heap(100);
        Recommendations recommendations = new Recommendations(50);
        ViewerFeedback viewerFeedback = new ViewerFeedback();
        
        //Animation genre
        
        //Brave
        FilmJ Brave = new FilmJ("Brave", 0, "Animation", 2012);
        FilmList.Add(Brave);
        ActorJ KellyMacdonald = new ActorJ("Kelly Macdonald", 0);
        KellyMacdonald.addFilm(Brave);
        ActorJ BillyConnoly = new ActorJ("Billy Connoly", 1);
        BillyConnoly.addFilm(Brave);
        ActorJ EmmaThompson = new ActorJ("Emma Thompson", 2);
        EmmaThompson.addFilm(Brave);
        
        //Toy Story 3
        FilmJ ToyStory3 = new FilmJ("Toy Story 3", 1, "Animation", 2010);
        FilmList.Add(ToyStory3);
        ActorJ TomHanks = new ActorJ("Tom Hanks", 3);
        TomHanks.addFilm(ToyStory3);
        ActorJ TimAllen = new ActorJ("Tim Allen", 4);
        TimAllen.addFilm(ToyStory3);
        ActorJ JoanCusack = new ActorJ("Joan Cusack", 5);
        JoanCusack.addFilm(ToyStory3);
        
        //Frozen
        FilmJ Frozen = new FilmJ("Frozen", 2, "Animation", 2013);
        FilmList.Add(Frozen);
        ActorJ KristenBell = new ActorJ("KristenBell", 6);
        KristenBell.addFilm(Frozen);
        ActorJ IdinaMenzel = new ActorJ("Idina Menzel", 7);
        IdinaMenzel.addFilm(Frozen);
        ActorJ JoshGad = new ActorJ("Josh Gad", 8);
        JoshGad.addFilm(Frozen);
        
        //Sci-Fi
        
        //Interstellar
        FilmJ Interstellar = new FilmJ("Interstellar", 3, "Sci-Fi", 2014);
        FilmList.Add(Interstellar);
        ActorJ MatthewMcConaughey = new ActorJ("Matthew McConaughey", 9);
        MatthewMcConaughey.addFilm(Interstellar);
        ActorJ AnneHathaway = new ActorJ("Anne Hathaway", 10);
        AnneHathaway.addFilm(Interstellar);
        ActorJ JessicaChastain = new ActorJ("Jessica Chastain", 11);
        JessicaChastain.addFilm(Interstellar);
        
        //Avatar
        FilmJ Avatar = new FilmJ("Avatar", 4, "Sci-Fi", 2009);
        FilmList.Add(Avatar);
        ActorJ SamWorthington = new ActorJ("Sam Worthington", 12);
        SamWorthington.addFilm(Avatar);
        ActorJ ZoeSaldana = new ActorJ("Zoe Saldana", 13);
        ZoeSaldana.addFilm(Avatar);
        ActorJ SigourneyWeaver = new ActorJ("Sigourney Weaver", 14);
        SigourneyWeaver.addFilm(Avatar);
        
        //Star Wars: The Force Awakens
        FilmJ StarWars = new FilmJ("Star Wars: The Force Awakens", 5, "Sci-Fi", 2015);
        FilmList.Add(StarWars);
        ActorJ DaisyRidley = new ActorJ("Daisy Ridley", 15);
        DaisyRidley.addFilm(StarWars);
        ActorJ JohnBoyega = new ActorJ("John Boyega", 16);
        JohnBoyega.addFilm(StarWars);
        ActorJ HarrisonFord = new ActorJ("Harrison Ford", 17);
        HarrisonFord.addFilm(StarWars);
        
        //Drama
        
        //The Blind Side
        FilmJ TheBlindSide = new FilmJ("The Blind Side", 6, "Drama", 2009);
        FilmList.Add(TheBlindSide);
        ActorJ SandraBullock = new ActorJ("Sandra Bullock", 18);
        SandraBullock.addFilm(TheBlindSide);
        ActorJ QuintonAaron = new ActorJ("Quinton Aaron", 19);
        QuintonAaron.addFilm(TheBlindSide);
        ActorJ TimMcGraw = new ActorJ("Tim McGraw", 20);
        TimMcGraw.addFilm(TheBlindSide);
        
        //Forrest Gump
        FilmJ ForrestGump = new FilmJ("Forrest Gump", 7, "Drama", 1994);
        FilmList.Add(ForrestGump);
        TomHanks.addFilm(ForrestGump);
        ActorJ RobinWright = new ActorJ("Robin Wright", 21);
        RobinWright.addFilm(ForrestGump);
        ActorJ GarySinise = new ActorJ("Gary Sinise", 22);
        GarySinise.addFilm(ForrestGump);
        
        //A Beautiful Mind
        FilmJ ABeautifulMind = new FilmJ("A Beautiful Mind", 8, "Drama", 2001);
        FilmList.Add(ABeautifulMind);
        ActorJ RusselCrowe = new ActorJ("Russel Crowe", 23);
        RusselCrowe.addFilm(ABeautifulMind);
        ActorJ JenniferConnelly = new ActorJ("Jennifer Connelly", 24);
        JenniferConnelly.addFilm(ABeautifulMind);
        ActorJ EdHarris = new ActorJ("Ed Harris", 25);
        EdHarris.addFilm(ABeautifulMind);
        
        //Action
        
        //Spider-Man 3
        FilmJ SpiderMan3 = new FilmJ("Spider-Man 3", 9, "Action", 2007);
        FilmList.Add(SpiderMan3);
        ActorJ TobeyMaguire = new ActorJ("Tobey Maguire", 26);
        TobeyMaguire.addFilm(SpiderMan3);
        ActorJ KirstenDunst = new ActorJ("Kirsten Dunst", 27);
        KirstenDunst.addFilm(SpiderMan3);
        ActorJ TopherGrace = new ActorJ("Topher Grace", 28);
        TopherGrace.addFilm(SpiderMan3);
        
        //The Dark Knight
        FilmJ TheDarkKnight = new FilmJ("The Dark Knight", 10, "Action", 2008);
        FilmList.Add(TheDarkKnight);
        ActorJ ChristianBale = new ActorJ("Christian Bale", 29);
        ChristianBale.addFilm(TheDarkKnight);
        ActorJ HeathLedger = new ActorJ("Heath Ledger", 30);
        HeathLedger.addFilm(TheDarkKnight);
        ActorJ AaronEckhart = new ActorJ("Aaron Eckhart", 31);
        AaronEckhart.addFilm(TheDarkKnight);
        
        //Avengers: Endgame
        FilmJ AvengersEndgame = new FilmJ("Avengers: Endgame", 11, "Action", 2019);
        FilmList.Add(AvengersEndgame);
        ActorJ RobertDowneyJr = new ActorJ("Robert Downey Jr.", 32);
        RobertDowneyJr.addFilm(AvengersEndgame);
        ActorJ ChrisEvans = new ActorJ("Chris Evans", 33);
        ChrisEvans.addFilm(AvengersEndgame);
        ActorJ ScarlettJohansson = new ActorJ("Scarlett Johansonn", 34);
        ScarlettJohansson.addFilm(AvengersEndgame);
        
        //Comedy
        
        //Paddington 2
        FilmJ Paddington2 = new FilmJ("Paddington 2", 12, "Comedy", 2017);
        FilmList.Add(Paddington2);
        ActorJ BenWhishaw = new ActorJ("Ben Whishaw", 35);
        BenWhishaw.addFilm(Paddington2);
        ActorJ HughGrant = new ActorJ("Hugh Grant", 36);
        HughGrant.addFilm(Paddington2);
        ActorJ SallyHawkins = new ActorJ("Sally Hawkins", 37);
        SallyHawkins.addFilm(Paddington2);
        
        //The Lego Movie
        FilmJ TheLegoMovie = new FilmJ("The Lego Movie", 13, "Comedy", 2014);
        FilmList.Add(TheLegoMovie);
        ActorJ ChrisPatt = new ActorJ("Chris Patt", 38);
        ChrisPatt.addFilm(TheLegoMovie);
        ActorJ ElizabethBanks = new ActorJ("Elizabeth Banks", 39);
        ElizabethBanks.addFilm(TheLegoMovie);
        ActorJ WillFerrell = new ActorJ("Will Ferrell", 40);
        WillFerrell.addFilm(TheLegoMovie);
        
        //Zootopia
        FilmJ Zootopia = new FilmJ("Zootopia", 14, "Comedy", 2016);
        FilmList.Add(Zootopia);
        ActorJ GinniferGoodwin = new ActorJ("GinniferGoodwin", 41);
        GinniferGoodwin.addFilm(Zootopia);
        ActorJ JasonBateman = new ActorJ("Jason Bateman", 42);
        JasonBateman.addFilm(Zootopia);
        ActorJ IdrisElba = new ActorJ("Idris Elba", 43);
        IdrisElba.addFilm(Zootopia);
        
        //Adventure
        
        //The Secret Life of Walter Mitty
        FilmJ WalterMitty = new FilmJ("The Secret Life of Walter Mitty", 15, "Adventure", 2013);
        FilmList.Add(WalterMitty);
        ActorJ BenStiller = new ActorJ("Ben Stiller", 44);
        BenStiller.addFilm(WalterMitty);
        ActorJ KristenWiig = new ActorJ("Kristen Wiig", 45);
        KristenWiig.addFilm(WalterMitty);
        ActorJ SeanPenn = new ActorJ("Sean Penn", 46);
        SeanPenn.addFilm(WalterMitty);
        
        //The Hobbit: An Unexpected Journey
        FilmJ TheHobbit = new FilmJ("The HobbitL An Unexpected Journey", 16, "Adventure", 2012);
        FilmList.Add(TheHobbit);
        ActorJ MartinFreeman = new ActorJ("Martin Freeman", 47);
        MartinFreeman.addFilm(TheHobbit);
        ActorJ IanMcKellen = new ActorJ("Ian McKellen", 48);
        IanMcKellen.addFilm(TheHobbit);
        ActorJ RichardArmitage = new ActorJ("Richard Armitage", 49);
        RichardArmitage.addFilm(TheHobbit);
        
        //Pirates of the Caribbean: The Curse of the Black Pearl
        FilmJ Pirates = new FilmJ("Pirates of the Caribbean: The Curse of the Black Pearl", 17, "Adventure", 2003);
        FilmList.Add(Pirates);
        ActorJ JohnnyDepp = new ActorJ("Johhny Depp", 50);
        JohnnyDepp.addFilm(Pirates);
        ActorJ OrlandoBloom = new ActorJ("Orlando Bloom", 51);
        OrlandoBloom.addFilm(Pirates);
        ActorJ KeiraKnightley = new ActorJ("Keira Knightley", 52);
        KeiraKnightley.addFilm(Pirates);
        
        while(!exit)
        {
            System.out.println("\nFilm Management System");
            System.out.println("1. Add Film");
            System.out.println("2. Update Film");
            System.out.println("3. Add Actor");
            System.out.println("4. Search Film/Actor");
            System.out.println("5. Simulate Revenue");
            System.out.println("6. Retrieve Revenue History");
            System.out.println("7. Display Popularity Rankings");
            System.out.println("8. Movie recommendations");
            System.out.println("9. Viewer feedback");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = Integer.parseInt(input.nextLine());
            
            switch(choice)
            {
                case 1:
                    System.out.print("Enter name of the film : ");
                    String filmName = input.nextLine();
                    System.out.print("\nEnter genre of the film : ");
                    String genre = input.nextLine();
                    System.out.print("\nEnter release year of the film : ");
                    int releaseYear = Integer.parseInt(input.nextLine());
                    FilmJ film = new FilmJ(filmName, id, genre, releaseYear);
                    FilmList.Add(film);
                    id++;
                    break;
                case 2:
                    System.out.println("The list of films : ");
                    FilmList.printList();
                    System.out.print("Select the film you want to update : ");
                    int indexChoice = Integer.parseInt(input.nextLine());
                    if(indexChoice >= id || indexChoice < 0)
                    {
                        System.out.println("Error: Wrong index choice.");
                        break;
                    }
                    else
                    {
                        FilmJ selectedFilm = FilmList.FindWithIndex(indexChoice);
                        
                        System.out.println("Updating Film: " + selectedFilm);

                        // Allow the user to update the film details
                        System.out.print("Enter new name (leave empty to keep current): ");
                        String newName = input.nextLine();
                        if (!newName.isEmpty()) 
                        {
                            selectedFilm.setName(newName);
                        }

                        System.out.print("Enter new genre (leave empty to keep current): ");
                        String newGenre = input.nextLine();
                        if (!newGenre.isEmpty()) 
                        {
                            selectedFilm.setGenre(newGenre);
                        }

                        System.out.print("Enter new release year (leave empty to keep current): ");
                        String newYear = input.nextLine();
                        if (!newYear.isEmpty()) 
                        {
                            selectedFilm.setReleaseYear(Integer.parseInt(newYear));
                        }

                        System.out.print("Enter new total revenue (leave empty to keep current): ");
                        String newRevenue = input.nextLine();
                        if (!newRevenue.isEmpty()) 
                        {
                            selectedFilm.setTotalRevenue(Double.parseDouble(newRevenue));
                        }
                    }
                    break;
                case 3:
                    System.out.println("The list of films : ");
                    FilmList.printList();
                    System.out.print("Select the film you want to add actor to : ");
                    int indexChoice2 = Integer.parseInt(input.nextLine());
                    if(indexChoice2 >= id || indexChoice2 < 0)
                    {
                        System.out.println("Error: Wrong index choice.");
                        break;
                    }
                    else
                    {
                        System.out.print("Enter name of the actor : ");
                        String name = input.nextLine();
                        ActorJ actor = new ActorJ(name, actorId);
                        ActorList.Add(actor);
                        System.out.println("Actor created successfully. Do you want to"
                                + " assing films to this actor?");
                        System.out.print("Enter 1 for yes, 2 for no : ");
                        int choose = Integer.parseInt(input.nextLine());
                        if(choose == 1)
                        {
                            boolean addingFilm = true;
                            while(addingFilm)
                            {
                                System.out.println("The list of films : ");
                                FilmList.printList();
                                System.out.print("Which film do you want to assign"
                                        + " the actor to? (Enter index of film) : ");
                                int theId = Integer.parseInt(input.nextLine());
                                FilmJ filmmm = FilmList.FindWithIndex(theId);
                                actor.addFilm(filmmm);
                                System.out.print("Do you want to assign actor "
                                        + "to new film? 1 for yes, 2 for no : ");
                                if(choose == 1)
                                    addingFilm = true;
                                else if(choose == 2)
                                    addingFilm = false;
                                else
                                {
                                    System.out.println("Wrong choice, accepting "
                                            + "the response as no");
                                }
                                System.out.println("");
                            }
                        }
                        else if (choose == 2)
                        {
                            System.out.println("Going back to main menu");
                        }
                        else
                        {
                            System.out.println("Wrong input, accepting the "
                                    + "response as no");
                        }
                    }
                case 4:
                    System.out.println("Which one do you want to search?");
                    System.out.println("1. Film");
                    System.out.println("2. Actor");
                    System.out.print("Make your choice : ");
                    int choiceSearch = Integer.parseInt(input.nextLine());
                    if(choiceSearch == 1)
                    {
                        System.out.print("\nEnter film name : ");
                        String filmNameSearch = input.nextLine();
                        FilmJ filmSearching = FilmList.FindWithName(filmNameSearch);
                        if(filmSearching != null)
                        {
                            System.out.println("Film found!");
                            System.out.println("Film name : " + filmSearching.getName());
                            System.out.println("Film ID : " + filmSearching.getFilmId());
                            System.out.println("Film genre : " + filmSearching.getGenre());
                            System.out.println("Film release year : " + filmSearching.getReleaseYear());
                            System.out.println("Film actor list : ");
                            filmSearching.getActors();
                        }
                        else
                        {
                            System.out.println("Film coulnd't be found! Please add it.");
                        }
                    }
                    else if(choiceSearch == 2)
                    {
                        System.out.print("\nEnter actor name : ");
                        String actorNameSearch = input.nextLine();
                        ActorJ actorSearching = ActorList.FindWithName(actorNameSearch);
                        if(actorSearching != null)
                        {
                            System.out.println("Actor found!");
                            System.out.println("Actor name : " + actorSearching.getName());
                            System.out.println("Actor ID : " + actorSearching.getActorId());
                            System.out.println("The films actor participated in : ");
                            actorSearching.getFilmsParticipated();
                        }
                        else
                        {
                            System.out.println("Actor couldn't be found! Please add them.");
                        }
                    }
                    else
                        System.out.println("Wrong input, going back to menu");
                    break;
                case 5:
                    boolean revenueExit = false;
                    
                    while(!revenueExit)
                    {
                        System.out.println("\nSimulate revenue options : ");
                        System.out.println("1. Add film screening");
                        System.out.println("2. Process screenings");
                        System.out.println("3. Display revenue history");
                        System.out.println("4. Display total revenue");
                        System.out.println("5. Clear revenue history");
                        System.out.println("6. Exit simulation");
                        System.out.print("Enter your selection : ");
                        
                        int revenueChoice = Integer.parseInt(input.nextLine());
                        
                        switch(revenueChoice)
                        {
                            case 1:
                                System.out.print("Enter viewer count : ");
                                int viewerCount = Integer.parseInt(input.nextLine());
                                System.out.print("Enter ticket prices : ");
                                double ticketPrice = Double.parseDouble(input.nextLine());
                                
                                FilmScreening screening = new FilmScreening(viewerCount, ticketPrice);
                                revenueManager.enqueueScreening(screening);
                                System.out.println("Film screening has been successfully added to queue");
                                break;
                            case 2:
                                System.out.println("Processing all screenings");
                                revenueManager.processScreenings();
                                System.out.println("Processing finished. Revenue updated");
                                break;
                            case 3:
                                revenueManager.displayRevenueHistory();
                                break;
                            case 4:
                                double totalRev = revenueManager.getTotalRevenue();
                                System.out.println("Total revenue : $" + totalRev);
                                break;
                            case 5:
                                revenueManager.clearRevenueHistory();
                                break;
                            case 6:
                                revenueExit = true;
                                break;
                            
                            default:
                                System.out.println("Invalid selection, try again");
                                break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("The revenue history : ");
                    revenueManager.displayRevenueHistory();
                case 7:
                    if(popularityHeap.size == 0)
                        System.out.println("No films available for ranking");
                    else
                    {
                        System.out.println("Popularity rankings : ");
                        
                        Heap tempHeap = new Heap(popularityHeap.capacity);
                        for(int i = 0; i < popularityHeap.size; i++)
                        {
                            tempHeap.insert(popularityHeap.heap[i]);
                        }
                        
                        int rank = 1;
                        while(tempHeap.size > 0)
                        {
                            FilmJ topFilm = tempHeap.removeTop();
                            System.out.println(rank + ". " + topFilm.getName()
                            + " (Revenue : $ " + topFilm.getTotalRevenue() + 
                                    ", Release year : " + topFilm.getReleaseYear());
                            rank++;
                        }
                    }
                    break;
                case 8:
                    System.out.println("Movie recommendations options : ");
                    System.out.println("1. Add film to a genre");
                    System.out.println("2. Get recommendations by a genre");
                    System.out.println("3. Print all recommendations");
                    System.out.print("Make your choice : ");
                    int recommendChoice = Integer.parseInt(input.nextLine());
                    
                    switch(recommendChoice)
                    {
                        case 1:
                            System.out.print("Enter the genre : ");
                            String genreRecommend = input.nextLine();
                            System.out.println("Available films : ");
                            FilmList.printList();
                            System.out.print("Enter the film index to add to this genre : ");
                            int filmIndexRecommend = Integer.parseInt(input.nextLine());
                            try
                            {
                                FilmJ selectedFilm = FilmList.FindWithIndex(filmIndexRecommend);
                                recommendations.addFilmByGenre(genreRecommend, selectedFilm);
                                System.out.println("Film added to genre recommendations");
                            }
                            catch(IndexOutOfBoundsException e)
                            {
                                System.out.println("Wrong index, going back to main menu");
                            }
                            break;
                        case 2:
                            System.out.print("Enter the genre to get recommendations : ");
                            String genreRecommend2 = input.nextLine();
                            LinkedList<FilmJ> recommendedFilms = recommendations.getRecommendations(genreRecommend2);
                            if(recommendedFilms == null || recommendedFilms.getSize() == 0)
                            {
                                System.out.println("No recommendations in this genre");
                            }
                            else
                            {
                                System.out.println("Recommendations for " + genreRecommend2 + " genre : ");
                                recommendedFilms.printList();
                            }
                            break;
                        case 3:
                            System.out.println("All genre recommendations : ");
                            recommendations.printRecommendations();
                            break;
                        
                        default:
                            System.out.println("Wrong choice, going back to main menu");
                        break;
                    }
                    break;
                    
                case 9:
                    System.out.println("Viewer feedback options : ");
                    System.out.println("1. Add feedback for a film");
                    System.out.println("2. Display feedbacks for all films");
                    System.out.print("Enter your choice : ");
                    int feedbackChoice = Integer.parseInt(input.nextLine());
                    
                    switch(feedbackChoice)
                    {
                        case 1:
                            System.out.println("Avaliable films : ");
                            FilmList.printList();
                            System.out.print("Enter the film index to add feedback for : ");
                            int filmFeedbackIndex = Integer.parseInt(input.nextLine());
                            try
                            {
                                FilmJ selectedFilm = FilmList.FindWithIndex(filmFeedbackIndex);
                                System.out.print("Write your review : ");
                                String review = input.nextLine();
                                System.out.print("Enter your rating (1-10) : ");
                                int rating = Integer.parseInt(input.nextLine());
                                
                                viewerFeedback.addFeedback(selectedFilm, review, rating);
                                System.out.println("Feedback has been added.");
                            }
                            catch(IndexOutOfBoundsException e)
                            {
                                System.out.println("Invalid film index, returning to main menu");
                            }
                            catch(IllegalArgumentException e)
                            {
                                System.out.println(e);
                            }
                            break;
                        case 2:
                            System.out.println("All viewer feedbacks");
                            viewerFeedback.displayFeedback();
                            break;
                        
                        default:
                            System.out.println("Invalid choice, returning to main menu");
                        break;
                    }
                    break;
                    
                case 10:
                    exit = true;
                    System.out.println("Exitting, thanks for using our service.");
                    break;
                    
                default:
                    System.out.println("Wrong choice, try again");
            }
        }
        input.close();
    }
}