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
    void setText(String text) {
        this.text = text;
    }

    // Check first character if it's Uppercase
    String checkFirstCharacter(String text) {
        text = Character.toUpperCase(text.charAt(0)) + text.substring(1);
        return text;
    }

    // Check space between words
    String checkSpace(String text) {
        int j = 0;
        String text1 = "";
        for (int i = 0; i < text.length(); i++) {

            // If this character is not space then we add to text1
            if (text.charAt(i) != 32) {
                text1 = text1 + text.charAt(i);
            } // Else if this character is space, then we have to check if the previous character is space or not. If it is, then we dont add to text1, if it's not, then we add to text1
            else if (text.charAt(i) == 32) {
                // if there's space before the first word of text
                // then we keep ignoing
                if (i == j) {
                    j += 1;
                    continue;
                }
                // if character is not space, then we add to text1
                if (text.charAt(i - 1) != 32) {
                    text1 = text1 + text.charAt(i);
                } // else if character is space, then we dont add to text1
                else if (text.charAt(i - 1) == 32) {
                    continue;
                }
            }

        }

        return text1;
    }

    // Check new line
    String checkNewLine(String text) {
        String text1 = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '\n') {
                text1 += '\n';
            } else {
                text1 += text.charAt(i);
            }
        }
        return text1;
    }

    // One space before dot (.), colon (,), semicolon(:)
    String checkSpaceBefore(String text) {
        String text1 = "";
        for (int i = 0; i < text.length(); i++) {
            // If this character is space and the next character is a colon then we dont add to text1
            if (text.charAt(i) == 32 && i < text.length() - 1 && text.charAt(i + 1) == 44) {
                continue;
            } // If this character is space and the next character is a dot then we dont add to text1
            else if (text.charAt(i) == 32 && i < text.length() - 1 && text.charAt(i + 1) == 46) {
                continue;
            } // If this character is space and the next character is a semicolon then we dont add to text1
            else if (text.charAt(i) == 32 && i < text.length() - 1 && text.charAt(i + 1) == 58) {
                continue;
            } else {
                text1 += text.charAt(i);
            }

        }
        return text1;
    }

    // This function is used to check if there's space after (.), (,) and (:)
    String checkSpaceAfter(String text) {
        String text1 = "";
        // this 'index' var is used to store the index of 
        int index = -1;
        for (int i = 0; i < text.length(); i++) {
            // If character is colon and the next is not space then we add one space after
            if (text.charAt(i) == 44 && i < text.length() - 1 && text.charAt(i + 1) != 32) {
                text1 += text.charAt(i) + " ";
            } // If character is dot and the next is not space then we add one space after
            else if (text.charAt(i) == 46 && i < text.length() - 1 && text.charAt(i + 1) != 32) {
                text1 += text.charAt(i) + " ";
            } // If character is semicolon and the next is not space then we add one space after
            else if (text.charAt(i) == 58 && i < text.length() - 1 && text.charAt(i + 1) != 32) {
                text1 += text.charAt(i) + " ";
            } else if (text.charAt(i) == 34 && i < text.length() - 1 && text.charAt(i + 1) != 32) {
                text1 += text.charAt(i) + " ";
            } else {
                text1 += text.charAt(i);
            }
        }
        return text1;
    }

    // Check first character after dot if it's Uppercase
    String checkDotUpper(String text) {
        int index = -1;
        char upper = ' ';
        String text1 = "";
        // We use this loop to determine the dot character
        for (int i = 0; i < text.length(); i++) {
            // If character is dot and has 2 more character to the end of line
            // Store the first character of first word after the dot into 'index' 
            // variable
            if (text.charAt(i) == 46 && i < text.length() - 2) {
                upper = Character.toUpperCase(text.charAt(i + 2));
                index = i + 2;
                text1 += text.charAt(i);
            } else // If i == index which means this character is the character needing
            // upper, then we upper this character
             if (i == index) {
                    text1 += upper;
                } else {
                    text1 += text.charAt(i);
                }
        }
        return text1;
    }

    // This function is used to check lower character after colon
    String checkLowerColon(String text) {
        char lower = ' ';
        int index = -1;
        String text1 = "";
        // This for loop is used to find the index of the chracter after colon
        for (int i = 0; i < text.length(); i++) {
            // If character is colon and has 2 more character to the end of line
            // Store the first character of first word after the colon into 'index' 
            // variable
            if (text.charAt(i) == 44 && i < text.length() - 2) {
                lower = Character.toLowerCase(text.charAt(i + 2));
                index = i + 2;

                text1 += text.charAt(i);
            } else if (i == index) {
                text1 += lower;

            } else {
                text1 += text.charAt(i);
            }

        }
        return text1;
    }

    // This function is used to check if there's space before open quote
    String checkSpaceBeforeQuote(String text) {
        String text1 = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 34 && text.charAt(i - 1) != 32) {
                text1 += " " + text.charAt(i);
            } else if (text.charAt(i) == 46) {
                text1 += text.charAt(i);
            } else {
                text1 += text.charAt(i);
            }

        }
        return text1;

    }

    // Check if there is space before and after the ""
    String checkQuote(String text) {
        int index = -1;
        int index1 = -1;
        String text1 = "";

        // We use this for loop to handle words between quotes
        for (int i = 0; i < text.length(); i++) {
            // If the character is quote, mark it as open quote
            if (text.charAt(i) == 34 && i < text.length() - 2 && i != index1 + 1) {
                // If the next character is space, then we store its index into
                // 'index' var
                if (text.charAt(i + 1) == 32) {
                    index = i + 1;
                }

                // After marking the open quote, we keeping finding the closed quote
                // using this for loop
                for (int j = i; j < text.length(); j++) {
                    // If the character before the closed quote is space, then
                    // we store it's index into 'index1' var
                    if (text.charAt(j) == 32 && j < text.length() - 1 && text.charAt(j + 1) == 34) {
                        index1 = j;
                        break;
                    }

                }
                text1 += text.charAt(i);
            } // if i == index which means this character is the space after 
            // open quote, we terminate it
            else if (i == index) {
                continue;
            } // if i== index1 which means this character is the space before
            // closed quote, we terminate it too
            else if (i == index1) {
                continue;
            } // Else we add normally
            else {
                text1 += text.charAt(i);
            }

        }

        return text1;
    }

    // Check if there is a dot at the end of the text
    String checkDotEnd(String line, String lineTemp) {
        
            if (lineTemp.charAt(lineTemp.length() - 1) != '.') {
                return ".";
            }
        
        return "";
    }

    // Check if there is blank line between lines
