package app;

public class Product {


  int id, cost;
  String title;

  public Product(int id, String title, int cost) {
    this.id = id;
    this.cost = cost;
    this.title = title;
  }

  public int getId() {
    return id;
  }

  public int getCost() {
    return cost;
  }

  public String getTitle() {
    return title;
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", name='" + title + '\'' +
        ", price=" + cost +
        '}';
  }
}