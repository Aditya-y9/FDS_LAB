package LAB9;

import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Implementing hashmaps using separate chaining:");

        // enter size
        System.out.print("Enter number of Employees: ");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        // create hashmap
        ChainHashMap<Integer, Employee> Employees = new ChainHashMap<>(n);

        // take Employee inputs
        for (int i = 0; i < n; ++i) {
            System.out.println("Enter Employee reg no, name, address and grade: ");
            int reg = s.nextInt();
            String name = s.next();
            String add = s.next();
            char grade = s.next().charAt(0);
            Employees.put(reg, new Employee(reg, name, add, grade));
        }

        // display Employees using Iterable
        Iterable<Entry<Integer, Employee>> t = Employees.entrySet();
        for (Entry<Integer, Employee> Employee : t) {
            Employee.getValue().display();
        }

        // remove a Employee by registration number
        System.out.print("Enter reg number of the Employee to remove: ");
        int to_remove = s.nextInt();
        Employee removed = Employees.remove(to_remove);
        if (removed != null) {
            removed.display();
        } else {
            System.out.println("Reg number entered was not found");
        }

        System.out.println("\nImplementing hashmaps using linear probing:");

        // enter size
        System.out.print("Enter number of Employees: ");
        int n1 = s.nextInt();

        // create hashmap
        ProbeHashMap<Integer, Employee> EmployeesProbeHashMap = new ProbeHashMap<>(n1);

        // take Employee inputs
        for (int i = 0; i < n1; ++i) {
            System.out.println("Enter Employee reg no, name, address and grade: ");
            int reg = s.nextInt();
            String name = s.next();
            String add = s.next();
            char grade = s.next().charAt(0);
            EmployeesProbeHashMap.put(reg, new Employee(reg, name, add, grade));
        }

        // display Employees using Iterator
        Iterator<Entry<Integer, Employee>> l = EmployeesProbeHashMap.entrySet().iterator();
        while (l.hasNext()) {
            l.next().getValue().display();
        }

        // search for a Employee
        System.out.print("Enter reg number of the Employee to search: ");
        int to_search1 = s.nextInt();
        EmployeesProbeHashMap.get(to_search1).display();
    }
}
