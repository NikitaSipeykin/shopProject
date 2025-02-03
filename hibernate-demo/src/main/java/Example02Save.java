import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Example02Save {

  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .buildSessionFactory();

    try (Session session = sessionFactory.getCurrentSession()) {
      session.getTransaction().begin();

      Student student = new Student("Андрей", 88);
      System.out.println(student);

      session.save(student);
      System.out.println(student);

      session.getTransaction().commit();
    }

    sessionFactory.close();
  }
}