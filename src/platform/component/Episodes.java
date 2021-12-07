/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platform.component;

/**
 *
 * @author oessf
 */
public class Episodes {
    private String title;
    private int number;
    private String synopsis;
    private int duration;

    public Episodes(String title, int number, String synopsis, int duartion) {
        this.title = title;
        this.number = number;
        this.synopsis = synopsis;
        this.duration = duartion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    @Override
    public String toString() {
        return "The episode infos: \ntitle: " + this.title + "\nnumber: " + this.number + "\nsynopsis: " + this.synopsis
                + "\nDuration: " + this.duration;
    }
}
