
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hungnlhe130716
 */
public class Intern extends Candidate {

    String majors;
    String semester;
    String university;

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setUniversity(String university) {
        this.university = university;
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

    public String getMajors() {
        return majors;
    }

    public String getSemester() {
        return semester;
    }

    public String getUniversity() {
        return university;
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

    public Intern() {

    }

    public Intern(String id, String firstName, String lastName, String birtDate, String address, String phone, String email, String type,
            String majors, String semester, String university
    ) {
        super(id, firstName, lastName, birtDate, address, phone, email, type);
        this.majors = majors;
        this.semester = semester;
        this.university = university;
    }

    @Override
    Intern createNew(List<Candidate> canList) {
        super.createNew(canList);
        String majors;
        String semester;
        String university;

        // Input majors
        do {
            System.out.print("Enter major: ");
            majors = in.nextLine();
            // If major is blank, ask user to re-enter
            if (!input.checkBlank(majors)){
                System.out.println("Blank major, please re-enter!");
                continue;
            }
            // If major is not a letter, ask user to re-enter
            if (!input.checkName(majors)){
                System.out.println("Invalid majors, please re-enter!");
            }
            
        } while (!input.checkName(majors) || !input.checkBlank(majors));
        // Input semester
        // We use do while to check valid semester
        do {
            System.out.print("Enter semester: ");
            semester = in.nextLine();
            
            if (!input.checkBlank(semester)){
                System.out.println("Blank semester, please re-enter!");
                continue;
            }
                
                
            // If checkSemester() is false, then we ask user to re-enter
            // semester
            if (!input.checkSemester(semester)) {
                System.out.println("Invalid semester, please re-enter "
                        + "semester (Spring, Sumber, or Winter)");
                continue;
            }
           
            semester = format.firstCharToUpper(semester);
        } while (!input.checkSemester(semester) || !input.checkBlank(semester));

        // We use do while loop to check valid university
        do {
            // Input university
            System.out.print("Enter university: ");
            university = in.nextLine();
            
            // If university name is blank, then ask user to re-enter
            if (!input.checkBlank(university)) {
                System.out.println("Blank university name, please re-enter");
                continue;
            }
            // If checkName() is false, then we ask user to re-enter
            // university name
            if (!input.checkName(university)) {
                System.out.println("Invalid university name, please re-enter");
                continue;
            }
            university = format.firstCharToUpper(university);
        } while (!input.checkName(university) || !input.checkBlank(university));
        Intern intern = new Intern(id, firstName, lastName, birtDate, address, phone, email, "2", majors, semester, university);
        return intern;
    }

}
