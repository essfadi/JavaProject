/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platform.component;
import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author oessf
 */
public class Seasons {
    private int number;
    private int num_episodes;
    private List<Episodes> episodes;
    
    public Seasons(int number, int num_episodes) {
        this.number = number;
        this.num_episodes = num_episodes;
        episodes = new LinkedList<Episodes>();
    }
    
    public String addEpisode(Episodes episode) {
        this.num_episodes =+ 1;
        episodes.add(episode);
        return episode.toString();
    }
    // Delete
    public String deleteEpisode(Episodes episode) {
        if (num_episodes == 0) {
            return "There are no seasons available";
        } else {
            this.num_episodes -= 1;
            episodes.remove(episode);
            return episode.toString();
        }
    }
    
    
    //Search : To be implemented

    @Override
    public String toString() {
        return "There are " + number + " seasons" + ", and " + num_episodes + " episodes: " ;
    }

}
