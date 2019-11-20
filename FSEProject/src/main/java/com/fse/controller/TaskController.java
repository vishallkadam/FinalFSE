package com.fse.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fse.pojo.Parent;
import com.fse.pojo.Task;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api/task"})
public class TaskController {

	final static Logger logger = Logger.getLogger(TaskController.class);
	@Autowired
	private TaskServices taskServices;
	
	@PostMapping
	public int createTask(@RequestBody Task task, @RequestParam(value="isParent") boolean isParent) {
		System.out.println("In Task create method1 ----------------------------"+task.getTaskName());
		System.out.println("In Task create Project id----------------------------"+task.getProjectId());
		System.out.println("In Task create isParent----------------------------"+isParent);
		
		if(isParent) {
			Parent parent = new Parent();
			parent.setParentTask(task.getTaskName());
			return taskServices.createParentTask(parent);
					
		}else {
			 return taskServices.createTask(task);
		}
	}
	
	@GetMapping
	public List<Task> getTasks(@RequestParam(value="projectId") int projectId){
		System.out.println("Project ID ---------------- "+projectId);
		return taskServices.getTasks(projectId);
	}
	
	@PutMapping
	public int updateTask(@RequestParam(value="taskId") int taskId, @RequestBody int taskId1) {
		System.out.println("Task ID ---------------"+taskId);
		return taskServices.updateTask(taskId);
	}
		
	
}
