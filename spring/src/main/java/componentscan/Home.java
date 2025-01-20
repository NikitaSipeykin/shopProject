package componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Home {
  @Value("Red 1")
  private String address;

  private Person owner;

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Person getOwner() {
    return owner;
  }
  @Autowired
  public void setOwner(Person owner) {
    this.owner = owner;
  }

  @Override
  public String toString() {
    return "Home{" +
        "address='" + address + '\'' +
        ", owner=" + owner.getName() +
        '}';
  }
}
