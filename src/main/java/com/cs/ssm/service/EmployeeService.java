package com.cs.ssm.service;

import com.cs.ssm.entity.Employee;
import com.github.pagehelper.PageInfo;

public interface EmployeeService {
	
	public PageInfo<Employee> pageEmployee(String searchName, int pageNum, int pageSize);
	
	public void addEmployee(Employee employee);
	
	public Employee getEmployeeById(int empId);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(int empId);

}
