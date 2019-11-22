package com.fse.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fse.pojo.Project;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api/project"})
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@PostMapping
	public Project createProject(@RequestBody Project project) {
		//System.out.println("In Project create method ----------------------------");
		return projectService.createProject(project);
	}
	
	@GetMapping
	public List<Project> getProjects(){
		System.out.println("In Project get method ----------------------------");
		List<Project> projectList = new ArrayList<Project>();
		Project p = new Project();
		p.setProjectId(1);
		p.setProjectName("TestProject");
		try {
			p.setStartDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2019"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			p.setEndDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/12/2019"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setPriority(2);
		p.setEmployeeId(12);
		projectList.add(p);
		
		return projectList;
		//return projectService.getProjects();
	}
	
	@PutMapping
	public void updateProject(@RequestParam(value="projectId") int projectId, @RequestBody Project p) {
		projectService.updateProject(projectId, p);
	}
}
