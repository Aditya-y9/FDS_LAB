package lab4.StacksImplementation;

import lab4.ArrayStack;

/**
 * This class provides a method to check if a given string of HTML tags has matching opening and closing tags.
 */
public class MatchingTags {
    /**
     * Checks if the given input string of HTML tags has matching opening and closing tags.
     * 
     * @param input the string of HTML tags to check
     * @return true if the input string has matching opening and closing tags, false otherwise
     */
    public static boolean isMatching(String input) {
        ArrayStack<String> stack = new ArrayStack<String>(input.length());
        int i = 0;
        while (i < input.length()) {
            if (input.charAt(i) == '<') {
                int j = input.indexOf('>', i + 1);
                if (j == -1) {
                    return false;
                }
                String tag = input.substring(i + 1, j);
                if (tag.startsWith("/")) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    String topTag = stack.pop();
                    if (!topTag.equals(tag.substring(1))) {
                        return false;
                    }
                } else {
                    stack.push(tag);
                }
                i = j + 1;
            } else {
                i++;
            }
        }
        return stack.isEmpty();
    }
}
    
