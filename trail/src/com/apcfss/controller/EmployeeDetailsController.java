package com.apcfss.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apcfss.model.EmployeeDetails;
import com.apcfss.model.Worker;
import com.apcfss.service.EmployeeDetailsService;

@Controller
@RequestMapping("/employeedetails")
public class EmployeeDetailsController {
	@Autowired
	EmployeeDetailsService employeeservice;
	
	@RequestMapping(value="/create",method = RequestMethod.GET)
	ModelAndView create(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView modelAndView=new ModelAndView();
		 modelAndView.addObject("employeedetails",new EmployeeDetails());
	
		modelAndView.setViewName("emp");
		 return modelAndView;
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	ModelAndView save(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("employeedetails")EmployeeDetails emp)
	{
		
		System.out.println("Name"+ emp.getName());
		System.out.println("id"+ emp.getId());
		System.out.println("salary"+ emp.getSalary());
		employeeservice.createEmployee(emp);
		return null;
	}
	@RequestMapping(value="/viewemp",method = RequestMethod.GET)
	ModelAndView viewemp(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView modelAndView=new ModelAndView();
		 List<EmployeeDetails> emplist=employeeservice.getEmployees();
		 modelAndView.addObject("emplist",emplist);
		 modelAndView.setViewName("viewemp");
		 return modelAndView;
	}
	@RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)
	ModelAndView deleteemp(HttpServletRequest request, HttpServletResponse response,@PathVariable int id)
	{
		//ModelAndView modelAndView=new ModelAndView();
		int eid = employeeservice.delete(id);
		if(eid>0){
			System.out.println("deleted successfully");
		}else{
			System.out.println("deleted failed");
		}
		return null;
	}
	@RequestMapping(value="/editemp/{id}",method = RequestMethod.GET)
	ModelAndView edit(HttpServletRequest request, HttpServletResponse response,@PathVariable int id)
	{
		System.out.println("Hello ");
		ModelAndView modelAndView=new ModelAndView();
		
		 EmployeeDetails getedit = employeeservice.getEmpById(id);
		 modelAndView.addObject("employeedetails",getedit);
		 System.out.println(getedit.getId());
	request.setAttribute("id", getedit.getId());
		modelAndView.setViewName("editform");
		 return modelAndView;
	}
	@RequestMapping(value="/editsave",method = RequestMethod.POST)
	public String editsave(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("employeedetails")EmployeeDetails emp)
	{
		 
		 System.out.println("----------"+request.getParameter("id"));
		 boolean edit = employeeservice.edit(emp,request);
		 //modelAndView.addObject("edit",edit);
		 System.out.println(edit);
		// return "redirect:/viewemp";  
		//modelAndView.setViewName("editform");
		 //return modelAndView;
		return null;
	}
	@RequestMapping(value="/dayspresent/{id}",method = RequestMethod.GET)
	ModelAndView dayspresent(HttpServletRequest request, HttpServletResponse response,@PathVariable int id)
	{
		ModelAndView modelAndView=new ModelAndView();
		 EmployeeDetails getedit1 = employeeservice.getEmpById(id);
		 List<EmployeeDetails> emplist1=employeeservice.getEmployees();
		 modelAndView.addObject("emplist1",emplist1);
		 modelAndView.addObject("employeedetails",new EmployeeDetails());
		 modelAndView.addObject("employeedetails",getedit1);
		 System.out.println("checing-----------"+getedit1.getId());
		modelAndView.setViewName("dropdown");
		 return modelAndView;
	}
	@RequestMapping(value="/dayspresentsave",method = RequestMethod.POST)
	ModelAndView dayspresentsave(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("employeedetails")EmployeeDetails emp)
	{
		
		 System.out.println("----------"+request.getParameter("id"));
		System.out.println("id"+ emp.getId());

		System.out.println("dayspresent"+ emp.getDayspresent());
		employeeservice.savedayspresent(emp);
		return null;
	}
	@RequestMapping(value="/payslipemp/{id}",method = RequestMethod.GET)
	ModelAndView payslipemp(HttpServletRequest request, HttpServletResponse response,@PathVariable int id)
	{

		ModelAndView modelAndView=new ModelAndView();
		 EmployeeDetails getsalaryp = employeeservice.getSalaryById(id);
		 EmployeeDetails geteditp = employeeservice.getEmpById(id);
		 List<EmployeeDetails> emplistp=employeeservice.getEmployeespayslip(id);
		 modelAndView.addObject("employeedetails",geteditp);
		 modelAndView.addObject("emplistp",emplistp);
		 System.out.println(geteditp.getId());
		modelAndView.setViewName("payslip");
		 return modelAndView;
	}
	@RequestMapping(value="/slip/{id}",method = RequestMethod.GET)
	ModelAndView slip(HttpServletRequest request, HttpServletResponse response,@PathVariable int id)
	{

		ModelAndView modelAndView=new ModelAndView();

		modelAndView.setViewName("payslip");
		 return modelAndView;
	}
}
