package Assign_03_03_program_EmployeeManagementSystem;

public class Employee {
	private String name;
	private String gender;
	private String department;
	private double salary;
	private int years_of_experience;
	public Employee(String name, String gender, String department, double salary, int years_of_experience) {
		super();
		this.name = name;
		this.gender = gender;
		this.department = department;
		this.salary = salary;
		this.years_of_experience = years_of_experience;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getYears_of_experience() {
		return years_of_experience;
	}
	public void setYears_of_experience(int years_of_experience) {
		this.years_of_experience = years_of_experience;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", gender=" + gender + ", department=" + department + ", salary=" + salary
				+ ", years_of_experience=" + years_of_experience + "]";
	}
	
}
