package Question3;




/**
 * It is a class having attributes of an employee
 * @author Vinod
 *
 */
public class Employee {
	private String empName;
	private int age;
	private int salary;
	
	/**
	 * It is a constructor to initialize employee attributes.
	 * @param empName name of employee
	 * @param age age of employee
	 * @param salary salary of employee.
	 */
	public Employee(String empName, int age, int salary) {
		this.empName = empName;
		this.age = age;
		this.salary = salary;
	}

	/**
	 * getter method for salary
	 * @return salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * getter method for age
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * setter method for employee name
	 * @return empName
	 */
	public String getEmpName() {
		return empName;
	}

}