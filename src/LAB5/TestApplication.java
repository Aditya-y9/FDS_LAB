package LAB5;

import java.util.Iterator;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This class represents a test application for a LinkedPositionalList.
 * It allows the user to perform various operations on the list such as adding, removing, and setting elements.
 * The user is prompted with a menu of options and can choose which operation to perform.
 * The class uses a Scanner object to read user input from the console.
 * The LinkedPositionalList is a generic class that can hold elements of any type.
 * The class provides methods to add elements to the front or back of the list, add elements before or after a given position,
 * remove an element at a given position, set the value of an element at a given position, and display the contents of the list.
 */
class TestApplication {

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedPositionalList<Integer> PositionList = new LinkedPositionalList<>();
        int choice;
        do {display(PositionList);
            System.out.println("1. First element"
                    + "\n2. Last element"
                    + "\n3. Add first"
                    + "\n4. Add last"
                    + "\n5. Add before"
                    + "\n6. Add after"
                    + "\n7. Remove"
                    + "\n8. Set"
                    + "\n9. Display"
                    + "\n10. Search"
                    + "\n11. Exit");
            System.out.println("Enter your choice: ");
            choice = 0;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                sc.next(); // clear the scanner buffer
                continue; // restart the loop
            }
            sc.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("Invalid choice");
                    break;
                case 1:
                    if (PositionList.isEmpty()) {
                        System.out.println("Positional list is empty, First Element does not exist");
                    } else {
                        System.out.println("First element is: " + PositionList.first().getElement());
                    }
                    break;
                case 2:
                    if (PositionList.isEmpty()) {
                        System.out.println("Positional list is empty, Last Element does not exist");
                    } else {
                        System.out.println("Last element is: " + PositionList.last().getElement());
                    }
                    break;
                case 3:
                    // enters an element at the front of the list returning the position of the new element
                    System.out.println("Enter the element you want to add First: ");
                    int temp;
                    try{
                        temp = sc.nextInt();
                    }
                    catch(Exception e){
                        System.out.println("Invalid input. Please enter an integer.");
                        sc.next(); // clear the scanner buffer
                        continue; // restart the loop
                    }
                    PositionList.addFirst(temp);
                    // display(PositionList);
                    break;
                
                case 4:
                    
                    System.out.println("Enter the element you want to add Last: ");
                    try{
                    temp = sc.nextInt();
                    }
                    catch(Exception e){
                        System.out.println("Invalid input. Please enter an integer.");
                        sc.next(); // clear the scanner buffer
                        continue; // restart the loop
                    }
                    PositionList.addLast(temp);

                    break;
                case 5:
                    System.out.println("Enter the element you want to add: ");
                    temp = sc.nextInt();
                    System.out.println("Enter the position before which you want to add : ");
                    int position;
                    try{
                        position = sc.nextInt();
                    }
                    catch(Exception e){
                        System.out.println("Invalid input. Please enter an integer.");
                        sc.next(); // clear the scanner buffer
                        continue; // restart the loop
                    }
                    if(position<1 || position>PositionList.size()) {
                        System.out.println("Invalid position");
                        break;
                    }
                    else{
                        Position<Integer> p = PositionList.first();
                        for (int i = 1; i < position; i++) {
                            p = PositionList.after(p);
                        }
                        PositionList.addBefore(p, temp);
                        break;
                    }
                case 6:
                    System.out.println("Enter the element you want to add: ");
                    temp = sc.nextInt();
                    System.out.println("Enter the position after which you want to add : ");
                    try {
                        position = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter an integer.");
                        sc.next(); // clear the scanner buffer
                        continue; // restart the loop
                    }
                    if(position<1 || position>PositionList.size()) {
                        System.out.println("Invalid position");
                        break;
                    }
                    if(position<1 || position>PositionList.size()) {
                        System.out.println("Invalid position");
                        break;
                    }
                    else{
                        Position<Integer> p = PositionList.first();
                        for (int i = 1; i < position; i++) {
                            p = PositionList.after(p);
                        }
                        PositionList.addAfter(p, temp);
                    }
                    break;
                case 7:
                    System.out.println("Enter the position: ");
                    int pos;
                    try{
                        pos = sc.nextInt();
                    }
                    catch(Exception e){
                        System.out.println("Invalid input. Please enter an integer.");
                        sc.next();
                        continue;
                    }
                    if(pos<1 || pos>PositionList.size()) {
                        System.out.println("Invalid position");
                        break;
                    }
                    Position<Integer> p = PositionList.first();
                    for (int i = 1; i < pos; i++) {
                        p = PositionList.after(p);
                    }
                    PositionList.remove(p);
                    break;
                case 8:
                    System.out.println("Enter the position: ");
                    try{
                    pos = sc.nextInt();
                    }
                    catch(Exception e){
                        System.out.println("Invalid input. Please enter an integer.");
                        sc.next();
                        continue;
                    }
                    if(pos<1 || pos>PositionList.size()) {
                        System.out.println("Invalid position");
                        break;
                    }
                    try{
                    p = PositionList.first();
                    }
                    catch(Exception e){
                        System.out.println("Position list is empty");
                        sc.next();
                        continue;
                    }
                    for (int i = 1; i < pos; i++) {
                        p = PositionList.after(p);
                    }
                    System.out.println("Enter the element you want to add: ");
                    temp = sc.nextInt();
                    PositionList.set(p, temp);
                    break;
                case 9:
                    // display is already implemented
                    break;
                case 10:
                    System.out.println("Enter the Element you want to search: ");
                    String to_search = sc.nextLine();
                    pos = 0;
                    for (Position<Integer> po : PositionList.positions()) {
                        pos++;
                        if (po.getElement().equals(to_search)) {
                            System.out.println("Element " + to_search + " found at position " + pos);
                            break;
                        }
                        if(pos==PositionList.size()){
                            System.out.println("Element " + to_search + " not found");
                        }
                    }
                    break;
                case 11:
                    System.out.println("Exiting... the program, Thank you!");
                    break;
                case 12:
                    System.out.println("Enter a valid choice");
                    break;
            
            }
        } while ((choice < 11 && choice >= 0) || choice == 12);
        
        Iterable<Position<Integer>> posiIter = PositionList.positions();
        for (Position<Integer> p : posiIter) {
            System.out.print(p.getElement() + " --> ");
        }
        System.out.println("\n");

    }
    public static <T> void display(LinkedPositionalList<T> posList) {
        if (posList.isEmpty()) {
            System.out.println("Positional list is empty" + "\n");
        } else {
            System.out.println("Elements of the positional list are: ");

            Iterator<T> i = posList.iterator();
            while (i.hasNext()) {
                System.out.print(" -- "+ i.next());
            }
            System.out.println("\nSize of the positional list is: " + posList.size());
            System.out.println("First node is :" + posList.first().getElement());
            System.out.println("Last node is :" + posList.last().getElement() + "\n");
        }
    }
}