//    String checkBlankLine(String text){
//        int j=0;
//        String text1 = "";
//        for (int i = 0; i < text.length(); i++) {
//            if (text.charAt(i) == 13){
//                if (i == j){
//                    j += 2;
//                    i++;
//                    continue;
//                }
//                else if (text.charAt(i+2) == 13){
//                    i++;
//                    continue;
//                }
//                else text1 += text.charAt(i);
//            }
//            else text1 += text.charAt(i);
//             
//        }
//        return text1;
//    }
    String checkSpaceEnd(String text) {
        String text1 = "";
        // We use this loop to find the space at the end
        for (int i = 0; i < text.length(); i++) {
            // If character is not last character, add normally
            if (i != text.length() - 1) {
                text1 += text.charAt(i);
            } // else if is
            else // if last character is space, we dont add to text1
             if (text.charAt(i) == ' ') {
                    continue;
                } // else we add to text1
                else {
                    text1 += text.charAt(i);
                }

        }
        return text1;
    }

    String normalize(String text) {

        // 1. Check if there's only one space between words
        text = checkSpace(text);

        // 2. Check space before dot, colon and semicolon
        text = checkSpaceBefore(text);

        // 3. Check space after dot, colon and semicolon
        text = checkSpaceAfter(text);

        // 4. Check If first word after dot is Upper or not
        text = checkDotUpper(text);

        // 5. Check lower character after colon
        text = checkLowerColon(text);

        // 6. Check space before open quote
        text = checkSpaceBeforeQuote(text);

        // 7. Check Word between quotes
        text = checkQuote(text);

        // 8. Check if there's space in the end of each line
        // If there's, we terminate it
        text = checkSpaceEnd(text);

        return text;
    }
}
