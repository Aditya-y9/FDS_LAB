package LAB4.StacksImplementation;

import LAB4.*;

/**
 * The ReversingAWord class contains a main method that reverses a given string using a stack.
 * The reverseString method takes a string as input and returns the reversed string using a stack.
 * The main method initializes a string variable with a value, calls the reverseString method to reverse the string,
 * and prints the reversed string to the console.
 * 
 * @param str the string to be reversed
 * @return the reversed string
 */
public class ReversingAWord {
    public static void main(String[] args) {
        String word = "Aditya Yedurkar";
        String reversedWord = reverseString(word);
        System.out.println(reversedWord); 
    }

    /**
     * Reverses the given string using a stack.
     * 
     * @param str the string to be reversed
     * @return the reversed string
     */
    public static String reverseString(String str) {
        ArrayStack<Character> stack = new ArrayStack<Character>(str.length());
        // Push each character of the string onto the stack.
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        // Pop each character from the stack and append it to the reversed string.
        // beacuse stack is LIFO, the characters will be popped in reverse order.
        String reversedString = "";
        while (!stack.isEmpty()) {
            reversedString += stack.pop();
        }
        return reversedString;
    }
}
    
