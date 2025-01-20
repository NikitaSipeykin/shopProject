package demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(AppConfig.class);

    context.getBean(Display.class).show();

    context.close();
  }
}
