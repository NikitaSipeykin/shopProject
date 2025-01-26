package app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    ProductRepository productRepository = context.getBean(ProductRepository.class);
    Cart cart = context.getBean(Cart.class);

    Scanner scanner = new Scanner(System.in);
    String command;

    System.out.println("Welcome to the Cart Management App!");
    do {
      System.out.println("\nCommands: view_products, add_to_cart, remove_from_cart, view_cart, clear_cart, exit");
      System.out.print("Enter command: ");
      command = scanner.nextLine();

      switch (command) {
        case "view_products":
          System.out.println("Available Products:");
          productRepository.getProductList().forEach(System.out::println);
          break;
        case "add_to_cart":
          System.out.print("Enter Product ID to add: ");
          int addId = Integer.parseInt(scanner.nextLine());
          Product productToAdd = productRepository.getProductById(addId);
          if (productToAdd != null) {
            cart.addProduct(productToAdd);
            System.out.println("Product added to cart.");
          } else {
            System.out.println("Product not found.");
          }
          break;
        case "remove_from_cart":
          System.out.print("Enter Product ID to remove: ");
          int removeId = Integer.parseInt(scanner.nextLine());
          cart.removeProduct(removeId);
          break;
        case "view_cart":
          System.out.println("Cart Items:");
          cart.getItems().forEach(System.out::println);
          break;
        case "clear_cart":
          cart.clearCart();
          System.out.println("Cart cleared.");
          break;
        case "exit":
          System.out.println("Exiting application.");
          break;
        default:
          System.out.println("Invalid command.");
      }
    } while (!command.equals("exit"));

    context.close();
  }
}
