package platform.component;

import authentication.Account;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class Request implements Comparable<Request>{

    private String titleSuggested;
    private Account requester;
    private GregorianCalendar request_made;

    public Request(Account owner, String title) {
        this.titleSuggested = title;
        this.requester = owner;
        this.request_made = new GregorianCalendar();
    }

    public Account getRequester() {
        return this.requester;
    }

    public Request(String title) {
        this.titleSuggested = title;
    }

    public String getTitle() {
        return this.titleSuggested;
    }

    //to retreive the history of the request made
    public GregorianCalendar getRequestDate() {
        return request_made;
    }

    public String getTitleSuggested() {
        return titleSuggested;
    }

    public void setTitleSuggested(String titleSuggested) {
        this.titleSuggested = titleSuggested;
    }

    public GregorianCalendar getRequest_made() {
        return request_made;
    }

    public void setRequest_made(GregorianCalendar request_made) {
        this.request_made = request_made;
    }
    
    @Override
    public int compareTo(Request req) {
        return this.getRequestDate().compareTo(req.getRequestDate());
    }
    @Override
    public String toString() {
        SimpleDateFormat fm = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        String formatted = fm.format(request_made.getTime());
        return "Requester: " + requester.getEmail() + "\nRequestedMovie:" + titleSuggested + "\nDate of request: " + formatted;
    }
}
