package customization;

import java.util.InputMismatchException;
import java.util.Scanner;
import main.OutOfRangeException;
import platform.component.Show;

public class Profile {

    private String name;

    private MaturityLevel level_restriction;

    private String email;

    private boolean toNotify;

    private String language;

    private Playback playback; // I think Enum or another Class

    private boolean subtitles;

    private FavoritesCollection favorites; // List or Array or Enum

    private BlockedCollection blocked; // List or Array or Enum

    private ShowLanguage subtitle_lang; // List or Array or Enum

    public Profile(String name, MaturityLevel level_restriction, String email,
            boolean toNotify, String language, Playback playback,
            boolean subtitles, ShowLanguage subtitle_lang) {
        this.name = name;
        this.level_restriction = level_restriction;
        this.email = email;
        this.toNotify = toNotify;
        this.language = language;
        this.playback = playback;
        this.subtitles = subtitles;
        this.subtitle_lang = subtitle_lang;
        this.favorites = new FavoritesCollection();
        this.blocked = new BlockedCollection();
    }

    public void modify_maturity() throws OutOfRangeException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. All\n2. +7\n3. +13\n4. +16\n5. +18.");
        int choice;
        try {
            choice = scanner.nextInt();
            if (choice > 0 && choice < 6) {
                setLevel_restriction(MaturityLevel.values()[choice - 1]);
                System.out.println("The Maturity level has been changed to: " + getLevel_restriction().toString());
            } else {
                throw new OutOfRangeException("Please Enter a choice within the range of choices!");
            }
        } catch (InputMismatchException err) {
            System.err.println("Please, enter a number for your choice!");
        } catch (ArrayIndexOutOfBoundsException err) {
            System.err.println("Please, enter a number within the choices!");
        }
    }

    public void add_favorite(Show show) {
        //add to favorites if exists
            favorites.add(show);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MaturityLevel getLevel_restriction() {
        return level_restriction;
    }

    public void setLevel_restriction(MaturityLevel level_restriction) {
        this.level_restriction = level_restriction;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isToNotify() {
        return toNotify;
    }

    public void setToNotify(boolean toNotify) {
        this.toNotify = toNotify;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Playback getPlayback() {
        return playback;
    }

    public void setPlayback(Playback playback) {
        this.playback = playback;
    }

    public boolean isSubtitles() {
        return subtitles;
    }

    public void setSubtitles(boolean subtitles) {
        this.subtitles = subtitles;
    }

    public FavoritesCollection getFavorites() {
        return favorites;
    }

    public void setFavorites(FavoritesCollection favorites) {
        this.favorites = favorites;
    }

    public BlockedCollection getBlocked() {
        return blocked;
    }

    public void setBlocked(BlockedCollection blocked) {
        this.blocked = blocked;
    }

    public ShowLanguage getSubtitle_lang() {
        return subtitle_lang;
    }

    public void setSubtitle_lang(ShowLanguage subtitle_lang) {
        this.subtitle_lang = subtitle_lang;
    }

    @Override
    public String toString() {
        return ("\nYour profile is name: " + name + level_restriction.toString()
                + "\nProfile's Language: " + language
                + "\nPofile's email: " + email + "\nNotifications Activation: " + toNotify
                + "\nSubtitle Activation: " + subtitles + ", in " + subtitle_lang.name()
                + playback.toString());
    }

}
