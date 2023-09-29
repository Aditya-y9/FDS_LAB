
import java.util.Scanner;

/** 
 * @author Aditya_Yedurkar_221080076
 * MyLongArray
 * Represents a LONG array with various operations on it
 * like a database
 */
class MyLongArray {
    int size;
    int currentIndex = 0;
    long[] arr;
    Scanner sc = new Scanner(System.in);

    /**
     * Initializes a new instance of the MyLongArray class with the specified size
     *
     * @param size The size of the array
     */
    MyLongArray(int size) {
        // Storing the size of the array to later traverse the array
        this.size = size;
        arr = new long[size];
        
    }
    

    /**
     * Finds the index of a given element in the array.
     *
     * @param value The value to find in the array
     * @return The index of the given element if found, or -1 if not found
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
     * Inserts an element at the end of the array
     *
     * @param value The value to insert
     */
    public void insert(long value) {
        if (currentIndex == size) {
            System.out.println("Array is already full");
            return;
        }
        arr[currentIndex++] = value;
    }

    /**
     * Gets the element at the given index
     *
     * @param index The index of the element to retrieve
     * @return The element at the specified index
     */
    public long getElem(int index) {
        return arr[index];
    }

    /**
     * Deletes an element at the specified index by shifting elements to the left
     *
     * @param index The index of the element to delete
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
     * @param value The value to delete
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
     *
     * @param index The index at which to insert the element
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
     * Deletes an element at the specified index and returns its value
     *
     * @param index The index of the element to delete
     * @return The deleted element's value, or -1 if the index is invalid
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
}

/**
 * Main class to demonstrate the usage of MyLongArray
 */
