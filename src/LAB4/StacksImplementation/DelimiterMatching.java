package LAB4.StacksImplementation;
import java.util.ArrayList;
import java.util.Scanner;
import LAB4.*;
public class DelimiterMatching {
    public static boolean isDelimiterMatching(String input) {
        ArrayStack<Character> stack = new ArrayStack<Character>(input.length());
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