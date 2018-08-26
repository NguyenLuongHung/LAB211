
import java.util.ArrayList;
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
    
    
//    String nameToUpper (String name){
//        String name1 = "";
//        int index = 9999;
//        name = firstCharToUpper(name);
//        for (int i = 0; i < name.length(); i++) {
//            if (name.charAt(i) == 32){
//                index = i + 1;
//                name1 += name.charAt(i);
//            }
//            else if (i == index)
//                name1 += Character.toUpperCase(name.charAt(i+1));
//            else name1 += name.charAt(i);
//            
//        }
//        return name1;
//    }
    
    // This function is used to make format things
    String firstCharToUpper(String text){
        text = Character.toUpperCase(text.charAt(0)) + text.substring(1);
        return text;
    }
    
    void display(List<Student> a){
        System.out.println("------------------------------------------------------------------------------------");
        System.out.printf("%-4s%-4s%-30s%-4s%-10s%-4s%-20s","ID", " | ",  "Student name", " | " ,"Semester"," | ", "Course mame");
        System.out.println("");
        for (int i = 0; i < a.size(); i++) {
            System.out.printf("%-4s%-4s%-30s%-4s%-10s%-4s%-20s",a.get(i).id, " | ", a.get(i).name, " | " ,a.get(i).semester, " | " ,a.get(i).course);
            System.out.println("");
        }
        System.out.println("------------------------------------------------------------------------------------");
    }
    
    void displayFound(List<Student> a){
        System.out.println("------------------------------------------------------------------------------------");
        System.out.printf("%-6s%-4s%-30s%-4s%-10s%-4s%-20s","Item", " | ", "Student name", " | " ,"Semester"," | ", "Course mame");
        System.out.println("");
        for (int i = 0; i < a.size(); i++) {
            System.out.printf("%-6d%-4s%-30s%-4s%-10s%-4s%-20s",i+1," | ", a.get(i).name, " | " ,a.get(i).semester, " | " ,a.get(i).course);
            System.out.println("");
        }
        System.out.println("------------------------------------------------------------------------------------");
    }
    
    void displayReport(List<Report> a) {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.printf("%-30s%-4s%-10s%-4s%-10s", "Student name", " | ", "Course", " | ", "Total");
        System.out.println("");
        for (int i = 0; i < a.size(); i++) {
            System.out.printf("%-30s%-4s%-10s%-4s%-10d", a.get(i).name, " | ", a.get(i).course, " | ", a.get(i).total);
            System.out.println("");
        }
    }
        
    

}

