
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hungnlHE130716
 */
public class Input {
    Scanner in = new Scanner (System.in);
    
    // This function is used to check valid name
    boolean checkName (String name){
        
        // Use for loop to check each character
        for (int i = 0; i < name.length(); i++) {
            // If character is below 'A' in Unicode table then return false
            if (name.charAt(i) < 65 && name.charAt(i) != 32 && name.charAt(i) != 10){
                return false;
            }
            // Else if character is between 'Z' and 'a' in unicode table,
            // then return false
            else if (name.charAt(i) > 90 && name.charAt(i) < 97){
                return false;
            }
            else if (name.charAt(i) > 122)
                return false;
        }
        return true;
    }
    
    // Check blank
    boolean checkBlank(String text){
         boolean check = false;
        // Check if name is all space
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != 32){
                check = true;
            }
        }
        // If the name is all space, then return false
        if (check == false){
            return false;
        }
        
        if (text.equals("")){
            return false;
        }
        else {
            return true;
        }
    }
    
    // check birt date format
    boolean checkNumberFormat (String birthDate){
        for (int i = 0; i < birthDate.length(); i++) {
            if ((birthDate.charAt(i) < 48 && birthDate.charAt(i) != 32 
                    && birthDate.charAt(i) != 10) 
                    || birthDate.charAt(i) > 57){
                return false;
            }
        }
        return true;
    }
    
    // Check birt date
    boolean checkBirthDateRange (String birthDate){
        int birthDate1;
        birthDate1 = Integer.parseInt(birthDate);
        // If birthDate is out of range (1900, current year), then return false
        if (birthDate1 < 1900 
                || birthDate1 > (Calendar.getInstance().get(Calendar.YEAR))){
            return false;
        }
        // Else if it's not, then return true
        return true;
        
    }
    
    // Use this function to check semester
    boolean checkSemester (String semester){
        // If the semester is either Spring or Summer or Winter, then return true
        if (semester.equalsIgnoreCase("spring") 
                || semester.equalsIgnoreCase("summer") 
                || semester.equalsIgnoreCase("winter")){
            return true;
        }
        else {
            return false;
        }
    }
    
    // This function is used to check if an Id is already existed
    boolean checkDuplicateByID (String id, List<Candidate> a){
        // We use this loop to check each student
        for (int i = 0; i < a.size(); i++) {
            // If id exists, thenr eturn false
            if (id.equalsIgnoreCase(a.get(i).id)){
                return false;
            }
        }
        // Else if it's not, return true
        return true;
    }
    
    // This function is used to check valid phone number
    boolean checkPhoneNumber (String phone){
        
        // If phone having less than 10 characters then return false
        if (phone.length() < 10){
            return false;
        }
        // Else if it's not, return true
        else {
            return true;
        }
    }
    
    // This function is used to check valid email
    boolean checkEmail (String email){
        String REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+[.][a-zA-Z0-9.-]+$";
        boolean check = email.matches(REGEX);
        return check;
    }
    
    // This function is used to check valid type
    boolean checkType (String type){
        try {
            // This try catch block us used to catch IllegalFormatException
            // when we convert String into Int, if there's Exeption, return false
            int type1 = Integer.parseInt(type);
        } catch (Exception e){
            return false;
        }
        
        // If type is  either 0,1 or 2 then we return true
        if (type.equalsIgnoreCase("0") 
                || type.equalsIgnoreCase("1") 
                || type.equalsIgnoreCase("2")){
            return true;
        }
        // Else if it's not, return false
        else {
            return false;
        }
    }
    
    
    // This function is used to check valid Year Of Experience
    
    boolean checkYearOfExp (String yearOfExp) {
        
        
        int yearOfExp1 = Integer.parseInt(yearOfExp);
        // If yearOfExp1 is less than 0 or is more than 100 then return true
        if (yearOfExp1 < 0 || yearOfExp1 > 100){
            return false;
        }
        else {
            return true;
        }
    }
    
    // This function is used to check valid rank of Graduation
    boolean checkRank (String rank){
        // If rank is  either Excellence, Good, Fair or Poor
        // Then return true
        if (rank.equalsIgnoreCase("Excellence") 
                || rank.equalsIgnoreCase("Good") 
                || rank.equalsIgnoreCase("Fair") 
                || rank.equalsIgnoreCase("Poor")) {
            return true;
        }
        // Else if it's not, return false
        else {
            return false;
        }
    }
    
    // This function is used to check valid date
    
    boolean checkDate (String dateOfGraduation) {
        // Use SimpleDateFormat class to specify our own date format
        SimpleDateFormat dateFormat = new SimpleDateFormat ("MM/dd/yyyy");
        //Set dateFormat to "Strict Format" which means that the input has
        // to match the format
        dateFormat.setLenient(false);
        try {
            // Parse the date in to Date class
            Date date = dateFormat.parse(dateOfGraduation);
            // If we catch ParseException while parsing, then return false
        } catch (ParseException e){
            return false;
        }
        // Else if it is not, then return true
        return true;
    }
    // This function is used to check Yes or No only
    boolean checkYesNo (String choice){
        if (choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("Y")){
            return true;
        }
        else {
            return false;
        }
    }
    
    // this function is used to let people make choices
    
    void choose (List<Candidate> canList, Candidate candidate){
        String check;
                do {
                    canList.add(candidate.createNew(canList));
                    do {
                        System.out.print("Do you want to continue (Y/N): ");
                        check = in.nextLine();
                        if (!checkYesNo(check)) {
                            System.out.println("You have to answer Yes(Y) or No(N) only!");
                        }
                    } while (!checkYesNo(check));
                } while (!check.equalsIgnoreCase("N"));
    }
}
