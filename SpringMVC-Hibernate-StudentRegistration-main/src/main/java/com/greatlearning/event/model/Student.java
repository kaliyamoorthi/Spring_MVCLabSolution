package com.greatlearning.event.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="students")
public class Student {
    @Id
    int id;
    String name;
    String department;
    String country;
	public String getName() {
      // TODO Auto-generated method stub
		return null;
	}
	public String getDepartment() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getCountry() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	}

