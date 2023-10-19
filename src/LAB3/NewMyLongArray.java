import java.util.Random;

/**
 * This class extends LongArray and provides additional operations such as sorting algorithms and array initialization.
 * The class includes bubble sort, selection sort, and insertion sort algorithms to sort the array in ascending order.
 * The initializeArray method initializes the array with random long values.
 * The class assumes that the array is not empty and not null.
 */

/**
 * This class extends the LongArray class and provides additional methods for sorting an array of long integers
 * using Bubble Sort, Selection Sort, and Insertion Sort techniques.
 */
public class NewMyLongArray extends MyLongArray {
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
    /**
     * Constructor for creating a new NewLongArray object with a specified size.
     *
     * @param size The size of the array.
     */
    public NewMyLongArray(int size) {
        super(size);
    }

    /**
     * Sorts an array of long integers using the Bubble Sort technique.
     *
     * @param originalArray The original array to be sorted.
     * @param size The size of the array.
     * @return A new array containing the sorted elements.
     */
    public long[] BubbleSort(long[] originalArray, int size) {
        // Create a duplicate array to avoid modifying the original array
        long[] arr = duplicateArray(originalArray, size);

        // Perform Bubble Sort
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    /**
     * Sorts an array of long integers using the Selection Sort technique.
     *
     * @param originalArray The original array to be sorted.
     * @param size The size of the array.
     * @return A new array containing the sorted elements.
     */
    public long[] SelectionSort(long[] originalArray, int size) {
        // Create a duplicate array to avoid modifying the original array
        long[] arr = duplicateArray(originalArray, size);

        // Perform Selection Sort
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }
        return arr;
    }

    /**
     * Sorts an array of long integers using the Insertion Sort technique.
     *
     * @param originalArray The original array to be sorted.
     * @param size The size of the array.
     * @return A new array containing the sorted elements.
     */
    public long[] InsertionSort(long[] originalArray, int size) {
        // Create a duplicate array to avoid modifying the original array
        long[] arr = duplicateArray(originalArray, size);

        // Perform Insertion Sort
        for (int i = 1; i < size; i++) {
            long key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    /**
     * Private helper method for swapping elements within an array.
     *
     * @param arr The array in which elements are to be swapped.
     * @param i   The index of the first element to be swapped.
     * @param j   The index of the second element to be swapped.
     */
    private void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Private method to create a copy of an array.
     *
     * @param arr  The original array to be duplicated.
     * @param size The size of the array.
     * @return A new array that is a copy of the original array.
     */
    private long[] duplicateArray(long[] arr, int size) {
        long[] temp = new long[size];
        System.arraycopy(arr, 0, temp, 0, size);
        return temp;
    }


    

}
