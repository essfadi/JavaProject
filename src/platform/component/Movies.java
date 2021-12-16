/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platform.component;

import customization.Language;
import customization.MaturityLevel;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import main.Genres;
import main.Quality;

/**
 *
 * @author oessf
 */
public class Movies extends Show {

    private int duration; // Should be in seconds

    public Movies(String title, GregorianCalendar release_date, Quality quality, ArrayList<Genres> genres,
            Language lang, String[] names, String synopsis, ArrayList<MaturityLevel> levels, int  num_views, double average_rating, int total_watch, int duration) {
        super(title, release_date, quality, genres, lang, names, synopsis, levels, num_views, average_rating, total_watch);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public String getFormattedDuration() {
        return String.format("%d:%02d:%02d", duration / 3600, (duration % 3600) / 60, (duration % 60));
    }

    @Override
    public String toString() {
        return "Movies{" + "\n\tduration= " + getFormattedDuration() + super.toString() +"\n}";
    } 
}
