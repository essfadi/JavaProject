package NetflixApp;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import authentication.finance.Subscription;
import authentication.Account;
import authentication.finance.PaymentMethod;
import authentication.finance.Plan;
import authentication.User;
import customization.MaturityLevel;
import customization.Playback;
import customization.Profile;
import customization.ShowLanguage;
import platform.component.Request;
import main.Netflix;
import platform.component.Show;
import platform.component.Viewing;
import java.util.Scanner;
import main.AgeException;
import main.DateException;
import platform.component.Country;

/**
 *
 * @author oessf
 */
public class Essfadi_Hakkour {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Netflix netflix = new Netflix();
        Account fakeAccount = null;
        Plan myPlan = null;
        PaymentMethod method;
        Playback setting;
        Profile myProfile = null;
        Subscription mySubscription;
        MaturityLevel levels;
        ShowLanguage language;
        Request showRequest;
        User myUser;
        Show show = null;
        Viewing viewing = null;
        boolean notification, subtitle;
        int choice_menu, choice_card, choice_plan, choice_request, choice_subs, month_exp,
                year_exp, playback_choice, option1, option2,
                profile_choice, profile_age, authenticated_choice, choice_show, choice;
        String full_name, card_number, profile_email, profile_name, profile_lang, phone_number, request, cancelReason, retry_char;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\n\t1. Register.\n\t2. Access Profile.\n\t3. Request\n\t4. Add a show\n\t5. Subscrib\n\t6. Maturity Ratings By Country\n\t0. Exit.\n");
            do {
                System.out.print("Enter your Choice: ");
                choice_menu = scanner.nextInt();
            } while (choice_menu < 0 || choice_menu > 6);

            switch (choice_menu) {
                case 1:
                    if (fakeAccount == null) {
                        fakeAccount = netflix.register();
                        // Start for: Plan 
                        System.out.println("1. Basic\n2. Standard\n3. Premuim\n");
                        do {
                            System.out.print("Enter Your Plan: ");
                            choice_plan = scanner.nextInt();
                        } while (!(choice_plan > 0 && choice_plan < 4));
                        myPlan = new Plan(choice_plan);
                        // The END
                        // Start For: PaymentInfo
                        scanner.nextLine();
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
                        card_number = scanner.nextLine();
                        method = new PaymentMethod(full_name, month_exp, year_exp, choice_card, card_number);
                        // The End
                        // Create Subscription
                        mySubscription = new Subscription(myPlan);
                        // The Start for Profile
                        System.out.print("Enter a name for your profile: ");
                        profile_name = scanner.nextLine();
                        System.out.print("Enter an email for your profile: ");
                        profile_email = scanner.next();
                        System.out.print("Enter the minimum age that will use this profile: ");
                        profile_age = scanner.nextInt();
                        levels = new MaturityLevel(profile_age);
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
                        System.out.println("Enter a language for your profile: ");
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
                            default:
                                language = ShowLanguage.ENGLISH;
                                break;
                        }
                        myProfile = new Profile(profile_name, levels, profile_email, notification, profile_lang, setting, subtitle, language);
                        System.out.print("Enter your phone number: ");
                        phone_number = scanner.next();
                        myUser = new User(phone_number, myProfile, method);
                        System.out.println("\t\t======================================================");
                        System.out.println("\t\tYou Have Been Registered Successfully!!!");
                        System.out.println("\t\t======================================================");
                        // THE END
                    } else {
                        System.out.println("\n\tYou alreadu have an Account !!!");
                    }
                    // Settings for profile

