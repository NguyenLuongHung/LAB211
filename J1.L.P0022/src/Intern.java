/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Intern extends Candidate {
    String majors;
    int semester;
    String university;
    
    public Intern(int id, String firstName, String lastName, int birtDate, String address, int phone, String email, int type, String majors, int semester, String university){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birtDate = birtDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
        this.majors = majors;
        this.semester = semester;
        this.university = university;
    }
    
}
