
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
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
public class OrderList {

    Scanner in = new Scanner(System.in);
    List<Fruit> fruit = new ArrayList();

    Hashtable order = new Hashtable();

    // Create new fruit and add to the ArrayList
    void addFruit() {
        // input fruit id
        System.out.print("Please input id: ");
        int id = Integer.parseInt(in.nextLine());

        // input fruit name
        System.out.print("Please input name: ");
        String name = in.nextLine();

        // input fruit price
        System.out.print("Please input price: ");
        double price = Double.parseDouble(in.nextLine());

        //input fruit quantity
        System.out.print("Please input quantity: ");
        int quantity = Integer.parseInt(in.nextLine());

        // input fruit origin
        System.out.print("Please input origin: ");
        String origin = in.nextLine();
        fruit.add(new Fruit(id, name, quantity, price, origin));
    }

    // view Order list
    void viewOrder() {
        Enumeration name;
        name = order.keys();
        String customer;
        while (name.hasMoreElements()) {
            // customer var to contain the name of customer
            customer = (String) name.nextElement();
            System.out.println("Customer: " + customer);
            // List of order of a specific customer
            List<Order> order1 = (List) order.get(customer);
            System.out.println("----------------------------------------");
            System.out.println("Product | Quantity | Price | Amount");
            double amount = 0;
            for (int i = 0; i < order1.size(); i++) {
                order1.get(i).displayForOrderView();
                amount += order1.get(i).amount;
            }
            
            System.out.println("Total: "+amount);
            System.out.print("$");
            System.out.println("");

        }
    }

    // shopping
    void shopping() {
        String check;
        boolean next;
        // We u
        do {
            // We use while loop to let customer shopping 

            // ================================= Display list of fruit =======================================
            System.out.println("List of Fruit: ");
            System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
            for (int i = 0; i < fruit.size(); i++) {
                System.out.printf("%-15d%-20s%-20s%.0f", i + 1, fruit.get(i).name, fruit.get(i).origin, fruit.get(i).price);
                System.out.print("$");
                System.out.println("");
            }

            //================================================================================================
            //============================= Choose a item to buy ==================================
            System.out.print("Choose a item: ");
            int item = Integer.parseInt(in.nextLine());
            item = item - 1;
            System.out.println("You selected: " + fruit.get(item).name);
            System.out.print("Please input quantity: ");
            int quantity = Integer.parseInt(in.nextLine());
            System.out.print("Do you want to order now (Y/N): ");
            check = in.nextLine();
            // ====================================================================================

            // Ask customer if he/she wants to order now
            if (check.equalsIgnoreCase("Y")) {
                // We use boolean next var to decide if the code runs order.put(name, itemList) or order.put(name, itemList2)
                next = false;

                // If people say yes, then we add the new order to the order list
                double amount = fruit.get(item).price * quantity;
                Order product = new Order(fruit.get(item).name, quantity, fruit.get(item).price, amount);
                product.display();

                System.out.print("Input your name: ");
                String name = in.nextLine();
                Enumeration customer;
                customer = order.keys();
                // We use this while to check if the customer is already in the order list or not, if yes then we will add new order to his/her
                while (customer.hasMoreElements()) {
                    String customerName = (String) customer.nextElement();
                    // if it found out the custormer, then add a new order 
                    if (customerName.equals(name)) {
                        List<Order> itemList2 = new ArrayList();
                        itemList2 = (List) order.get(customerName);
                        itemList2.add(product);
                        order.put(name, itemList2);
                        next = true;
                        check = "N";
                    }
                }
                if (next == false) {
                    // If the customer isn't already in customer list, then we will create a new order list for him/her
                    List<Order> itemList = new ArrayList();
                    itemList.add(product);
                    order.put(name, itemList);
                    check = "N";
                }
            }
        } while (!check.equalsIgnoreCase("N"));

    }
}
