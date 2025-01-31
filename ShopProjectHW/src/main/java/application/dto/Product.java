package application.dto;

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

  public void setId(int id) {
    this.id = id;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
