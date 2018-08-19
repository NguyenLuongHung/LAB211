
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
public class Format {
    // This function is used to upper the first character of word
    String firstCharToUpper(String text){
        text = Character.toUpperCase(text.charAt(0)) + text.substring(1);
        return text;
    }
    
    // This function is used to display list of candidates
    void displayList (List<Candidate> a){
        // =========== Display Experience ================
        System.out.println("================== EPERIENCE CANDIDATE =================");
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).type.equalsIgnoreCase("0")){
                System.out.println(a.get(i).firstName + " " + a.get(i).lastName);
            }
        }
        
         // =========== Display Fresher ================
        System.out.println("================== FRESHER CANDIDATE =================");
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).type.equalsIgnoreCase("1")){
                System.out.println(a.get(i).firstName + " " + a.get(i).lastName);
            }
        }
        
         // =========== Intern Fresher ================
        System.out.println("================== INTERN CANDIDATE =================");
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).type.equalsIgnoreCase("2")){
                System.out.println(a.get(i).firstName + " " + a.get(i).lastName);
            }
        }
    }
    
    void displayFound (List<Candidate> a){
        System.out.println("--------------------------------------------------"
                + "----------------------------");
        for (int i = 0; i < a.size(); i++) {
                
                    System.out.println(a.get(i).firstName + " " 
                            + a.get(i).lastName + " | " 
                            + a.get(i).birtDate + " | " 
                            + a.get(i).address + " | " 
                            + a.get(i).phone + " | " 
                            + a.get(i).email + " | " 
                            + a.get(i).type);
                
            }
        System.out.println("--------------------------------------------------"
                + "----------------------------");
    }
}
