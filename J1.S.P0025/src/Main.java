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
        File file1 = new File();  
        String text = file1.readFile("input.txt");

        System.out.println(text);
        file1.writeFile(text, "output.txt");
    
    }
}
