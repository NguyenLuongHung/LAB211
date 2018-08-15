/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Order {
    String product;
    int quantity;
    double price;
    double amount;
    
    public Order(String product, int quantity, double price, double amount){
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
    }
    
    void display(){
        
        System.out.println("Product | Quantity | Price | Amount");
        System.out.printf("%-15s%-9d%.0f",product,quantity,price);
        System.out.printf("%-7s", "$");      
        System.out.printf("%.0f",amount);
        System.out.print("$");
        System.out.println("");
        System.out.print("Total: "+amount);
        System.out.println("$");
    }
    void displayForOrderView(){
        
        System.out.printf("%-15s%-9d%.0f",product,quantity,price);
        System.out.printf("%-7s", "$");      
        System.out.printf("%.0f",amount);
        System.out.print("$");
        System.out.println("");
    }
}
