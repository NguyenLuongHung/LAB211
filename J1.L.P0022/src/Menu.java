
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
public class Menu {
        CandidateList can = new CandidateList();
        
        int ct = 0;
        Scanner in = new Scanner(System.in);
        List<Candidate> canList = new ArrayList();
        Experience exp = new Experience();
        Fresher fresh = new Fresher();
        Intern intern = new Intern();
        Input input = new Input();
        
    void autoAdd() {
        // Auto add ====================================================
        canList.add(new Experience("1", "Aelbrecht", "Stefan", "1980", "US"
                , "012376127823", "ael@fpt.edu.vn", "0", "80", "Pro"));
        
        canList.add(new Experience("2", "Aguirre", "Eva", "1989", "VN"
                , "123781287232", "agu@fpt.edu.vn", "0", "50", "Pro"));
        
        canList.add(new Fresher("3", "Ah", "Stefan", "1980", "US"
                , "012376127823", "ael@fpt.edu.vn", "1", "07/04/2015", "Good", "FTU"));
        
        canList.add(new Fresher("4", "Joana", "Filipa", "1970", "Nigeria"
                , "0167876127823", "ael@fpt.edu.vn", "1", "07/04/2015", "Poor", "NEU"));
        
        canList.add(new Intern("5", "Patreicia", "Carine", "1960", "Japan"
                , "012376127823", "Patreicia@fpt.edu.vn", "2", "FE", "Winter", "FTU"));
        
        canList.add(new Intern("6", "Cabrera", "Cornde", "1999", "LAOS"
                , "0199376127823", "Cabre@fpt.edu.vn", "2", "IA", "Winter", "FPT"));
        // =============================================================
    }
        
    void showMenu() {
        
        
        do {
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            try {
                ct = Integer.parseInt(in.nextLine());

            } catch (Exception e) {
                System.out.println("Invalid choice, choose again!");
                continue;
            }
            if (ct == 1) {
                input.choose(canList, exp);
            } else if (ct == 2) {
                input.choose(canList, fresh);
            } else if (ct == 3) {
                input.choose(canList, intern);
            } else if (ct == 4) {
                can.search(canList);
            }
        } while (ct != 5);
    }
}
