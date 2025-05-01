package application.dao;

import application.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class ProjectDao {
  SessionFactory factory;

  public ProjectDao(SessionFactory factory) {
    this.factory = factory;
  }

  public Product findById(Long id){
    Product product;
    try(Session session = factory.getCurrentSession()) {
      session.getTransaction().begin();

      product = session.find(Product.class, 1L);

      session.getTransaction().commit();
    }
    factory.close();

    return product;
  }

  public List<Product> findAll(){
    List<Product> products = new ArrayList<>();
    try(Session session = factory.getCurrentSession()) {
      session.getTransaction().begin();

      products = session.createQuery("Select s from product s", Product.class).getResultList();

      session.getTransaction().commit();
    }
    factory.close();

    return products;
  }

  public void deleteById(Long id){
    try (Session session = factory.getCurrentSession()){
      session.delete(id);
    }
    factory.close();
  }

  public void saveOrUpdate(Product product){
    try(Session session = factory.getCurrentSession()) {
      session.saveOrUpdate(product);
    }
    factory.close();
  }
}
