package com.fse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.dao.DataBaseTransaction;
import com.fse.pojo.Parent;
import com.fse.pojo.Task;
@Service
public class TaskServices {

	@Autowired
	private static DataBaseTransaction dao = new DataBaseTransaction();
	
		
	public int createTask(Task task) {
		return dao.createTask(task);
	}
	
	public int createParentTask(Parent parent) {
		return dao.createParentTask(parent);
	}
	
	public List<Task> getTasks(int projectId){
		return dao.getTasks(projectId);
	}
	
	public int updateTask(int taskId) {
		return dao.updateTask(taskId);
	}
}
