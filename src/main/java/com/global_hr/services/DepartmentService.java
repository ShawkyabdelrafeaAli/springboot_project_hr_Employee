package com.global_hr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global_hr.entity.Department;
import com.global_hr.entity.Employee;
import com.global_hr.repository.DepartmentRepo;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;
	 
	 public Department findByID (Long id) {
		 return departmentRepo.findById(id).orElseThrow();
	 }
	 
 public  Department insert(Department dep) {
		 
		 return departmentRepo.save(dep);
	 }
	 public Department update(Department dep) {
		 
		 Department current = departmentRepo.findById(dep.getId()).get();
		 
		 current.setName(dep.getName());
		 
		 return departmentRepo.save(current );
	 }
	 
	 public List<Department> findAllDepartments(){
		   return 	 departmentRepo.findAll();
		}
		
}
