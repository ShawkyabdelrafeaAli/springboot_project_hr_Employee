package com.global_hr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.global_hr.entity.Role;
import com.global_hr.entity.User;
import com.global_hr.repository.UserRepo;

@Service
public class UserService {


	   @Autowired
	   private RoleService roleService;
	
		 @Autowired
		 private UserRepo userRepo;
		 
		 public User findByID (Long id) {
			 return userRepo.findById(id).orElseThrow();
		 }
		  
		
		 public  User insert(User emp) {
			
			 return userRepo.save(emp);
		 }
		 public User update(User user) {
			 
			 User current = userRepo.findById(user.getId()).get();
			 
			 current.setUserName(user.getUserName());
			 current.setPassword(user.getPassword());
			
			 
			 return userRepo.save(current );
		 }
		 
		
		
		public List<User> findAllUsers(){
			   return 	 userRepo.findAll();
			}
		
		@Transactional
		public void addRoleForAllUsers(String roleName) {
			Role role = roleService.findByName(roleName);
			
			
			findAllUsers().forEach(user ->{
				user.addRole(role);
				userRepo.save(user);
			});
				
			
		}
			
		 }

     




	

