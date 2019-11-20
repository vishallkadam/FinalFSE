package com.fse.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fse.pojo.Users;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api/user"})
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@PostMapping
	public Users createUsers(@RequestBody Users users) {
		System.out.println("User - "+users);
		return userService.createUsers(users);
	}
	
	@GetMapping
	public List<Users> viewUsers(){
		Iterator<Users> iterator = userService.viewUsers().iterator();
		 
		while (iterator.hasNext()) {
		    Users users = iterator.next();
		    System.out.println("All Users ---------------------"+users.getFirstName());
		}
		return userService.viewUsers();
	}
	

	
	@PutMapping
	public void updateUsers(@RequestParam(value="userId") int userId, @RequestBody Users users) {
		userService.updateUsers(userId, users);
	}
	
	@DeleteMapping
	public void deleteUsers(@RequestParam(value="employeeId") int employeeId) {
		System.out.println("Emp ID - --------------------------"+employeeId);
		userService.deleteUsers(employeeId);
	}
}
