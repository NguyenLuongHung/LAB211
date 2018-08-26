
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
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StudentList list = new StudentList();
        Format format = new Format();
        int ct = 0;
        
        // =================== Auto add ========================
        list.add(new Student("1","Nguyen Luong Hung", "Winter", "Java"));
        list.add(new Student("1","Nguyen Luong Hung", "Winter", ".Net"));
        list.add(new Student("1","Nguyen Luong Hung", "Spring", ".Net"));
        list.add(new Student("1","Nguyen Luong Hung", "Winter", "C/C++"));
        list.add(new Student("1","Nguyen Luong Hung", "Summer", "Java"));
        list.add(new Student("1","Nguyen Luong Hung", "Summer", ".Net"));
        list.add(new Student("2","Nguyen Luong Dung", "Winter", "Java"));
        list.add(new Student("2","Nguyen Luong Dung", "Summer", "Java"));
        list.add(new Student("2","Nguyen Luong Dung", "Winter", ".Net"));
        list.add(new Student("2","Nguyen Luong Dung", "Spring", ".Net"));
        
        do {
            
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/ Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            ct = Integer.parseInt(in.nextLine());
            if (ct == 1){
                list.create();
            }
            if (ct == 2){
                list.find();
            }
            if (ct == 3){
                list.UpdateOrDelete();
            }
            if (ct == 4){
                format.displayReport(list.report());
            }
        } while (ct != 5);
    }
}
