package Ques2;

/**
 * @author Vinod This class implements the constructor and getters, setters
 *         Methods for keeping information of an employee
 */
public class Employee {
	private int empId;
	private int salary;
	private int age;
	private String name;

	public Employee(int empId, String name, int salary, int age) {
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	public int getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public int getAge() {
		return age;
	}

}
