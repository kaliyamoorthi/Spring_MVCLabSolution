package com.greatlearning.event.service;

import com.greatlearning.event.model.Student;
import com.greatlearning.event.repository.StudentRepository;
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
    public Student updateStudentDetails(int id, Student student){
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
}
