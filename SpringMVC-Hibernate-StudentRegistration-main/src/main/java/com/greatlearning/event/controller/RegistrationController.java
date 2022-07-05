package com.greatlearning.fest.controller;


import com.greatlearning.fest.model.Student;
import com.greatlearning.fest.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.util.List;

@Controller
@Component
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;
    public RegistrationController(RegistrationService registratonService){
        this.registrationService = registratonService;
    }

    /****************/
    @RequestMapping("/showStudentform")
    public ModelAndView showStudentForm(){
        return new ModelAndView("student-form","command",new Student());
    }
    @RequestMapping(value="/registerStudent",method = RequestMethod.POST)
    public ModelAndView registerStudent(@ModelAttribute("student") Student theStudent){
        //write code to save  object

        System.out.println(theStudent.getId()+" "+theStudent.getName()+
                " "+theStudent.getDepartment()+" " +theStudent.getCountry());
        registrationService.registerStudent(theStudent);
        System.out.println("Student registered Successfully");
        //return new ModelAndView("empform","command",emp);
        return new ModelAndView("redirect:/list");
    }
   
    @GetMapping("/list")
    public String getAllRegisteredStudents(Model theModel){
        List<Student> theStudents = registrationService.getRegisteredStudents();
        theModel.addAttribute("students",theStudents);
        System.out.println("All registered students: \n"+theStudents.toString());
        return "list-students";
    }
    @RequestMapping(value="/delete")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public ModelAndView deleteStudentById(@RequestParam("studentId") int theId){
        registrationService.deleteStudent(theId);
        Model theModel = new RedirectAttributesModelMap();
        System.out.println("The student with Id "+theId+" is deleted successfully");
        return new ModelAndView("redirect:/list");
    }



    @RequestMapping(value="/updateForm")
    public String updateStudent(@RequestParam("studentId") int theId, Model theModel) {
        Student theStudent = registrationService.getStudent(theId);
        System.out.println("The details of student with id "+theId+" are updated from ");
        System.out.println(theStudent.toString());
        theModel.addAttribute("command",theStudent);
        return "edit-student-form";
    }
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public String editsave(@ModelAttribute("student") Student student){
        registrationService.updateStudentDetails(student.getId(),student);
        System.out.println("to :"+student.toString());
        return ("redirect:/list");
    }
    @RequestMapping(value="/homePage")
    public String showHomePage() {
        return "index";
    }



}
