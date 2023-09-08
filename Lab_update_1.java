class Human {
    // Attributes of a Human
    private String name;
    private int age;
    private String gender;

    // Constructor to initialize Human attributes (will call by super keyword)
    public Human(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    // Getter fn for age
    public int getAge() {
        return age;
    }

    // Method to update Human information
    public void update(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }
}

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

    // Method to update Student information
    public void update(int age, String name, String gender, int rollno, String Class_Student, int semester, double CPI) {
        super.update(age, name, gender); // Call the superclass method keyword super to prevent overriding
        this.rollno = rollno;
        this.Class_Student = Class_Student;
        this.semester = semester;
        this.CPI = CPI;
    }

    // Method to display Student information
    public void getinfo() {
        System.out.println("The age of the Student is: " + getAge());
        System.out.println("The rollno of the Student is: " + rollno);
        System.out.println("The class of the Student is: " + Class_Student);
        System.out.println("The Semester of the Student is: " + semester);
        System.out.println("The CPI of the Student is: " + CPI);
    }
}

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

    // Method to update Faculty information
    public void update(int age, String name, String gender, int empid, double sal, String sp) {
        super.update(age, name, gender); // Call the superclass method
        this.EmpID = empid;
        this.specialization = sp;
        this.Salary = sal;
    }

    // Method to display Faculty information
    public void getinfo() {
        System.out.println("The age of the Faculty is: " + getAge());
        System.out.println("The Employee Id of the Faculty is: " + EmpID);
        System.out.println("The Salary of the Faculty is: " + Salary);
        System.out.println("The Specialization of the Faculty is: " + specialization);
    }
}

class Main {
    public static void main(String[] args) {
        // Create a Student and a Faculty instance with initial information
        Student S1 = new Student(19, "Aditya Yedurkar", "Male", 221080076, "C", 3, 9.2);
        Faculty f1 = new Faculty(45, "Mahesh Shirole Sir", "Male", 22108045, 100000, "Software");

        // Display initial information for Student and Faculty
        S1.getinfo();
        f1.getinfo();

        // Update Student and Faculty information
        S1.update(20, "Sudarshan", "Male", 221080077, "D", 4, 9.5);
        f1.update(48, "Borase Sir", "Male", 221080, 900000, "English");

        // Display updated information for Student and Faculty
        S1.getinfo();
        f1.getinfo();
    }
}

