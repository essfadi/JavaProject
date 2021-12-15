package netflixApp;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import authentication.finance.Subscription;
import authentication.Account;
import authentication.AccountCollection;
import authentication.finance.PaymentMethod;
import authentication.finance.Plan;
import authentication.User;
import customization.BlockedCollection;
import customization.MaturityLevel;
import customization.Playback;
import customization.Profile;
import customization.ProfileCollection;
import customization.ShowLanguage;
import java.util.ArrayList;
import platform.component.Request;
import main.Netflix;
import platform.component.Show;
import platform.component.Viewing;
import java.util.Scanner;
import main.AgeException;
import main.DateException;
import main.OutOfRangeException;
import platform.component.Country;
import platform.component.ShowCollection;

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
        AccountCollection accList = new AccountCollection();
        Plan myPlan = null;
        PaymentMethod method;
        Playback setting;
        Profile myProfile = null;
        ProfileCollection profiles = new ProfileCollection();
        ShowCollection showList = null;
        Subscription mySubscription;
        ArrayList<MaturityLevel> levels = new ArrayList<>();
        ShowLanguage language;
        Request showRequest;
        User myUser=null;
        Show show = null;
        boolean notification, subtitle;
        int choice_menu, choice_card, choice_plan, choice_request, choice_subs, month_exp,
                year_exp, playback_choice, option1, option2,
                profile_choice, profile_age, authenticated_choice, choice_show, choice;
        String full_name, card_number, profile_email, profile_name, profile_lang, phone_number, request, cancelReason, retry_char;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\n\t1. Account Menu.\n\t2. Profile Menu.\n\t3. Request\n\t4. Add a show\n\t5. Subscrib\n\t6. Maturity Ratings By Country\n\t0. Exit.\n");
            do {
                System.out.print("Enter your Choice: ");
                choice_menu = scanner.nextInt();
            } while (choice_menu < 0 || choice_menu > 6);

            switch (choice_menu) {
                case 1:
                    do {
                        System.out.println("=========Account Menu=========\n1. Register\n2. Authenticate\n3. Add profile"
                                + "\n4.Delete Account\n5.Exit");
                        choice = scanner.nextInt();
                    } while (choice < 1 && choice > 5);
                    switch (choice) {
                        case 1:
                            //Register Account
                            fakeAccount = netflix.register();
                            fakeAccount.getUser().addProfile();
                            break;
                        case 2:
                            //authenticate
                            System.out.println("Enter your email:");
                            String email= scanner.nextLine();
                            System.out.println("Enter your password:");
                            String password= scanner.nextLine();
                            fakeAccount= new Account(email, password);
                            fakeAccount.authenticate();
                            break;
                        case 3:
                            //add profile 
                            if(accList!=null){
                                if(profiles.getNumberOfProfiles()<5 && myUser!=null)
                                    myUser.addProfile();
                            }else
                                System.out.println("There is no account! Register or authenticate first!");
                            break;
                        case 4:
                            //Delete Account
                            if(fakeAccount!=null)
                                accList.remove(fakeAccount);
                            else 
                                System.out.println("Authenticate to delete the account!");
                            break;
                        case 5:
                            System.out.println("Exit Account Menu!");
                            break;
                    }
                    break;
                // Add Your case 2

                case 2:
                    if (myProfile != null) {
                        do {
                            System.out.println("======================================================");
                            System.out.println("\t1. Change Maturity\n\t2. Show Menu\n\t3. Remove Profile\n\t0. Exit Profile");
                            System.out.println("======================================================");
                            do {
                                System.out.print("Enter your choice: ");
                                authenticated_choice = scanner.nextInt();
                            } while (choice_menu < 0 || choice_menu > 3);
                            switch (authenticated_choice) {
                                case 1:
                                    try {
                                        myProfile.modify_maturity();
                                    } catch (OutOfRangeException err) {
                                        System.out.println(err.getMessage());
                                    }
                                    break;
                                case 2:
                                    BlockedCollection notAllowed = myProfile.getBlocked();
                                    ShowCollection allowed = notAllowed.generateAllowedShows(showList, myProfile);
                                    System.out.println("--------------Show_Menu-------------\n\t1. AddFavorites\n\t2. Edit \n\t3. Remove"
                                            + "\n\t4. View Show \n\t5. Rate Show \nEnter your choice: ");
                                    int choice_show_menu = scanner.nextInt();
                                    System.out.println(allowed);
                                    switch (choice_show_menu) {
                                        case 1:
                                            //add favorites
                                            if (showList != null) {
                                                scanner.nextLine();
                                                System.out.println(showList.toString());
                                                System.out.println("enter the title of your show:");
                                                String title = scanner.nextLine();
                                                System.out.println(title);
                                                Show s = showList.searchByTitle(title);
                                                if (s != null) {
                                                    myProfile.add_favorite(s);
                                                    System.out.println(s.getTitle() + " is added to favorite!");
                                                } else {
                                                    System.out.println("The movie doesn't exist!");
                                                }
                                            } else {
                                                System.out.println("\nThere are no shows to add as favoite, exit this menu to add new one!\n");
                                            }
                                            break;
                                        case 2:
                                            // Edit show in fav
                                            System.out.println("Enter the title of the show to edit");
                                            String title = scanner.nextLine();
                                            System.out.println("Rate this show: \n\t1/ Thumbs Up\n\t Thumbs Down");
                                            int choice_rate = scanner.nextInt();
                                            myProfile.getFavorites().modify(title, choice_rate);
                                            break;
                                        case 3:
                                            // Remove show from favorites
                                            String toRemove;
                                            System.out.println("Please enter the title of the show to remove:");
                                            toRemove = scanner.nextLine();
                                            myProfile.getFavorites().remove(toRemove);
                                            System.out.println("Show was Removed Sucessfully!");
                                            break;
                                        case 4:
                                            // Viewing
                                            System.out.println("Choose the show that you want to watch by title: ");
                                            String title_viewing = scanner.nextLine();
                                            Show show_viewing = allowed.searchByTitle(title_viewing);
                                            if (show_viewing != null) {
                                                showList.searchByTitle(title_viewing).view();
                                                myProfile.getViewing().add(new Viewing(show_viewing));
                                            } else {
                                                System.out.println("There is no show with this title!");
                                            }
                                            title_viewing = null;
                                            show_viewing = null;
                                            break;
                                        case 5:
                                            //Rate
                                            if (!myProfile.getViewing().getViewings().isEmpty()) {
                                                System.out.println(myProfile.getViewing().toString());
                                                System.out.println("Choose the show that you want to watch by title: ");
                                                String title_rate = scanner.nextLine();
                                                Show show_rate = allowed.searchByTitle(title_rate);
                                                if (show_rate != null) {
                                                    System.out.println("If Thumbs up, Enter '1': ");
                                                    choice_show = scanner.nextInt();
                                                    for (Viewing view : myProfile.getViewing().getViewings()) {
                                                        if (view.getShow().equals(show_rate)) {
                                                            view.rate(choice_show);
                                                        }
                                                    }
                                                    System.out.println(show_rate.getTitle() + " is rated");
                                                } else {
                                                    System.out.println("You did not view the show that you wanna rate!");
                                                }
                                            } else {
                                                System.out.println("\nThere are no Viewings to rate, exit this menu to add new one!\n");
                                            }
                                            break;
                                    }
                                    break;
                                case 3:
                                    // Remove Profile  
                                    System.out.println("Would you like to delete this profile? Press 1 if yes:");
                                    choice = scanner.nextInt();
                                    if (choice == 1) {
                                        System.out.println("This Profile no longer exists!");
                                        profiles.removeProfile(myProfile);
                                    }
                                    //Done
                                    break;
                                case 0:
                                    //Exit
                                    System.out.println("=======================");
                                    System.out.println("       Main Menu");
                                    System.out.println("=======================");
                                    break;
                            }
                        } while (authenticated_choice != 0);
                    } else {
                        System.out.println("\n\tYou Should Create a Profile!!!");
                    }
                    break;
                case 3:
                    //Request Show
                    System.out.println("Please enter your show request:");
                    request = scanner.nextLine();
                    netflix.request(fakeAccount, request);
                    break;
                case 4:
                    // Add a new show
                    do {
                        try {
                            showList = new ShowCollection();
                            showList = Netflix.addShow();
                            System.out.println("Test1");
                            System.out.println("======================================================");
                            System.out.println(showList.toString());
                            System.out.println("Test2");
                            System.out.println("======================================================");
                        } catch (AgeException err1) {
                            System.err.println(err1.getMessage());
                        } catch (DateException err2) {
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
