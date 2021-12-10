/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authentication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author oessf
 */
public class AccountCollection {

    private ArrayList<Account> accounts;
    private int numberOfAccounts = 0;

    public AccountCollection() {
        accounts = new ArrayList();
    }

    public void add(Account acc) {
        if (search(acc.getEmail()) == null) {
            accounts.add(acc);
        } else {
            System.out.println("You already have an account!");
        }
    }

    public Account search(String email) {
        Iterator<Account> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            Account account = iterator.next();
            if (account.getEmail().equalsIgnoreCase(email)) {
                return account;
            }
        }
        return null;
    }

    public void remove(Account acc) {
        while (accounts != null) {
            if (accounts.contains(acc)) {
                accounts.remove(acc);
            } else {
                System.out.println("The account is not found, Deletion failed!");
            }
        }
    }

    public Account checkAcc(String email, String password) {
        Account acc = search(email);
        if (acc != null) {
            if (acc.getPassword().equals(password)) {
                return acc;
            } else {
                return null;
            }
        }
        return null;
    }

    public void modify(String email) {
        Account placeHolder = this.search(email);
        Scanner scanner = new Scanner(System.in);
        int choice_change;
        if (placeHolder != null) {
            System.out.println("1. Email.\n2.Password.\n");
            System.out.print("Choose The Element You want to change: ");
            choice_change = scanner.nextInt();
            switch (choice_change) {
                case 1:
                    System.out.println("You can not modify your email!");
                    break;
                case 2:
                    placeHolder.changePass();
                    break;
                default:
                    System.out.println("The Choice You Entered Is Not Valid!");
            }
        } else {
            System.out.println("The Profile you entered is not contained in your list of profiles for this account!");
        }
    }

    public void sort() {
        Collections.sort(accounts, new sortByEmail());
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public void setNumberOfAccounts(int numberOfAccounts) {
        this.numberOfAccounts = numberOfAccounts;
    }

    @Override
    public String toString() {
        String str = "";
        ListIterator<Account> iter = accounts.listIterator();
        while (iter.hasNext()) {
            Account acc = iter.next();
            str += acc.toString() + "\n";
        }
        return str;
    }

}
