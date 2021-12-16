package authentication.finance;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PaymentMethod {

    private String holder_name;

    private GregorianCalendar expiration; // Date of expiration

    private Type type; // Enum

    private String number;

    public PaymentMethod(String holder_name, int month, int year, int choice_type, String number) {
        this.holder_name = holder_name;
        this.setExpiration(month, year);
        switch(choice_type) {
            case 1:
                this.type = Type.VISA;
                break;
            case 2:
                this.type = Type.MASTERCARD;
                break;
            case 3:
                this.type = Type.AMERICANEXPRESS;
                break;
        }
        this.number = number;
    }

    public String getHolder_name() {
        return holder_name;
    }

    public void setHolder_name(String holder_name) {
        this.holder_name = holder_name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpiration() {
        int month = expiration.get(Calendar.MONTH) + 1;
        int year = expiration.get(Calendar.YEAR);
        return month+"-"+year;
    }

    public void setExpiration(int month, int year) {
        GregorianCalendar expiration = new GregorianCalendar();
        expiration.set(GregorianCalendar.YEAR, year);
        expiration.set(GregorianCalendar.MONTH, month-1);
        expiration.set(GregorianCalendar.DATE, expiration.getActualMaximum(Calendar.DAY_OF_MONTH));

        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return "PaymentMethod:\n" + "Holder Name:" + holder_name + "\nExpiration: " + expiration.getTime() + "\nType: " + type.name() + "\nCard Number:" + number;
    }
    
}
