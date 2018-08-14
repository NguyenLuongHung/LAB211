
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
public class CandidateList {

    int id;
    String firstName;
    String lastName;
    int birtDate;
    String address;
    int phone;
    String email;
    int type;
    List<Experience> exp = new ArrayList();
    List<Fresher> fresh = new ArrayList();
    List<Intern> intern = new ArrayList();
    Scanner in = new Scanner(System.in);

    // add Experience to the list
    void addExp(Experience e) {
        exp.add(e);
    }

    // add Fresher to the list
    void addFresh(Fresher e) {
        fresh.add(e);
    }

    // add Intern to the list
    void addIntern(Intern e) {
        intern.add(e);
    }

    // Check BirtDate
    boolean checkBirtDate(int birtDate) {
        if (birtDate < 2018 && birtDate > 1900) {
            return true;
        } else {
            return false;
        }
    }

    // Check Phone minimum character
    boolean checkPhoneCharacter(int phone) {
        String phone1 = phone + "";
        if (phone1.length() < 10) {
            return false;
        } else {
            return true;
        }
    }

    // Check Gmail format
    boolean checkEmail(String email) {
        int count = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                count++;
            }
        }
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

    // Check Year Of Exp
    boolean checkYearOfExp(int exp) {
        if (exp <= 100 && exp >= 0) {
            return true;
        } else {
            return false;
        }
    }

    // check Rank of Graduation
    boolean checkRank(String rank) {
        if ((rank.equals("Excellenec")) || (rank.equals("Good")) || (rank.equals("Fair")) || (rank.equals("Poor"))) {
            return true;
        } else {
            return false;
        }
    }

    // Input common attributes
    void inputCommon() {
        // input id
        System.out.print("Please enter id: ");
        id = Integer.parseInt(in.nextLine());
        
        // input first name
        System.out.print("Please enter first name: ");
        firstName = in.nextLine();
        // input last name
        System.out.print("Plesae enter last name: ");
        lastName = in.nextLine();

        // We check the validation of birthdate
        boolean checkBirtDate = false;
        do {
            System.out.print("Please enter birt date: ");
            try {
                // If user inputs character instead of a valid number, we will catch exception and ask user to input again
                birtDate = Integer.parseInt(in.nextLine());
                checkBirtDate = true;
                if (!checkBirtDate(birtDate)) {
                    System.out.println("Invalid date of birth, try again!");
                }
            } catch (Exception e) {
                checkBirtDate = false;
                System.out.println("Invalid date of birth, try again!");
            }

        } // We use do while loop to ask user to input a valid birthday
        while (checkBirtDate == false || checkBirtDate(birtDate) == false);

        // We check the validation of phone 
        boolean checkPhone = false;
        do {
            System.out.print("Please enter phone: ");
            try {
                // If user inputs character instead of number, we will catch exception and ask user to input again
                phone = Integer.parseInt(in.nextLine());
                checkPhone = true;
                if (!checkPhoneCharacter(phone)) {
                    System.out.println("Invalid phone number, try again!");
                }
            } catch (Exception e) {
                e.printStackTrace();
                checkPhone = false;
                System.out.println("Invalid phone number, try again!");
            }
        } // We use do while loop to ask user to input a valid phone number
        while (checkPhone == false || checkPhoneCharacter(phone) == false);
        
        // Input and check email format
        do {
        System.out.print("Please enter email: ");
        email = in.nextLine();
        if (!checkEmail(email)) System.out.println("Invalid email, please try again!");
        } while (!checkEmail(email));
        
        // input type
        System.out.print("Please enter type of candidate: ");
        type = Integer.parseInt(in.nextLine());
    }
    
    // ===================================== Input each kind of candidate ================================================ //
    
    // ==================================input Experience ==============================================//
    void inputExp(){
        int yearOfExp = 0;
        // input common attributes
        inputCommon();
        // Input year of exp
        boolean checkYear = false;
        do {
            // input year of experience
            System.out.print("Please enter year of experience: ");
            try {
                // If user inputs character instead of a number, we will catch exception and ask user to input again
                yearOfExp = Integer.parseInt(in.nextLine());
                checkYear = true;
                if (!checkYearOfExp(yearOfExp)) System.out.println("Invalid year of exp, please try again!");
            }
            catch (Exception e){
                checkYear = false;
                System.out.println("Invalid year of exp, please try again!");
            }
            
        } // we use do while loop to ask user to input a valid Years of Exp 
        while (checkYear == false || checkYearOfExp(yearOfExp) == false);
        // Input pro skill
        System.out.print("Please enter pro skill: ");
        String proSkill = in.nextLine();
        // add Experience to the ArrayList
        addExp(new Experience(id, firstName, lastName, birtDate, address, phone, email, type, yearOfExp, proSkill));
    }
    
    // =================================== input Fresher =============================================//
    
    void inputFresh(){
        // input common attributes
        inputCommon();
        // input graduation type
        System.out.print("Please input graduation date: ");
        String graduation_date = in.nextLine();
        String rank;
        do {
            // input graduation rank
            System.out.print("Please input graduation rank: ");
            rank = in.nextLine();
            if (!checkRank(rank)) System.out.println("Invalid rank, please input the graduation rank again!");
        } // We use do while loop to ask user to input a valid graduation rank
        while (!checkRank(rank));
        // input graduation university
        System.out.print("Please input graduation university: ");
        String university = in.nextLine();
        
        // add fresher to the ArrayList
        addFresh(new Fresher (id, firstName, lastName, birtDate, address, phone, email, type, graduation_date, rank, university));
        
    }
    
    // =================================== input Intern ==============================================//
    
    void inputIntern(){
        // input common attributes
        inputCommon();
        // input intern major
        System.out.print("Please input major: ");
        String major = in.nextLine();
        // input intern semester
        System.out.print("Please input Semester: ");
        int semester = Integer.parseInt(in.nextLine());
        // input intern university
        System.out.print("Please input University name: ");
        String university = in.nextLine();
        // add intern to the ArrayList
        addIntern(new Intern(id, firstName, lastName, birtDate, address, phone, email, type, major, semester, university));        
    }

    // Search and Display Candidate
    void searchAndDisplay() {
        System.out.println("List of candidate: ");
        System.out.println("==============EXPERIENCE CANDIDATE===================");
        // Display Experienec Candidate
        for (int i = 0; i < exp.size(); i++) {
            System.out.println(exp.get(i).firstName + " " + exp.get(i).lastName);
        }
        System.out.println("===============FRESHER CANDIDATE=====================");
        // Display Fresh Candidate
        for (int i = 0; i < fresh.size(); i++) {
            System.out.println(fresh.get(i).firstName + " " + fresh.get(i).lastName);
        }

        System.out.println("===============INTERN CANDIDATE================");

        // Display Intern Candidate
        for (int i = 0; i < intern.size(); i++) {
            System.out.println(intern.get(i).firstName + " " + intern.get(i).lastName);
        }

        System.out.println("");
        // Input name to search
        System.out.print("Input Candidate name (First name or Last name): ");
        String name = in.nextLine();
        // Input type of candidate to search
        System.out.print("Input type of candidate: ");
        int type = Integer.parseInt(in.nextLine());
        // =============================================== Display found cancdidate ===============================================================
        System.out.println("The candidates found:");
        if (type == 0) {
            for (int i = 0; i < exp.size(); i++) {
                if (exp.get(i).firstName.contains(name) || exp.get(i).lastName.contains(name)) {
                    System.out.println(exp.get(i).firstName + " " + exp.get(i).lastName + " | " + exp.get(i).birtDate + " | " + exp.get(i).address + " | " + exp.get(i).phone + " | " + exp.get(i).email + " | " + exp.get(i).type);
                }
            }
        } else if (type == 1) {
            for (int i = 0; i < fresh.size(); i++) {
                if (fresh.get(i).firstName.contains(name) || fresh.get(i).lastName.contains(name)) {
                    System.out.println(fresh.get(i).firstName + " " + fresh.get(i).lastName + " | " + fresh.get(i).birtDate + " | " + fresh.get(i).address + " | " + fresh.get(i).phone + " | " + fresh.get(i).email + " | " +  fresh.get(i).type);
                }
            }
        } else if (type == 2) {
            for (int i = 0; i < intern.size(); i++) {

                if (intern.get(i).firstName.contains(name) || intern.get(i).lastName.contains(name)) {
                    System.out.println(intern.get(i).firstName + " " + intern.get(i).lastName + " | " + intern.get(i).birtDate + " | " + intern.get(i).address + " | " + intern.get(i).phone + " | " + intern.get(i).email + " | " + intern.get(i).type);
                }
            }
        }

    }
    void displayFound(List<Candidate> e, String name){
        for (int i = 0; i < e.size(); i++) {
            if (e.get(i).firstName.contains(name) || e.get(i).lastName.contains(name)) {
                System.out.println(e.get(i).firstName + " " + e.get(i).lastName + " | " + e.get(i).birtDate + " | " + e.get(i).address + " | " + e.get(i).phone + " | " + e.get(i).email + " | " + e.get(i).type);
            }
        }
    }
}
