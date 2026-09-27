import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private List<Employee> employees;

    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>();
    }

    public void createEmployee(int id, String name, String department, double salary) {
        // Check for unique ID
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.println("Employee with ID " + id + " already exists. Creation failed.");
                return;
            }
        }
        Employee newEmployee = new Employee(id, name, department, salary);
        employees.add(newEmployee);
        System.out.println("Employee created successfully.");
    }

    public void searchEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.println("Employee found: " + emp);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public void updateEmployee(int id, String newName, String newDepartment, double newSalary) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.setName(newName);
                emp.setDepartment(newDepartment);
                emp.setSalary(newSalary);
                System.out.println("Employee updated successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found. Update failed.");
    }

    public void listEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees in the system.");
            return;
        }
        System.out.println("--- Employee List ---");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        System.out.println("---------------------");
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Employee Management System");

        while (running) {
            System.out.println("\nOptions:");
            System.out.println("1. Create Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. List Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id;
                    try {
                        id = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Must be an integer.");
                        break;
                    }
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary;
                    try {
                        salary = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Salary. Must be a number.");
                        break;
                    }
                    ems.createEmployee(id, name, department, salary);
                    break;
                case 2:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId;
                    try {
                        searchId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                        break;
                    }
                    ems.searchEmployee(searchId);
                    break;
                case 3:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId;
                    try {
                        updateId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                        break;
                    }
                    System.out.print("Enter New Employee Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Employee Department: ");
                    String newDept = scanner.nextLine();
                    System.out.print("Enter New Employee Salary: ");
                    double newSalary;
                    try {
                        newSalary = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Salary.");
                        break;
                    }
                    ems.updateEmployee(updateId, newName, newDept, newSalary);
                    break;
                case 4:
                    ems.listEmployees();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
        scanner.close();
    }
}
