package com.metacube.parkingSystem.service;

import java.util.List;

import com.metacube.parkingSystem.model.Employee;
import com.metacube.parkingSystem.model.EmployeeDetails;
import com.metacube.parkingSystem.model.Pass;
import com.metacube.parkingSystem.model.PassType;
import com.metacube.parkingSystem.model.Vehicle;

/*
 * Interface of service class.
 */
public interface IEmployeeSevice {

	public boolean addEmployee(Employee emp, short organizationId);
	public short getOrganizationId(String organizationName);
	public int getEmpolyeeId();
	public boolean addVehicle(Vehicle vehicle);
	public PassType getPrice(String vehicleType);
	public boolean addVehiclePass(Pass pass, int empId);
	public String auth(String email);
	public EmployeeDetails getEmployeeDetails(String emailId);
	public boolean updateEmployeeDetails(EmployeeDetails empDetails, Short OrganizationId);
	public List<Employee> getFriendList(short OrganizationId, String email);
	public short getOrganizationIdByEmail(String email);
}
