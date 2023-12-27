package LAB9;
/**
 * Employee ADT
 * A class that represents a Employee
 * An Employee has an id, name, address and grade
 * 
 */
public class Employee {
    private final int id;
    private final String name;
    private final String address;
    private final char grade;


    // constructor
    Employee(int id, String name, String address, char grade) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.grade = grade;
    }
    // getters
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return address;
    }

    public char getGrade() {
        return grade;
    }

    // display the employee details
    public void display() {
        System.out.println(this.id + ": " + this.name + ", " + this.address + " - " + this.grade);
    }
}
