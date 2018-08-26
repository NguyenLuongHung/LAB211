
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
 * @author hungnlHE130716
 */
public class CandidateList {

   
    Scanner in = new Scanner(System.in);
    Input input = new Input();
    Format format = new Format();
    

    

//    void add() {
//        // Input id
//        // We use do while loop to ask user to enter id, if the id exists
//        // We ask user to unput again
//        do {
//            System.out.print("Enter candidate id: ");
//            id = in.nextLine();
//            // If checkDuplicateByID() is false, then we ask user to input id
//            // again
//            if (!input.checkDuplicateByID(id, canList)) {
//                System.out.println("Candidate id is already existed, "
//                        + "please try again!");
//                continue;
//            }
//            if (!input.checkBlank(id)){
//                System.out.println("Blank id, please re-enter!");
//            }
//        } while (!input.checkDuplicateByID(id, canList) || !input.checkBlank(id));
//
//        // Input first name
//        // We use do while loop to ask user to enter valid first name
//        do {
//            System.out.print("Enter first name: ");
//            firstName = in.nextLine();
//            
//            // If checkName() is false, then we ask user to input first name
//            // again
//            if (!input.checkName(firstName)) {
//                System.out.println("Invalid first name, please re-enter!");
//                continue;
//            }
//            if (!input.checkBlank(firstName)){
//                System.out.println("Blank first name, please re-enter");
//                continue;
//            }
//            firstName = format.firstCharToUpper(firstName);
//        } while (!input.checkName(firstName) || !input.checkBlank(firstName));
//
//        // Input last name
//        // We use do while loop to ask user to enter valid last name
//        do {
//            System.out.print("Enter last name: ");
//            lastName = in.nextLine();
//            
//            // If checkName() is false, then we ask user to input last name
//            // again
//            if (!input.checkName(lastName)) {
//                System.out.println("Invalid last name, please re-enter!");
//                continue;
//            }
//            if (!input.checkBlank(lastName)){
//                System.out.println("Blank last name, please re-enter!");
//                continue;
//            }
//            lastName = format.firstCharToUpper(lastName);
//        } while (!input.checkName(lastName) || !input.checkBlank(lastName));
//
//        // Input birth date
//        // We use do while loop to ask user toenter valid birth date
//        do {
//            System.out.print("Enter birth date: ");
//            birtDate = in.nextLine();
//            // If checkBirthDate() is false, then we ask user to input
//            // birthDate again
//            if (!input.checkBirthDate(birtDate)) {
//                System.out.println("Invalid birth date, please re-enter!");
//                continue;
//            }
//            if (!input.checkBlank(birtDate)){
//                System.out.println("Blank birtDate, please re-enter");
//                continue;
//            }
//        } while (!input.checkBirthDate(birtDate) || !input.checkBlank(birtDate));
//
//        // Input address
//        System.out.print("Enter address: ");
//        address = in.nextLine();
//
//        // Input phone number
//        // We use do while loop to check valid phone number
//        do {
//            System.out.print("Enter phone number: ");
//            phone = in.nextLine();
//            // If checkPhoneNumber() is false, then we ask user to re-enter
//            // phone number again
//            if (!input.checkPhoneNumber(phone)) {
//                System.out.println("Invalid phone number, please re-enter!");
//                continue;
//            }
//            if (!input.checkBlank(phone)){
//                System.out.println("Blank phone number, please re-enter!");
//            }
//        } while (!input.checkPhoneNumber(phone) || !input.checkBlank(phone));
//
//        // Input email
//        // We use do while loop to check valid email
//        do {
//            System.out.print("Enter email: ");
//            email = in.nextLine();
//            // If checkEmail() is false, then we ask user to re-enter email
//            if (!input.checkEmail(email)) {
//                System.out.println("Invalid email, please re-enter email: ");
//
//            }
//        } while (!input.checkEmail(email));
//
//        if (inputType == 0) {
//            String expInYear;
//            String proSkill;
//            // Input year of exp
//            // We use do while loop to ask user to enter valid yearOfExp
//            do {
//                System.out.print("Enter year of experience: ");
//                expInYear = in.nextLine();
//                // If checkYearOfExp is false, then we ask user to re-enter
//                // year of exp
//                if (!input.checkYearOfExp(expInYear)) {
//                    System.out.println("Invalid year of experience, "
//                            + "please re-enter!");
//                }
//            } while (!input.checkYearOfExp(expInYear));
//
//            // Input proSkill
//            System.out.print("Enter pro skill: ");
//            proSkill = in.nextLine();
//
//            Experience exp = new Experience(id, firstName, lastName, birtDate, address, phone, email, "1", expInYear, proSkill);
//            canList.add(exp);
//
//        }
//        else if (inputType == 1) {
//            String timeOfGraduation;
//            String rankOfGraduation;
//            String university;
//            
//            // Input graduated time
//            // We use do while to ask user to enter valid time
//            do {
//                System.out.print("Enter graduation time: ");
//                timeOfGraduation = in.nextLine();
//                // If checkDate() is false, then we ask user to enter time again
//                if (!input.checkDate(timeOfGraduation)){
//                    System.out.println("Invalid date, please re-enter "
//                            + "as format (MM/dd/yyyy)!");
//                }
//            } while (!input.checkDate (timeOfGraduation));
//            
//            // Input graduation rank
//            // We use do while loop to ask user to enter valid rank
//            do {
//                System.out.print("Enter graduation rank: ");
//                rankOfGraduation = in.nextLine();
//                // If checkRank() is false, then we ask user toenter rank again
//                if (!input.checkRank(rankOfGraduation)) {
//                    System.out.println("Invalid rank, please re-enter"
//                            + " (Excellence, Good, Fair or Poor)!");
//                }
//            } while (!input.checkRank(rankOfGraduation));
//            
//            // Input university
//            // We use do while loop to ask user to enter valid university
//            do {
//                System.out.print("Enter university name: ");
//                university = in.nextLine();
//                university = format.firstCharToUpper(university);
//                // If checkName() is false, then we ask user to re-enter
//                // university
//                if (!input.checkName(university)) {
//                    System.out.println("Invalid university name, "
//                            + "please re-enter");
//                }
//            } while (!input.checkName(university));
//            
//            Fresher fresher = new Fresher(id, firstName, lastName, birtDate
//                    , address, phone, email, "1", timeOfGraduation
//                    , rankOfGraduation, university);
//            canList.add(fresher);
//                    
//        }
//        
//        else if (inputType == 2){
//            String majors;
//            String semester;
//            String university;
//            
//            // Input majors
//            System.out.print("Enter major: ");
//            majors = in.nextLine();
//            
//            // Input semester
//            // We use do while to check valid semester
//            do {
//                System.out.print("Enter semester: ");
//                semester = in.nextLine();
//                semester = format.firstCharToUpper(semester);
//                // If checkSemester() is false, then we ask user to re-enter
//                // semester
//                if (!input.checkSemester(semester)) {
//                    System.out.println("Invalid semester, please re-enter "
//                            + "semester (Spring, Sumber, or Winter)");
//                }
//            } while (!input.checkSemester(semester));
//            
//            // We use do while loop to check valid university
//            do {
//                // Input university
//                System.out.print("Enter university: ");
//                university = in.nextLine();
//                university = format.firstCharToUpper(university);
//                // If checkName() is false, then we ask user to re-enter
//                // university name
//                if (!input.checkName(university)){
//                    System.out.println("Invalid university name, please re-enter");
//                }
//            } while (!input.checkName(university));
//            Intern intern = new Intern(id, firstName, lastName, birtDate, address, phone, email, "2", majors, semester, university);
//            canList.add(intern);
//        }
//        
//        
//
//    }
    
