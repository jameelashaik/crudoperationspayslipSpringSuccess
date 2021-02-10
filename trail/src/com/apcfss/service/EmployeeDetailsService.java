package com.apcfss.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.apcfss.model.EmployeeDetails;

public interface EmployeeDetailsService {
	
	public boolean createEmployee(EmployeeDetails emp);
	public List<EmployeeDetails> getEmployees();
	public int delete(int id);
	public EmployeeDetails getEmpById(int id);
	public boolean edit(EmployeeDetails emp,HttpServletRequest req);
	public int attendence(EmployeeDetails emp);
	public int savedayspresent(EmployeeDetails emp);
	public List<EmployeeDetails> getEmployees1();
	public List<EmployeeDetails> getEmployeespayslip(int id);
	public EmployeeDetails getSalaryById(int id);
}
