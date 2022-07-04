package com.greatlearning.debate.event.dao;

import java.util.List;

import com.greatlearning.debate.event.entity.Student;

public interface IStudentDao {

	public Student insertStudentDetails(Student student);

	public Student updateStudentDetails(Student student);

	public boolean deleteStudentDetails(int studentId);

	public Student findStudent(int studentId);

	public List<Student> retrieveStudentDetails();

}
