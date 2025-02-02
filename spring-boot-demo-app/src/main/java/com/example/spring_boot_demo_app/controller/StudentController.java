package com.example.spring_boot_demo_app.controller;

import com.example.spring_boot_demo_app.dto.Student;
import com.example.spring_boot_demo_app.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
  private StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  // http://localhost:8080/app/all/ GET
  @GetMapping("/all")
  public String getAllStudents(Model model){
    model.addAttribute("students", studentService.getAll());
    return "student_list";
  }

  @GetMapping("/info/{id}")
  public String getStudentInfo(@PathVariable("id") Integer studentId, Model model){
    model.addAttribute("student", studentService.findById(studentId));
    return "student_info";
  }

  @GetMapping("/add")
  public String getStudentAddForm(){
    return "student_form";
  }

  @PostMapping("/add")
  public String saveStudent(Student student){
    studentService.save(student);
    return "redirect:all";
  }

  @PostMapping("/delete/{id}")
  public String deleteStudent(@PathVariable("id") Integer studentId){
    studentService.deleteById(studentId);
    return "redirect:/all";
  }


  //rest example
  @GetMapping("/all/rest")
  @ResponseBody
  public List<Student> getAllRest(){
    return studentService.getAll();
  }

  @PostMapping("/add/rest")
  @ResponseBody
  public List<Student> saveStudentRest(@RequestBody Student student){
    studentService.save(student);
    return studentService.getAll();
  }
}
