/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customization;

import java.util.Comparator;

/**
 *
 * @author oessf
 */
public class sortByName implements Comparator<Profile>{
    
    /**
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public int compare(Profile a, Profile b) {
        return a.getName().compareTo(b.getName());
    }
}
