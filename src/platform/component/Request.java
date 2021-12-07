package platform.component;

import java.util.GregorianCalendar;
import authentication.Account;
import java.text.SimpleDateFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class Request {

    private String titleSuggested;
    private Account requester;
    private String formatted;
    private GregorianCalendar request_made = new GregorianCalendar();

    public Request(Account owner, String title) {
        this.titleSuggested = title;
        this.requester = owner;
        //sets the current date of the request and store it for later use
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

    @Override
    public String toString() {
        SimpleDateFormat fm = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        formatted = fm.format(request_made.getTime());
        return "Requester: " + requester.getEmail() + "\nRequestedMovie:" + titleSuggested + "\nDate of request: " + formatted;
    }
}
