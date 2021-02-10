package com.apcfss.model;

public class EmployeeDetails {

	private int id;
	private int dayspresent;
	private String name;
	private float salary;
	private String designation;
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float f) {
		this.salary = f;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getDayspresent() {
		return dayspresent;
	}
	public void setDayspresent(int dayspresent) {
		this.dayspresent = dayspresent;
	}
	
}
