/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customization;

/**
 *
 * @author oessf
 */
public enum Playback {
    AUTO, LOW, MEDIUM, HIGH;
    private boolean autoplayNextEpi;
    private boolean autoplayPreviews;

    public boolean isAutoplayNextEpi() {
        return autoplayNextEpi;
    }

    public void setAutoplayNextEpi(int option1) {
        switch (option1) {
            case 1:
                this.autoplayNextEpi = true;
                break;
            default:
                this.autoplayNextEpi = false;
                break;
        }
    }

    public boolean isAutoplayPreviews() {
        return autoplayPreviews;
    }

    public void setAutoplayPreviews(int option2) {
        switch (option2) {
            case 1:
                this.autoplayPreviews = true;
                break;
            default:
                this.autoplayPreviews = false;
                break;
        }
    }

    public String toString() {
        return ("\nYour current Playback setting status is: \n Auto Play Next Episodes in all devices: " + autoplayNextEpi + "\n Auto play preview in all devices: " + autoplayPreviews);
    }
}
