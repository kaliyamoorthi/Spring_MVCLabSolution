package com.greatlearning.event.repository;

import com.greatlearning.event.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Repository
@Component
@Transactional
public class StudentRepository {
    @Autowired
    private SessionFactory sessionFactory;
    private List<Student> students = new ArrayList<>();

    public Student registerStudent(Student student){
        Session session = sessionFactory.getCurrentSession();
        session.persist(student);
        //students.add(student);
        //System.out.println("Registered Students:"+students.toString());
        return student;
    }

    public List<Student> getRegisteredStudents(){
        Session session = sessionFactory.getCurrentSession();
        List<Student> listStudents = session.createQuery("from Student",Student.class).getResultList();
        return listStudents;
    }
    public Student updateStudentDetails(Student id,Student updatedStudent){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(updatedStudent);

//            Optional<Student> studentOptional = students
//                                               .stream()
//                                               .filter(order -> order.getId() == id)
//                                                .findAny();
//            if(studentOptional.isPresent()) {
//                Student studentFetchedFromList = studentOptional.get();
//                studentFetchedFromList.setName(updatedStudent.getName());
//                studentFetchedFromList.setDepartment(updatedStudent.getDepartment());
//                studentFetchedFromList.setId(updatedStudent.getId());
//                studentFetchedFromList.setCountry(updatedStudent.getCountry());
//                return studentFetchedFromList;
//            }
            return null;
    }

    public void deleteStudentbyId(int id){
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Student.class,id));
        //students.removeIf(student -> student.getId()==id);
        return;
    }


    public Student getStudentbyId(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class,id);
    }

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
