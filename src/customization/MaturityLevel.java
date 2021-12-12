package customization;


public enum MaturityLevel {
    ALL(0, "Recommended for all audiences"),
    KIDS(7, "Recommended for ages 7 and up"),
    TEENS(13, "Recommended for ages 13 and up"),
    ADULT(16, "Recommended for ages 16 and up"),
    ADULTS(18, "Recommended for ages 18 and up");
    
    private final int minAge;
    private final String description;
    
    private MaturityLevel(int rating, String description){
    this.minAge = rating;
    this.description = description;
    }
    
    public int getMinAge() {
        return minAge;
    }
    public String getDescription() {
        return description;
    }
}

