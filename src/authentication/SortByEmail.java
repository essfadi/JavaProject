/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authentication;
import java.util.Comparator;
/**
 *
 * @author oessf
 */
public class SortByEmail implements Comparator<Account>{
    public int compare(Account a, Account b) {
        return a.getEmail().compareTo(b.getEmail());
    }
}
