/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author oessf
 */
public class DateException extends Exception {

    public DateException(String str) {
        super(str);
    }

    public void recover() {
        System.err.println("Try for: \n\tMonth: 1->12 \n\t Days: 1->30");
    }
}
