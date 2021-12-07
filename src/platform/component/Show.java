package platform.component;


import customization.MaturityLevel;
import main.Genres;
import customization.Language;
import main.Quality;
import java.util.GregorianCalendar; // To change

public class Show {

    private String title;

    private GregorianCalendar release_date;

    private Quality quality; // Enum

    private Genres genres; // Enum

    private Language lang; // Enum

    private String names; // Array of names

    private static int num_views; //Should be static 

    private String synopsis; // Summary of the film

    private static double average_rating; // Should be calculated or entered by the producer

    private MaturityLevel levels; // Enum 

    private static int total_watch; // should be static too (not sure)

    public Show(String title, GregorianCalendar release_date, Quality quality, Genres genres,
            Language lang, String names, String synopsis, MaturityLevel levels)  {
        this.title = title;
        this.release_date = release_date;
        this.quality = quality;
        this.genres = genres;
        this.lang = lang;
        this.names = names;
        this.synopsis = synopsis;
        this.levels = levels;
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

    public Genres getGenres() {
        return genres;
    }

    public void setGenres(Genres genres) {
        this.genres = genres;
    }

    public Language getLang() {
        return lang;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
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

    public MaturityLevel getLevels() {
        return levels;
    }

    public void setLevels(MaturityLevel levels) {
        this.levels = levels;
    }

    public int getTotal_watch() {
        return total_watch;
    }

    public void setTotal_watch(int total_watch) {
        this.total_watch = total_watch;
    }

    @Override
    public String toString() {
        return ("\n\tTitle: " + title + "\n\tRelease_date: " 
        + release_date.getTime() + "\n\tQuality: " + quality + "\n\tGenre: " 
        + genres + "\n\tLanguage:" + lang + "\n\tNames of Actors: " + names 
        + "\n\tNumber Of Views: " + num_views + "\n\tSynopsis: " + synopsis 
        + "\n\tAverage Rating:" + average_rating + levels.toString() 
        + "\n\tTotal Watch: " + total_watch + '.');
    }
    
}
