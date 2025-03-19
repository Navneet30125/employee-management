package Assign_03_03_program_EmployeeManagementSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmployeeManagement {
private static List<Employee> employees = new ArrayList<>();
	
//Add operation
@SuppressWarnings("unused")
private static void addEmployee(Scanner sc) {
	try {
        System.out.println("Enter name:");
        String name = sc.nextLine();

        System.out.println("Enter gender:");
        String gender = sc.nextLine();

        System.out.println("Enter department:");
        String department = sc.nextLine();

        System.out.println("Enter salary:");
        double salary = Double.parseDouble(sc.nextLine());

        System.out.println("Enter years of experience:");
        int yearsOfExperience = Integer.parseInt(sc.nextLine());

        if (yearsOfExperience < 0) {
            throw new IllegalArgumentException("Years of experience cannot be negative.");
        }

        employees.add(new Employee(name, gender, department, salary, yearsOfExperience));
        System.out.println("Employee added successfully.");
    } catch (NumberFormatException e) {
        System.out.println("Error: Salary and years of experience must be numeric values.");
    } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
    }
}
    //update operation
	@SuppressWarnings("unused")
	private static void updateEmployee(Scanner sc) {
		try {
            System.out.println("Enter index of employee to update:");
            int index = Integer.parseInt(sc.nextLine());

            if (index < 0 || index >= employees.size()) {
                throw new IndexOutOfBoundsException("Employee not found.");
            }

            Employee employee = employees.get(index);

            System.out.println("Enter new name:");
            employee.setName(sc.nextLine());

            System.out.println("Enter new gender:");
            employee.setGender(sc.nextLine());

            System.out.println("Enter new department:");
            employee.setDepartment(sc.nextLine());

            System.out.println("Enter new salary:");
            employee.setSalary(Double.parseDouble(sc.nextLine()));

            System.out.println("Enter new years of experience:");
            employee.setYears_of_experience(Integer.parseInt(sc.nextLine()));
            System.out.println("Employeen updated successfully..");
		}
		catch(NumberFormatException e) {
			System.out.println("Error: Salary and years of experience must be numeric values.");
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	//remove operation
	@SuppressWarnings("unused")
	private static void removeEmployee(Scanner sc){
		System.out.println("Enter index of employee to remove:");
		int index = Integer.parseInt(sc.nextLine());
		if(index<0 || index>=employees.size()) {
			throw new IndexOutOfBoundsException("Employee not found.");
		}
		Employee employee = employees.get(index);
		employees.remove(index);
		
	}
	@SuppressWarnings("unused")
	private static void listAllEmployees() {
		employees.forEach(System.out::println);
	}
	@SuppressWarnings("unused")
	private static void sortEmployeesByName() {
		System.out.println("Employee sorted on the basis of Name: ");
		employees.stream()
		.sorted((e1, e2)->e1.getName().compareToIgnoreCase(e2.getName()))
		.collect(Collectors.toList())
		.forEach(System.out::println);
	}
	@SuppressWarnings("unused")
	private static void findHighestSalaryByDepartment() {
		Map<String, Employee> highSalDeptWise = employees.stream()
				.collect(Collectors.groupingBy(
						Employee::getDepartment,
						Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), 
								opt->opt.orElse(null))
						));
		highSalDeptWise.forEach((dept, emp)->
		{
			if(emp!=null) {
				System.out.println("Department: "+dept+" , Employee: "+emp);
			}
		});
		
	}

	@SuppressWarnings("unused")
	private static void categorizeAndIncreaseSalary() {
		Map<String, Map<String, Employee>> categorizedEmployees = employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender,
						Collectors.groupingBy(Employee::getDepartment,
								Collectors.collectingAndThen(
										Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
										opt -> opt.orElse(null)))));
		categorizedEmployees.forEach((gender, deptMap) -> {
			deptMap.forEach((dept, emp) -> {
				if (emp != null) {
					System.out.println("Gender: " + gender + " , Department: " + dept + " ,Employee: " + emp);
				}

			});
		});
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee emp = null;
		while(true) {
		System.out.println("Choose an operation:\r\n"
				+ "1. Add Employee\r\n"
				+ "2. Update Employee\r\n"
				+ "3. Remove Employee\r\n"
				+ "4. List All Employees\r\n"
				+ "5. Sort Employees by Name\r\n"
				+ "6. Find Highest Salary by Department\r\n"
				+ "7. Categorize and Increase Salary\r\n"
				+ "8. Exit");
		
		System.out.println("Enter your choice: ");
		int choice = Integer.parseInt(sc.nextLine());
		switch(choice) {
		
		case 1:
			EmployeeManagement.addEmployee(sc);
			break;
		case 2:
			EmployeeManagement.updateEmployee(sc);
			break;
		case 3:
			EmployeeManagement.removeEmployee(sc);
			break;
		case 4:
			EmployeeManagement.listAllEmployees();
			System.out.println(emp);
			break;
		case 5:
			EmployeeManagement.sortEmployeesByName();
			break;
		case 6:
			EmployeeManagement.findHighestSalaryByDepartment();
			break;
		case 7:
			EmployeeManagement.categorizeAndIncreaseSalary();
			break;
		case 8:
			System.exit(0);
		default:
			System.out.println("Invalid choice");		
		}
	  }
	}
}
