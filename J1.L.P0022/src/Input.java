
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
 * @author Admin
 */
public class Input {
    Scanner in = new Scanner (System.in);
    
    // This function is used to check valid name
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
            if (name.charAt(i) < 65)
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
    // Check Birth date
    boolean checkBirthDate(String birthDate){
        int birthDate1;
        // We use try catch block to catch IllegalFormatException
        // If we catch one, then return false
        try {
            
            birthDate1 = Integer.parseInt(birthDate);
        } catch (Exception e){
            return false;
        }
        // If birthDate is out of range (1900,current year), then return false
        if (birthDate1 < 1900 || birthDate1 > (Calendar.getInstance().get(Calendar.YEAR))){
            return false;
        }
        // Else if it's not, then return true
        return true;
    }
    
    // Use this fucntion to check semester
    boolean checkSemester (String semester){
        // If the semester is either spring or summer or winter, then return true
        if (semester.equalsIgnoreCase("spring") || semester.equalsIgnoreCase("summer") || semester.equalsIgnoreCase("winter"))
            return true;
        // Else if it is not, return false
        else return false;
                   
    }
    
    
    // This function is used to check if an ID is already exist
    boolean checkDuplicateByID (String id, List<Candidate> a){
        // We use this loop to check each student
        for (int i = 0; i < a.size(); i++) {
            // If id exists, then return false
            if (id.equalsIgnoreCase(a.get(i).id))
                return false;
        }
        // Else if it's not, return true
        return true;
    }
    
    // This function is used to check if valid phone number
    boolean checkPhoneNumber (String phone){
        for (int i = 0; i < phone.length(); i++) {
            if (phone.charAt(i) < 48 || phone.charAt(i) > 57 )
                return false;
        }
        // If phone having less than 10 characters then return false
        if (phone.length() < 10) {
            return false;
        }
        // Else if it's not, return true
        else {
            return true;
        }
        
    }
    
    // This function is used to check valid email
    boolean checkEmail (String email) {
        String EMAIL_REGEX = "^(.+)@(.+)$";
        boolean check = email.matches(EMAIL_REGEX);
        return check;
        }
    
    
    // This function is used to check valid type
    boolean checkType (String type) {
        try {
            // This try catch block is used to catch IllegalFormat when we
            // convert String into Int, if there's exception, we return false
            int type1 = Integer.parseInt(type);
        } catch (Exception e){
            return false;
        }
        
        // If type is not either 0, 1, or 2 then we return false
        if (type.equals("0") || type.equals("1") ||
                type.equals("2")){
            return true;
        }
        // else if it's not, then we return true
        
            return false;
        
        
    }
    
    // This function is used to check valid Year of Experience
    
    boolean checkYearOfExp (String yearOfExp){
        
        int yearOfExp1;
        // This try catch is used to catch IllegalFormat
        try {
            yearOfExp1 = Integer.parseInt(yearOfExp);
        } catch (Exception e) {
            return false;
        }
        
        // If yearOfExp1 is less than 0 or is more than 100 then return true;
        if (yearOfExp1 < 0 && yearOfExp1 > 100) {
            return false;
        }
        // Else if it's not then return true;
        else {
            return true;
        }
    }
    
    // This function is used to check valid rank of graduation
    boolean checkRank (String rank){
        // If rank is not either Excellence, Good, Fair or Poor, 
        //  then return false
        if (rank.equalsIgnoreCase("Excellence")
            || rank.equalsIgnoreCase("Good") 
            || rank.equalsIgnoreCase("Fair") 
            || rank.equalsIgnoreCase("Poor"))
        {
            return true;
        }
        // Else if it is, then return true;
        
            return false;
        
    }
    
    // This  function is used to check valid date 
    boolean checkDate (String dateOfGraduation){
        
        // Use SimpleDateFormat class to specify our own date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        // Set dateFormat to 'Strict Format' which means that the input has to 
        // match the format.
        dateFormat.setLenient(false);
        
        try {
            // Parse the date in to Date class
            Date date = dateFormat.parse(dateOfGraduation);
            // If we catch ParseException while parsing, then return false;
        } catch (ParseException e){
            return false;
        }
        // Else if it is not, then we return true;
        return true;
        
    }
    
    
    
    
}
    
    
    

