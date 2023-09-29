import java.util.Scanner;
import java.util.Random;

/**
 * Represents a LONG array with various operations on it.
 * like a database.
 */
class MyLongArray {
    int size;
    int currentIndex = 0;
    long[] arr;
    Scanner sc = new Scanner(System.in);

    /**
     * Initializes a new instance of the MyLongArray class with the specified size.
     *
     * @param size The size of the array.
     */
    MyLongArray(int size) {
        // Storing the size of the array to later traverse the array
        this.size = size;
        arr = new long[size];
        
    }

    /**
     * Finds the index of a given element in the array.
     *
     * @param value The value to find in the array.
     * @return The index of the given element if found, or -1 if not found.
     */
    public int find(long value) {
        for (int i = 0; i < currentIndex; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Inserts an element at the end of the array.
     *
     * @param value The value to insert.
     */
    public void insert(long value) {
        if (currentIndex == size) {
            System.out.println("Array is already full");
            return;
        }
        arr[currentIndex++] = value;
    }

    /**
     * Gets the element at the given index.
     *
     * @param index The index of the element to retrieve.
     * @return The element at the specified index.
     */
    public long getElem(int index) {
        return arr[index];
    }

    /**
     * Deletes an element at the specified index by shifting elements to the left.
     *
     * @param index The index of the element to delete.
     */
    public void delete(int index) {
        if (index < 0 || index >= currentIndex) {
            System.out.println("Invalid index");
            return;
        }
        for (int i = index; i < currentIndex - 1; i++) {
            // left shift the elements
            arr[i] = arr[i + 1];
        }
        // make the current array size smaller
        currentIndex--;
    }

    /**
     * Deletes all occurrences of a given value in the array.
     *
     * @param value The value to delete.
     * @return True if at least one element was deleted, otherwise false.
     */
    public boolean delete(long value) {
        for (int i = 0; i < currentIndex; i++) {
            if (arr[i] == value) {
                delete(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Displays the elements in the array.
     */
    public void display() {
        for (int i = 0; i < currentIndex; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * Deletes all occurrences of a given value in the array and returns the count.
     *
     * @param value The value to delete.
     * @return The number of elements deleted.
     */
    public int dupDelete(long value) {
        int count = 0;

        // traverse the whole array
        for (int i = 0; i < currentIndex; i++) {
            if (arr[i] == value) {
                // delete matching elements
                delete(i);
                count++;
                i--;
                // decrement i as deleted fn shortens the array
            }
        }
        return count;
    }

    /**
     * Inserts an element at the specified index, shifting elements to the right.
     *
     * @param index The index at which to insert the element.
     * @param value The value to insert.
     */
    public void insert(int index, long value) {
        if (index < 0 || index >= currentIndex) {
            System.out.println("Enter index from 0 up to " + (currentIndex - 1) + " only");
            return;
        }
        if (currentIndex == arr.length) {
            System.out.println("Array is already full");
            return;
        }
        // right shift the elements

        // increase the size of the array
        currentIndex++;
        for (int i = currentIndex - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        // insert the element
        arr[index] = value;
    }

    /**
     * Deletes an element at the specified index and returns its value.
     *
     * @param index The index of the element to delete.
     * @return The deleted element's value, or -1 if the index is invalid.
     */
    public long deleteAt(int index) {
        if (index >= 0 && index < currentIndex) {
            long temp = arr[index];
            delete(index);
            return temp;
        } else {
            System.out.println("Invalid index");
            return -1; // Return a default value or handle it differently
        }
    }
    public void bubbleSort() {
        for (int i = 0; i < currentIndex - 1; i++) {
            for (int j = 0; j < currentIndex - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    long temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        } 
    }
    public void selectionSort() {
        for (int i = 0; i < currentIndex - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < currentIndex; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            long temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    public void insertionSort() {
        for (int i = 1; i < currentIndex; i++) {
            long temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j--];
            }
            arr[j + 1] = temp;
        }
    }
    public void initArray() {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextLong();
        }
    }
}

/**
 * Main class to demonstrate the usage of MyLongArray.
 */
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size = sc.nextInt();
        LAB2 arr = new LAB2(size);

        char choice1 = 'Y';
        boolean Exit = false;
        boolean running = true;

        while (running) {
            System.out.println("Enter the operation to be performed\n" +
                    "0: Initialize the array\n"+
                    "1: Find an element\n" +
                    "2: Insert an element\n" +
                    "3: Get an element\n" +
                    "4: Delete an element\n" +
                    "5: Display the array\n" +
                    "6: Delete all the elements matching the given value\n" +
                    "7: Insert an element at a given index\n" +
                    "8: Delete an element at a given index\n" +
                    "9: Exit\n"+
                    "10: Bubble Sort\n"+
                    "11: Selection Sort\n"+
                    "12: Insertion Sort\n");
            int choice = sc.nextInt();
            Exit = false;
            while (!Exit) {
                switch (choice) {
                    case 0:
                        arr.initArray();
                        Exit = true;
                        break;
                    case 1:
                        System.out.println("Enter the element to find");
                        long value = sc.nextLong();
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
                        arr.insert(value);
                        Exit = true;
                        break;
                    case 3:
                        System.out.println("Enter the index of the element to be found");
                        index = sc.nextInt();
                        System.out.println("Element at index " + index + " is " + arr.getElem(index));
                        Exit = true;
                        break;
                    case 4:
                        System.out.println("Enter the index of the element to be deleted");
                        index = sc.nextInt();
                        arr.delete(index);
                        Exit = true;
                        break;
                    case 5:
                        arr.display();
                        Exit = true;
                        break;
                    case 6:
                        System.out.println("Enter the value of the element to be deleted");
                        value = sc.nextLong();
                        int count = arr.dupDelete(value);
                        System.out.println("Number of elements deleted are " + count);
                        Exit = true;
                        break;
                    case 7:
                        System.out.println("Enter the index at which the element is to be inserted");
                        index = sc.nextInt();
                        System.out.println("Enter the value of the element to be inserted");
                        value = sc.nextLong();
                        arr.insert(index, value);
                        Exit = true;
                        break;
                    case 8:
                        System.out.println("Enter the index of the element to be deleted");
                        index = sc.nextInt();
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
            }
        }
    }
}

