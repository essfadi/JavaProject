/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platform.component;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ShowCollection {
    private ArrayList<Show> shows;
    private int numberOfShows  = 0;
    
    public ShowCollection() {
        shows = new ArrayList();
    }
        public void addShow(Show show) {
        shows.add(numberOfShows++, show);
    }
    public void removeShow(Show show) {
        shows.remove(show);
    }
    public Show searchShow(Show show) {
        return shows.get(shows.indexOf(show));
    }

    public void modifyShow(Show show) {
        Show placeHolder;
        Scanner scanner = new Scanner(System.in);
        int choice_change;
        if (shows.contains(show)) {
            placeHolder = this.searchShow(show);
            System.out.println("1/ title\n2/ quality\n3/genres\n4/language\n5/names\n6/synopsis\n7/levels\n");
            System.out.print("Choose The Element You want to change: ");
            choice_change =  scanner.nextInt();
            switch (choice_change) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                default:
                    System.out.println("The Choice You Entered Is Not Valid!");
            }
        }
        else {
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
        return "ShowCollection{" + "shows=" + shows + ", numberOfShows=" + numberOfShows + '}';
    }
}
