package com.cs.ssm.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cs.ssm.entity.Employee;
import com.cs.ssm.service.EmployeeService;
import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestSpring {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void test01() {
		PageInfo<Employee> emp = employeeService.pageEmployee(null, 2, 5);
		for (Employee e : emp.getList()) {
			System.out.println(e);
		}
	}

}
