package app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class AppConfig {

  @Bean
  public ProductRepository productRepository(){
    ProductRepository products = new ProductRepository();

    for (int i = 0; i < 4; i++) {
      products.addProduct(new Product(i, "p" + i + 1, 1000 + i * 100));
    }

    return products;
  }

  @Bean
  public Cart cart(){
    Cart cart = new Cart();

    return cart;
  }
}
