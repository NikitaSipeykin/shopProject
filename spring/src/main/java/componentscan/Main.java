package componentscan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(AppConfig.class);

    var beanName = context.getBeanDefinitionNames();

    for (var name: beanName) {
      System.out.println(context.getBean(name));
    }
  }
}
