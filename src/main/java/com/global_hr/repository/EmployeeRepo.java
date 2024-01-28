package com.global_hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global_hr.HRStatisticProjection;
import com.global_hr.entity.Employee;

@Repository
public interface EmployeeRepo  extends JpaRepository<Employee, Long>{
	
	List<Employee> findBySalary(Double salary , String name);
//	List<Employee> findByDepartment(Long deptId);
	
//	
//	List<Employee> findNameContainingAndDepartmentNameContaining(String empName , String deptName);
//	
//	
	// this is the JPQL
	@Query(value = "select emp from Employee emp where emp.name like :empName")
	List<Employee> filter (@Param("empName") String name);
	
	
	// this is the sql native
	@Query(value = "select * from hr_employees emp where emp.emp_name like :empName" ,nativeQuery = true)
	List<Employee>filterNative (@Param("empName") String name);
	
 
	
	List<Employee> findByDepartmentId(Long deptId);
//	
	@Query(value = "select emp from Employee emp join emp.department dept  where dept.id = :deptId")
	List<Employee> findByDepartment(Long deptId);
	
	@Query(value = "select (select count(*) from hr_department) deptCount,"
			+ "(select count(*) from hr_employees) empCount,"
			+ "(select count(*) from sec_users) userCount"
			, nativeQuery = true)
	HRStatisticProjection getHRStatistic ();
	
}






