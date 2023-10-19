import java.util.Random;

/**
 * This class extends MyLongArray and provides additional operations such as sorting algorithms and array initialization.
 * The class includes bubble sort, selection sort, and insertion sort algorithms to sort the array in ascending order.
 * The initArray method initializes the array with random long values.
 * The class assumes that the array is not empty and not null.
 */
public class NewMyLongArray extends MyLongArray {
    public NewMyLongArray(int size) {
        super(size);
    }

    /**
     * Sorts the array using the bubble sort algorithm
     * The array is sorted in ascending order
     * The array must not be empty
     * The array must not be null
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
