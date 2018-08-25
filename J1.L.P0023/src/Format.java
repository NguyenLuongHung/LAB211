
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hungnlhe130716
 */
public class Format {
    // This function is used to upper the first characet of word
    String firstCharToUpper (String text){
        text = Character.toUpperCase(text.charAt(0)) + text.substring(1);
        return text;
    }
    
    // This function is used to display order
    // This function is used to display list of fruit
    void displayList (List<Fruit> a){
        System.out.println("-------------------------------------------------");
        System.out.printf("%-5s%-4s%-13s%-4s%-8s%-4s%-10s%-4s%-6s", "Item",
                " | ", "Fruit Name",
                " | ", "Quantity",
                " | ", "Origin",
                " | ", "Price");
        System.out.println("");
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).quantity.equalsIgnoreCase("0")){
            System.out.printf("%-5s%-4s%-13s%-4s%-8s%-4s%-10s%-4s%-6s",a.get(i).id,
                    " | ",a.get(i).name,
                    " | ",a.get(i).quantity,
                    " | ",a.get(i).origin,
                    " | ",a.get(i).price+"$");
            System.out.println("");
            }
        }
        System.out.println("-------------------------------------------------");
    }
        //This function is used to display shopping
        void displayShopping (String name, String quantity, String price, double amount){
            System.out.println("-----------------------------------------");
            System.out.printf("%-8s%-4s%-9s%-4s%-6s%-4s%8s","Product",
                    " | ","Quantity",
                    " | ","Price",
                    " | ","Amount");
            System.out.println("");
            System.out.printf("%-8s%-4s%-9s%-4s%-6s%-4s%7.1f",name,
                    " | ",quantity,
                    " | ",price+"$",
                    " | ", amount);
            System.out.print("$");
            System.out.println("");
            System.out.printf("Total: %7.1f%2s" ,amount,"$");
            System.out.println("");
            System.out.println("-----------------------------------------");
   
    }
        
        // This function is used to display order
        void displayOrder (List<Order> order1){
            if (order1.isEmpty()){
                System.out.println("There is no order at the moment!");
            }
            else {
            System.out.println("---------------------------------------------");
            System.out.printf("%-8s%-4s%-9s%-4s%-6s%-4s%8s","Product",
                    " | ","Quantity",
                    " | ","Price",
                    " | ","Amount");
            System.out.println("");
            double amount = 0;
            for (int i = 0; i < order1.size(); i++) {
                System.out.printf("%-8s%-4s%-9s%-4s%-6s%-4s%7.1f", order1.get(i).product,
                        " | ",order1.get(i).quantity,
                        " | ",order1.get(i).price+"$",
                        " | ",order1.get(i).amount);
                System.out.print("$");
                amount += order1.get(i).amount;
                System.out.println("");
                
            }
            System.out.println("");
                System.out.println("----");
                System.out.printf("Total: %7.1f%2s" ,amount,"$");
                System.out.println("");
                System.out.println("-----------------------------------------");
                    }
        }
}
