import java.util.Scanner;
public class test {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int option;
        System.out.println("enter the capacity of the array");
        int size = sc.nextInt();
        MyLongArray a = new MyLongArray(size);

        char choice1 = 'Y';
        boolean Exit = false;
        boolean running = true;

        while (running) {
            
            //Menu for doing the operations.
            System.out.println("Enter your choice :");
            System.out.println("1: Find an element\n" +
                    "2: Insert an element\n" +
                    "3: Get an element\n" +
                    "4: Delete an element\n" +
                    "5: Display the array\n" +
                    "6: Delete all the elements matching the given value\n" +
                    "7: Insert an element at a given index\n" +
                    "8: Delete an element at a given index\n" +
                    "9: Exit");
            option = sc.nextInt();

            while (!Exit) {
                
                // SWITCH CASE
                switch (option) {
                    case 1:
                        System.out.println("Enter the element to find");
                        long value = sc.nextLong();
                        int index = a.find(value);
                        Exit = true;
                        break;
                    case 2:
                        System.out.println("Enter the element to be inserted");
                        value = sc.nextLong();
                        a.insert(value);
                        Exit = true;
                        break;
                    case 3:
                        System.out.println("Enter the index of the element to be found");
                        index = sc.nextInt();
                        System.out.println("Element at index " + index + " is " + a.getElem(index));
                        Exit = true;
                        break;
                    case 4:
                        System.out.println("Enter the index of the element to be deleted");
                        index = sc.nextInt();
                        a.delete(index);
                        Exit = true;
                        break;
                    case 5:
                        a.display();
                        Exit = true;
                        break;
                    case 6:
                        System.out.println("Enter the value of the element to be deleted");
                        value = sc.nextLong();
                        int count = a.dupDelete(value);
                        System.out.println("Number of elements deleted are " + count);
                        Exit = true;
                        break;
                    case 7:
                        System.out.println("Enter the index at which the element is to be inserted");
                        index = sc.nextInt();
                        System.out.println("Enter the value of the element to be inserted");
                        value = sc.nextLong();
                        a.insert(index, value);
                        Exit = true;
                        break;
                    case 8:
                        System.out.println("Enter the index of the element to be deleted");
                        index = sc.nextInt();
                        System.out.println("Element deleted is " + a.deleteAt(index));
                        Exit = true;
                        break;
                    case 9:
                        System.out.println("THANK YOU FOR USING THE PROGRAM!");
                        Exit = false;
                        break;
                    
                    default:
                        System.out.println("Enter a valid choice");
                        Exit = true;
                        break;
                        
                }
                System.out.println("Do you want to continue? (Y/N)");
                choice1 = sc.next().charAt(0);
                if (choice1 == 'Y' || choice1 == 'y') {
                    running = true;
                } else if (choice1 == 'N' || choice1 == 'n') {
                    running = false;
                    System.out.println("EXITTING");
                } else {
                    System.out.println("Enter a valid character");
                }
            }
        }
    }
}