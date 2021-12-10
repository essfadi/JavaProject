/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platform.component;

import customization.MaturityLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
import main.Genres;
import main.Quality;

/**
 *
 * @author user
 */
public class ShowCollection{

    private ArrayList<Show> shows;
    private int numberOfShows = 0;

    public ShowCollection() {
        shows = new ArrayList<>();
    }

    public void addShow(Show show) {
        shows.add(numberOfShows++, show);
    }
    public void addShows(ArrayList<Show> shows){
        this.shows.addAll(shows);
    }

    public void removeShow(Show show) {
        shows.remove(show);
    }

    public Show searchShow(Show searched) {
        Iterator<Show> iterator = shows.iterator();
        while (iterator.hasNext()) {
            Show show = iterator.next();
            if (show.getTitle().equalsIgnoreCase(searched.getTitle())) {
                return show;
            }
        }
        return null;
    }
    
    public void modifyShow(Show show) {
        Show placeHolder;
        Scanner scanner = new Scanner(System.in);
        int choice_change;
        if (shows.contains(show)) {
            placeHolder = this.searchShow(show);
            System.out.println("1/ title\n2/ release_date\n\t3/quality\n4/genres\n5/language\n6/names\n7/synopsis\n8/level\n");
            System.out.print("Choose The Element You want to change: ");
            choice_change = scanner.nextInt();
            switch (choice_change) {
                case 1:
                    System.out.print("Please enter the searched title:");
                    String title = scanner.nextLine();
                    placeHolder.setTitle(title); 
                    break;
                case 2:
                    break;
                case 3:
                    System.out.print("Please enter the searched quality:");
                    String quality= scanner.nextLine();
                    placeHolder.setQuality(Quality.valueOf(quality));
                    break;
                case 4:
                    System.out.print("Please enter the searched Genre:");
                    String genre= scanner.nextLine();
                    placeHolder.setGenres(Genres.valueOf(genre));
                    break;
                case 5:
                    System.out.print("Please enter the new language :");
                    String language= scanner.nextLine();
                    placeHolder.setGenres(Genres.valueOf(language));
                    break;
                case 6:
                    System.out.print("Please enter the new names :");
                    String names= scanner.nextLine();
                    placeHolder.setNames(names);
                    break;
                case 7:
                    System.out.print("Please enter the new synopsis :");
                    String synopsis= scanner.nextLine();
                    placeHolder.setSynopsis(synopsis);
                    break;
                case 8:
                    System.out.print("Please enter the new min age:");
                    int age= scanner.nextInt();
                    placeHolder.setLevels(new MaturityLevel(age));
                    break;
                default:
                    System.out.println("The Choice You Entered Is Not Valid!");
            }
        } else {
            System.out.println("The Show you entered is not contained in your list of shows for this account!");
        }
    }

    public ArrayList<Show> getShows() {
        return shows;
    }

    public void setShows(ArrayList<Show> shows) {
        this.shows = shows;
    }

    public int getNumberOfShows() {
        return numberOfShows;
    }

    public void setNumberOfShows(int numberOfShows) {
        this.numberOfShows = numberOfShows;
    }

    @Override
    public String toString() {
        String str = "";
        ListIterator<Show> iter = shows.listIterator();
        while (iter.hasNext()) {
            Show s = iter.next();
            str += s.toString() + "\n";
        }
        return str;
    }
}
