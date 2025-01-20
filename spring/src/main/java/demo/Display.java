package demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Display {

  private Quoter quoter;

  public Display(@Qualifier("t") Quoter quoter) {
    this.quoter = quoter;
  }

  public void show(){
    System.out.println(quoter.sayQuote());
  }
}
