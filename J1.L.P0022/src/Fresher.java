/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Fresher extends Candidate {
    String graduation_date;
    String graduation_rank;
    String education;
    
    public Fresher(int id, String firstName, String lastName, int birtDate, String address, int phone, String email, int type, String graduation_date, String graduation_rank, String education ){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birtDate = birtDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
        this.graduation_date = graduation_date;
        this.graduation_rank = graduation_rank;
        this.education = education;
    }
    
}
