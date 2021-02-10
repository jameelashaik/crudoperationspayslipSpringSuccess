package com.apcfss.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.apcfss.model.EmployeeDetails;

public interface EmployeeDetailsDao {
	
	public boolean createEmployee(EmployeeDetails emp);
	public List<EmployeeDetails> getEmployees();
	public int delete(int id);
	 public EmployeeDetails getEmpById(int id);
	 public boolean edit(EmployeeDetails emp,HttpServletRequest request);
	public int attendence(EmployeeDetails emp);
	public int savedayspresent(EmployeeDetails emp);
	public List<EmployeeDetails> getEmployees1();
	public List<EmployeeDetails> getEmployeespayslip(int id);
	public EmployeeDetails getSalaryById(int id);
}
