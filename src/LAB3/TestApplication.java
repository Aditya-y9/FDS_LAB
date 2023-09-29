
import java.util.Scanner;


/**
 * 
 * <p>The <code>TestApplication</code> class represents a test application for <code>MyLongArray</code>
 * It allows users to perform various operations on an array of long values.</p>
 *@author Aditya Yedurkar
  @version 1.5.0
 * <p><strong>Author: Aditya Yedurkar 221080076</strong></p>
 * <p><strong>Version:</strong> 1.5</p>
 * <p>
 * This program is used to perform various operations on an array of long values
 * </p>
 */
public class TestApplication {
    /**
     * The main method that allows users to interact with <code>MyLongArray</code>
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size = sc.nextInt();
        MyLongArray arr = new MyLongArray(size);

        char choice1 = 'Y';
        boolean Exit = false;
        boolean running = true;

        while (running) {
            System.out.println("Enter the operation to be performed\n" +
                    "0. Initialize the array\n" +
                    "1. Find an element\n" +
                    "2. Insert an element\n" +
                    "3. Get an element\n" +
                    "4. Delete an element\n" +
                    "5. Display the array\n" +
                    "6. Delete all elements matching a value\n" +
                    "7. Insert an element at a given index\n" +
                    "8. Delete an element at a given index\n" +
                    "9. Bubble sort\n" +
                    "10. Selection sort\n" +
                    "11. Insertion sort\n");
            int choice = sc.nextInt();
            Exit = false;
            while (!Exit) {
                try {
                    switch (choice) {
                        case 0:
                            /**
                             * Initializes the array with user-defined size
                             */
                            arr.initArray();
                            Exit = true;
                            break;
                        case 1:
                            System.out.println("Enter the element to find");
                            long value = sc.nextLong();
                            /**
                             * Finds an element in the array
                             *
                             * @param value The element to find
                             * @return The index of the element, or -1 if not found
                             */
                            int index = arr.find(value);
                            if (index == -1) {
                                System.out.println("Element not found");
                            } else {
                                System.out.println("Element found at index " + index);
                            }
                            Exit = true;
                            break;
                        case 2:
                            System.out.println("Enter the element to be inserted");
                            value = sc.nextLong();
                            /**
                             * Inserts an element into the array
                             *
                             * @param value The element to insert
                             */
                            arr.insert(value);
                            Exit = true;
                            break;
                        case 3:
                            System.out.println("Enter the index of the element to be found");
                            index = sc.nextInt();
                            /**
                             * Gets an element from the array at a given index
                             *
                             * @param index The index of the element to retrieve
                             * @return The element at the specified index
                             */
                            System.out.println("Element at index " + index + " is " + arr.getElem(index));
                            Exit = true;
                            break;
                        case 4:
                            System.out.println("Enter the index of the element to be deleted");
                            index = sc.nextInt();
                            /**
                             * Deletes an element from the array at a given index
                             *
                             * @param index The index of the element to delete
                             */
                            arr.delete(index);
                            Exit = true;
                            break;
                        case 5:
                            /**
                             * Displays the contents of the array
                             */
                            arr.display();
                            Exit = true;
                            break;
                        case 6:
                            System.out.println("Enter the value of the element to be deleted");
                            value = sc.nextLong();
                            /**
                             * Deletes all elements matching the given value from the array
                             *
                             * @param value The value to be deleted
                             * @return The number of elements deleted
                             */
                            int count = arr.dupDelete(value);
                            System.out.println("Number of elements deleted are " + count);
                            Exit = true;
                            break;
                        case 7:
                            System.out.println("Enter the index at which the element is to be inserted");
                            index = sc.nextInt();
                            System.out.println("Enter the value of the element to be inserted");
                            value = sc.nextLong();
                            /**
                             * Inserts an element at a given index in the array
                             *
                             * @param index The index at which to insert the element
                             * @param value The element to insert
                             */
                            arr.insert(index, value);
                            Exit = true;
                            break;
                        case 8:
                            System.out.println("Enter the index of the element to be deleted");
                            index = sc.nextInt();
                            /**
                             * Deletes an element from the array at a given index
                             *
                             * @param index The index of the element to delete
                             * @return The deleted element
                             */
                            System.out.println("Element deleted is " + arr.deleteAt(index));
                            Exit = true;
                            break;
                        case 9:
                            // bubble sort
                            arr.bubbleSort();
                            System.out.println("Array after bubble sort");
                            arr.display();
                            Exit = true;
                            break;
                        case 10:
                            // selection sort
                            arr.selectionSort();
                            System.out.println("Array after selection sort");
                            arr.display();
                            Exit = true;
                            break;
                        case 11:
                            // insertion sort
                            arr.insertionSort();
                            System.out.println("Array after insertion sort");
                            arr.display();
                            Exit = true;
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
                        System.out.println("Thank you for using the program");
                    } else {
                        System.out.println("Enter a valid character");
                    }
                } catch (Exception e) {
                    System.err.println("An error occurred: " + e.getMessage());
                    sc.nextLine(); // Consume the invalid input
                }
            }
        }
    }
}

