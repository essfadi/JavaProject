package authentication.finance;
import main.Quality;

public class Plan {

        private Plans subPlan;

    private double cost;

    private int screen_num;

    private int download_devices;

    private Quality quality;

    public Plan(int choice) {
        switch (choice) {
            case 1:
                this.subPlan = Plans.BASIC;
                this.cost = 65;
                this.screen_num = 1;
                this.download_devices = 1;
                this.quality = Quality.ATMOS;
                break;

            case 2:
                this.subPlan = Plans.STANDARD;
                this.cost = 90;
                this.screen_num = 2;
                this.download_devices = 2;
                this.quality = Quality.HD;
                break;
            case 3:
                this.subPlan = Plans.PREMIUM;
                this.cost = 125;
                this.screen_num = 4;
                this.download_devices = 4;
                this.quality = Quality.UHD;
                break;
        }
    }

    public double getCost() {
        return this.cost;
    }

    public int getScreen_num() {
        return this.screen_num;
    }

    public int getDownload_devices() {
        return this.download_devices;
    }

    public Quality getQuality() {
        return this.quality;
    }

        @Override
    public String toString() {
        return ("Your plan is: " + subPlan.name() +" costs "+cost +" The number of screens you can watch is : " + screen_num);
    }
}
