import java.util.Scanner;

class MyLongArray {
    int size;
    int currentIndex = 0;
    long[] arr;
    Scanner sc = new Scanner(System.in);

    MyLongArray(int size) {
        // Storing the size of the array to later traverse the array
        this.size = size;
        arr = new long[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Please Enter the value at index " + i);
            arr[i] = sc.nextLong();
            currentIndex++;
        }
    }
    // to find a given element in the array
    // return the mathcing index
    public int find(long value){
            for(int i=0;i<currentIndex;i++){
                if(arr[i] == value){
                    return i;
                }
            }
            return -1;
        }
    // insert element at the end of the array
    // if the array is full, fn prints "Array is already full"
    public void insert(long value){
        if(currentIndex == size){
            System.out.println("Array is already full");
            return;
        }
        arr[currentIndex] = value;
        currentIndex++;
    }

    // get element on the given index
    public long getElem(int index){
            return arr[index];
        }

    



    // delete function operates by just shifting the elements after the index to the left
    public void delete(int index){
        if (index < 0 || index >= currentIndex){
            System.out.println("Invalid index");
            return;
        }
        for(int i=index;i<currentIndex-1;i++){
            // left shift the elements
            arr[i] = arr[i+1];
        }
        // make the current array size smaller
        currentIndex--;
    }
    // delete function operates by just shifting the elements after the index to the left
        // at index matching the given value from arguments
    public boolean delete(long value){
        for(int i=0;i<currentIndex;i++){
            if(arr[i] == value){
                delete(i);
                return true;
            }
        }
        return false;
    }

    public void display(){
            for(int i=0;i<currentIndex;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

    // dupDelete operates by traversing the complete array and using delete fn over the whole array
    public int dupDelete(long value){
            int count = 0;

            // traverse the whole array
            for(int i=0;i<currentIndex;i++){
                if(arr[i] == value){
                    // delete matching elements
                    delete(i);
                    count++;
                }
            }
            return count;
        }


    public void insert(int index, long value){
            for(int i=currentIndex;i>index;i--){
                arr[i] = arr[i-1];
            }
            arr[index] = value;
            currentIndex++;
    }
    

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

public class main {
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
                    "1:Find an element\n" +
                    "2:Insert an element\n" +
                    "3:Get an element\n" +
                    "4:Delete an element\n" +
                    "5:Display the array\n" +
                    "6:Delete all the elements matching the given value\n" +
                    "7:Insert an element at a given index\n" +
                    "8:Delete an element at a given index\n" +
                    "9:Exit");
            int choice = sc.nextInt();
            while (Exit == false) {
                switch (choice) {
                    case 1:
                        System.out.println("Enter the element to be found");
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
                } else {
                    System.out.println("Enter a valid character");
                }
            }
        }
    }
}
