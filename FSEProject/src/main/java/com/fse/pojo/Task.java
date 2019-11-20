package com.fse.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="task_id", updatable=false, nullable=false)
	private int taskId;
	
	/*//@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name ="parent_id")
	private Parent parent;
	
	
	//@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@ManyToOne
	  @JoinColumn(name ="project_id")
	private Project project;*/
	
	@Transient
	private Project project;
	@Transient
	private int employeeId;
	//@ManyToOne (fetch=FetchType.LAZY)
	@Transient
	private Parent parent;
	
	@Column(name ="parent_id", updatable=false, nullable=false)
	private int parentId;
	@Column(name ="project_id", updatable=false, nullable=false)
	private int projectId; 
	
	@Column (name="task")
	private String taskName;
	@Column (name="start_date")
	private Date startDate;
	@Column (name="end_date")
	private Date endDate;
	@Column (name="priority")
	private int priority;
	@Column (name="status")
	private String status;
	
	@Transient
	private boolean isParent;
	

	
	public boolean isParent() {
		return isParent;
	}
	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	

	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Parent getParent() {
		return parent;
	}
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}

	
	
	
}
