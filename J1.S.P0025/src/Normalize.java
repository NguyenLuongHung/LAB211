/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Normalize {
    String text = "";
    
    // set input
    void setText (String text){
        this.text = text;
    }
    // Check first character if it's Uppercase
    String checkFirstCharacter(String text){
        text = Character.toUpperCase(text.charAt(0)) + text.substring(1);
        return text;
    }
    
    // Check space between words
    String checkSpace(String text){
        int j = 0;
        String text1 = "";
        for (int i = 0; i < text.length(); i++) {
            
            // If this character is not space then we add to text1
            if ( text.charAt(i) != 32){
                text1 = text1 + text.charAt(i);
            }
            // Else if this character is space, then we have to check if the previous character is space or not. If it is, then we dont add to text1, if it's not, then we add to text1
            else if (text.charAt(i) == 32){
                if (i == j){
                    j += 1;
                    continue;
                }
                if (text.charAt(i-1) != 32)
                    text1 = text1 + text.charAt(i);
                else if (text.charAt(i-1) == 32)
                    continue;
            }
            
        }
        
        return text1;
    }
    
    // Check new line
    String checkNewLine(String text){
        String text1 = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '\n')
                text1 += '\n';
            else text1 += text.charAt(i);
        }
        return text1;
    }
    
    // One space after dot (.), colon (,), semicolon(:)
    String checkAfter(String text){
        String text1 = "";
        for (int i = 0; i < text.length(); i++) {
            // If this character is space and the next character is a colon then we dont add to text1
            if(text.charAt(i) == 32 &&  i < text.length() - 1 && text.charAt(i+1) == 44 )
                continue;
            // If this character is space and the next character is a dot then we dont add to text1
            else if (text.charAt(i) == 32 && i < text.length() - 1  && text.charAt(i+1) == 46 )
                continue;
            // If this character is space and the next character is a semicolon then we dont add to text1
            else if (text.charAt(i) == 32 && i < text.length() - 1 && text.charAt(i+1) == 58 )
                continue;
            else
                text1 += text.charAt(i);
            
            
        }
        return text1;
    }
    
    // Check first character after dot if it's Uppercase
    String checkDotUpper(String text){
        int index = 999;
        char upper = ' ';
        String text1 = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 46 && i < text.length()-2){
                upper = Character.toUpperCase(text.charAt(i+2));
                index = i+2;
                text1 += text.charAt(i);
            }
            else {
                if (i == index)
                    text1 += upper;
                else text1 += text.charAt(i);
            }
        }
        return text1;
    }
    
    // Check if there is space before and after the ""
    String checkQuote(String text){
        int index = -1;
        int index1 = -1;
        String text1 = "";
        
        for (int i = 0; i < text.length(); i++) {
            
            if (text.charAt(i) == 34 && i < text.length() - 2 && i != index1+1){
                if(text.charAt(i+1) == 32)
                    index = i+1;
                
                for (int j = i; j < text.length(); j++) {
                    if (text.charAt(j) == 32 && j < text.length() - 1 && text.charAt(j+1) == 34)
                        index1 = j;
                }
                text1 += text.charAt(i);
            }
            else if (i == index){
                continue;
            }
            else if (i == index1)
                continue;
            else text1 += text.charAt(i);
            
            
        }
        
        return text1;
    }
    
    // Check if there is a dot at the end of the text
    String checkDotEnd(String text){
        if (text.charAt(text.length()-1) != 46){
//            text = text.substring(0, text.length()-1) + '.';
            text += '.';
        }
        return text;
    }
    
    // Check if there is blank line between lines
    
    String checkBlankLine(String text){
        int j=0;
        String text1 = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 13){
                if (i == j){
                    j += 2;
                    i++;
                    continue;
                }
                else if (text.charAt(i+2) == 13){
                    i++;
                    continue;
                }
                else text1 += text.charAt(i);
            }
            else text1 += text.charAt(i);
             
        }
        return text1;
    }
    
    boolean checkSpaceEnd (String text){
       if (text.charAt(text.length() - 1) != ' ') {
           return true;
       }
       else {
           return false;
       }
    }
    
    String normalize(String text){
        
        text = checkSpace(text);
        text = checkAfter(text);
        text = checkDotUpper(text);
        text = checkQuote(text);
        if (checkSpaceEnd(text)){
            text += " ";
        }
        
        return text;
    }
}
