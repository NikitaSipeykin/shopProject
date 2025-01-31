package application.repository;

import application.dto.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentRepository {
  private List<Student> studentList;

  @PostConstruct
  public void init(){
    studentList = new ArrayList<>();
    studentList.add(new Student(1, "Ivan", 90));
    studentList.add(new Student(2, "Michel", 100));
    studentList.add(new Student(3, "Andrew", 85));
  }

  public List<Student> getAll(){
    return List.copyOf(studentList);
  }

  public void save(Student student){
    studentList.add(student);
  }

  public Student findById(int id){
    return studentList.stream().filter(student -> student.getId() == id)
        .findFirst()
        .orElse(null);
  }
}
