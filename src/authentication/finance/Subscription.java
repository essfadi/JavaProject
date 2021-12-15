package authentication.finance;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Subscription {

    private GregorianCalendar subscribed;

    private Plan current_plan; // Enum

    private GregorianCalendar canceled;

    private String cancel_reason;

    private final Map<Integer, Double> billing_by_month;
    private final GregorianCalendar month = new GregorianCalendar();

    public Subscription(Plan current_plan) {
        this.billing_by_month = new HashMap<>();
        this.subscribed = new GregorianCalendar();
        this.current_plan = current_plan;
    }

    public void change_plan(Plan newPlan) {
        this.subscribed = new GregorianCalendar();
        this.current_plan = newPlan;
    }

    public void billing_by_month() {
        if (current_plan != null) {
            if (billing_by_month != null) {
                this.billing_by_month.put(month.get(GregorianCalendar.MONTH) + 1, this.current_plan.getCost());
                billing_by_month.entrySet().forEach((E) -> {
                    System.out.println("Month: " + (int) E.getKey() + " Cost : " + (double) E.getValue());
                });
            } else {
                System.out.println("No bill for the moment");
            }
        } else {

            System.out.println("You are not subscribed!");
        }
    }

    public static Plan addPlan() {
        Scanner scanner = new Scanner(System.in);
        int choice_plan;
        System.out.println("1. Basic\n2. Standard\n3. Premuim\n");
        do {
            System.out.print("Enter Your Plan: ");
            choice_plan = scanner.nextInt();
        } while (!(choice_plan > 0 && choice_plan < 4));
        return (new Plan(choice_plan));
    }

    public void cancel(String reason) {
        this.cancel_reason = reason;
        this.current_plan = null;
        this.canceled = new GregorianCalendar();
    }

    public GregorianCalendar getSubscribed() {
        return subscribed;
    }

    public Plan getCurrent_plan() {
        return current_plan;
    }

    public GregorianCalendar getCanceled() {
        return canceled;
    }

    public String getCancel_reason() {
        return cancel_reason;
    }

    @Override
    public String toString() {
        return "Subscription{" + "subscribed=" + subscribed.getTime() + ", current_plan=" + current_plan.toString() + ", canceled=" + canceled.getTime() + ", cancel_reason=" + cancel_reason + ", billing_by_month=" + billing_by_month + ", month=" + month + '}';
    }

}
