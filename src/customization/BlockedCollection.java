/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import platform.component.Show;
import platform.component.ShowCollection;

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

    public ShowCollection generateAllowedShows(ShowCollection showList, Profile profile) {
        ShowCollection allowedShows = new ShowCollection();
        ListIterator<Show> iter = showList.getShows().listIterator();
        while (iter.hasNext()) {
            Show show = iter.next();
            int lastIndex = show.getLevels().size() - 1;
            if (profile.getLevel_restriction().getMinAge() > show.getLevels().get(lastIndex).getMinAge() || show.getLevels().get(0).equals(MaturityLevel.ALL)) {
                this.add(show);
            } else {
                allowedShows.addShow(show);
            }
        }
        return allowedShows;
    }

    // For Our Beloved Teammate!
    @Override
    public String toString() {
        return "BlockedCollection{" + "blocked=" + blocked + '}';
    }
    
}
