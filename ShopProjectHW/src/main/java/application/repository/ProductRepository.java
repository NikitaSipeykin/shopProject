package application.repository;

import application.dto.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
  private List<Product> products;

  @PostConstruct
  public void init(){
    products = new ArrayList<>();
    products.add(new Product(1, 1000, "Smartphone"));
    products.add(new Product(2, 1500, "Laptop"));
    products.add(new Product(3, 2000, "TV"));
  }

  public List<Product> getAll(){
    return List.copyOf(products);
  }

  public void save(Product product){
    products.add(product);
  }

  public Product findById(int id){
    return products.stream().filter(product -> product.getId() == id)
        .findFirst()
        .orElse(null);
  }
}
