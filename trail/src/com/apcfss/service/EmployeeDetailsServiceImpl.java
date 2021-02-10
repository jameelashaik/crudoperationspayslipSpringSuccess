package com.apcfss.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apcfss.dao.EmployeeDetailsDao;
import com.apcfss.model.EmployeeDetails;
@Service("employeeservice")
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService
{
	@Autowired
	EmployeeDetailsDao employeedao;
	
 public boolean createEmployee(EmployeeDetails emp) {
	
	 
	 
	 
	return employeedao.createEmployee(emp);
}

 public List<EmployeeDetails> getEmployees(){
		return employeedao.getEmployees();
		
	}
 public int delete(int id) {
		// TODO Auto-generated method stub
		return employeedao.delete(id);
	}
 public EmployeeDetails getEmpById(int id) {
		// TODO Auto-generated method stub
		return employeedao.getEmpById(id);
	}
 public boolean edit(EmployeeDetails emp,HttpServletRequest req) {
		System.out.println("iam excuted");
		
		return employeedao.edit(emp,req) ;
	}

public int attendence(EmployeeDetails emp) {
	return employeedao.attendence(emp);

	
}

public int savedayspresent(EmployeeDetails emp) {
	return employeedao.savedayspresent(emp);
}

public List<EmployeeDetails> getEmployees1() {
	return employeedao.getEmployees1();
}

public List<EmployeeDetails> getEmployeespayslip(int id) {
	// TODO Auto-generated method stub
	return employeedao.getEmployeespayslip(id);
}

public EmployeeDetails getSalaryById(int id) {
	// TODO Auto-generated method stub
	return employeedao.getSalaryById(id);
}


}
