package com.global_hr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global_hr.HRStatisticProjection;
import com.global_hr.entity.Employee;
import com.global_hr.repository.EmployeeRepo;

@Service
public class EmployeeService {

	 @Autowired
	 private EmployeeRepo employeeRepo;
	 

	 @Autowired
	 private DepartmentService departmentService;
	 
	 public Employee findByID (Long id) {
		 return employeeRepo.findById(id).orElseThrow();
	 }
//	 
//	 public List <Employee>findByEmpAndDept(String empName , String deptName){
//		 return employeeRepo.findNameContainingAndDepartmentNameContaining(empName, deptName);
//	 }
	 
	 public List<Employee> filter (String name){
		 return employeeRepo.filterNative(name);
	 }
	 public  Employee insert(Employee emp) {
		 
		 if(emp.getDepartment()!= null && emp.getDepartment().getId() !=null ) {
			 emp.setDepartment(departmentService.findByID(emp.getDepartment().getId()));
		 }
		 return employeeRepo.save(emp);
	 }
	 public Employee update(Employee emp) {
		 
		 Employee current = employeeRepo.findById(emp.getId()).get();
		 
		 current.setName(emp.getName());
		 current.setSalary(emp.getSalary());
		 current.setDepartment(emp.getDepartment());
		 
		 return employeeRepo.save(current );
	 }
	 
	public List<Employee> findByDepartmentId(Long deptId){
	   return 	 employeeRepo.findByDepartmentId(deptId);
	}
	
	public List<Employee> findAllEmployees(){
		   return 	 employeeRepo.findAll();
		}
		
	public HRStatisticProjection getHRStatistic() {
		
		return employeeRepo.getHRStatistic();
	}
	
 public	List<Employee> findBySalary(Double salary , String name)   {
	 
	  return employeeRepo.findBySalary(salary , name);
 }
	 }





