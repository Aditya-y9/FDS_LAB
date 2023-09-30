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
            System.out.println(" 1. Search an element \n 2. Insertion\n 3. Get the element at an index\n 4. Deletion\n 5. Display elements of array\n 6. Delete all elements matching the given value\n 7. Insert an element at a given index\n 8. Delete element at given index\n 9. Random Init \n 10. Bubble Sort \n 11. Selection Sort \n 12. Insertion Sort \n 13. Exit\n");
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
                        a.initArray();
                        System.out.println("Successfully Initialized");
                        Exit = true;
                        break;
                    
                    case 10:
                        a.bubbleSort();
                        System.out.println("Successfully sorted using Bubble Sort");
                        Exit = true;
                        break;
                        
                    case 11:
                        a.selectionSort();
                        System.out.println("Successfully sorted using Selection Sort");
                        Exit = true;
                        break;
                        
                    case 12:
                        a.insertionSort();
                        System.out.println("Successfully sorted using Insertion Sort");
                        Exit = true;
                        break;
                    
                    case 13:
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