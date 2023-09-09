package LAB_PROGRAMS.LAB2;
import java.util.Scanner;
class MyLongArray{
    int x;
    int currentIndex = 0;
    long[] arr;
    Scanner sc = new Scanner(System.in);
    MyLongArray(int x){
        this.x = x;
        arr = new long[x];
        for(int i=0;i<x;i++){
            System.out.println("Enter the value at index " + i);
            arr[i] = sc.nextLong();
            currentIndex++;
        }
    }
    public void delete(int index){
        for(int i=index;i<currentIndex;i++){
            arr[i] = arr[i+1];
        }
        currentIndex--;
    }
        
    public int dupDelete(long value){
            int count = 0;
            for(int i=0;i<currentIndex;i++){
                if(arr[i] == value){
                    delete(i);
                    count++;
                }
            }
            return count;
        }
        public boolean delete(long value){
            for(int i=0;i<currentIndex;i++){
                if(arr[i] == value){
                    delete(i);
                    return true;
                }
            }
            return false;
        }
        public long deleteAt(int index){
            long temp = arr[index];
            delete(index);
            return temp;
        }
        public void insert(int index, long value){
            for(int i=currentIndex;i>index;i--){
                arr[i] = arr[i-1];
            }
            arr[index] = value;
            currentIndex++;
        }
        public void display(){
            for(int i=0;i<currentIndex;i++){
                System.out.println(arr[i]);
            }
        }
        public long getElem(int index){
            return arr[index];
        }
        public int find(long value){
            for(int i=0;i<currentIndex;i++){
                if(arr[i] == value){
                    return i;
                }
            }
            return -1;
        }
    }






class main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int x = sc.nextInt();
        MyLongArray arr = new MyLongArray(x);
        int a;
        // display a menu to the user
        while(true){
            System.out.println("1. Delete all occurences of a value");
            System.out.println("2. Delete the first occurence of a value");
            System.out.println("3. Delete the value at a given index");
            System.out.println("4. Insert a value at a given index");
            System.out.println("5. Display the array");
            System.out.println("6. Get the value at a given index");
            System.out.println("7. Find the index of a value");
            System.out.println("8. Exit");
            a = sc.nextInt();
            if(a == 1){
                long value = sc.nextLong();
                int count = arr.dupDelete(value);
                System.out.println(count + " occurences deleted");
            }
            else if(a == 2){
                long value = sc.nextLong();
                boolean flag = arr.delete(value);
                if(flag){
                    System.out.println("Value deleted");
                }
                else{
                    System.out.println("Value not found");
                }
            }
            else if(a == 3){
                int index = sc.nextInt();
                long value = arr.deleteAt(index);
                System.out.println(value + " deleted");
            }
            else if(a == 4){
                int index = sc.nextInt();
                long value = sc.nextLong();
                arr.insert(index, value);
                System.out.println(value + " inserted at index " + index);
            }
            else if(a == 5){
                arr.display();
            }
            else if(a == 6){
                int index = sc.nextInt();
                long value = arr.getElem(index);
                System.out.println(value + " at index " + index);
            }
            else if(a == 7){
                long value = sc.nextLong();
                int index = arr.find(value);
                if(index == -1){
                    System.out.println("Value not found");
                }
                else{
                    System.out.println("Value found at index " + index);
                }
            }
            else if(a == 8){
                break;
            }
            else{
                System.out.println("Invalid input");
            }
        }



    }
}