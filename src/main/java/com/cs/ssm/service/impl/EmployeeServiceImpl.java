package com.cs.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.ssm.entity.Employee;
import com.cs.ssm.mapper.EmployeeMapper;
import com.cs.ssm.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public PageInfo<Employee> pageEmployee(String searchName, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		if(searchName != null) {
			return PageHelper.startPage(pageNum, pageSize)
					.doSelectPageInfo(()->employeeMapper.listEmployeeLikeName(searchName));
		}else {
			return PageHelper.startPage(pageNum, pageSize)
					.doSelectPageInfo(()->employeeMapper.listEmployee());
		}
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.insertEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return employeeMapper.getEmployeeById(empId);
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		employeeMapper.deleteEmployee(empId);
	}

}
