
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
public class Main {

    public static void main(String[] args) {
        Normalize normalize = new Normalize();
        File file = new File();
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        String line = "";
        String lineTemp = "";
        int firstLine = 0;

        // Read each line of text 
        try {
            // FileReader reads text files in the default encoding.
            FileReader fr = new FileReader(inputFile);

            // Always wrap FileReader in BufferedReader.
            BufferedReader br = new BufferedReader(fr);

            // Read each line of text
            FileWriter fw = new FileWriter(outputFile);

            BufferedWriter bw = new BufferedWriter(fw);
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()){
                    continue;
                }
                else {
                    // Store normalized line in 'lineTemp' variable 
                    lineTemp = file.normalizeInputText(line, lineTemp, firstLine);
                    // Then we write 'lineTemp' to the output file
                    file.writeNormalizedLineToOutput(lineTemp, bw, firstLine);
                    // After normalizing and write to output the first line
                    // We increase 'firstline' var to ignore first Line
                    firstLine++;
                }
            }
            
           // After normalizing the whole text, we check if there's a dot in 
           // the end of text file, if there isn't, we add dot to the end
           bw.write(normalize.checkDotEnd(line, lineTemp));
           // After reading file, close them
            br.close();
            fr.close();
            // After writing to file, close them
            bw.close();
            fw.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + inputFile + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + inputFile + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }

    }
}
