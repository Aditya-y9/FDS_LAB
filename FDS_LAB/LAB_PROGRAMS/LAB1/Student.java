package LAB_PROGRAMS.LAB1;
// inheritance in java

class Student extends Human {
    // Additional attributes specific to Student
    private int rollno;
    private String Class_Student;
    private int semester;
    private double CPI;

    // Constructor to initialize Student attributes
    public Student(int age, String name, String gender, int rollno, String Class_Student, int semester, double CPI) {
        super(age, name, gender); // Call the superclass constructor.
        this.rollno = rollno;
        this.Class_Student = Class_Student;
        this.semester = semester;
        this.CPI = CPI;
    }

    //setter fn for rollno
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
    //setter fn for Class_Student
    public void setClass_Student(String Class_Student) {
        this.Class_Student = Class_Student;
    }
    //setter fn for semester
    public void setSemester(int semester) {
        this.semester = semester;
    }
    //setter fn for CPI
    public void setCPI(double CPI) {
        this.CPI = CPI;
    }


    // Method to update Student information
    public void update(int age, String name, String gender, int rollno, String Class_Student, int semester, double CPI) {
        super.update(age, name, gender); // Call the superclass method keyword super to prevent overriding
        this.rollno = rollno;
        this.Class_Student = Class_Student;
        this.semester = semester;
        this.CPI = CPI;
    }

    // Method to display Student information using string object
    public String getinfo() {
        return ("The age of the Student is: " + getAge()+"\n"+
        "The rollno of the Student is: " + rollno+"\n"+
        "The class of the Student is: " + Class_Student+"\n"+
        "The Semester of the Student is: " + semester+"\n"+
        "The CPI of the Student is: " + CPI+"\n");
    }
}