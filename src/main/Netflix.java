package main;

import platform.component.Request;
import platform.component.Show;
import authentication.Account;
import authentication.finance.Plans;
import customization.ShowLanguage;
import customization.MaturityLevel;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import platform.component.Country;
import platform.component.Movies;
import platform.component.Seasons;
import platform.component.Series;
import platform.component.ShowCollection;

public class Netflix {

    private ShowCollection shows; // Array or List

    private Account customers; // Array or List

    private Request requests; // Array or List

    private Map<Plans, Double> plans_by_country = new HashMap<>();

    // Countries Selector or enum
    private final Map<String, String> maturityByCountry = new HashMap<>(); // Regions Selector or enum

    public Netflix() {
    }

    Netflix(ArrayList<Show> showList, Map plans_by_country, Map maturity_by_region) {
        shows=new ShowCollection();
        this.shows.addShows(showList); 
        this.plans_by_country = plans_by_country;

    }

    public final void setMaturityByRegion(Country country) {

        switch (country) {
            case MOROCCO:
                this.maturityByCountry.put("ALL", "Recommended for all\n");
                this.maturityByCountry.put("7+", "Recommended for ages 7 and up\n");
                this.maturityByCountry.put("13+", "Recommended for ages 13 and up \n");
                this.maturityByCountry.put("16+", "Recommended for ages 16 and up \n");
                this.maturityByCountry.put("18+", "Recommended for ages 18 and up\n");
                break;
            case UNITEDKINGDOM:
                this.maturityByCountry.put("U", "Suitable for all ages\n");
                this.maturityByCountry.put("PG", "Parental Guidance suggested\n");
                this.maturityByCountry.put("12", "Suitable for 12 and up\n");
                this.maturityByCountry.put("15", "Suitable for 15 and up\n");
                this.maturityByCountry.put("18", "Suitable for adults only\n");
                break;
            default:
                break;
        }

    }

    public Map getMaturityByRegion() {
        return maturityByCountry;
    }

    public Map getPlans_by_country() {
        return this.plans_by_country;
    }

    public void setPlans_by_country(Country country) {
        switch (country) {
            case UNITEDKINGDOM:
                this.plans_by_country.put(Plans.BASIC, 5.99);

                this.plans_by_country.put(Plans.STANDARD, 9.99);

                this.plans_by_country.put(Plans.PREMIUM, 13.99);
                break;
            case MOROCCO:
                this.plans_by_country.put(Plans.BASIC, 65.0);
                this.plans_by_country.put(Plans.STANDARD, 95.0);
                this.plans_by_country.put(Plans.PREMIUM, 125.0);
                break;
            default:
                break;
        }
    }

    public Account register() {
        System.out.println("======================================================");
        Scanner scanner = new Scanner(System.in);
        //Should be developped later for checking the format!
        String email;
        String password;
        System.out.print("Enter an email: ");
        email = scanner.next();
        scanner.nextLine();
        System.out.print("Enter a password: ");
        password = scanner.next();
        System.out.println("======================================================");

        return (new Account(email, password));
    }

    public void search() {
        // We don't have any prior data for shows and we are not allowed to use List or Array
        
    }

    public void browse() {
        // We don't have any prior data for shows and we are not allowed to use List or Array
    }

