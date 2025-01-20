package annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(AppConfig.class);

    var beanName = context.getBeanDefinitionNames();

    for (var name: beanName) {
      System.out.println(context.getBean(name));
    }
  }
}
