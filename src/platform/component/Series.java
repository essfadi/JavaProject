/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platform.component;

import customization.Language;
import customization.MaturityLevel;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import main.Genres;
import main.Quality;

/**
 *
 * @author oessf
 */
public class Series extends Show {

    private int num_seasons = 0;
    private List<Seasons> seasons;

    public Series(String title, GregorianCalendar release_date, Quality quality, Genres genres,
            Language lang, String names, String synopsis, MaturityLevel levels, int num_seasons) {
        super(title, release_date, quality, genres, lang, names, synopsis, levels);
        this.num_seasons = num_seasons;
        this.seasons = new LinkedList<Seasons>();
    }

    public String addSeason(Seasons season) {
        this.num_seasons += 1;
        seasons.add(season);
        return season.toString();
    }
    // delete

    public String deleteString(Seasons season) {
        if (num_seasons == 0) {
            return "There are no seasons available";
        } else {
            this.num_seasons -= 1;
            seasons.remove(season);
            return season.toString();
        }
    }

    //search seasons : to implement later
    @Override
    public String toString() {
        return "Series {" + super.toString() + "\n\tNumber of seasons: " + num_seasons + "\n}";
    }
}
