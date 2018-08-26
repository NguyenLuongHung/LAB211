
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
public class Fresher extends Candidate {

    String dateOfGraduation;
    String rankOfGraduation;
    String university;

    public void setDateOfGraduation(String dateOfGraduation) {
        this.dateOfGraduation = dateOfGraduation;
    }

    public void setRankOfGraduation(String rankOfGraduation) {
        this.rankOfGraduation = rankOfGraduation;
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

    public String getDateOfGraduation() {
        return dateOfGraduation;
    }

    public String getRankOfGraduation() {
        return rankOfGraduation;
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
    
    public Fresher (){
        
    }
        
    public Fresher( String id, String firstName, String lastName
            , String birtDate, String address, String phone, String email
            , String type, String dateOfGraduation, String rankOfGraduation
            , String university) {
        super(id, firstName, lastName, birtDate, address, phone, email, type);
        this.dateOfGraduation = dateOfGraduation;
        this.rankOfGraduation = rankOfGraduation;
        this.university = university;
    }

    @Override
    Fresher createNew(List<Candidate> canList) {
        super.createNew(canList);
        String timeOfGraduation;
        String rankOfGraduation;
        String university;

        // Input graduated time
        // We use do while to ask user to enter valid time
        do {
            System.out.print("Enter graduation time: ");
            timeOfGraduation = in.nextLine();
            // If checkDate() is false, then we ask user to enter time again
            if (!input.checkDate(timeOfGraduation)) {
                System.out.println("Invalid date, please re-enter "
                        + "as format (MM/dd/yyyy)!");
                continue;
            }
            // If date is blank, then ask user to re-enter
            if (!input.checkBlank(timeOfGraduation)){
                System.out.println("Blank date, please re-enter");
            }
        } while (!input.checkDate(timeOfGraduation) 
                || !input.checkBlank(timeOfGraduation));

        // Input graduation rank
        // We use do while loop to ask user to enter valid rank
        do {
            System.out.print("Enter graduation rank: ");
            rankOfGraduation = in.nextLine();
            // If checkRank() is false, then we ask user toenter rank again
            if (!input.checkRank(rankOfGraduation)) {
                System.out.println("Invalid rank, please re-enter"
                        + " (Excellence, Good, Fair or Poor)!");
                continue;
            }
            // If rank is blank, ask user to re-enter
            if (!input.checkBlank(rankOfGraduation)){
                System.out.println("Blank rank, please re-enter");
            }
        } while (!input.checkRank(rankOfGraduation) 
                || !input.checkBlank(rankOfGraduation));

        // Input university
        // We use do while loop to ask user to enter valid university
        do {
            System.out.print("Enter university name: ");
            university = in.nextLine();
            
            // If checkName() is false, then we ask user to re-enter
            // university
            if (!input.checkName(university)) {
                System.out.println("Invalid university name, "
                        + "please re-enter");
                continue;
            }
            // If university name is blank, then ask user to re-enter
            if (!input.checkBlank(university)){
                System.out.println("Blank university name, please re-enter");
                continue;
            }
            university = format.firstCharToUpper(university);
        } while (!input.checkName(university) || !input.checkBlank(university));

        Fresher fresher = new Fresher(id, firstName, lastName, birtDate, address
                , phone, email, "1", timeOfGraduation, rankOfGraduation
                , university);
        return fresher;
    }
    

}
