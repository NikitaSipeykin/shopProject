package application.service;

import application.dto.Student;
import application.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
  private StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getAll(){
    return studentRepository.getAll();
  }

  public void save(Student student){
    studentRepository.save(student);
  }

  public Student findById(int id){
    return studentRepository.findById(id);
  }
}
