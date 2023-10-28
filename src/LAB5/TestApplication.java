package LAB5;

import java.util.Iterator;
import java.util.Scanner;

class TestApplication {

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedPositionalList<String> PositionList = new LinkedPositionalList<>();
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
                    + "\n10. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                
                case 1:
                    if (PositionList.isEmpty()) {
                        System.out.println("Positional list is empty");
                    } else {
                        System.out.println("First element is: " + PositionList.first().getElement());
                    }
                    break;
                case 2:
                    if (PositionList.isEmpty()) {
                        System.out.println("Positional list is empty");
                    } else {
                        System.out.println("Last element is: " + PositionList.last().getElement());
                    }
                    break;
                case 3:
                    // enters an element at the front of the list returning the position of the new element
                    System.out.println("Enter the element you want to add First: ");
                    String temp = sc.nextLine();
                    PositionList.addFirst(temp);
                    // display(PositionList);
                    break;
                
                case 4:
                    
                    System.out.println("Enter the element you want to add Last: ");
                    temp = sc.nextLine();
                    PositionList.addLast(temp);

                    break;
                case 5:
                    System.out.println("Enter the element you want to add: ");
                    String element = sc.next();
                    System.out.println("Enter the position before which you want to add : ");
                    int position = sc.nextInt();
                    if(position<1 || position>PositionList.size()) {
                        System.out.println("Invalid position");
                        break;
                    }
                    else{
                        Position<String> p = PositionList.first();
                        for (int i = 1; i < position; i++) {
                            p = PositionList.after(p);
                        }
                        PositionList.addBefore(p, element);
                        break;
                    }
                case 6:
                    System.out.println("Enter the element you want to add: ");
                    element = sc.next();
                    System.out.println("Enter the position after which you want to add : ");
                    position = sc.nextInt();
                    if(position<1 || position>PositionList.size()) {
                        System.out.println("Invalid position");
                        break;
                    }
                    if(position<1 || position>PositionList.size()) {
                        System.out.println("Invalid position");
                        break;
                    }
                    else{
                        Position<String> p = PositionList.first();
                        for (int i = 1; i < position; i++) {
                            p = PositionList.after(p);
                        }
                        PositionList.addAfter(p, element);
                    }
                    break;
                case 7:
                    System.out.println("Enter the position: ");
                    int pos = sc.nextInt();
                    if(pos<1 || pos>PositionList.size()) {
                        System.out.println("Invalid position");
                        break;
                    }
                    System.out.println("Enter the element you want to add: ");
                    element = sc.next();
                    Position<String> p = PositionList.first();
                    for (int i = 1; i < pos; i++) {
                        p = PositionList.after(p);
                    }
                    PositionList.addBefore(p, element);
                    break;
                case 8:
                    System.out.println("Enter the position: ");
                    pos = sc.nextInt();
                    if(pos<1 || pos>PositionList.size()) {
                        System.out.println("Invalid position");
                        break;
                    }
                    System.out.println("Enter the element you want to add: ");
                    element = sc.next();
                    p = PositionList.first();
                    for (int i = 1; i < pos; i++) {
                        p = PositionList.after(p);
                    }
                    PositionList.addAfter(p, element);
                    break;
                case 9:
                    System.out.println("Enter the position: ");
                    pos = sc.nextInt();
                    if(pos<1 || pos>PositionList.size()) {
                        System.out.println("Invalid position");
                        break;
                    }
                    p = PositionList.first();
                    for (int i = 1; i < pos; i++) {
                        p = PositionList.after(p);
                    }
                    PositionList.remove(p);
                    break;
                case 10:
                    System.out.println("Enter the position: ");
                    pos = sc.nextInt();
                    if(pos<1 || pos>PositionList.size()) {
                        System.out.println("Invalid position");
                        break;
                    }
                    p = PositionList.first();
                    for (int i = 1; i < pos; i++) {
                        p = PositionList.after(p);
                    }
                    System.out.println("Enter the element you want to add: ");
                    element = sc.next();
                    PositionList.set(p, element);
                    break;
                default:
                    System.out.println("Exiting the program ...");
                    System.out.println("Thank you for using the program");
                    break;
            
            }
        } while (choice < 10 && choice > 0);

        
        Iterable<Position<String>> posIterable = PositionList.positions();
        // an iterable can support a for-each loop in Java
        for (Position<String> p : posIterable) {
            System.out.print(p.getElement() + " --> ");
        }
        System.out.println("\n");

        // searching for a node element using iterable
        System.out.println("!----------------------------->");
        System.out.println("Searching the positional list for a node");
        System.out.println("Enter the city you want to search: ");
        Scanner s = new Scanner(System.in);
        String to_search = s.nextLine();
        int pos = 0;
        for (Position<String> p : posIterable) {
            pos++;
            if (p.getElement().equals(to_search)) {
                System.out.println("City " + to_search + " found at position " + pos);
                return;
            }
        }
        System.out.println("City not found");
    }
    public static <T> void display(LinkedPositionalList<T> posList) {
        if (posList.isEmpty()) {
            System.out.println("Positional list is empty" + "\n");
        } else {
            System.out.println("Elements of the positional list are: ");

            Iterator<T> i = posList.iterator();
            while (i.hasNext()) {
                System.out.print(i.next() + " --> ");
            }
            System.out.println("\nSize of the positional list is: " + posList.size());
            System.out.println("First node is :" + posList.first().getElement());
            System.out.println("Last node is :" + posList.last().getElement() + "\n");
        }
    }
}