    public ShowCollection addShow() throws DateException, AgeException{
        System.out.println("======================================");
        Scanner scanner = new Scanner(System.in);
        String title;
        GregorianCalendar gcal;
        Quality quality;
        Genres genres = Genres.TVSHOWS;
        ShowLanguage language = ShowLanguage.ENGLISH;
        String names;
        String synopsis;
        int choice = 0;
        int release_year;
        int release_month;
        int release_day;
        int age;
        int choice_show, duration, seasons_num, episode_num;
        Seasons season;
        MaturityLevel levels;
        System.out.print("Enter the title of your show: ");
        title = scanner.nextLine();
        System.out.print("Enter the release year: ");
        release_year = scanner.nextInt();
        System.out.print("Enter the release month: ");
        release_month = scanner.nextInt();
        System.out.print("Enter the release day: ");
        release_day = scanner.nextInt();
        if ((release_year > 0 && release_year <= GregorianCalendar.getInstance().get(GregorianCalendar.YEAR))
                && (release_month > 0 && release_month < 13) && (release_day > 0 && release_day < 32)) {
            gcal = new GregorianCalendar(release_year, release_month, release_day);
        }
        else {
            throw new DateException("\tYou Have Entered a None-Logical Value for 'The Date Of Release'");
        }
        System.out.println("\n1. UHD\n2. ATOMOS\n3. HD");
        while (choice != 1 && choice != 2 && choice != 3) {
            System.out.print("Chooose a quality: ");
            choice = scanner.nextInt();
        }
        if (choice == 1) {
            quality = Quality.UHD;
        } else if (choice == 2) {
            quality = Quality.ATMOS;
        } else {
            quality = Quality.HD;
        }
        System.out.println("\n1.ACTION\n2.ANIME\n3.FAMILY\n4.CLASSIC\n5.COMEDIES\n6.DRAMAS"
                + "\n7.HORROR\n8.ROMANTIC\n9.SCIENCEFICTION\n10.SPORTS\n11.TVSHOWS");
        choice = 0;
        while (choice < 1 || choice > 11) {
            System.out.print("Enter your choice of genres: ");
            choice = scanner.nextInt();
        }
        switch (choice) {
            case 1:
                genres = Genres.ACTION;
                break;
            case 2:
                genres = Genres.ANIME;
                break;
            case 3:
                genres = Genres.FAMILY;
                break;
            case 4:
                genres = Genres.CLASSIC;
                break;
            case 5:
                genres = Genres.COMEDIES;
                break;
            case 6:
                genres = Genres.DRAMAS;
                break;
            case 7:
                genres = Genres.HORROR;
                break;
            case 8:
                genres = Genres.ROMANTIC;
                break;
            case 9:
                genres = Genres.SCIENCEFICTION;
                break;
            case 10:
                genres = Genres.SPORTS;
                break;
            case 11:
                genres = Genres.TVSHOWS;
                break;
        }
        System.out.println("\n1.ENGLISH\n2.FRENCH\n3.GERMAN\n4.ITALIEN\n5.SPANISH\n6.POTUGUESE"
                + "\n7.ARABIC\n8.KOREAN\n9.TURKISH\n10.HEBREW\n11.CHINESE");
        choice = 0;
        while (choice < 1 || choice > 11) {
            System.out.print("Enter your choice of languages: ");
            choice = scanner.nextInt();
        }
        switch (choice) {
            case 1:
                language = ShowLanguage.ENGLISH;
                break;
            case 2:
                language = ShowLanguage.FRENCH;
                break;
            case 3:
                language = ShowLanguage.GERMAN;
                break;
            case 4:
                language = ShowLanguage.ITALIEN;
                break;
            case 5:
                language = ShowLanguage.SPANISH;
                break;
            case 6:
                language = ShowLanguage.POTUGUESE;
                break;
            case 7:
                language = ShowLanguage.ARABIC;
                break;
            case 8:
                language = ShowLanguage.KOREAN;
                break;
            case 9:
                language = ShowLanguage.TURKISH;
                break;
            case 10:
                language = ShowLanguage.HEBREW;
                break;
            case 11:
                language = ShowLanguage.CHINESE;
                break;
        }
        scanner.nextLine();
        System.out.print("Enter the names of actors: ");
        names = scanner.nextLine();
        System.out.print("Enter the synopsis of your show: ");
        synopsis = scanner.nextLine();
        System.out.print("Enter the minimum age allowed to watch: "); // Should be a switch (not sure)
        age = scanner.nextInt();
        if (age > 0) {
            levels = new MaturityLevel(age);
        }
        else {
            throw new AgeException("\tThe Age You Entered Is Not Valid");
        }
        System.out.println("======================================================");

        System.out.print("********Show Menu*********\n1/Movie\n2/Serie\nPlease Enter your Choice:");
        do {
            choice_show = scanner.nextInt();
        } while (choice_show != 1 && choice_show != 2);
        if (choice_show == 1) {
            System.out.println("Please enter the duration of the movie in seconds: ");
            duration = scanner.nextInt();
            
            shows.addShow(new Movies(title, gcal, quality, genres, language, names, synopsis, levels, duration));
        } else {
            System.out.println("Please enter the number of seasons:");
            seasons_num = scanner.nextInt();
            System.out.println("Please enter the number of episodes:");
            episode_num = scanner.nextInt();
            shows.addShow(new Series(title, gcal, quality, genres, language, names, synopsis, levels, seasons_num));
            season = new Seasons(seasons_num, episode_num);
        }
        return (shows);
    }

}
