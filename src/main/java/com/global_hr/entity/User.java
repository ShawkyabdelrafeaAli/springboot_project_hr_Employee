package com.global_hr.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="sec_users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public Long getId() {
		return id;
	}
	
	@ManyToMany
	@JoinTable(name = "sec_user_roles" ,
	         joinColumns = @JoinColumn(name= "user_id"),
	         inverseJoinColumns = @JoinColumn(name ="role_id") )
	private Set<Role> roles = new  HashSet<>();
	
	public void addRole(Role role) {
		
		roles.add(role);
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Employee getEmployee() {
		return employee;	}
	public void setEmployee(Employee employee) {
	this.employee = employee;
	}
 
	@OneToOne(mappedBy = "user")
	  // @JsonBackReference
	@JsonIgnore
	private Employee employee;
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String userName;
	private String password;
	
}