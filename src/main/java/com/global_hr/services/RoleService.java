package com.global_hr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global_hr.entity.Role;
import com.global_hr.entity.User;
import com.global_hr.repository.RoleRepo;
import com.global_hr.repository.UserRepo;

@Service
public class RoleService {



	 @Autowired
	 private RoleRepo  roleRepo;
	 
	 public Role findByID (Long id) {
		 return roleRepo.findById(id).orElseThrow();
	 }
	 
	
	 public  Role insert(Role role) {
		
		 return roleRepo.save(role);
	 }
	 public Role update(Role role) {
		 
		 Role current = roleRepo.findById(role.getId()).get();
		 
		 current.setName(role.getName());
		 
		 
		 return roleRepo.save(current );
	 }
	 
	public Role findByName(String name) {
		return roleRepo.findByName(name);
	}
	 }

