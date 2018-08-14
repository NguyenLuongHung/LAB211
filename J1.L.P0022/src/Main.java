
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
public class Main {
    public static void main(String[] args) {
        CandidateList can = new CandidateList();
        int ct;
        Scanner in = new Scanner (System.in);
        do {
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            ct = Integer.parseInt(in.nextLine());
            
            if (ct == 1){
                String check;
                do{
                    can.inputExp();
                    System.out.print("Do you want to continue (Y/N): ");
                    check = in.nextLine();
                } while (!check.equalsIgnoreCase("N"));
            }
            else if (ct == 2){
                String check;
                do{
                    can.inputFresh();
                    System.out.print("Do you want to continue (Y/N): ");
                    check = in.nextLine();
                } while (!check.equalsIgnoreCase("N"));
            }
            else if (ct == 3){
                String check;
                do{
                    can.inputIntern();
                    System.out.print("Do you want to continue (Y/N): ");
                    check = in.nextLine();
                } while (!check.equalsIgnoreCase("N"));
            }
            else if (ct == 4){
                can.searchAndDisplay();
            }
            
           
        } while (ct != 5);
        
    }
}
