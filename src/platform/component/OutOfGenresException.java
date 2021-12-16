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
public class OutOfGenresException extends Exception{
    
    public OutOfGenresException(String message){
        super(message);
    }
    public void recover(){
        System.err.println("Try: Action, Romance, COMEDIES, DRAMAS, HORROR.....");
    }
}
