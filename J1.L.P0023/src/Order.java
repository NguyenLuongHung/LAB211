/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hungnlhe130716
 */
public class Order {
    String product;
    String quantity;
    String price;
    double amount;

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public Order (String product, String quantity, String price, double amount){
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
    }
}
