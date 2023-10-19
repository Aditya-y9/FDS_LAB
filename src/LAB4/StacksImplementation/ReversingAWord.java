package lab4.StacksImplementation;

import java.util.Stack;

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

    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }
}
    
