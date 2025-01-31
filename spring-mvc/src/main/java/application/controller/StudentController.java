package application.controller;

import application.dto.Student;
import application.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
  public String saveStudent(@RequestParam Integer id,
                            @RequestParam String name,
                            @RequestParam Float score){
    studentService.save(new Student(id, name, score));
    return "redirect:all";
  }
}
