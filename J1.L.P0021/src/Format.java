
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
        System.out.printf("%-30s%-4s%-10s%-4s%-20s", "Student name", " | " ,"Semester"," | ", "Course mame");
        System.out.println("");
        for (int i = 0; i < a.size(); i++) {
            System.out.printf("%-30s%-4s%-10s%-4s%-20s", a.get(i).name, " | " ,a.get(i).semester, " | " ,a.get(i).course);
            System.out.println("");
        }
        System.out.println("------------------------------------------------------------------------------------");
    }
    
    void report(List<Student> student) {
        
        // Create a list of Report form 
        List<Report> report = new ArrayList();
        // We use this for loop to create report form
        for (int i = 0; i < student.size(); i++) {
            boolean next = true;
            
            for (int j = 0; j < report.size(); j++) {
                // If student name and course id the same as student name and course in report list, then we add one to total
                if (student.get(i).name.equals(report.get(j).name) && student.get(i).course.equals(report.get(j).course)){
                    report.get(j).setTotal(report.get(j).getTotal()+1);
                    next = false;
                }
                
            }
            // if student name and course is not the same as student name and course in report list, then we create a new report form and add to the list
            if (next)
                report.add(new Report(student.get(i).name, student.get(i).course,1));
        }
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-30s%-4s%-10s%-4s%-10s", "Student Name", " | ", "Course", " | ", "Total");
        System.out.println("");
        for (int i = 0; i < report.size(); i++) {
            System.out.printf("%-30s%-4s%-10s%-4s%-10d",report.get(i).name," | ", report.get(i).course, " | ", report.get(i).total);
        }
    }
}
