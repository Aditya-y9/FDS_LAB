package LAB4.StacksImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.*;

import LAB4.*;


/**
 * The DelimiterMatching class checks if the delimiters in the given input string are matching or not.
 * It contains a static method isDelimiterMatching which takes an input string and returns true if the delimiters are matching, false otherwise.
 * It also contains a main method to test the isDelimiterMatching method.
 */
public class DelimiterMatching {

    /**
     * Checks if the delimiters in the given input string are matching or not.
     * @param input the input string to check
     * @return true if the delimiters are matching, false otherwise
     */
    public static boolean isDelimiterMatching(String input) {
        ArrayStack<Character> stack = new ArrayStack<>(input.length()+1);
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            // If the current character is an opening delimiter, then push it onto the stack.
            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                stack.push(currentChar);
            } else if (currentChar == ')' || currentChar == ']' || currentChar == '}') {
                // If the current character is a closing delimiter, then pop the top character from the stack.
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                // If the popped character does not match the current character, then the delimiters are not matching.
                if ((currentChar == ')' && topChar != '(') || (currentChar == ']' && topChar != '[')
                        || (currentChar == '}' && topChar != '{')) {
                            // so return false.
                    return false;
                }
            }
        }
        // if the stack is empty, then all the opening delimiters have been matched with closing delimiters.
        return stack.isEmpty();
    }

    /**
     * The main method to test the isDelimiterMatching method.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the input string: ");
        Scanner s = new Scanner(System.in);
        ArrayList<String> in = new ArrayList<String>();
        while (s.hasNextLine() == true){
            String line = s.nextLine();
            if ("".equals(line)) {
                break;
            }
            in.add(line);
        }
        String input = String.join("", in);
        if (isDelimiterMatching(input)) {
            System.out.println("Delimiter matching");
        }
        else {
            System.out.println("Delimiter not matching");
        }
    }
};
