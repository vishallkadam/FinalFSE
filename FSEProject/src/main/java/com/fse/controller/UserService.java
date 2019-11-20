package com.fse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.dao.DataBaseTransaction;
import com.fse.pojo.Users;

@Service
public class UserService {

	@Autowired
	private static DataBaseTransaction dao = new DataBaseTransaction();
	
	public Users createUsers(Users users) {
		
		return dao.createUsers(users);
	}
	public List<Users> viewUsers(){
		return dao.viewUsers();
	}
	
	public void updateUsers(int userId, Users users) {
		dao.updateUsers(userId, users);
	}
	
	public void deleteUsers(int employeeId) {
		dao.deleteUser(employeeId);
	}
}
