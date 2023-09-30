import java.util.Scanner;
import java.util.Random;

/**

 * <html>
 * <head>
 * <title>MyLongArray Class</title>
 * </head>
 * <body>
 * <h1>MyLongArray Class - Array Operations</h1>
 * <p>
 * This program allows users to perform various operations on a long array, including initialization,
 * insertion, deletion, searching, sorting, and more. Users can interactively choose from a menu of
 * operations and customize the array as needed
 * It provides a versatile tool for managing and
 * manipulating long arrays.
 * Additionally, the program utilizes random number generation to populate the array with random long values,
 * enhancing its flexibility and usefulness for experimentation and testing
 * 
 * This class manages an array of long values and provides various operations.
 *
 * Data members:
 * - a[]: long -- An array of type long, storing elements within the class
 * - currentIndex: int -- Keeps track of the index of the last element in the array
 *
 * Member functions:
 * - MyLongArray(int size): void -- Initializes the class with an internal array of the specified size
 * - find(long searchKey) : int -- Searches for a specified 'searchKey' in the array and returns its index if found
 * - insert(long value): void -- Inserts 'value' into the array at the current index and increments the index
 * - getElement(int index): long -- Retrieves the element at the specified 'index' if it's within bounds; otherwise, returns -1
 * - delete(long value): boolean -- Removes the first occurrence of 'value' from the array, shifts elements, decrements currentIndex, and returns true if successful, false if 'value' is not found
 * - display():void -- Displays all elements of the array
 * - dupDelete(long value): int -- Deletes all instances of 'value' from the array and returns the count of deleted elements
 * - insert(int index, long value): void -- Inserts 'value' at the specified 'index' if 'index' <= currentIndex; otherwise, inserts at currentIndex and increments it, displaying a warning message
 * - deleteAt(int index): long -- Deletes the element at the specified 'index' if it's within bounds; otherwise, returns -1
 * - bubbleSort(): void -- Sorts the array using the bubble sort algorithm
 * - selectionSort(): void -- Sorts the array using the selection sort algorithm
 * - insertionSort(): void -- Sorts the array using the insertion sort algorithm
 * - initArray(): void -- Initializes the array with random long values
 * 
 * </p>
 * <p>
 * The <code>MyLongArray</code> class represents a LONG array with various operations on it
 * It allows you to perform operations similar to a database on an array of long values
 * This class provides methods for initialization, insertion, deletion, searching, sorting,
 * and more on a long array
 * </p>
 * @author Aditya Yedurkar 221080076
 * @version 1.5
 *
 * <p><strong>Author: Aditya Yedurkar 221080076</strong> Your Name</p>
 * <p><strong>Version:</strong> 1.5</p>
 * </body>
 * </html>
 */

public class MyLongArray {
    int size;
    int currentIndex = 0;
    long[] arr;
    Scanner sc = new Scanner(System.in);

    /**
     * Initializes a new instance of the <code>MyLongArray</code> class with the specified size
     * Constructs an array of long values with the specified size
     * The array is initially empty (contains no elements)
     * The size of the array is fixed upon construction
     *
     * @param size The size of the array
     */
    MyLongArray(int size) {
        try {
            if (size <= 0) {
                throw new IllegalArgumentException("Size must be a positive integer");
            }
            // Storing the size of the array to later traverse the array
            this.size = size;
            arr = new long[size];
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Finds the index of a given element in the array
     * Searches the array for the specified element using the linear search algorithm
     * The array is searched sequentially and the index of the first occurrence of the element is returned
     *
     * @param value The value to find in the array
     * @return The index of the given element if found, or -1 if not found
     */
    public int find(long value) {
        // if array is null
        if(arr == null) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Inserts an element at the end of the array
     * Inserts the specified element at the end of the array
     * The array must not be full
     * The index of the next available position is automatically determined
     * The array size is increased by one
     * @param value The value to insert
     */
    public void insert(long value) {
        try {
            if (currentIndex == size) {
                throw new ArrayIndexOutOfBoundsException("Array is already full");
            }
            arr[currentIndex++] = value;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
    public long getElem(int index) {
        return arr[index];
    }

    /**
     * Gets the element at the given index
     * @param index The index of the element to retrieve
     * @return The element at the specified index
     */
    

    /**
     * Deletes an element at the specified index by shifting elements to the left
     * After deletion, the array size is decreased by one
     * The index of the next available position is automatically deterined
     * The array must not be empty
     * The index must be valid
     *
     * @param index The index of the element to delete
     */
    public void delete(int index) {
        try {
            if (index < 0 || index >= currentIndex) {
                throw new IndexOutOfBoundsException("Invalid index");
            }
            for (int i = index; i < currentIndex - 1; i++) {
                // left shift the elements
                arr[i] = arr[i + 1];
            }
            // make the current array size smaller
            currentIndex--;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Deletes all occurrences of a given value in the array
     *
     * @param value The value to delete
     * @return True if at least one element was deleted, otherwise false
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
     * Displays the elements in the array
     */
    public void display() {
        for (int i = 0; i < currentIndex; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    /**
     * Deletes all occurrences of a given value in the array and returns the count
     * 
     *
     * @param value The value to deleted
     * @return The number of elements deleted
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
     * Inserts an element at the specified index, shifting elements to the right
     * The array must not be full
     * The index must be valid
     * The index of the next available position is automatically determined
     * The array size is increased by one
     * @param index The index at which to insert the element
     * @param value The value to insert
     */
    public void insert(int index, long value) {
        try {
            if (index < 0 || index >= currentIndex) {
                throw new IndexOutOfBoundsException("Enter index from 0 up to " + (currentIndex - 1) + " only");
            }
            if (currentIndex == arr.length) {
                throw new ArrayIndexOutOfBoundsException("Array is already full");
            }
            // right shift the elements

            // increase the size of the array
            currentIndex++;
            for (int i = currentIndex - 1; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            // insert the element
            arr[index] = value;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Deletes an element at the specified index and returns its value
     * The array must not be empty
     * The index must be valid
     *
     * @param index The index of the element to delete
     * @return The deleted element's value, or -1 if the index is invalid
     */
    public long deleteAt(int index) {
        try {
            if (index >= 0 && index < currentIndex) {
                long temp = arr[index];
                delete(index);
                return temp;
            } else {
                throw new IndexOutOfBoundsException("Invalid index");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return -1; // Return a default value or handle it differently
        }
    }

    /**
     * Sorts the array using the bubble sort algorithm
     * The array is sorted in ascending order
     * The array must not be empty
     * The array must not be null
     * 
     */
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

    /**
     * Sorts the array using the selection sort algorithm
     */
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

    /**
     * Sorts the array using the insertion sort algorithm
     */
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

    /**
     * Initializes the array with random long values
     */
    public void initArray() {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextLong();
        }
        // because we have initialized the array
        // up to its whole length
        // then it is maximum filled
        // so max index is the length of the array
        currentIndex = arr.length;
    }
}
