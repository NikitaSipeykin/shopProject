package app;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
  private List<Product> products = new ArrayList<>();

  public void addProduct(Product product){
    products.add(product);
  }

  public void removeProduct(int id){
    products.removeIf(product -> product.getId() == id);
  }

  public List<Product> getItems() {
    return products;
  }

  public void clearCart() {
    products.clear();
  }
}
