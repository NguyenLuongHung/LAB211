
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
 * @author hungnlhe130716
 */
public class Candidate {

    String id;

    
    String firstName;
    String lastName;
    String birtDate;
    String address;
    String phone;
    String email;
    String type;
    Scanner in = new Scanner(System.in);
    Input input = new Input();
    Format format = new Format();
    
    
    public Candidate(){
        
    }
    
    public Candidate(String id, String firstName, String lastName
            , String birtDate, String address, String phone
            , String email, String type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birtDate = birtDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirtDate(String birtDate) {
        this.birtDate = birtDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirtDate() {
        return birtDate;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }

    Candidate createNew(List<Candidate> canList) {
        do {
            System.out.print("Enter candidate id: ");
            id = in.nextLine();
            // If checkDuplicateByID() is false, then we ask user to input id
            // again
            if (!input.checkDuplicateByID(id, canList)) {
                System.out.println("Candidate id is already existed, "
                        + "please try again!");
                continue;
            }
            if (!input.checkBlank(id)) {
                System.out.println("Blank id, please re-enter!");
            }
        } while (!input.checkDuplicateByID(id, canList) || !input.checkBlank(id));

        // Input first name
        // We use do while loop to ask user to enter valid first name
        do {
            System.out.print("Enter first name: ");
            firstName = in.nextLine();

            // If checkName() is false, then we ask user to input first name
            // again
            if (!input.checkName(firstName)) {
                System.out.println("Invalid first name, please re-enter!");
                continue;
            }
            if (!input.checkBlank(firstName)) {
                System.out.println("Blank first name, please re-enter");
                continue;
            }
            firstName = format.firstCharToUpper(firstName);
        } while (!input.checkName(firstName) || !input.checkBlank(firstName));

        // Input last name
        // We use do while loop to ask user to enter valid last name
        do {
            System.out.print("Enter last name: ");
            lastName = in.nextLine();

            // If checkName() is false, then we ask user to input last name
            // again
            if (!input.checkName(lastName)) {
                System.out.println("Invalid last name, please re-enter!");
                continue;
            }
            if (!input.checkBlank(lastName)) {
                System.out.println("Blank last name, please re-enter!");
                continue;
            }
            lastName = format.firstCharToUpper(lastName);
        } while (!input.checkName(lastName) || !input.checkBlank(lastName));

        // Input birth date
        // We use do while loop to ask user toenter valid birth date
        do {
            System.out.print("Enter birth date: ");
            birtDate = in.nextLine();
            // If checkBirthDate() is false, then we ask user to input
            // birthDate again
            if (!input.checkNumberFormat(birtDate)) {
                System.out.println("Invalid birth date, please re-enter!");
                continue;
            }
            
            if (!input.checkBlank(birtDate)) {
                System.out.println("Blank birt date, please re-enter!");
                continue;
            }
            
            if (!input.checkBirthDateRange(birtDate)){
                System.out.println("Birthdate out of range, "
                        + "please re-enter (1990-current year)");
                
            }
            
        } while (!input.checkNumberFormat(birtDate)
                || !input.checkBlank(birtDate)
                || !input.checkBirthDateRange(birtDate)
                );

        // Input address
        do {
            System.out.print("Enter address: ");
            address = in.nextLine();
            // If address is blank, ask user to re-enter
            if (!input.checkBlank(address)) {
                System.out.println("Blank address, please re-enter");
            }
        } while (!input.checkBlank(address));

        // Input phone number
        // We use do while loop to check valid phone number
        do {
            System.out.print("Enter phone number: ");
            phone = in.nextLine();
            
            if (!input.checkNumberFormat(phone)){
                System.out.println("Invalid phone number, please re-enter!");
                continue;
            }
            // If checkPhoneNumber() is false, then we ask user to re-enter
            // phone number again
            
            
            if (!input.checkPhoneNumber(phone)) {
                System.out.println("Phone length is to short, "
                        + "please re-enter (10 minimum character)");
                continue;
            }
            if (!input.checkBlank(phone)){
                System.out.println("Blank phone number, please re-enter!");
            }
        } while (!input.checkNumberFormat(phone) 
                || !input.checkPhoneNumber(phone) 
                || !input.checkBlank(phone));

        // Input email
        // We use do while loop to check valid email
        do {
            System.out.print("Enter email: ");
            email = in.nextLine();
            // If this email is blank, then ask suer to re-enter email
            if (!input.checkBlank(email)){
                System.out.println("Blank email, please re-enter email!");
                continue;
            }
            // If checkEmail() is false, then we ask user to re-enter email
            if (!input.checkEmail(email)) {
                System.out.println("Invalid email, please re-enter email: ");
                continue;
            }
            
        } while (!input.checkEmail(email) || !input.checkBlank(email));
        
       return new Candidate (id, firstName, lastName
            ,  birtDate, address, phone
            ,  email,  type);
        
    }
    
    
}
