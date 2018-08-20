
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Input {
    // this function is used to check valid fruit name
    boolean checkName(String name){
        boolean check = false;
        // Check if name is all space
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != 32){
                check = true;
            }
        }
        // If the name is all space, then return false
        if (check == false){
            return false;
        }
        // Use for loop to check each character
        for (int i = 0; i < name.length(); i++) {
            // If character is below 'A' in unicode table then return false
            if (name.charAt(i) < 65 && name.charAt(i) != 32)
                return false;
            // else if character is between 'Z' and 'a' in unicode table,
            //then return false
            else if (name.charAt(i) > 90 && name.charAt(i) < 97)
                return false;
            // else if character is beyon 'z' in unicode table then return false
            else if (name.charAt(i) > 122)
                return false;
        }
        return true;
    }
    
    // This function is used to check if an ID is already exist
    boolean checkDuplicateByID (String id, List<Fruit> a){
        // We use this loop to check each student
        for (int i = 0; i < a.size(); i++) {
            // If id exists, then return false
            if (id.equalsIgnoreCase(a.get(i).id))
                return false;
        }
        // Else if it's not, return true
        return true;
    }
    
    // This function is used to check valid price
    boolean checkPrice (String text){
        for (int i = 0; i < text.length(); i++) {
            // If character is out of range [0,9] and is not dot (.) 
            // return false;
            if ((text.charAt(i) < 48 && text.charAt(i) != 46) || text.charAt(i) > 57){
                return false;
            }
        }
        return true;
    }
    
    // This function is used to check valid quantity
    boolean checkQuantity (String text){
        for (int i = 0; i < text.length(); i++) {
            // If character is out of range [0,9] and is not dot (.) 
            // return false;
            if (text.charAt(i) < 48 || text.charAt(i) > 57){
                return false;
            }
        }
        return true;
    }
    
    // This function is used to check valid item choice
    boolean checkChoice (String id, List<Fruit> a){
        for (int i = 0; i < a.size(); i++) {
            // if id found then return true
            if (id.equalsIgnoreCase(a.get(i).id)){
                return true;
            }
        }
        //Else if it's not found, then return false;
        return false;
    }
}
