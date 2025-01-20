package componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {
  @Value("Ivan")
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
  @Autowired
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
