
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
    public Input() {
    }
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
    
    // Use this fucntion to check semester
    boolean checkSemester (String semester){
        // If the semester is either spring or summer or winter, then return true
        if (semester.equalsIgnoreCase("spring") 
                || semester.equalsIgnoreCase("summer") 
                || semester.equalsIgnoreCase("winter"))
            return true;
        // Else if it is not, return false
        else return false;
                   
    }
    
    // This function is used to check valid course
    boolean checkCourse (String course){
        // If the course either .net or c/c++ or java, then return true
        if (course.equalsIgnoreCase(".net") 
                || course.equalsIgnoreCase("c/c++") 
                || course.equalsIgnoreCase("java"))
            return true;
        // else if it's not neither, return false
        else return false;
        
    }
    
//    // This function is used to check if an ID is already exist
//    boolean checkDuplicateByID (String id, List<Student> a){
//        // We use this loop to check each student
//        for (int i = 0; i < a.size(); i++) {
//            // If id exists, then return false
//            if (id.equalsIgnoreCase(a.get(i).id))
//                return false;
//        }
//        // Else if it's not, return true
//        return true;
//    }
    
    // This function is used to check if updating student is 
    // duplicate with other student in the course
    boolean checkDuplicateUpdating (String id, String semester
            , String course, List<Student> a){
        // We use this foor loop to search for duplicated student
        for (int i = 0; i < a.size(); i++) {
            // if we found duplicate, then return false
            if (a.get(i).id.equalsIgnoreCase(id) && a.get(i).semester.equalsIgnoreCase(semester) 
                    && a.get(i).course.equalsIgnoreCase(course))
                return false;
        }
        // else return true if we cant found
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
    // This function is used to check if item is existed in the list
    boolean checkItem (List<Student> search, int item){
        // We use for loop to search
        for (int i = 0; i < search.size(); i++) {
            // if item exists, then we reutrn true
            if (item == i){
                return true;
            }
        }
        // else if it doesn't, then we return false
        return false;
    }
    
    // This function is used to check update or delete only
     boolean updateOrDelete (String choice){
        if (choice.equalsIgnoreCase("U") || choice.equalsIgnoreCase("D")){
            return true;
        }
        else {
            return false;
        }
    }
}
