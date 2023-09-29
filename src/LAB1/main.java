// Name: Aditya Yedurkar

public class main {
    public static void main(String[] args) {
        // Create a Student and a Faculty instance with initial information
        Student S1 = new Student(19, "Aditya Yedurkar", "Male", 221080076, "C", 3, 9.2);
        Faculty f1 = new Faculty(45, "Mahesh Shirole Sir", "Male", 22108045, 100000, "Software");

        // Display initial information for Student and Faculty
        System.out.println(S1.getinfo());
        System.out.println(f1.getinfo());

        // Update Student and Faculty information using setter methods
        S1.setAge(20);
        S1.setName("Sudarshan");
        S1.setGender("Male");
        S1.setCPI(9.5);
        S1.setClass_Student("IT");
        S1.setRollno(221080076);
        S1.setSemester(4);

        
        f1.setAge(46);
        f1.setName("Udmale Sir");
        f1.setGender("Male");
        f1.setEmpID(22108045);
        f1.setSalary(95000);
        f1.setSpecialization("AI/ML");

        // Display updated information for Student and Faculty
        System.out.println(S1.getinfo());
        System.out.println(f1.getinfo());
    }
}
