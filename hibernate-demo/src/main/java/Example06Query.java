import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Example06Query {

  public static void main(String[] args) {
    EntityManagerFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .buildSessionFactory();

    EntityManager entityManager = sessionFactory.createEntityManager();
      entityManager.getTransaction().begin();

      entityManager.persist(new );

      var students1 = entityManager
          .createQuery("select s from Student s where s.score > :score", Student.class)
          .setParameter("score", 80)
          .getResultList();

      var students2 = entityManager
          .createNativeQuery("select * from student where score > :score", Student.class)
          .setParameter("score", 80)
          .getResultList();

      var student = entityManager
          .createQuery("from Student s where s.name = :name", Student.class)
          .setParameter("name", "Анна")
          .getSingleResult();

//      session.createQuery("update Student s set s.score = 0")
//          .executeUpdate();

      var students3 = entityManager
          .createNamedQuery("studentsWithScore", Student.class)
          .setParameter("score", 80)
          .getResultList();

      students1.forEach(System.out::println);

      System.out.println("------");

      students2.forEach(System.out::println);
      entityManager.getTransaction().commit();

      System.out.println("------");

      students3.forEach(System.out::println);

    }

    StudetntDao dao;


    sessionFactory.close();
  }
}
