package com.global_hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global_hr.HRStatisticProjection;
import com.global_hr.entity.Department;
import com.global_hr.entity.Employee;
import com.global_hr.services.EmployeeService;

@RestController 
@RequestMapping("/employee") 
public class EmployeeController {

	@Autowired
	private EmployeeService  employeeService;
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable Long id) {
		
		  return employeeService.findByID(id);
	}
  
	@GetMapping("/filter")
	public List<Employee> findByName(@RequestParam String name)
         {
		return employeeService.filter(name);
		}
	
	
	@PostMapping("/insert")
    public  String insert(@RequestBody Employee emp) {
		 	 employeeService.insert(emp);
		 return " inserted Employee successfully";
	 }
	@PutMapping("/")
	 public Employee update(@RequestBody Employee emp) {
		 
		  return employeeService.update(emp);
		 
	 }
	
	@GetMapping("/department/{deptId}")
      public List<Employee> findByDepartmentId(@PathVariable Long deptId){
		   return 	 employeeService.findByDepartmentId(deptId);
		}
	
	@GetMapping("/getAllEmployees")
      public List<Employee> findAllDepartment(){
		
		return employeeService.findAllEmployees();
	}
	@GetMapping("/salary")
    public	List<Employee> findBySalary(@RequestParam Double salary , @RequestParam String name){
    	
    	return employeeService.findBySalary(salary , name);
    }
	
	@GetMapping("/Statistic")
	public HRStatisticProjection getHRStatistic() {
		
		return employeeService.getHRStatistic();
	}
	
//	 @GetMapping("/emp-dept")
//	 public List <Employee>findByEmpAndDept( @RequestParam String empName ,@RequestParam String deptName){
//		 return employeeService.findByEmpAndDept(empName, deptName);
//	 }
}
