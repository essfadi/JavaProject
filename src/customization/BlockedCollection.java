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
public class BlockedCollection {

    private ArrayList<Show> blocked;

    public BlockedCollection() {
        blocked = new ArrayList();
    }

    public ArrayList<Show> getBlocked() {
        return blocked;
    }

    public void setBlocked(ArrayList<Show> blocked) {
        this.blocked = blocked;
    }

    public void add(Show show) {
        blocked.add(show);
    }

    public Show search(String title) {
        Iterator<Show> iterator = blocked.iterator();
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
            blocked.remove(show);
        } else {
            System.out.println("The Show's title you entered is not contained in your list of blocked shows for this profile!");
        }
    }

    public void sort() {
        Collections.sort(blocked, new sortByTitle());
    }

    // For Our Beloved Teammate!
    @Override
    public String toString() {
        return "BlockedCollection{" + "blocked=" + blocked + '}';
    }
    
}
