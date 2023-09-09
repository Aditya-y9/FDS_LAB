import LAB_PROGRAMS.LAB1.Faculty;
import LAB_PROGRAMS.LAB1.Human;
import LAB_PROGRAMS.LAB1.Student;

class Human {
    private String name;
    private int age;
    private String gender;

    public Human(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void update(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }
}

class Student extends Human {
    private int rollno;
    private String Class_Student;
    private int semester;
    private double CPI;

    public Student(int age, String name, String gender, int rollno, String Class_Student, int semester, double CPI) {
        super(age, name, gender);
        this.rollno = rollno;
        this.Class_Student = Class_Student;
        this.semester = semester;
        this.CPI = CPI;
    }

    public void update(int age, String name, String gender, int rollno, String Class_Student, int semester, double CPI) {
        super.update(age, name, gender);
        this.rollno = rollno;
        this.Class_Student = Class_Student;
        this.semester = semester;
        this.CPI = CPI;

    }

    public void getinfo() {
        System.out.println("The age of the Student is: " + getAge());
        System.out.println("The rollno of the Student is: " + rollno);
        System.out.println("The class of the Student is: " + Class_Student);
        System.out.println("The Semester of the Student is: " + semester);
        System.out.println("The CPI of the Student is: " + CPI);
    }
}

class Faculty extends Human {
    private int EmpID;
    private double Salary;
    private String specialization;

    public Faculty(int age, String name, String gender, int empid, double sal, String sp) {
        super(age, name, gender);
        this.EmpID = empid;
        this.specialization = sp;
        this.Salary = sal;
    }

    public void update(int age, String name, String gender, int empid, double sal, String sp) {
        super.update(age, name, gender);
        this.EmpID = empid;
        this.specialization = sp;
        this.Salary = sal;
    }

    public void getinfo() {
        System.out.println("The age of the Faculty is: " + getAge());
        System.out.println("The Employee Id of the Faculty is: " + EmpID);
        System.out.println("The Salary of the Faculty is: " + Salary);
        System.out.println("The Specialization of the Faculty is: " + specialization);
    }
}

class Main {
    public static void main(String[] args) {
        Student S1 = new Student(19, "Aditya Yedurkar", "Male", 221080076, "C", 3, 9.2);
        Faculty f1 = new Faculty(45, "Sagar Rawool Sir", "Male", 22108045, 500000, "Linear Algebra");

        S1.getinfo();
        f1.getinfo();

        // Update Student and Faculty information
        S1.update(20, "Sudarshan", "Male", 221080077, "D", 4, 9.5);
        f1.update(48, "Borase Sir", "Male", 221080, 900000, "English");

        S1.getinfo();
        f1.getinfo();
    }
}

