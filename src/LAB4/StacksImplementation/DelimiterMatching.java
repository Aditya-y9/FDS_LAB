package LAB4.StacksImplementation;

import java.util.ArrayList;
import java.util.Scanner;
import LAB4.*;
public class DelimiterMatching {
    /**
     * This method checks if the delimiters in the input string are matching or not.
     *
     * @param input the input string
     * @return true if the delimiters are matching, false otherwise
     */
    public static boolean isDelimiterMatching(String input) {
        // Create a stack of characters.
        ArrayStack<Character> stack = new ArrayStack<Character>(input.length());
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
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Enter the input string: ");
        Scanner s = new Scanner(System.in);
        String input = "";
        ArrayList<String> inputLines = new ArrayList<String>();
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if (line.equals("")) {
                break;
            }
            inputLines.add(line);
        }
        for (String line : inputLines) {
            input += line;
        }
        if (isDelimiterMatching(input)) {
            System.out.println("Delimiter matching");
        } else {
            System.out.println("Delimiter not matching");
        }
        s.close();
    }
}
