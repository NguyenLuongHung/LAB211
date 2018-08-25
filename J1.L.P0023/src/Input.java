
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hungnlhe130716
 */
public class Input {

    // This function is used to check valid fruit name
    boolean checkName(String name) {

        // Use for loop to check each character
        for (int i = 0; i < name.length(); i++) {
            // If checracter is below 'A' in unicode table then return false
            if (name.charAt(i) < 65 && name.charAt(i) != 32 && name.charAt(i) != 10) {
                return false;
            } // Else if character is between 'Z' and 'a' in unicode talbe
            // then return false
            else if (name.charAt(i) > 90 && name.charAt(i) < 97) {
                return false;
            } // Else if character is beyon 'z' in unicode table then return false
            else if (name.charAt(i) > 122) {
                return false;
            }

        }
        return true;
    }

    // Check blank name
    boolean checkBlank(String text) {
        boolean check = false;
        // Check if name is all space
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != 32) {
                check = true;
            }
        }
        // If the name is all space, then return false
        if (check == false) {
            return false;
        }

        if (text.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    // This function is used to check if an ID is already exist
    boolean checkDuplicateByID(String id, List<Fruit> a) {
        // We use this loop to check each student
        for (int i = 0; i < a.size(); i++) {
            // If id exists, then return false
            if (id.equalsIgnoreCase(a.get(i).id)) {
                return false;
            }
        }
        // Else if it's not, return true
        return true;
    }

    // This function is used to check valid price
    boolean checkPrice(String text) {
        for (int i = 0; i < text.length(); i++) {
            // If character is out of range [0,9]
            // return false;
            if ((text.charAt(i) < 48 && text.charAt(i) != 46 && text.charAt(i) != 32)
                    || text.charAt(i) > 57) {
                return false;
            }
        }
        return true;
    }

    // This function is used to check valid quantitiy
    boolean checkQuantity(String text) {
        for (int i = 0; i < text.length(); i++) {
            // If character is out of range [0,9]
            // return false;
            if ((text.charAt(i) < 48 && text.charAt(i) != 32) || text.charAt(i) > 57) {
                return false;
            }
        }
        return true;
    }

    // Thif unction is used to check valid item choice
    boolean checkChoice(String id, List<Fruit> a) {
        for (int i = 0; i < a.size(); i++) {
            // If id is found then return true
            if (id.equalsIgnoreCase(a.get(i).id)) {
                return true;
            }
        }
        // Else if it's not found, then return false
        return false;
    }

    // This function is used to check Yes or No
    boolean checkYesNo(String choice) {
        if (choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("Y")) {
            return true;
        } else {
            return false;
        }
    }

    // Check if quantity  is equal 0
    boolean checkQuantityEqual0(String text) {
        if ((Integer.parseInt(text)) == 0) {
            return false;
        }
        return true;
    }

    // Check if price is equal 0
    boolean checkPriceEqual0(String text) {
        if ((Double.parseDouble(text)) == 0) {
            return false;
        }
        return true;
    }

    // This function is used to check if store no longer has fruit to sell
    boolean checkFruit(int id, List<Fruit> a) {
        // If this fruit has 0 quantity in store, then return false
        if (a.get(id).quantity.equalsIgnoreCase("0")) {
            return false;
        // Else if it's not, return true;
        } else {

            return true;
        }
    }
}
