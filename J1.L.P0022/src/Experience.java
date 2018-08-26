
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hungnlHE130716
 */
public class Experience extends Candidate {

    String expInYear;
    String proSkill;

    public Experience() {

    }

    public Experience( String id
            , String firstName, String lastName, String birtDate
            , String address, String phone, String email, String type,
            String expInYear, String proSkill) {

        super(id, firstName, lastName, birtDate, address, phone, email, type);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    @Override
    Experience createNew(List<Candidate> canList) {
        super.createNew(canList);
        String expInYear;
        String proSkill;
        // Input year of exp
        // We use do while loop to ask user to enter valid yearOfExp
        do {
            System.out.print("Enter year of experience: ");
            expInYear = in.nextLine();
            // If year of exp is blank, then ask user to enter again
            if (!input.checkBlank(expInYear)) {
                System.out.println("Blank year of Exp, please re-enter!");
                continue;
            }
            // If checkYearOfExp is false, then we ask user to re-enter
            // year of exp
            if (!input.checkNumberFormat(expInYear)) {
                System.out.println("Invalid year of experience, "
                        + "please re-enter!");
                continue;
            }
            if (!input.checkYearOfExp(expInYear)){
                System.out.println("Year Of exp out of range, "
                        + "please re-enter (0-100)!");
                continue;
            }
            
        } while ( !input.checkBlank(expInYear) || 
                !input.checkNumberFormat(expInYear) 
                || !input.checkYearOfExp(expInYear) 
                
                );

        // Input proSkill
        do {
            System.out.print("Enter pro skill: ");
            proSkill = in.nextLine();
            // If pro skill is blank, then ask user to re-enter again
            if (!input.checkBlank(proSkill)) {
                System.out.println("Blank pro skill, please re-enter!");
            }
        } while (!input.checkBlank(proSkill));

        Experience exp = new Experience(id, firstName, lastName, birtDate
                , address, phone, email, "0", expInYear, proSkill);
        
        return exp;
        
    }

}
