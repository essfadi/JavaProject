package customization;

import java.util.Comparator;
import platform.component.Show;

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
