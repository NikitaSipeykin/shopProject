package annotation;

public class Home {
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
