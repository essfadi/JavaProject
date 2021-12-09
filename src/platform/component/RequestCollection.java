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
public class RequestCollection {
    private ArrayList<Request> requests;
    
    public RequestCollection() {
        requests = new ArrayList();
    }
    
    public void add(Request req) {
        requests.add(req);
    }
    
    public void sort() {
        Collections.sort(requests);
    }

    public Request search(String suggested) {
        Iterator<Request> iterator = requests.iterator();
        while (iterator.hasNext()) {
            Request req = iterator.next();
            if (req.getTitle().equals(suggested)) {
                return req;
            }
        }
        return null;
    }
    
    public void delete(String suggested) {
        Iterator<Request> iterator = requests.iterator();
        while (iterator.hasNext()) {
            Request req = iterator.next();
            if (req.getTitle().equals(suggested)) {
                requests.remove(req);
            }
        }
    }

    @Override
    public String toString() {
        return "RequestCollection{" + "requests=" + requests + '}';
    }
    
}
