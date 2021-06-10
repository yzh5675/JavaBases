package com.cs.ssm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cs.ssm.entity.Department;
import com.cs.ssm.entity.Employee;
import com.cs.ssm.service.DepartmentService;
import com.cs.ssm.service.EmployeeService;
import com.github.pagehelper.PageInfo;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value="/emps/{pageNum}", method = RequestMethod.GET)
	public String emps(@PathVariable("pageNum") Integer pageNum, 
			@RequestParam(value="searchName", required=false, defaultValue="") String searchName,
			Map<String, Object> map) {
		
		PageInfo<Employee> pe = employeeService.pageEmployee(searchName, pageNum, 5);
		map.put("emps", pe.getList());
		map.put("pageNum", pe.getPageNum());
		map.put("totalPage", pe.getPages());
		
		return "list";
	}
	
	@RequestMapping(value="/toadd", method = RequestMethod.GET)
	public String toAdd(Model model) {
		List<Department> depts = departmentService.listDepartment();
		model.addAttribute("depts", depts);
		//转发
		return "add";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute Employee employee) {
		
		System.out.println("add : " + employee);
		
		employeeService.addEmployee(employee);
		
		//重定向
		return "redirect:/emps/1";
	}
	
	//跳转到编辑页面
	@RequestMapping(value="/toedit/{empId}/{pageNum}", method = RequestMethod.GET)
	public String toEdit(@PathVariable("empId") Integer empId, 
			@PathVariable("pageNum") Integer pageNum, Model model) {
		List<Department> depts = departmentService.listDepartment();
		Employee emp = employeeService.getEmployeeById(empId);
		model.addAttribute("depts", depts);
		model.addAttribute("emp", emp);
		model.addAttribute("pageNum", pageNum);
		//转发
		return "edit";
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.POST)
	public String updateEmp(Employee employee , 
			@RequestParam("pageNum") Integer pageNum) {
		
		employeeService.updateEmployee(employee);
		
		return "redirect:/emps/" + pageNum;
	}
	
	//删除
	@RequestMapping(value="/delete/{empId}/{pageNum}", method = RequestMethod.GET)
	public String deleteEmp(@PathVariable("empId") Integer empId, 
			@PathVariable("pageNum") Integer pageNum) {

		employeeService.deleteEmployee(empId);

		//转发
		return "redirect:/emps/" + pageNum;
	}

}
