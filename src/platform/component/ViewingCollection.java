/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platform.component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/**
 *
 * @author oessf
 */
public class ViewingCollection {
    private ArrayList<Viewing> viewings;
    
    public ViewingCollection() {
        viewings = new ArrayList();
    }

    public ArrayList<Viewing> getViewings() {
        return viewings;
    }

    public void setViewings(ArrayList<Viewing> viewings) {
        this.viewings = viewings;
    }
    
    public void add(Viewing vue) {
        viewings.add(vue);
    }
    public Viewing search(String titleShow) {
        Iterator<Viewing> iterator = viewings.iterator();
        while(iterator.hasNext()) {
            Viewing vue = iterator.next();
            if (vue.getShow().getTitle().equals(titleShow)) {
                return vue;
            }
        }
        return null;
    }
    public void remove(String titleShow) {
        Viewing vue = this.search(titleShow);
        if (vue != null) {
            viewings.remove(vue);
        }
        else {
            System.out.println("The Show you are trying to delete from viewing activity doesn't exist!");
        }
    }
    public void sort() {
        Collections.sort(viewings);
    }
    @Override
    public String toString() {
        return "";
    }
}