    void search(List<Candidate> canList){
        String name;
        String type;
        format.displayList(canList);
        System.out.println("");
        List<Candidate> search = new ArrayList();
        // input name to find
        // We use do while to check valid name
        do {
            System.out.println("Input Candidate name (First name or Last name): ");
            name = in.nextLine();
            // If checkName() is false, then we ask user to re-enter
            if (!input.checkName(name)){
                System.out.println("Invalid name, please re-enter name!");
                continue;
            }
            // If name is blank, then ask user to re-enter
            if (!input.checkBlank(name)){
                System.out.println("Blank name, please re-enter!");
            }
        } while (!input.checkName(name) || !input.checkBlank(name));
        // Input type to find
        // We use do while to check valid type
        do {
            System.out.print("Input type of candidate: ");
            type = in.nextLine();
            // If checkType() is false, then we ask user to re-enter type
            if (!input.checkType(type)) {
                System.out.println("Invalid type, "
                        + "please re-enter type (0,1 or 2)");
                continue;
            }
            // IF type is blank, then ask user to re-enter
            if (!input.checkBlank(type)){
                System.out.println("Blank type, please re-enter type (0,1 or 2)");
            }
        } while (!input.checkType(type));
        
        for (int i = 0; i < canList.size(); i++) {
            String fullName = canList.get(i).firstName 
                    + " " + canList.get(i).lastName;
            if (fullName.toLowerCase().contains(name.toLowerCase()) 
                    && canList.get(i).type.equalsIgnoreCase(type)) {
                search.add(canList.get(i));
            }
        }
        
        if (!search.isEmpty()) {
            System.out.println("The candidates found: ");
            format.displayFound(search);
        }
        else {
            System.out.println("----------------------------");
            System.out.println("No candidate found!");
            System.out.println("----------------------------");
        }
    }
}
