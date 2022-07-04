package com.greatlearning.debate.event.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="collegefest")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String department;
	private String country;
	
	public Student() {
	}
		
	
	public Student(Integer id, String name, String department, String country) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.country = country;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", department=" + department + ", country=" + country + "]";
	}
	
	
}
