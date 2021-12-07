package customization;


public class MaturityLevel {

    private int min_age;
    private String description;
    
 
    public MaturityLevel(int age) {
        if (age < 7) {
            this.min_age = Level.ALL.getRating();
            this.description = Level.ALL.getDescription();
        }
        else if (age >= 7 && age < 13) {
            this.min_age = Level.KIDS.getRating();
            this.description = Level.KIDS.getDescription();
        }
        else if (age >= 13 && age < 16) {
            this.min_age = Level.TEENS.getRating();
            this.description = Level.TEENS.getDescription();
        }   
        else if (age >= 16 && age < 18) {
            this.min_age = Level.ADULT.getRating();
            this.description = Level.ADULT.getDescription();
        } 
        else {
            this.min_age = Level.ADULTS.getRating();
            this.description = Level.ADULTS.getDescription();
        }
    }
    
    public int getMin_age() {
        return min_age;
    }

    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return "\n\tThe minimum age can watch is " + min_age + "\n\tDescription: " + description;
    }
}
