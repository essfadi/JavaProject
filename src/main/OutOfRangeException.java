/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author user
 */
public class OutOfRangeException extends Exception {

    public OutOfRangeException(String message) {
        super(message);
    }

    public void recover() {
        System.err.println("Try integer values from the menu displayed above");
    }
}
