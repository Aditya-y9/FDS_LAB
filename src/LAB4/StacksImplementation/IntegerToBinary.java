package lab4.StacksImplementation;

import lab4.ArrayStack;

/**
 * The IntegerToBinary class converts an integer to its binary representation.
 * It contains a main method that takes an integer and prints its binary representation.
 * The binary representation is obtained by dividing the integer by 2 and pushing the remainder onto a stack.
 * The binary representation is then obtained by popping the elements from the stack and printing them.
 */
public class IntegerToBinary {
    public static void main(String[] args) {
        int num = 10;
        ArrayStack<Integer> stack = new ArrayStack<Integer>();
        while (num > 0) {
            stack.push(num % 2);
            num = num / 2;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}

