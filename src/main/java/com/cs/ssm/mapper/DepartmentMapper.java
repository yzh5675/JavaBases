package com.cs.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.cs.ssm.entity.Department;

public interface DepartmentMapper {
	
	@Select("select * from department")
	public List<Department> listDepartment();

}
