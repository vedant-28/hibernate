package com.orm.manytomany;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	private int pid;
	
	@Column(name = "project_name")
	private String name;
	
	@ManyToMany(mappedBy = "projects")
	private List<Employee> employees;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int pid, String name, List<Employee> employees) {
		super();
		this.pid = pid;
		this.name = name;
		this.employees = employees;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Project [pid=" + pid + ", name=" + name + ", employees=" + employees + "]";
	}
}
