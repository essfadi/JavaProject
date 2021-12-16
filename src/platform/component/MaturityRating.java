package platform.component;

public class MaturityRating {

    private String rating_reason; 
    
    MaturityRating(String rating_reason) {
        this.rating_reason = rating_reason;
    }

    public String getRating_reason() {
        return rating_reason;
    }

    public void setRating_reason(String rating_reason) {
        this.rating_reason = rating_reason;
    }

    @Override
    public String toString() {
        return "MaturityRating: \n" + "Rating Reason: " + rating_reason;
    }
    
}
