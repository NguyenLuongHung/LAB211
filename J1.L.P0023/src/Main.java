
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
        OrderList list = new OrderList();
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
                    list.addFruit();
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
