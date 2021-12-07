/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author oessf
 */
public class ProfileCollection {

    private ArrayList<Profile> profiles;
    private int numberOfProfiles = 0;

    public ProfileCollection() {
        profiles = new ArrayList(5);
    }

    public void addProfile(Profile profile) {
        profiles.add(numberOfProfiles++, profile);
    }

    public void removeProfile(Profile profile) {
        if (!profiles.contains(profile)) {
            System.out.println("The profie is not found, Deletion Fails!");
        } else {
            profiles.remove(profile);
        }
    }

    public Profile searchProfile(String name) {
        Iterator<Profile> iterator = profiles.iterator();
        while (iterator.hasNext()) {
            Profile profile = iterator.next();
            if (profile.getName().equals(name)) {
                return profile;
            }
        }
        return null;
    }

    public void modifyProfile(String name) {
        Profile placeHolder = this.searchProfile(name);
        Scanner scanner = new Scanner(System.in);
        int playback_choice;
        int choice_change;
        if (placeHolder != null) {
            System.out.println("1. Name.\n2. Level of restriction.\n3. email."
                    + "\n4. Notifications.\n5. Language.\n6. Playback Option."
                    + "\n7. Subtitle Activation.\n8. Favorite Shows.\n"
                    + "9. Blocked Shows.\n8. Subtitle Language.\n");
            System.out.print("Choose The Element You want to change: ");
            choice_change = scanner.nextInt();
            switch (choice_change) {
                case 1:
                    System.out.print("Please eneter the new name:");
                    String newname = scanner.nextLine();
                    placeHolder.setName(newname);
                    break;
                case 2:
                    break;
                case 3:
                    System.out.print("Please enter the new email: ");
                    String email = scanner.nextLine();
                    placeHolder.setEmail(email);
                    break;
                case 4:
                    System.out.println("");
                    placeHolder.setToNotify(!placeHolder.isToNotify());
                    break;
                case 5:
                    System.out.print("Please enter the new language: ");
                    String language = scanner.nextLine();
                    placeHolder.setLanguage(language);
                    break;
                case 6:
                    System.out.println("Please enter your playback Settings.\n1. AUTO \n2. LOW \n3. MEDIUM \n4. HIGH");
                    do {
                        System.out.print("Chooose a Play Back setting: ");
                        playback_choice = scanner.nextInt();
                    } while (!(playback_choice < 5 && playback_choice > 0));

                    switch (playback_choice) {
                        case 1:
                            Playback setting = Playback.AUTO;
                            break;
                        case 2:
                            setting = Playback.LOW;
                            break;
                        case 3:
                            setting = Playback.MEDIUM;
                            break;
                        default:
                            setting = Playback.HIGH;
                            break;
                    }
                    break;
                case 7:
                    System.out.print("Please enter something to toggle the activation status:");
                    scanner.next();
                    
                    break;
                case 8:
                    break;
                case 9:
                    break;
                default:
                    System.out.println("The Choice You Entered Is Not Valid!");
            }
        } else {
            System.out.println("The Profile you entered is not contained in your list of profiles for this account!");
        }
    }

    public void sortProfiles() {
        Collections.sort(profiles, new sortByName());
    }

    public ArrayList<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(ArrayList<Profile> profiles) {
        this.profiles = profiles;
    }

    public int getNumberOfProfiles() {
        return numberOfProfiles;
    }

    public void setNumberOfProfiles(int numberOfProfiles) {
        this.numberOfProfiles = numberOfProfiles;
    }

    @Override
    public String toString() {
        return "ProfileCollection{" + "profiles=" + profiles + ", numberOfProfiles=" + numberOfProfiles + '}';
    }

}
