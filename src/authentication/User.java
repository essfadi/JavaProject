package authentication;

import platform.component.Request;
import authentication.finance.PaymentMethod;
import customization.Profile;

public class User {

    private String phone;

    private Profile profile; // List or Array

    private Request requests; // List or Array

    private PaymentMethod pay_method;
    
    public User(String phone, Profile main_profile, PaymentMethod payment) {
        this.pay_method = payment;
        this.phone = phone;
        this.profile = main_profile;
    }

    public void view_prof_history() {
        // Cannot implemmented without aggregations
    }

    public void download_history() {
        // Cannot implemmented without aggregations
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Request getRequests() {
        return requests;
    }

    public void setRequests(Request requests) {
        this.requests = requests;
    }

    public PaymentMethod getPay_method() {
        return pay_method;
    }

    public void setPay_method(PaymentMethod pay_method) {
        this.pay_method = pay_method;
    }

    @Override
    public String toString() {
        return "User{" + "phone=" + phone + ", profile=" + profile.toString() + ", requests=" + requests.toString() + ", pay_method=" + pay_method.toString() + '}';
    }
    
}
