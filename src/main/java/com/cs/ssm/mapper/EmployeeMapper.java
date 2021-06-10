package com.cs.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cs.ssm.entity.Employee;

public interface EmployeeMapper {

	@Select("select * from employee order by emp_id desc")
	public List<Employee> listEmployee();
	
	@Select("select * from employee where emp_name like '%${searchName}%' order by emp_id desc")
	public List<Employee> listEmployeeLikeName(@Param("searchName") String searchName);
	
	@Insert("insert into employee(emp_name, gender, email, salary, job_title,dept_id) "
			+ "values(#{empName},#{gender},#{email},#{salary},#{jobTitle},#{deptId})")
	public void insertEmployee(Employee employee);
	
	@Select("select * from employee where emp_id=#{empId}")
	public Employee getEmployeeById(int empId);
	
	@Update("update employee set emp_name=#{empName},gender=#{gender},email=#{email},"
			+ "salary=#{salary},job_title=#{jobTitle},dept_id=#{deptId} where emp_id=#{empId}")
	public void updateEmployee(Employee employee);
	
	@Delete("delete from employee where emp_id=#{empId}")
	public void deleteEmployee(int empId);
}
