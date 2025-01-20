package demo;

import org.springframework.stereotype.Component;

@Component
public class ShangTsungQuoter implements Quoter{

  @Override
  public String sayQuote() {
    return "Your soul shall be mine!";
  }
}
