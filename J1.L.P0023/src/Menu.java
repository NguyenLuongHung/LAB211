
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
public class Menu {
    Fruit list = new Fruit();
    void autoAdd(){
        list.add(new Fruit("1", "Coconut", "2", "3", "Vietnam"));
        list.add(new Fruit("2", "Orange", "3", "4", "US"));
        list.add(new Fruit("3", "Apple", "4", "6", "Thailand"));
        list.add(new Fruit("4", "Grape", "6", "5", "France"));
    }
    void showMenu(){
        
        Scanner in = new Scanner (System.in);
        int ct;
        do {
            System.out.println("1. Create Fruit");
            System.out.println("2. View Order");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            ct = Integer.parseInt(in.nextLine());
            if (ct == 1){
                String check;
                do {
                    list.create();
                    System.out.print("Do you want to contitnue (Y/N): ");
                    check = in.nextLine();
                } while (!check.equalsIgnoreCase("N"));
            }
            else if (ct == 2){
                list.viewOrder();
            }
            else if (ct == 3){
                list.shopping();
            }
        } while (ct != 4);
    }
}
