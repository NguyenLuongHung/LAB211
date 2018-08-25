
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

    Normalize normalize = new Normalize();

    // We write a function to read a input file
    String normalizeInputText(String line, String lineTemp, int firstLine) {

        

        // If line is empty, we skip this line
        // If line is the first line, we upper the first character
        // of the first word of this line
        if (firstLine == 0) {

            System.out.println("line: " + line);
            // normalize line
            lineTemp = normalize.normalize(line);
            // upper first character
            lineTemp = normalize.checkFirstCharacter(lineTemp);

            System.out.println("lineTemp: " + lineTemp);
            return lineTemp;

            // Else if line is not first line
            // We keep normalizing each line and add to output textfile
        } else {
            System.out.println("line: " + line);
            System.out.println("lineTemp: " + lineTemp);
            int length = lineTemp.length() - 1;

            // If the last character of the line is (.), 
            // Then we upper the first character of the first word
            // of the next line
            if (lineTemp.charAt(length) == 46) {

                lineTemp = normalize.normalize(line);
                lineTemp = normalize.checkFirstCharacter(lineTemp);
                System.out.println("line: " + line);
                System.out.println("lineTemp: " + lineTemp);
                return lineTemp;
            }
            else {
            // Else, we just keep normalizing normally
            lineTemp = normalize.normalize(line);
            System.out.println("line: " + line);
                System.out.println("lineTemp: " + lineTemp);
            return lineTemp;
            }
        }

        // If the last line doesn't have dot at the end, then we add it
        // to the end of the text
//            if (lineTemp.charAt(lineTemp.length() - 1) != '.') {
//                return ".";
//            
//        }
        // Alway close after finishing
    }

//    void writeFile(String text, String fileName){
//        try {
//            //  Assume default encoding
//            FileWriter fw = new FileWriter(fileName);
//            
//            // Always wrap FileWriter in BufferedWriter
//            BufferedWriter bw = new BufferedWriter(fw);
//            
//            // Note that write() dose not automatically append a newline
//            
//            bw.write(text);
//            
//            bw.close();
//        } catch (IOException e){
//            System.out.println("Error writing to file '" + "'");
//        }
//    }
    void writeNormalizedLineToOutput(String line, BufferedWriter bw, int firstLine) {
        try {
            if (firstLine == 0) {
                bw.write(line);
            } else {
                bw.newLine();
                bw.write(line);
                
            }
        } catch (IOException e) {
            System.out.println("Error writing ");
        }
    }
}
