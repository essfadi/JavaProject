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

/**
 *
 * @author user
 */
public class BlockedCollection {
    ArrayList<Show> blocked; 
    
    BlockedCollection(){
        this.blocked=new ArrayList<>(); 
    }

    public ArrayList<Show> getBlocked() {
        return blocked;
    }

    public void setBlocked(ArrayList<Show> Blocked) {
        this.blocked = Blocked;
    }
    public Show search(String title){
        Iterator<Show> iter=blocked.iterator();
        while(iter.hasNext()){
            Show show=iter.next();
            if(title.equalsIgnoreCase(show.getTitle()));
                return show;
        }   
        return null; 
    }
    public void remove(String title) {
        Show show = this.search(title);
        if (show != null) {
            blocked.remove(show);
        } else {
            System.out.println("The show is not found, Deletion Fails!");
        }
    }
       
    @Override
    public String toString() {
        String str = "";
        ListIterator<Show> iter = blocked.listIterator();
        while (iter.hasNext()) {
            Show s = iter.next();
            str += s.toString() + "\n";
        }
        return str;
    }
        public void sort() {
        Collections.sort(blocked, new sortByTitle());
    }
    
}
