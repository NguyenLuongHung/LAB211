
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
    // This function is used to check valid name
    boolean checkName(String name){
        // Use for loop to check each character
        for (int i = 0; i < name.length(); i++) {
            // If character is below 'A' in unicode table then return false
            if (name.charAt(i) < 65)
                return false;
            // else if character is between 'Z' and 'a' in unicode table then return false
            else if (name.charAt(i) > 90 && name.charAt(i) < 97)
                return false;
            // else if character is beyon 'z' in unicode table then return false
            else if (name.charAt(i) > 122)
                return false;
        }
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
    
    // This function is used to check valid course
    boolean checkCourse (String course){
        // If the course either .net or c/c++ or java, then return true
        if (course.equalsIgnoreCase(".net") || course.equalsIgnoreCase("c/c++") || course.equalsIgnoreCase("java"))
            return true;
        // else if it's not neither, return false
        else return false;
        
    }
    
    // This function is used to check if an ID is already exist
    boolean checkDuplicateByID (String id, List<Student> a){
        // We use this loop to check each student
        for (int i = 0; i < a.size(); i++) {
            // If id exists, then return false
            if (id.equalsIgnoreCase(a.get(i).id))
                return false;
        }
        // Else if it's not, return true
        return true;
    }
    
    // This function is used to check if updating student is duplicate with other student in the course
    boolean checkDuplicateUpdating (String id, String semester, String course, List<Student> a){
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).id == id && a.get(i).semester == semester && a.get(i).course == course)
                return false;
        }
        return true;
    }
}
