package app;

public class Product {


  int id, cost;
  String title;

  public Product(int id, int cost, String title) {
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
}
