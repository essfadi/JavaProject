package main;

import platform.component.Request;
import platform.component.Show;
import authentication.Account;
import authentication.AccountCollection;
import authentication.finance.Plans;
import customization.Language;
import customization.MaturityLevel;
import customization.Profile;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import platform.component.Country;
import platform.component.Movies;
import platform.component.RequestCollection;
import platform.component.Seasons;
import platform.component.Series;
import platform.component.ShowCollection;

public class Netflix {

    public static ShowCollection shows;

    private AccountCollection accList;

    private RequestCollection requests; // Array or List

    private Map<Plans, Double> plans_by_country = new HashMap<>();

    // Countries Selector or enum
    private final Map<String, String> maturityByCountry = new HashMap<>(); // Regions Selector or enum

    public Netflix() {
        shows = new ShowCollection();
        accList = new AccountCollection();
        requests = new RequestCollection();
    }

    Netflix(ShowCollection showList, Map plans_by_country, Map maturity_by_region) {
        shows = new ShowCollection();
        accList = new AccountCollection();
        requests = new RequestCollection();
        shows.addShows(showList);
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

    public Account register() throws InvalidPasswordException {
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
        boolean flag = passwordCheck(password);
        System.out.println("======================================================");
        if (flag) {
            Account acc = new Account(email, password);
            return (accList.add(acc));
        } else {
            throw new InvalidPasswordException("Password Format is not Valid");
        }
    }

    public boolean passwordCheck(String pass) {
        boolean upper = false;
        boolean lower = false;
        boolean num = false;
        if (pass.length() == 8) {
            for (int i = 0; i < pass.length(); i++) {
                char c = pass.charAt(i);
                if (Character.isDigit(c)) {
                    num = true;
                } else if (Character.isUpperCase(c)) {
                    upper = true;
                } else if (Character.isLowerCase(c)) {
                    lower = true;
                }
                if (num && upper && lower) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public void search() throws OutOfGenresException {
        // We ask the user then implement one of the 3 types of search()
        Scanner scanner = new Scanner(System.in);
        System.out.println("We have Try types of Search: (1. by Title 2. by Genre 3. by Language");
        int choice = scanner.nextInt();
        System.out.println("Enter a keyword please based on your choice: ");
        String data = scanner.next();
        switch (choice) {
            case 1:
                System.out.println(shows.searchByTitle(data).toString());
                break;
            case 2:
                try {
                    System.out.println(shows.searchByGenre(data).toString());
                } catch (OutOfGenresException ex) {
                    System.err.println(ex.getMessage());
                    ex.recover();
                }
                break;
            case 3:
                shows.searchByLang(shows.searchByLang(data).toString());
                break;
        }
    }

    public void browse(Profile myProfile) {
        // To display all shows available
        if (myProfile != null) {
            Iterator<Show> iter = shows.getShows().iterator();;
            while (iter.hasNext()) {
                Show show = iter.next();
                if (show.getLevels().contains(myProfile.getLevel_restriction())) {
                    shows.toString();
                }
            }
            System.out.println("there are no shows to display!");
        }
        System.out.println("You don't have a profile!");
    }

    public void request(Account fake, String title) {
        Scanner scanner = new Scanner(System.in);
        if (fake == null) {
            System.out.print("Sorry you need to authenticate to make a request!");
        } else {
            Request request = new Request(fake, title);
            System.out.println("Your request has been sent successfully!\n Click '1' to see your request info.");
            int choice_request = scanner.nextInt();
            if (choice_request == 1) {
                System.out.println(request.toString());
            }
        }
    }

    public static ShowCollection addShow() throws DateException, AgeException {
        System.out.println("======================================");
        Scanner scanner = new Scanner(System.in);
        String title;
        GregorianCalendar gcal;
        Quality quality;
        Genres genre = Genres.TVSHOWS;
        ArrayList<Genres> genres = new ArrayList();
        Language language = Language.ENGLISH;
        String[] names = new String[5];
        String synopsis;
        int choice = 0;
        int release_year;
        int release_month;
        int release_day;
        int age, num_views, total_watch;
        double average_rating;
        int choice_show, duration, seasons_num, episode_num;
        Seasons season;
        ArrayList<MaturityLevel> levels = new ArrayList<>();

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
        } else {
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
            genres.add(Genres.values()[choice]);
        }
        switch (choice) {
            case 1:
                genre = Genres.ACTION;
                break;
            case 2:
                genre = Genres.ANIME;
                break;
            case 3:
                genre = Genres.FAMILY;
                break;
            case 4:
                genre = Genres.CLASSIC;
                break;
            case 5:
                genre = Genres.COMEDIES;
                break;
            case 6:
                genre = Genres.DRAMAS;
                break;
            case 7:
                genre = Genres.HORROR;
                break;
            case 8:
                genre = Genres.ROMANTIC;
                break;
            case 9:
                genre = Genres.SCIENCEFICTION;
                break;
            case 10:
                genre = Genres.SPORTS;
                break;
            case 11:
                genre = Genres.TVSHOWS;
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
                language = Language.ENGLISH;
                break;
            case 2:
                language = Language.FRENCH;
                break;
            case 3:
                language = Language.GERMAN;
                break;
            case 4:
                language = Language.ITALIEN;
                break;
            case 5:
                language = Language.SPANISH;
                break;
            case 6:
                language = Language.POTUGUESE;
                break;
            case 7:
                language = Language.ARABIC;
                break;
            case 8:
                language = Language.KOREAN;
                break;
            case 9:
                language = Language.TURKISH;
                break;
            case 10:
                language = Language.HEBREW;
                break;
            case 11:
                language = Language.CHINESE;
                break;
        }
        scanner.nextLine();
        System.out.print("Enter the names of actors: ");
        String name = scanner.nextLine();
        for (int i = 0; i < names.length; i++) {
            names[i] = name;
        }
        System.out.print("Enter the synopsis of your show: ");
        synopsis = scanner.nextLine();
        System.out.print("Enter the minimum age allowed to watch: "); // Should be a switch (not sure)
        age = scanner.nextInt();
        setMaturityLevel(age, levels);
        System.out.print("Enter the total watch: ");
        total_watch = scanner.nextInt();
        System.out.print("Enter the number of views:");
        num_views = scanner.nextInt();
        System.out.print("Enter the average rating:");
        average_rating = Double.parseDouble(scanner.next());
        System.out.println("======================================================");
        System.out.print("********Show Menu*********\n1/Movie\n2/Serie\nPlease Enter your Choice:");
        do {
            choice_show = scanner.nextInt();
        } while (choice_show != 1 && choice_show != 2);
        if (choice_show == 1) {
            System.out.println("Please enter the duration of the movie in seconds: ");
            duration = scanner.nextInt();

            shows.addShow(new Movies(title, gcal, quality, genres, language, names, synopsis, levels, num_views, average_rating, total_watch, duration));
        } else {
            System.out.println("Please enter the number of seasons:");
            seasons_num = scanner.nextInt();
            System.out.println("Please enter the number of episodes:");
            episode_num = scanner.nextInt();
            shows.addShow(new Series(title, gcal, quality, genres, language, names, synopsis, levels, num_views, average_rating, total_watch, seasons_num));
            season = new Seasons(seasons_num, episode_num);
        }
        return (shows);
    }

    public static void setMaturityLevel(int age, ArrayList<MaturityLevel> levels) throws AgeException {
        if (age > 0) {
            if (age < 7) {
                levels.add(MaturityLevel.ALL);
            } else if (age < 13) {
                levels.add(MaturityLevel.ALL);
                levels.add(MaturityLevel.KIDS);
            } else if (age < 16) {
                levels.add(MaturityLevel.ALL);
                levels.add(MaturityLevel.KIDS);
                levels.add(MaturityLevel.TEENS);
            } else if (age < 18) {
                levels.add(MaturityLevel.ALL);
                levels.add(MaturityLevel.KIDS);
                levels.add(MaturityLevel.TEENS);
                levels.add(MaturityLevel.ADULT);
            } else {
                levels.add(MaturityLevel.ALL);
                levels.add(MaturityLevel.KIDS);
                levels.add(MaturityLevel.ADULT);
                levels.add(MaturityLevel.ADULTS);
            }
        } else {
            throw new AgeException("\tThe Age You Entered Is Not Valid");
        }
    }

    public AccountCollection getAccList() {
        return accList;
    }

    public void setAccList(AccountCollection accList) {
        this.accList = accList;
    }

    public RequestCollection getRequests() {
        return requests;
    }

    public void setRequests(RequestCollection requests) {
        this.requests = requests;
    }

    //To string
    @Override
    public String toString() {
        return "Netflix:\n" + "Accounts Registered:\n" + accList.toString() + ", requests:\n" + requests.toString() + ", plans_by_country=" + plans_by_country + ", maturityByCountry:\n" + maturityByCountry.toString() + '}';
    }
}
