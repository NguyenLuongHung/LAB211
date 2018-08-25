
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
public class Main {

    public static void main(String[] args) {
        Fruit list = new Fruit();
        Input input = new Input();
        // ======== Auto add list of fruit ======================
        list.add(new Fruit("1", "Coconut", "2", "3", "Vietnam"));
        list.add(new Fruit("2", "Orange", "3", "4", "US"));
        list.add(new Fruit("3", "Apple", "4", "5", "Thailand"));
        list.add(new Fruit("4", "Grape", "6", "6", "Myanma"));
        // =======================================================

        Scanner in = new Scanner(System.in);
        int ct = 0;
        // =========== Show menu ======================
        do {
            System.out.println("1. Create Fruit");
            System.out.println("2. View Order");
            System.out.println("3. Shopping (for buyer");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            try {
                ct = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid choice, please choose again!");
                continue;
            }
            // ======= Add new fruit to list ========
            if (ct == 1) {
                String check;
                do {
                    
                    Fruit e = list.create();
                    list.add(e);
                    do {
                        System.out.print("Do you want to contitnue (Y/N): ");
                        check = in.nextLine();
                        // if checkYesNo() is false, then we ask user to re-enter
                        if (!input.checkYesNo(check)) {
                            System.out.println("You have to anser Yes(Y) or No(N) only!");
                        }
                    } while (!input.checkYesNo(check));
                } while (!check.equalsIgnoreCase("N"));
            // ======== View order ===============    
                
            } else if (ct == 2) {
                list.viewOrder();
                
            // ======== Go shopping ================    
            } else if (ct == 3) {
                list.shopping();
                
            // ======== Ask user to input again if valid choice ========    
            } else if (ct != 4) {
                System.out.println("Invalid choice, please choose again!");
            }
        } while (ct != 4);

    }
}
