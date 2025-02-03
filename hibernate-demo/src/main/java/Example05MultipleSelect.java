import javax.persistence.EntityManager;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Example05MultipleSelect {

  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .buildSessionFactory();

    Student student1;
    try (Session session = sessionFactory.getCurrentSession()) {
      session.getTransaction().begin();

      student1 = session.get(Student.class, 1L);
      Student student2 = session.get(Student.class, 1L);

      Student s = new Student("BBB", 15);

      session.save(s);

      session.evict(s);

      s.setScore(150);

      System.out.println(student1 == student2);

      session.getTransaction().commit();
    }

    System.out.println(student1);

    sessionFactory.close();
  }
}
