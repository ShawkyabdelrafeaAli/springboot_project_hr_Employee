package com.global_hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global_hr.entity.Department;
import com.global_hr.entity.Employee;
import com.global_hr.services.DepartmentService;
import com.global_hr.services.EmployeeService;

@RestController
@RequestMapping("/department")
public class DepartmentController {


	@Autowired
	private DepartmentService  departmentService;
	
	@GetMapping("/{id}")
	public Department findById(@PathVariable Long id) {
		return departmentService.findByID(id);
	}
	
	@PostMapping("/insert")
    public  Department insert(@RequestBody Department dep) {
		 
		 return departmentService.insert(dep);
	 }
	@PutMapping("/")
	 public Department update(@RequestBody Department dep) {
		 
		  return departmentService.update( dep);
		 
	 }
	
	@GetMapping("/getAllDepartment")
	public List<Department> findAllDepartment(){
		
		return departmentService.findAllDepartments();
	}
}
