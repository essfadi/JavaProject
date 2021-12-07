/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platform.component;
import java.util.Comparator;
/**
 *
 * @author user
 */

/**
 *
 * @author oessf
 */
public class SortByTitle implements Comparator<Show>{
    
    @Override
    public int compare(Show a, Show b) {
        return a.getTitle().compareTo(b.getTitle());
    }
}
