/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customization;

import java.util.Comparator;
import platform.component.Show;

/**
 *
 * @author oessf
 */
public class sortByTitle implements Comparator<Show> {

    /**
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public int compare(Show a, Show b) {
        return a.getTitle().compareTo(b.getTitle());
    }
}
