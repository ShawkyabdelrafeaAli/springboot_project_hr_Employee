package com.global_hr;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.global_hr.entity.Role;
import com.global_hr.entity.User;
import com.global_hr.services.RoleService;
import com.global_hr.services.UserService;

@Component
public class AppStartUp  implements CommandLineRunner{

	@Autowired
	private UserService userSerivce;
	@Autowired
	private RoleService roleService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		if(userSerivce.findAllUsers().isEmpty())
		{
		
		//  create roles
		Role role1 = new Role();
		role1.setName("Admin");
		
		Role role2 = new Role();
		role1.setName("User");
		roleService.insert(role1);
		roleService.insert(role2);
		
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(role1);
		
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(role2);
		
		// create users
		
		User user1 = new User();
		user1.setUserName("Admen");
		user1.setPassword("123");
		user1.setRoles(adminRoles);
		
		userSerivce.insert(user1);
		User user2 = new User();
		user1.setUserName("User");
		user1.setPassword("123");
		user2.setRoles(userRoles);
		userSerivce.insert(user2);
	}
}
}
