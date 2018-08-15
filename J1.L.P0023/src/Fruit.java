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
    int id;
    String name;
    int quantity;
    double price;
    String origin;
    public Fruit(int id, String name, int quantity, double price, String origin){
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.origin = origin;
        this.name = name;
    }
}
