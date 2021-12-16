/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platform.component;

import customization.Language;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
import main.Genres;
import main.Quality;
import main.AgeException;
import main.Netflix;

/**
 *
 * @author user
 */
public class ShowCollection {

    private ArrayList<Show> shows;
    private int numberOfShows = 0;
    private static final long serialversionUID = 129348938L;
    //private Genres genre;

    public ShowCollection() {
        shows = new ArrayList<>();
    }

    public void addShow(Show show) {
        if (!shows.contains(show)) {
            shows.add(numberOfShows++, show);
        } else {
            System.out.println("This show already exists!");
        }
    }

    public void addShows(ShowCollection shows) {
        this.shows.addAll(shows.shows);
    }

    public void removeShow(Show show) {
        shows.remove(show);
        numberOfShows--;
    }

    public Show search(Show searched) {
        Iterator<Show> iterator = shows.iterator();
        while (iterator.hasNext()) {
            Show s = iterator.next();
            if (s.getTitle().equalsIgnoreCase(searched.getTitle())) {
                return s;
            }
        }
        return null;
    }

    public Show searchByTitle(String title) {
        Iterator<Show> iterator = shows.iterator();
        while (iterator.hasNext()) {
            Show s = iterator.next();
            if (s.getTitle().equalsIgnoreCase(title)) {
                return s;
            }
        }
        return null;
    }

    public Show searchByGenre(String genre) throws OutOfGenresException {
        boolean flag = false;
        for (Genres genres : Genres.values()) {
            if (genres.equals(Genres.valueOf(genre.toUpperCase()))) {
                flag = true;
                break;
            }
        }
        if (flag) {
            Iterator<Show> iterator = shows.iterator();
            while (iterator.hasNext()) {
                Show s = iterator.next();
                if (s.getGenres().equals(Genres.valueOf(genre.toUpperCase()))) {
                    return s;
                }
            }
            return null;
        } else {
            throw new OutOfGenresException("The Genre You Entered Is Out of Bound.");
        }
    }

    public Show searchByLang(String lang) {
        Iterator<Show> iterator = shows.iterator();
        while (iterator.hasNext()) {
            Show s = iterator.next();
            if (s.getLang().equals(Language.valueOf(lang.toUpperCase()))) {
                return s;
            }
        }
        return null;
    }

    public void modifyShow(Show show) {
        Show placeHolder;
        ArrayList<Genres> genres = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice_change;
        if (shows.contains(show)) {
            placeHolder = this.search(show);
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
                    String quality = scanner.nextLine();
                    placeHolder.setQuality(Quality.valueOf(quality));
                    break;
                case 4:
                    //modifying Genres;
                    int choice = 0;
                    System.out.print(show.getGenres().toString());

                    do {
                        System.out.print("would you like to add a show?");
                        choice = scanner.nextInt();

                    } while (choice != 1);
                    if (choice == 1) {
                        System.out.print("Please enter the new Genres:");
                    }
                    String genre = scanner.nextLine();
                    genres.add(Genres.valueOf(genre));
                    placeHolder.setGenres(genres);
                    break;
                case 5:
                    //modifying language
                    System.out.print("Please enter the new language for your show:");
                    String language = scanner.nextLine();
                    placeHolder.setLang(Language.valueOf(language));
                    break;
                case 6:
                    String[] names = {};

                    do {
                        System.out.println("would you like to add show names? ");
                        choice = scanner.nextInt();
                    } while (choice != 1);
                    if (choice == 1) {
                        System.out.print("Please enter the new name :");
                        String name = scanner.nextLine();
                        for (int i = 0; i < placeHolder.getNames().length - 1; i++) {
                            names[i] = name;
                        }
                    }
                    placeHolder.setNames(names);
                    break;
                case 7:
                    System.out.print("Please enter the new synopsis :");
                    String synopsis = scanner.nextLine();
                    placeHolder.setSynopsis(synopsis);
                    break;
                case 8:
                    System.out.print("Please enter the new min age:");
                    int age = scanner.nextInt();
                    try {
                        Netflix.setMaturityLevel(age, placeHolder.getLevels());
                    } catch (AgeException err) {
                        System.err.println(err.getMessage());
                    }
                    break;
                default:
                    System.out.println("The Choice You Entered Is Not Valid!");
            }
        } else {
            System.out.println("The Show you entered is not contained in your list of shows for this account!");
        }

    }

    public ArrayList<Show> findShowWithGenre(Genres genre) {
        ArrayList<Show> results = new ArrayList();
        ListIterator<Show> iter = shows.listIterator();
        while (iter.hasNext()) {
            Show st = iter.next();
            if (st.getGenres().contains(genre)) {
                results.add(st);
            }
        }
        return results;
    }

    public void save() throws IOException {
        FileOutputStream fout = new FileOutputStream("data/netflix.ser");
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(this.shows);
        fout.close();
        out.close();
    }

    public void load() throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream("data/netflix.ser");
        ObjectInputStream in = new ObjectInputStream(fin);
        this.shows = (ArrayList<Show>) in.readObject();
        fin.close();
        in.close();
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
