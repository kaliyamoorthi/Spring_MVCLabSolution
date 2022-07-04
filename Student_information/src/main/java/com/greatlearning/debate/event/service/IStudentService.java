package com.greatlearning.debate.event.service;

import java.util.List;

import com.greatlearning.debate.event.entity.Student;

public interface IStudentService {

	public Student add(Student student);

	public Student update(Student student);

	public Student getStudent(int studentId);

	public boolean deleteStudent(int studentId);

	public List<Student> getAllStudents();

}
