

public class MyLongArray {
  private long[] array;
  private int currentIndex;
  private int size;

  public MyLongArray(int size) {
    this.size = size;
    array = new long[size];
    currentIndex = 0;
  }
  
  public int find(long searchKey) {
    for (int i = 0; i < currentIndex; i++) {
      if (array[i] == searchKey) {
        return i;
      }
    }
    return -1;
  }

  public void insert(long value) {
    if (currentIndex < array.length) {
      array[currentIndex] = value;
      currentIndex++;
    } else {
      System.out.println("Array is full so cannot insert");
    }
  }

  //  creating get element function
  public long getElem(int index) {
    if (index >= 0 && index < currentIndex) {
      return array[index];
    } else {
      return -1;
    }
  }
 
  //  creating a delete function (delete given element)
  public boolean delete(long value) {
    int index = find(value);
    if (index != -1) {
      for (int i = index; i < currentIndex - 1; i++) {
        array[i] = array[i + 1];
      }
      currentIndex--;
      return true;
    }
    return false;
  }
  
  // creating a delete function (delete given index element)
  public void deleteAtIndex(int index) {
    if (index >= 0 && index < currentIndex) {
      for (int i = index; i < currentIndex - 1; i++) {
        array[i] = array[i + 1];
      }
      currentIndex--;
    } else {
      System.out.println("Invalid index");
    }
  }
 
  // creating a insert function (inserting an element at given index)
  public void insert(int index, long value) {
    if (currentIndex < array.length && index >= 0 && index <= currentIndex) {
      for (int i = currentIndex; i > index; i--) {
        array[i] = array[i - 1];
      }
      array[index] = value;
      currentIndex++;
    } else {
      System.out.println("Invalid index or array is full so cannot insert");
    }
  }
    
  // printing the array
  public void display() {
    for (int i = 0; i < currentIndex; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }
  
  
  public void initArray() {
        Random rd = new Random();
        for(int i = 0; i < array.length; i++) {
         array[i] = rd.nextInt(100);
        }
        System.out.print("Random Array Elements : ");
        display();
    }
    
    // sorting the array by using bubble sort algorithm
    public void bubbleSort() {
        long n = array.length;
        long temp;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }
    
    // sorting the array by using insertion sort algorithm
    public void insertionSort() {
        long n = array.length;
        for (int i = 1; i < n; ++i) {
            long key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
    
    // sorting the array by using seletion sort algorithm
    void selectionSort() {
        long n = array.length;
        int index;
        long temp;
        for (int i = 0; i < n - 1; i++) {
            index = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[index])
                    index = j;
            }
            if (index != i) {
                    temp = array[index];
                    array[index] = array[i];
                    array[i] = temp;
            }
        }
    }
}
