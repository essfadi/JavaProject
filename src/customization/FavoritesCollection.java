/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import platform.component.Show;

/**
 *
 * @author oessf
 */
public class FavoritesCollection {

    private ArrayList<Show> favorites;

    public FavoritesCollection() {
        this.favorites = new ArrayList();
    }

    public ArrayList<Show> getFavorites() {
        return favorites;
    }

    public void setFavorites(ArrayList<Show> favorites) {
        this.favorites = favorites;
    }

    // Begins: For You Hiba
    @Override
    public String toString() {
        return "FavoritesCollection{" + "favorites=" + favorites + '}';
    }

    // End
    public void add(Show show) {
        favorites.add(show);
    }

    public Show search(String title) {
        Iterator<Show> iterator = favorites.iterator();
        while (iterator.hasNext()) {
            Show show = iterator.next();
            if (show.getTitle().equals(title)) {
                return show;
            }
        }
        return null;
    }

    public void remove(String title) {
        Show show = this.search(title);
        if (show != null) {
            favorites.remove(show);
        } else {
            System.out.println("The show is not found, Deletion Fails!");
        }
    }

    public void modify(String title) {
        Show show = this.search(title);
        if (show != null) {
            // The logic of Modification can be Ratings: Polymorphism
        } else {
            System.out.println("The Show you entered is not contained in your list of profiles for this account!");
        }
    }

    public void sort() {
        Collections.sort(favorites, new sortByTitle());
    }
}
