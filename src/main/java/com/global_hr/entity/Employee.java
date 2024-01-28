package com.global_hr.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Table(name="hr_employees")
@Entity
//@NamedQuery(name ="Employee.findBySalary" , query = "select emp from Employee emp where emp.salary >= :salary ")
@NamedQuery(name ="Employee.findBySalary" , query = "select emp from Employee emp where emp.salary >= :salary and name like :name ")
@NamedNativeQuery(name = "Employee.findByDepartment" , query = "select * from hr_employees where department_id = :deptId")
public class Employee {

	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long id;

	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="department_id")
	//@JsonIgnore
	//@JsonManagedReference
	private Department department;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	//@JsonManagedReference
	private User user;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Column(name = "emp_name")
	private String name;
	private Double salary;
}
