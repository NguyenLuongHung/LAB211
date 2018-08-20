
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
public class Fruit {

    List<Fruit> fruitList = new ArrayList();
    Hashtable order = new Hashtable();
    Scanner in = new Scanner(System.in);
    Input input = new Input();
    Format format = new Format();
    String id;
    String name;
    String price;
    String quantity;
    String origin;

    public Fruit(){
        
    }
    
    public Fruit(String id, String name, String price,
            String quantity, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    Fruit create() {
        // This function is used to check if id is already existed
        do {
            System.out.print("Enter id: ");
            id = in.nextLine();
            // If id is already existed, then ask user to input again
            if (!input.checkDuplicateByID(id, fruitList)) {
                System.out.println("ID is already existed, please re-enter!");
            }
        } while (!input.checkDuplicateByID(id, fruitList));

        // This function is used to check 
        do {
            System.out.print("Enter name: ");
            name = in.nextLine();
            name = format.firstCharToUpper(name);
            // If checkName() is false, then we ask user to input first name
            // again
            if (!input.checkName(name)) {
                System.out.println("Invalid name, please re-enter!");
            }

        } while (!input.checkName(name));

        // This function is used to check valid price
        do {
            System.out.print("Enter price: ");
            price = in.nextLine();
            // If checkLetter() is false, then ask user to re-enter price
            if (!input.checkPrice(price)) {
                System.out.println("Invalid price, please re-enter");
            }
        } while (!input.checkPrice(price));

        // This function is used to check valid quantity
        do {
            System.out.print("Enter quantity: ");
            quantity = in.nextLine();
            // If checkQuantity() is false, then ask user to re-enter quantity
            if (!input.checkQuantity(quantity)) {
                System.out.println("Invalid quantity, please re-enter");
            }
        } while (!input.checkQuantity(quantity));

        // This function is used to check valid Origin
        do {
            System.out.print("Enter origin: ");
            origin = in.nextLine();
            origin = format.firstCharToUpper(origin);
            // If checkName() is false, then we ask user to input origin
            // again
            if (!input.checkName(origin)) {
                System.out.println("Invalid origin, please re-enter!");
            }

        } while (!input.checkName(origin));
        
        Fruit fruit = new Fruit(id, name, price,quantity,origin);
        return fruit;
    }
    
    // This function is used to add
    void add (Fruit e){
        fruitList.add(e);
    }

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
            
            format.displayOrder(order1);
           

        }
    }

    // This function is used to make shopping
    void shopping() {
        String item;
        String check;
        boolean next;
        // Display list of fruit
        format.displayList(fruitList);

        do {
            String quantity;
            // We use do while loop to ask user to enter valid item
            do {
                System.out.print("Choose item to buy: ");
                item = in.nextLine();
                // If checkChoice() is false, then ask user to reenter choice
                if (!input.checkChoice(item, fruitList)) {
                    System.out.print("Invalid item, please choose again!");
                }
            } while (!input.checkChoice(item, fruitList));

            //============================= Choose a item to buy ==================================
            int select = Integer.parseInt(item);
            select = select - 1;
            System.out.println("You selected: " + fruitList.get(select).name);
            // We used do while loop to ask user to enter valid quantity
            do {
                System.out.print("Please input quantity: ");
                quantity = in.nextLine();
                // If checkQuantity() is false, thern we ask user to re-enter
                if (!input.checkQuantity(quantity)) {
                    System.out.println("Invalid quantity, please re-enter!");
                }
            } while (!input.checkQuantity(quantity));
            System.out.print("Do you want to order now (Y/N): ");
            check = in.nextLine();
            // ====================================================================================

            // Ask customer if he/she wants to order now
            if (check.equalsIgnoreCase("Y")) {
                // We use boolean next var to decide if the code runs order.put(name, itemList) or order.put(name, itemList2)
                next = false;
                int price = Integer.parseInt(fruitList.get(select).price);
                int quantity1 = Integer.parseInt(quantity);
                // If people say yes, then we add the new order to the order list
                int amount = price * quantity1;
                format.displayShopping(fruitList.get(select).name, quantity, fruitList.get(select).price, amount);
                Order product = new Order(fruitList.get(select).name, quantity, fruitList.get(select).price, amount);
                
                // We use do while loop to ask user to input valid name
                String name1;
                do {
                    System.out.print("Input your name: ");
                     name1 = in.nextLine();
                    if (!input.checkName(name1)) {
                        System.out.println("Invalid name, please re-enter!");
                    }
                } while (!input.checkName(name1));
                Enumeration customer;
                customer = order.keys();
                // We use this while to check if the customer is already in the order list or not, if yes then we will add new order to his/her
                while (customer.hasMoreElements()) {
                    String customerName = (String) customer.nextElement();
                    // if it found out the custormer, then add a new order 
                    if (customerName.equals(name1)) {
                        // Create new list or class Order
                        List<Order> itemList2 = new ArrayList();
                        // Get list from hashtable and restore in itemList2
                        itemList2 = (List) order.get(customerName);
                        // Add new order to itemList2
                        itemList2.add(product);
                        // Then restore it into hashtable again
                        order.put(name1, itemList2);
                        next = true;
                        check = "N";
                    }
                }
                if (next == false) {
                    // If the customer isn't already in customer list, then we will create a new order list for him/her
                    List<Order> itemList = new ArrayList();
                    itemList.add(product);
                    order.put(name1, itemList);
                    check = "N";
                }
            }
        } while (!check.equalsIgnoreCase("N"));

    }
}
