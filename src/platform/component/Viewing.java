package platform.component;


import java.util.GregorianCalendar; 

public class Viewing implements Comparable<Viewing>{

    private GregorianCalendar date; 

    private Show show;

    private Rating rate; // Enum
    
    public Viewing(Show show) {
        this.date = new GregorianCalendar();
        this.show = show;
    }

    public void rate(int choice) {
        if (choice == 1)
            setRate(Rating.THUMBS_UP);
        else
            setRate(Rating.THUMBS_DOWN);
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Rating getRate() {
        return rate;
    }

    public void setRate(Rating rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "\n\tLast Time You Viewed " + show.getTitle() + " is " + date.getTime();
    }
    @Override
    public int compareTo(Viewing view) {
        return this.getDate().compareTo(view.getDate());
    }
}
