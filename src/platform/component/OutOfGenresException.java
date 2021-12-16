/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platform.component;

import main.Genres;

/**
 *
 * @author oessf
 */
public class OutOfGenresException extends Exception {
    public OutOfGenresException(String err) {
        super(err);
        this.suggestGenres();
    }
    public void suggestGenres() {
        System.out.println("Here is the available Genres:");
        for (Genres genre: Genres.values()) {
            System.out.println(genre.name());
        }
        System.out.println("Please, Choose one within this list!");
    }
}
