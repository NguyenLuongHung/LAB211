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
        Normalize normalize = new Normalize();
        
        String text = file1.readFile("input.txt");
        
//      text = normalize.checkNewLine(text);
        text = normalize.checkBlankLine(text);
        text = normalize.checkSpace(text);
        text = normalize.checkFirstCharacter(text);
        text = normalize.checkAfter(text);
        text = normalize.checkDotUpper(text);
        text = normalize.checkQuote(text);
        text = normalize.checkDotEnd(text);
        

        System.out.println(text);
        file1.writeFile(text, "output.txt");
    
    }
}
