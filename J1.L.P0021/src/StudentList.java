
import java.util.ArrayList;
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
public class StudentList {

    List<Student> student = new ArrayList();
    Scanner in = new Scanner(System.in);

    void create() {
        int total = 0;
        String name;
        String id;
        int semester;
        String course;

        System.out.print("Enter student id: ");
        id = in.nextLine();
        System.out.print("Enter student name: ");
        name = in.nextLine();
        System.out.print("Enter student semester: ");
        semester = Integer.parseInt(in.nextLine());
        System.out.print("Enter student course: ");
        course = in.nextLine();
        student.add(new Student(id, name, semester, course));

    }

    int size() {
        return student.size();
    }
    
    List<Student> sortStudent(List<Student> a){
        Student swap = null;
        Student swap1= null;
        for (int i = a.size(); i > 0; i--) {
            for (int j = 0 ; j < i-1; j++) {
                if (a.get(j).getName().compareTo(a.get(j+1).getName()) > 0){
                    swap = a.get(j);
                    swap1 = a.get(j+1);
                    a.remove(j);
                    a.remove(j);
                    a.add(j, swap1);
                    a.add(j+1,swap);
                    
                    
                    
                }
            }
        }
        return a;
    }

    void find(){
        List<Student> sort1 = new ArrayList();
        String name;
        System.out.print("Enter student name that you want to find: ");
        name = in.nextLine();
        for (int i = 0; i < student.size(); i++) {
            if (student.get(i).getName().contains(name)){
                sort1.add(student.get(i));
                
            }
        }
        sort1 = sortStudent(sort1);
        for (int i = 0; i < sort1.size(); i++) {
            sort1.get(i).display();
        }
        
    }
    Student search(){
        System.out.print("Enter Student ID to search: ");
        String id = in.nextLine();
        for (int i = 0; i < student.size(); i++) {
            if (student.get(i).getId().equals(id))
                return student.get(i);
        }
        return null;
    }
    
    void update(Student a){
        System.out.print("Update name: ");
        String name = in.nextLine();
        a.setName(name);
        System.out.print("Update semester: ");
        int semester = Integer.parseInt(in.nextLine());
        a.setSemester(semester);
        System.out.print("Update course: ");
        String course = in.nextLine();
        a.setCourse(course);
    }
    void delete(Student e){
        student.remove(e);
        return;
    }
}
