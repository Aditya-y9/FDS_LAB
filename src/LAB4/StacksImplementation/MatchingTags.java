package LAB4.StacksImplementation;

import LAB4.*;

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
            // If the current character is '<', then it is the start of a tag.
            if (input.charAt(i) == '<') {
                int j = input.indexOf('>', i + 1);
                if (j == -1) {
                    return false;
                }
                // Extract the tag from the input string.
                String tag = input.substring(i + 1, j);
                if (tag.startsWith("/")) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    // If the tag is a closing tag, then check if it matches the top tag in the stack.
                    String topTag = stack.pop();
                    if (!topTag.equals(tag.substring(1))) {
                        return false;
                    }
                    // If the tag is a closing tag, then check if it matches the top tag in the stack.
                } else {
                    stack.push(tag);
                }
                i = j + 1;
            } else {
                i++;
            }
        }
        // If the stack is empty, then all the opening tags have been matched with closing tags.
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String input = "<html><head><title>My Title</title></head><body><h1>Heading</h1><p>Paragraph</p></body></html>";
        String mismatch = "<html><head><title>My Title</title></head><body><h1>Heading</h1><p>Paragraph</body></html>";
        if (isMatching(input)) {
            System.out.println("The String has Matching tags");
        }
        else {
            System.out.println("The String has Mismatching tags");
        }
    }
}
    
