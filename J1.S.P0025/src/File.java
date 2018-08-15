
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class File {
    
    // We write a function to read a input file
    String readFile(String fileName){
        int current;
        String text = "";
        try {
            // FileReader reads text file in the default encoding
            FileReader fr = new FileReader(fileName);
            
            // Alway wrap FileReader in BufferedReader
            BufferedReader br = new BufferedReader(fr);
            while((current = br.read()) != -1){
                text += (char)current;
                
            }
            
            // Alway close after finishing
            br.close();
            fr.close();
        } catch (FileNotFoundException e){
            System.out.println("Unable to open file '" + fileName +"'");
        }
         catch (IOException e){
             System.out.println("Error reading file '" + "'");
         }
        return text;
    }
    
    
    void writeFile(String text, String fileName){
        try {
            //  Assume default encoding
            FileWriter fw = new FileWriter(fileName);
            
            // Always wrap FileWriter in BufferedWriter
            BufferedWriter bw = new BufferedWriter(fw);
            
            // Note that write() dose not automatically append a newline
            
            bw.write(text);
            
            bw.close();
        } catch (IOException e){
            System.out.println("Error writing to file '" + "'");
        }
    }
}
