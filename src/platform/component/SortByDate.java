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
public class SortByDate implements Comparator<Viewing>{
    @Override
    public int compare(Viewing a, Viewing b){
        return a.getDate().compareTo(b.getDate());
    }
    
}