                    break;
                // Add Your case 2
                case 2:
                    if (myProfile != null) {
                        do {
                            System.out.println("======================================================");
                            System.out.println("\t1. Change Maturity\n\t2. Add To Favorite\n\t3. View Show\n\t4. Rating\n\t0. Exit Profile");
                            System.out.println("======================================================");
                            do {
                                System.out.print("Enter your choice: ");
                                authenticated_choice = scanner.nextInt();
                            } while (choice_menu < 0 || choice_menu > 3);
                            switch (authenticated_choice) {
                                case 1:
                                    System.out.print("Enter the new minimal age you want for this profile: ");
                                    profile_age = scanner.nextInt();
                                    myProfile.modify_maturity(profile_age);
                                    break;
                                case 2:
                                    if (show != null) {
                                        myProfile.getFavorites().add(show);
                                        System.out.println(show.getTitle() + " is added to favorite!");
                                    } else {
                                        System.out.println("\nThere are no shows to add as favoite, exit this menu to add new one!\n");
                                    }
                                    break;
                                case 3:
                                    // Menu of Shows (we have only 1 shows)
                                    if (show != null && show.getLevels().getMin_age() <= myProfile.getLevel_restriction().getMin_age()) {
                                        // After choosing
                                        System.out.print("There is only one show as Max!!!");
                                        // Creating Viewing
                                        viewing = new Viewing(show);
                                        System.out.println(viewing.toString());
                                    } else {
                                        System.out.println("\nThere are no shows to view, exit this menu to add new one!\n");
                                    }

                                    break;
                                case 4:
                                    if (viewing != null && show != null) {
                                        System.out.println("If Thumbs up, Enter '1': ");
                                        choice_show = scanner.nextInt();
                                        viewing.rate(choice_show);
                                        System.out.println(show.getTitle() + " is rated with " + viewing.getRate());
                                    } else {
                                        System.out.println("\nThere are no Viewings to rate, exit this menu to add new one!\n");
                                    }
                                    break;
                            }
                        } while (authenticated_choice != 0);
                    } else {
                        System.out.println("\n\tYou Should Create a Profile!!!");
                    }
                    break;
                case 3:
                    //Request Show 
                    if (fakeAccount == null) {
                        System.out.println("Sorry you need to authenticate to make a request!");
                    } else {
                        scanner.nextLine();
                        System.out.print("Please enter your Show request: ");
                        request = scanner.nextLine();
                        showRequest = new Request(fakeAccount, request);
                        System.out.println("Your request has been sent successfully!\n Click '1' to see your request info.");
                        choice_request = scanner.nextInt();
                        if (choice_request == 1) {
                            System.out.println(showRequest.toString());
                        } else {
                            break;
                        }
                    }
                    break;
                case 4:
                    // Add a new show
                    do {
                        try {
                            show = netflix.addShow();
                            System.out.println("======================================================");
                            System.out.println(show.toString());
                            System.out.println("======================================================");
                        }
                        catch (AgeException err1) {
                            System.err.println(err1.getMessage());
                        }
                        catch (DateException err2) {
                            System.err.println(err2.getMessage());
                        } finally {
                            System.out.print("If you want to try again or add another show, enter 'YES': ");
                            retry_char = scanner.next();
                        }
                    } while (retry_char.compareToIgnoreCase("YES") == 0);
                    break;
                case 5:
                    //Subscrib
                    if (fakeAccount != null) {
                        do {
                            System.out.println("=========================================================");
                            System.out.println("Please Enter an option: \n1/ Change Plan\n2/ See your Billing by month\n3/Cancel subscribtion\n4/Exit");
                            choice_subs = scanner.nextInt();
                            //Plan should be initialized!
                            mySubscription = new Subscription(myPlan);
                            switch (choice_subs) {
                                case 1://change Plan
                                    do {
                                        System.out.println("Please choose your new plan: \n1. Basic\n2. Standard\n3. Premuim\n");
                                        choice_plan = scanner.nextInt();
                                    } while (!(choice_plan > 0 && choice_plan < 4));
                                    myPlan = new Plan(choice_plan);
                                    System.out.println(myPlan.toString());
                                    mySubscription.change_plan(myPlan);
                                    break;
                                case 2://See your billing by month
                                    mySubscription.billing_by_month();
                                    break;
                                case 3://cancel plan
                                    scanner.nextLine();
                                    System.out.println("Please enter the reason for your cancelation: ");
                                    cancelReason = scanner.nextLine();
                                    mySubscription.cancel(cancelReason);
                                    System.out.println("Your subscription is canceled successfully!\nReason: " + mySubscription.getCancel_reason());
                                    break;
                                case 4:
                                    System.out.println("Stay Safe!");
                                    break;
                            }
                        } while (choice_subs > 0 && choice_subs < 4);
                    } else {
                        System.out.println("You are not Subscribed!");
                    }
                    break;
                case 6:
                    //This is just to give info about what are the maturity ratings according to their region
                    System.out.println("\n\t1. Morocco \n\t2. United Kingdom ");
                    System.out.println("Choose your country: ");
                    choice = scanner.nextInt();
                    if (choice == 1) {
                        netflix.setMaturityByRegion(Country.MOROCCO);
                    } else {
                        netflix.setMaturityByRegion(Country.UNITEDKINGDOM);
                    }

                    System.out.println(netflix.getMaturityByRegion());
                    break;
                case 7:
                    if (fakeAccount != null) {
                        System.out.println("1. Change your password!");
                        System.out.println("2. Reset your password");
                        System.out.println("0. Exit");
                        do {
                            System.out.println("Enter your choice: ");
                            choice = scanner.nextInt();
                        } while (choice < 0 || choice > 2);
                        if (choice == 1) {
                            fakeAccount.changePass();
                        } else if (choice == 2) {
                            fakeAccount.resetPass();
                        }
                    } else {
                        System.out.println("You are not connected to your account!");
                    }
                    break;
            }
        } while (choice_menu != 0);
        System.out.println("\n\t\tThank You For Using Netflix, See You Soon!");
    }

}
