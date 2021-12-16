package platform.component;

import customization.MaturityLevel;
import main.Genres;
import customization.Language;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import main.Quality;
import java.util.GregorianCalendar; // To change

public class Show implements Serializable{

    private String title;

    private GregorianCalendar release_date;

    private Quality quality; // Enum

    private ArrayList<Genres> genres; // Enum

    private Language lang; // Enum

    private String[] names; // Array of names

    private int num_views; //Should be static 

    private String synopsis; // Summary of the film

    private double average_rating; // Should be calculated or entered by the producer

    private ArrayList<MaturityLevel> levels; // Enum 

    private int total_watch; // should be static too (not sure)

    
    public Show(String title, GregorianCalendar release_date, Quality quality, ArrayList<Genres> genres,
            Language lang, String[] names, String synopsis, ArrayList<MaturityLevel> levels, int num_views, double average_rating, int total_watch) {
        this.title = title;
        this.release_date = release_date;
        this.quality = quality;
        this.genres = genres;
        this.lang = lang;
        this.names = names;
        this.synopsis = synopsis;
        this.levels = levels;
        this.num_views = num_views;
        this.average_rating = average_rating;
        this.total_watch = total_watch;
    }
    
    public void view() {
        this.num_views += 1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GregorianCalendar getRelease_date() {
        return release_date;
    }

    public void setRelease_date(GregorianCalendar release_date) {
        this.release_date = release_date;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public Language getLang() {
        return lang;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }

    public int getNum_views() {
        return num_views;
    }

    public void setNum_views(int num_views) {
        this.num_views = num_views;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public double getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(double average_rating) {
        this.average_rating = average_rating;
    }

    public int getTotal_watch() {
        return total_watch;
    }

    public void setTotal_watch(int total_watch) {
        this.total_watch = total_watch;
    }

    public ArrayList<Genres> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genres> genres) {
        this.genres = genres;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public ArrayList<MaturityLevel> getLevels() {
        return levels;
    }

    public void setLevels(ArrayList<MaturityLevel> levels) {
        this.levels = levels;
    }
    
    @Override
    public String toString() {
        return ("\n\tTitle: " + title + "\n\tRelease_date: "
                + release_date.getTime() + "\n\tQuality: " + quality.name() + "\n\tGenre: "
                + genres + "\n\tLanguage:" + lang + "\n\tNames of Actors: " + Arrays.toString(names)
                + "\n\tNumber Of Views: " + num_views + "\n\tSynopsis: " + synopsis
                + "\n\tAverage Rating:" + average_rating + "\n\tMaturity Levels: " +levels
                + "\n\tTotal Watch: " + total_watch + '.');
    }

}
