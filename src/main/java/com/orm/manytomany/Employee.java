package com.orm.manytomany;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Employee {

	@Id
	private int eid;
	
	@Column(name = "emp_name")
	private String name;
	
	@ManyToMany
	private List<Project> projects;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int eid, String name, List<Project> projects) {
		super();
		this.eid = eid;
		this.name = name;
		this.projects = projects;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", projects=" + projects + "]";
	}
	
}
