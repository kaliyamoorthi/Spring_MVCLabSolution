package com.greatlearning.event.controller;


import com.greatlearning.event.model.Student;
import com.greatlearning.event.service.RegistrationService;
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
    /*************************************/

//    @RequestMapping(value="/registration", method = RequestMethod.GET)
//    public String showStudentForm(Model theModel){
//        Student theStudent = new Student();
//       theModel.addAttribute("student",theStudent);
//        return "student-form";
////        theModel.addAttribute("message",
////                "Hello World and Welcome to Spring MVC!");
//        //return "student-form";
//       //return "Student";
//    }
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


//    @RequestMapping(value="/updateForm")
//    public String updateStudent(@PathVariable int id, Model m){
//        Emp emp=dao.getEmpById(id);
//        m.addAttribute("command",emp);
//        return "empeditform";
//    }
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

//    @RequestMapping(value = "/registerStudent", method = RequestMethod.POST)
//    /*@ResponseStatus(HttpStatus.CREATED)*/
//    public String registerStudent(@ModelAttribute("student") Student thestudent){
//        registrationService.registerStudent(thestudent);
//        return("redirect:/list");
//    }

/*****************Emp Methods*****************/

//    @RequestMapping("/empform")
//    public ModelAndView showform(){
//        return new ModelAndView("empform","command",new Emp());
//    }
//    @RequestMapping(value="/save",method = RequestMethod.POST)
//    public ModelAndView save(@ModelAttribute("emp") Emp emp){
//        //write code to save emp object
//        System.out.println(emp.getName()+" "+emp.getSalary()+" "+emp.getDesignation());
//
//        //return new ModelAndView("empform","command",emp);
//        return new ModelAndView("redirect:/viewemp");
//    }
//
//    @RequestMapping("/viewemp")
//    public ModelAndView viewemp(){
//        //write the code to get all employees from DAO
//        //writing manual code for easy understanding
//        List<Emp> list=new ArrayList<Emp>();
//        list.add(new Emp(1,"rahul",35000f,"S.Engineer"));
//        list.add(new Emp(2,"aditya",25000f,"IT Manager"));
//        list.add(new Emp(3,"sachin",55000f,"Care Taker"));
//
//        return new ModelAndView("viewemp","list",list);
//    }


}
