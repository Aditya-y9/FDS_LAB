package lab4.StacksImplementation;

import lab4.ArrayStack;

/**
 * This class checks if the delimiters in a given string are matching or not.
 */
public class DelimiterMatching {

    /**
     * Checks if the delimiters in the given input string are matching or not.
     * @param input the input string to check
     * @return true if the delimiters are matching, false otherwise
     */
    public static boolean isDelimiterMatching(String input) {
        ArrayStack<Character> stack = new ArrayStack<>(input.length());
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                stack.push(currentChar);
            } else if (currentChar == ')' || currentChar == ']' || currentChar == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if ((currentChar == ')' && topChar != '(') || (currentChar == ']' && topChar != '[')
                        || (currentChar == '}' && topChar != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * The main method to test the isDelimiterMatching method.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = "{(Aditya Yedurkar 221080076)SYBTech IT}[]";
        String not = "[{}][[[Aditya Yedurkar 221080076}}";
        if (isDelimiterMatching(input)) {
            System.out.println("Delimiter matching");
        }
        else {
            System.out.println("Delimiter not matching");
        }
    }
}
