package LAB_PROGRAMS;
// inheritance in java

class Faculty extends Human {
    // Additional attributes specific to Faculty
    private int EmpID;
    private double Salary;
    private String specialization;

    // Constructor to initialize Faculty attributes
    public Faculty(int age, String name, String gender, int empid, double sal, String sp) {
        super(age, name, gender); // Call the superclass constructor
        this.EmpID = empid;
        this.specialization = sp;
        this.Salary = sal;
    }
    //setter fn for EmpID
    public void setEmpID(int EmpID) {
        this.EmpID = EmpID;
    }
    //setter fn for Salary
    public void setSalary(double Salary) {
        this.Salary = Salary;
    }
    //setter fn for specialization
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // Method to update Faculty information
    public void update(int age, String name, String gender, int empid, double sal, String sp) {
        super.update(age, name, gender); // Call the superclass method
        this.EmpID = empid;
        this.specialization = sp;
        this.Salary = sal;
    }

    // Method to display Faculty information
    public String getinfo() {
        return("The age of the Faculty is: " + getAge() + "\n" +
        "The Employee Id of the Faculty is: " + EmpID + "\n" +
        "The Salary of the Faculty is: " + Salary + "\n" +
        "The Specialization of the Faculty is: " + specialization + "\n");
    }
}