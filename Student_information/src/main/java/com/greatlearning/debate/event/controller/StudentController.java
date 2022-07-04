package com.greatlearning.debate.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.debate.event.entity.Student;
import com.greatlearning.debate.event.service.IStudentService;

@Controller
@RequestMapping("/Student")
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@RequestMapping(method = RequestMethod.GET, path = "/show-form")
	public String showFormToUser() {
		return "welcome";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/delete-student")
	public String deleteStudentDetails(@RequestParam("id") Integer id) {
		System.out.println("method called with id is: "+id);
		if (studentService.deleteStudent(id)) {
			System.out.println("Student deleted");
		} else {
			System.out.println("Student not deleted");
		}

		return "redirect:show-students";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/new-student")
	public String addStudentDetails(@RequestParam("id") Integer id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {
		Student student = new Student(id, name, department, country);
		studentService.add(student);

		return "redirect:show-students";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/show-students")
	public ModelAndView getStudentsDetails(ModelAndView mav) {

		List<Student> students = studentService.getAllStudents();
		mav.setViewName("student-info");
		mav.addObject("studentInfo", students);

		return mav;
	}

}
