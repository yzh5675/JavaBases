package com.cs.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.ssm.entity.Department;
import com.cs.ssm.mapper.DepartmentMapper;
import com.cs.ssm.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	public List<Department> listDepartment() {
		// TODO Auto-generated method stub
		return departmentMapper.listDepartment();
	}

}
