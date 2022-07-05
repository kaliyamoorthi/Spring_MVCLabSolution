package com.greatlearning.fest.service;

import com.greatlearning.fest.model.Student;
import com.greatlearning.fest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RegistrationService {
    @Autowired
    private final StudentRepository studentRepository;
    public RegistrationService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student registerStudent(Student student){
        return this.studentRepository.registerStudent(student);
    }
    public List<Student> getRegisteredStudents(){
        return this.studentRepository.getRegisteredStudents();
    }
    public Student updateStudentDetails(Student id, Student student){
        return this.studentRepository.updateStudentDetails(id,student);
    }
    public void deleteStudent(int id){
        System.out.println("Student with the following Id is deleted: "+ id);
        this.studentRepository.deleteStudentbyId(id);
        return;
    }

    public Student getStudent(int id) {
        return this.studentRepository.getStudentbyId(id);
    }

	public void updateStudentDetails(String id, Student student) {
		// TODO Auto-generated method stub
		
	}
}
