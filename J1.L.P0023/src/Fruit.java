
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
 * @author hungnlhe130716
 */
public class Fruit {
    
    List <Fruit> fruitList = new ArrayList();
    Hashtable order = new Hashtable();
    Scanner in = new Scanner(System.in);
    Input input = new Input();
    Format format = new Format();
    String id;
    String name;
    String price;
    String quantity;
    String origin;

    public void setFruitList(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    public void setOrder(Hashtable order) {
        this.order = order;
    }

    public void setIn(Scanner in) {
        this.in = in;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Fruit() {

    }

    public Fruit(String id, String name, String price, String quantity, String origin) {
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
                continue;
            }
            if (!input.checkBlank(id)) {
                System.out.println("Blank id, please re-enter");
                continue;
            }

        } while (!input.checkDuplicateByID(id, fruitList)
                || !input.checkBlank(id));

        // This function is used to check valid name
        do {
            System.out.print("Enter name: ");

            name = in.nextLine();

            // If checkName() is false, then we ask user to input first name
            // again
            if (!input.checkName(name)) {
                System.out.println("Invalid name, please re-enter!");
                continue;
            }
            if (!input.checkBlank(name)) {
                System.out.println("Blank name, please re-enter!");
                continue;
            }

            name = format.firstCharToUpper(name);

        } while (!input.checkName(name) || !input.checkBlank(name));
        // This function is used to check valid price
        do {
            System.out.print("Enter price: ");
            price = in.nextLine();
            // If checkLetter() is false, then ask user to re-enter price
            if (!input.checkPrice(price)) {
                System.out.println("Invalid price, please re-enter");
                continue;
            }
            if (!input.checkBlank(price)) {
                System.out.println("Blank price, please re-enter!");
                continue;
            }
            if (!input.checkPriceEqual0(price)) {
                System.out.println("Price can't be 0, please re-enter!");
            }
        } while (!input.checkPrice(price)
                || !input.checkBlank(price)
                || !input.checkPriceEqual0(price));

        // This function is used to check valid quantity
        do {
            System.out.print("Enter quantity: ");
            quantity = in.nextLine();
            // If checkQuantity() is false, then ask user to re-enter quantity
            if (!input.checkQuantity(quantity)) {
                System.out.println("Invalid quantity, please re-enter!");
                continue;
            }
            if (!input.checkBlank(quantity)) {
                System.out.println("Blank quantity, please re-enter!");
                continue;
            }
            if (!input.checkQuantityEqual0(quantity)) {
                System.out.println("Quantity can't be 0, please re-enter!");
            }
        } while (!input.checkQuantity(quantity)
                || !input.checkBlank(quantity)
                || !input.checkQuantityEqual0(quantity));

        // This function is used to check valid Origin
        do {
            System.out.print("Enter origin: ");
            origin = in.nextLine();

            // If checkname() is false, then we ask user to input orgin again
            if (!input.checkName(origin)) {
                System.out.println("Invalid orgin, please re-enter!");
                continue;
            }
            if (!input.checkBlank(origin)) {
                System.out.println("Blank origin, please re-enter!");
                continue;
            }
            origin = format.firstCharToUpper(origin);
        } while (!input.checkName(origin) || !input.checkBlank(origin));

        Fruit fruit = new Fruit(id, name, price, quantity, origin);
        return fruit;
    }

    // This function is used to add fruit to list
    void add(Fruit e) {
        fruitList.add(e);
    }

    void viewOrder() {
        Enumeration name;
        // this 'name' var is used to store keys
        name = order.keys();
        // 'customer' var is used to store name of custormer
        String customer;
        while (name.hasMoreElements()) {
            // 'customer' var is used to contain the name of customer
            customer = (String) name.nextElement();
            
            // List of order of spcific customer
            List<List<Order>> order1 = (List<List<Order>>) order.get(customer);
            for (int i = 0; i < order1.size(); i++) {
                System.out.println("Customer: " + customer);
                format.displayOrder(order1.get(i));
                System.out.println("");
            }
            
            
        }
    }

