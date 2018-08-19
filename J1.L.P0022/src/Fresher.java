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

    public void setGraduation_date(String graduation_date) {
        this.graduation_date = graduation_date;
    }

    public void setGraduation_rank(String graduation_rank) {
        this.graduation_rank = graduation_rank;
    }

    public void setEducation(String education) {
        this.education = education;
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

    public String getGraduation_date() {
        return graduation_date;
    }

    public String getGraduation_rank() {
        return graduation_rank;
    }

    public String getEducation() {
        return education;
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
    String education;
    
    public Fresher(String id, String firstName, String lastName, String birtDate, String address, String phone, String email, String type, String graduation_date, String graduation_rank, String education ){
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
