package LAB4.StacksImplementation;
import LAB4.*;
public class IntegerToBinary {
    public static void main(String[] args) {
        int num = 10;
        ArrayStack<Integer> stack = new ArrayStack<>(num);
        System.out.print("The binary representation of " + num + " is: ");
        while (num > 0) {
            stack.push(num % 2);
            num = num / 2;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}

