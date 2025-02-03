import java.util.List;
import javax.persistence.EntityManagerFactory;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StudetntDao {

  SessionFactory factory;

  public StudetntDao(SessionFactory factory) {
    this.factory = factory;
  }

  Student findById(Long id) {
    Student student;
    try (Session session = factory.getCurrentSession()) {
      session.getTransaction().begin();

      student = session.find(Student.class, 1L);

      session.getTransaction().commit();
    }
    return student;
  }

  EntityManagerFactory
    EntityManager

  List<Student> findAll();
  void deleteById(Long id);
  Student saveOrUpdate(Student product);
}
