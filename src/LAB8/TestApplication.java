package LAB8;
import java.util.Comparator;
import java.util.Date;
import java.util.InputMismatchException;

import java.text.SimpleDateFormat;

import LAB8.Entry;

import LAB8.HeapsImplementation.*;
import java.util.Scanner;



/**
 * TestApplication
 *@author Aditya Yedurkar
 *@version 1.0
 *@since 2023-11-28
 * Test Application for HeapPriorityQueue is a simple application that allows the user to add assignments with deadlines and print them in order of priority
 * It uses the HeapPriorityQueue class to implement the priority queue
 * It uses the DatesComparator class to compare the dates of the assignments
 * It uses the Date class to store the deadlines of the assignments
 * It uses the Entry class to store the assignments and their deadlines
 * It uses the AbstractPriorityQueue class to implement the abstract methods of the priority queue
 */
public class TestApplication{

    

    public static void main(String[] args){
        try{
        Comparator<Date> comp = new DatesComparator();
        HeapPriorityQueue<Date,String> pq = new HeapPriorityQueue<>(comp);
        boolean runnning = true;
        while(runnning){
            int choice;
            System.out.println( "1. Print all Assigments according to Priority\n" +
                                "2. Add Assigment\n" +
                                "3. Print Assigment with Earliest Deadline\n" +
                                "4. Print Assigment with Latest Deadline\n" +
                                "5. Remove Assigment with Earliest Deadline\n" +
                                "6. Print Number of Assigments\n" +
                                "7. Check if Empty\n" +
                                "8. Exit");

            Scanner sc = new Scanner(System.in);

            try{
            choice = sc.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Choice, Please Enter An Integer");
                continue;
            }
            switch(choice){
                case 1:
                    System.out.println("All Assigments in order of Priority are :");
                    try{
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    for(Entry<Date,String> e : pq.entries()){
                        System.out.println(e.getValue() + " " + formatter.format(e.getKey()));
                        System.out.println("<------------------------------>");
                    }
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                try{
                    System.out.print("Enter Assignment Name : ");
                    String assignment = sc.next();
                    System.out.print("Enter Assignment Deadline Date (dd/mm/yyyy) :)");
                    String dates = sc.next();
                    String[] dateArray = dates.split("/");
                    int day = Integer.parseInt(dateArray[0]);
                    int month = Integer.parseInt(dateArray[1]);
                    int year = Integer.parseInt(dateArray[2]);
                    // adjusting the year to the correct format
                    year = year - 1900;
                    Date date = new Date(year,month-1,day);
                    pq.insert(date,assignment);
                    System.out.println("Assigment " + assignment + " added");
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                    break;
                case 3:
                try{
                    System.out.print("Assignment with Earliest Deadline is :");
                    System.out.println(pq.min().getValue());
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                    break;
                case 4:
                try{
                    System.out.print("Earliest Deadline is :");
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println(formatter.format(pq.min().getKey()));
                    
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                    break;
                case 5:
                try{
                    System.out.println("Removing Assigment with Earliest Deadline.....");
                    System.out.println("Assigment " + pq.min().getValue() + " removed" );
                    System.out.println(pq.removeMin().getValue());
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                    break;
                case 6:
                try{
                    System.out.print("Number of Pending Assigments are :");
                    System.out.println(pq.size());
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                    break;
                case 7:
                try{
                    System.out.print("Is the List Empty :");
                    if(pq.isEmpty()){
                        System.out.println("Yes");
                    }
                    else{
                        System.out.println("No");
                    }
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                    break;
                case 8:
                    System.out.println("Exiting....");
                    System.out.println("Thank You for using our Application");
                    runnning = false;
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
    catch(Exception e){
        System.out.println(e.getMessage());
    }
    }
}
