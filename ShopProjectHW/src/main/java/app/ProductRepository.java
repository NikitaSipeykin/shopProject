package app;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
  private List<Product> products = new ArrayList<>();

  public void addProduct(Product product){
    products.add(product);
  }

  public Product getProductById(int id) {
    return products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
  }

  public List<Product> getProductList(){
    return products;
  }
}
