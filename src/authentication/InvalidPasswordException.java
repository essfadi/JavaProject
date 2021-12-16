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
public class InvalidPasswordException extends Exception{

    public InvalidPasswordException(String string) {
        super(string);
    }
    public void recover(){
        System.err.println("Password must contain 8 characters: 1 interger, 1 uppercase and 1 lowercase");
    }
}