    // This function is used to make shopping
    void shopping() {
        List <List<Order>> shoppingList = new ArrayList();
        String item;
        // This 'check' var is used to check if user want to order now
        String check;
        // this 'check1' var is used to check if user want to continue
        // buying items
        String check1;
        boolean next;
        int select;
        // Display list of fruit
        format.displayList(fruitList);

        
        // =================== Choose a item to buy ======================
        // This 'shopping' is used to store orders list of customer
        
//        List<Order> shopping = new ArrayList();
        List <Order> shopping = new ArrayList();
         
       
        do {        
            String quantity;
            // We use do while loop to ask user to enter valid item
            do {
                System.out.print("Choose item to buy: ");
                item = in.nextLine();
                // If checkChoice() is false, then ask user to re-enter choice
                if (!input.checkChoice(item, fruitList)) {
                    System.out.println("Invalid item, please choose again");
                    continue;
                }
                // If item is blank, ask user to re-enter
                if (!input.checkBlank(item)) {
                    System.out.println("Blank item, please choose again");
                    continue;
                }
                // If fruit quantity is 0, then ask user to choose other item
                if (!input.checkFruit(Integer.parseInt(item) - 1, fruitList)) {
                    System.out.println("Invalid item, please choose again!");
                }
            } while (!input.checkChoice(item, fruitList)
                    || !input.checkBlank(item)
                    || !input.checkFruit(Integer.parseInt(item) - 1, fruitList));

            
            
        // ========================Input quantity of chosen item=======================
            
            select = Integer.parseInt(item) - 1;
            System.out.println("You selected: " + fruitList.get(select).name);
            // We use do while loop to ask user to enter valid quantity
            boolean limit;
            
            // We use this 'createNewOrder' to check if we have to create new
            // order or just update the quantity of existed order
            boolean createNewOrder = true;
            // We use this 'indexOfUpdateQuantity' to store the index of the fruit
            // in the 'shopping' list needing to update
            int index = -1;
                do {
                    limit = true;
                    System.out.print("Please input quantity: ");
                    quantity = in.nextLine();
                    
                    // If checkQuantity() is false, then ask user to re-enter
                    if (!input.checkQuantity(quantity)) {
                        System.out.println("Invalid quantity, please re-enter!");
                        continue;
                    }
                    // If quantity is blank, ask user to re-enter
                    if (!input.checkBlank(quantity)) {
                        System.out.println("Blank quantity, please re-enter!");
                        continue;
                    }
                    // If quantity is 0, ask user to re-enter
                    if (!input.checkQuantityEqual0(quantity)) {
                        System.out.println("Quantity can't be 0, please re-enter!");
                        continue;
                    }
                    
                    // We use this loop to check if a fruit is
                    // already exists in the shopping list
                    for (int i = 0; i < shopping.size(); i++) {
                        // If it exists, then we add quantity for it
                        if (fruitList.get(select).name.equalsIgnoreCase(shopping.get(i).product)){
                            quantity = Integer.parseInt(quantity) + Integer.parseInt(shopping.get(i).quantity) + "";
                            createNewOrder = false;
                            index = i;
                            break;
                    }
                    }
                    
                    // If the quantity is beyond the limit, then we ask user to re-input
                    if (Integer.parseInt(quantity) > Integer.parseInt(fruitList.get(select).quantity)) {
                        System.out.println("There's not enough fruit for you, sorry!");
                        limit = false;
                        continue;
                    }
                } while (!input.checkQuantity(quantity)
                        || limit == false
                        || !input.checkBlank(quantity)
                        || !input.checkQuantityEqual0(quantity));

               
                // ============ add temp order to shopping list ===============
                double price = Double.parseDouble(fruitList.get(select).price);
                int quantity1 = Integer.parseInt(quantity);
                // If customer say yes, then we add the new order to the order list
                double amount = price * quantity1;
                // If 'createNewOrder == true, which means it doesn't have in the shopping list
                // , then we have to create a new order
                // and add it to the 'shopping' list
                if (createNewOrder == true){
                    shopping.add(new Order (fruitList.get(select).name
                        , quantity
                        , fruitList.get(select).price, amount));
                    
                }
                // else if it's not, then we just have to update the quantity 
                // of the existed item
                else {
                    shopping.get(index).setQuantity(quantity);
                }
                
                // ==========Ask user if want to continue shopping===========
                do {
                System.out.println("Do you want to continue shopping (Y/N): ");
                check1 = in.nextLine();
                // If check1 is blank, ask user to answer yes or no again
                if (!input.checkBlank(check1)) {
                    System.out.println("Blank answer, please answer Yes or No !");
                    continue;
                }
                // If user doesnt type Y or N, ask them to re-enter again!
                if (!input.checkYesNo(check1)) {
                    System.out.println("You have to answer Yes(Y) or No(N) only!");
                }
                } while (!input.checkYesNo(check1) || !input.checkBlank(check1));
                
            } while (!check1.equalsIgnoreCase("N"));
            
              // =============Ask user if want to order now ===================
            do {
                System.out.print("Do you want to order now (Y/N): ");
                check = in.nextLine();
                // If check is blank, ask user to answer yes or no again
                if (!input.checkBlank(check)) {
                    System.out.println("Blank answer, please answer Yes or No !");
                    continue;
                }
                // If user doesnt type Y or N, ask them to re-enter again!
                if (!input.checkYesNo(check)) {
                    System.out.println("You have to answer Yes(Y) or No(N) only!");
                }
                
            } while (!input.checkYesNo(check) || !input.checkBlank(check));
            
            
            // ========If user wants to order now, we run below code=============
            if (check.equalsIgnoreCase("Y")) {
                //We use boolean next var to decide if the code runs
                // order.put(name, itemList) or order.put(name, itemList2)
                shoppingList.add(shopping);
                next = false;
                
            // ========== Reset quantity after customer bought items ===========
                // Set quantity of the fruit in the list using for loop
                for (int i = 0; i < shopping.size(); i++) {
                    // For each fruit in the shopping list, we search the same in
                    // the store fruit list
                    for (int j = 0; j < fruitList.size(); j++) {
                        // If we found, then we have to reset the quantity after
                        // the customer bought them
                        if (shopping.get(i).product.equalsIgnoreCase(fruitList.get(j).name)) {
                            fruitList.get(j).setQuantity(
                                    (Integer.parseInt(fruitList.get(j).quantity)
                                    - Integer.parseInt(shopping.get(i).quantity))
                                    + "");
                        }

                    }
                }
                
                // ====== Display product that customer bought ========
                format.displayOrder(shopping);
                
                // =====================================
                // We use do while loop to ask user to input valid name
                String name1;
                do {
                    System.out.print("Input your name: ");
                    name1 = in.nextLine();
                    // If checkName() is false, then we ask user to re-enter
                    // name again
                    if (!input.checkName(name1)) {
                        System.out.println("Invalid name, please re-enter!");
                        continue;
                    }
                    // Ì name is blank, then ask user to re-enter
                    if (!input.checkBlank(name1)) {
                        System.out.println("Blank name, please re-enter");
                        continue;
                    }

                    name1 = format.firstCharToUpper(name1);
                } while (!input.checkName(name1) || !input.checkName(name1));

                
                
                
                
                Enumeration customer;
                customer = order.keys();
                // We use this while to check if the customer is already 
                // in the order list or not, if yes then we will add new order list to
                // his/her created list
                while (customer.hasMoreElements()) {
                    String customerName = (String) customer.nextElement();
                    // if it found out the customer, then add a new order list
                    if (customerName.equals(name1)) {
                        // Create new list or class Order
                        List<List<Order>> itemList2 = new ArrayList();
                        // get list from hashtable and restore in itemLsit2
                        itemList2 = (List<List<Order>>) order.get(customerName);
                        // Add new order to itemList2
                        itemList2.add(shopping);
                        // then restore it into hashtable again
                        order.put(name1, itemList2);
                        next = true;
                        check = "N";

                    }
                }
                // If 'next' == false, whick means customer is not in the list
                // We just create a pair key-value normally
                if (next == false){
                    order.put(name1, shoppingList);
                }
                
            }

        
    }
}
