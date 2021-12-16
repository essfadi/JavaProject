package authentication;

import authentication.finance.PaymentMethod;
import authentication.finance.Subscription;
import customization.MaturityLevel;
import customization.Playback;
import customization.Profile;
import customization.ProfileCollection;
import customization.Language;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import main.AgeException;
import main.Netflix;
import platform.component.Request;
import platform.component.RequestCollection;
import platform.component.ViewingCollection;

public class User {

    private String phone;

    private ProfileCollection profile;

    private RequestCollection requests;

    private PaymentMethod pay_method;

    private ViewingCollection history;

    private Subscription subscription;

    public User(String phone) {
        this.phone = phone;
        this.profile = new ProfileCollection();
        this.requests = new RequestCollection();
        this.history = new ViewingCollection();
        this.pay_method = User.addPaymentMethod();
        this.subscription = User.addSubscription();

    }

    public void view_prof_history(Profile myProfile) {
        //Print History of profile
        this.history = myProfile.getViewing();
        if (history == null) {
            System.out.println("You have no history yet!");
        } else {
            System.out.println("Your Activity:");
            this.history.toString();
        }
    }

    public void download_history(String file) throws IOException, AgeException {
        // save view_prof_History to the file
        FileOutputStream fout = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(this.history);
        fout.close();
        out.close();
    }

    public void addProfile() {
        Scanner scanner = new Scanner(System.in);
        String profile_name, profile_email, profile_lang;
        boolean notification, subtitle;
        ArrayList<MaturityLevel> levels = new ArrayList();
        Playback setting;
        Language language;
        int profile_age, playback_choice, option1, option2, profile_choice;
        System.out.print("Enter a name for your profile: ");
        profile_name = scanner.nextLine();
        System.out.print("Enter an email for your profile: ");
        profile_email = scanner.next();
        System.out.print("Enter the minimum age that will use this profile: ");
        profile_age = scanner.nextInt();
        try {
            Netflix.setMaturityLevel(profile_age, levels);
        } catch (AgeException ex) {
            System.err.println(ex.getMessage());
            return;
        }
        // The Start for: Playback Settings (1)
        System.out.println("\n1. AUTO \n2. LOW \n3. MEDIUM \n4. HIGH");
        System.out.print("Choose your Data Usage setting: ");
        do {
            System.out.print("Chooose a Play Back setting: ");
            playback_choice = scanner.nextInt();
        } while (!(playback_choice < 5 && playback_choice > 0));

        switch (playback_choice) {
            case 1:
                setting = Playback.AUTO;
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
        System.out.print("Would you like to auto play next episodes in all devices?(if YES, Enter '1'): ");
        option1 = scanner.nextInt();
        setting.setAutoplayNextEpi(option1);
        System.out.print("Would you like to auto play previews while browsing on devices?(if YES, Enter '1'): ");
        option2 = scanner.nextInt();
        setting.setAutoplayPreviews(option2);
        System.out.print("Enter a language for your profile: ");
        profile_lang = scanner.next();
        System.out.print("Would you like to receive notifications?(if YES, Enter '1'): ");
        profile_choice = scanner.nextInt();
        notification = profile_choice == 1;
        System.out.print("Would you like to activate subtitle?(if YES, Enter '1'): ");
        profile_choice = scanner.nextInt();
        subtitle = profile_choice == 1;
        System.out.println("\n1.ENGLISH\n2.FRENCH\n3.GERMAN\n4.ITALIEN\n5.SPANISH\n6.POTUGUESE"
                + "\n7.ARABIC\n8.KOREAN\n9.TURKISH\n10.HEBREW\n11.CHINESE");
        profile_choice = 0;
        while (profile_choice < 1 || profile_choice > 11) {
            System.out.print("Enter your choice of languages: ");
            profile_choice = scanner.nextInt();
        }
        switch (profile_choice) {
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
            default:
                language = Language.ENGLISH;
                break;
        }
        Profile myProfile = new Profile(profile_name, levels.get(levels.size() - 1), profile_email, notification, profile_lang, setting, subtitle, language);
        this.profile.addProfile(myProfile);
    }

    public static Subscription addSubscription() {
        return (new Subscription(Subscription.addPlan()));
    }

    public static PaymentMethod addPaymentMethod() {
        Scanner scanner = new Scanner(System.in);
        String full_name;
        String card_number;
        int choice_card, month_exp, year_exp;
        System.out.print("Enter Your Legal Full Name: ");
        full_name = scanner.nextLine();
        System.out.println("1. Visa\n2. MasterCard\n3. American Express\n");
        do {
            System.out.print("Enter The Type of Your Card: ");
            choice_card = scanner.nextInt();
        } while (!(choice_card > 0 && choice_card < 4));
        System.out.print("Enter Month of Expiration: ");
        month_exp = scanner.nextInt();
        System.out.print("Enter Year of Expiration: ");
        year_exp = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your Card Number: ");
        card_number = scanner.next();
        return (new PaymentMethod(full_name, month_exp, year_exp, choice_card, card_number));
    }

    public void addRequest(Account owner) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the title of your requested show: ");
        String request = scanner.nextLine();
        requests.add(new Request(owner, request));
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ProfileCollection getProfile() {
        return profile;
    }

    public void setProfile(ProfileCollection profile) {
        this.profile = profile;
    }

    public RequestCollection getRequests() {
        return requests;
    }

    public void setRequests(RequestCollection requests) {
        this.requests = requests;
    }

    public PaymentMethod getPay_method() {
        return pay_method;
    }

    public void setPay_method(PaymentMethod pay_method) {
        this.pay_method = pay_method;
    }

    public ViewingCollection getHistory() {
        return history;
    }

    public void setHistory(ViewingCollection history) {
        this.history = history;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public String toString() {
        return "User: " + "\nPhone: " + phone + "\nProfile: " + profile.toString() + "\nRequests: " + requests.toString() + "\nPay Method: " + pay_method.toString();
    }

}
