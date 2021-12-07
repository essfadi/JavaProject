/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customization;

/**
 *
 * @author oessf
 */
public enum Level {
    ALL(0, "Recommended for all audiences"),
    KIDS(7, "Recommended for ages 7 and up"),
    TEENS(13, "Recommended for ages 13 and up"),
    ADULT(16, "Recommended for ages 16 and up"),
    ADULTS(18, "Recommended for ages 18 and up");
    
    private final int rating;
    private final String description;
    
    private Level(int rating, String description){
    this.rating = rating;
    this.description = description;
    }
    
    public int getRating() {
        return rating;
    }
    public String getDescription() {
        return description;
    }
}
