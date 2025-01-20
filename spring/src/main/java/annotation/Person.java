package annotation;

public class Person {
  private String name;
  private Home home;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Home getHome() {
    return home;
  }

  public void setHome(Home home) {
    this.home = home;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", home=" + home.getAddress() +
        '}';
  }
}
