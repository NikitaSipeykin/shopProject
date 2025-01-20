package annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  @Bean
  public Cat catBean(){
    var cat = new Cat();
    cat.setTitle("Mursik");
    return cat;
  }

  @Bean
  public Home homeBean(){
    var home = new Home();
    home.setAddress("Red 1");
    return home;
  }

  @Bean
  public Person personBean(Home home){
    var person = new Person();
    person.setName("John");
    person.setHome(home);
    home.setOwner(person);
    return person;
  }
}
