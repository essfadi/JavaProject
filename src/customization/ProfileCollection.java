/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ListIterator;
import java.util.Set;
import platform.component.*;
import customization.*;

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
        int choice_change;
        if (placeHolder != null) {
            System.out.println("1. Name.\n2. Level of restriction.\n3. email."
                    + "\n4. Notifications.\n5. Language.\n6. Playback Option."
                    + "\n7. Subtitle Activation.\n8. Favorite Shows.\n"
                    + "9. Blocked Shows.\n10. Subtitle Language.\n");
            System.out.print("Choose The Element You want to change: ");
            choice_change = scanner.nextInt();
            switch (choice_change) {
                case 1:
                    System.out.print("Please eneter the new name:");
                    String newname = scanner.nextLine();
                    placeHolder.setName(newname);
                    break;
                case 2:
                    System.out.println("Please enter the minimal age for this profile:");
                    int age = scanner.nextInt();
                    MaturityLevel level = new MaturityLevel(age);
                    placeHolder.setLevel_restriction(level);
                    break;
                case 3:
                    System.out.print("Please enter the new email: ");
                    String email = scanner.nextLine();
                    placeHolder.setEmail(email);
                    break;
                case 4:
                    System.out.println("Your Notification status has been changed!");
                    placeHolder.setToNotify(!placeHolder.isToNotify());
                    if (placeHolder.isToNotify()) {
                        System.out.println("Notifications are activated!");
                    } else {
                        System.out.println("Notifications are disactivted!");
                    }
                    break;
                case 5:
                    System.out.print("Please enter the new language: ");
                    String language = scanner.nextLine();
                    placeHolder.setLanguage(language);
                    break;
                case 6:
                    System.out.print("Please enter your playback Settings.\n1. AUTO \n2. LOW \n3. MEDIUM \n4. HIGH");
                    String playBack = scanner.nextLine();
                    placeHolder.setPlayback(Playback.valueOf(playBack.toUpperCase()));
                    break;
                case 7:
                    System.out.print("Please enter a space to toggle the activation status:");
                    String click = scanner.nextLine();
                    placeHolder.setSubtitles(!placeHolder.isSubtitles());
                    break;
                case 8:
                    System.out.print("Please enter a show that you would like to remove from Favorites: ");
                    String title = scanner.nextLine();
                    //Search for show by name
                    if (placeHolder.getFavorites() == null) {
                        System.out.println("You have no show in Favorites List");
                    } else {
                        ListIterator<Show> iter = placeHolder.getFavorites().listIterator();
                        while (iter.hasNext()) {
                            Show s = iter.next();
                            if (title.equalsIgnoreCase(s.getTitle())) {
                                placeHolder.getFavorites().remove(s);
                                System.out.println(placeHolder.getFavorites());
                            }
                        }
                        System.out.println("The show" + title + "you are looking for does not exist in Favorites List");
                    }
                    break;
                case 9:
                    System.out.print("Please enter the title of the show to remove from the blocked list:");
                    title = scanner.nextLine();
                    if (placeHolder.getBlocked() == null) {
                        System.out.println("Your Blocked List is Empty!");
                    } else {
                        ListIterator<Show> iter = placeHolder.getBlocked().listIterator();
                        while (iter.hasNext()) {
                            Show b = iter.next();
                            if (title.equals(b.getTitle())) {
                                placeHolder.getBlocked().remove(b);
                            }
                        }
                        System.out.println("The show" + title + "you are looking for does not exist in Blocked List");
                    }
                    break;
                case 10:
                    System.out.println("Please enter the new language of subtitles");
                    String subtitle = scanner.nextLine();
                    placeHolder.setSubtitle_lang(Language.valueOf(subtitle.toUpperCase()));

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
