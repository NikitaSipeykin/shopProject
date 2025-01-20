package demo;

import org.springframework.stereotype.Component;

@Component("t")
public class TerminatorQuoter implements Quoter{
  @RandomInt(min = 2, max = 5 )
  private int count;

  @Override
  public String sayQuote() {
    var sb = new StringBuilder();
    for (int i = 0; i < count; i++) {
      sb.append("I'll be back!\n");
    }
    return sb.toString();
  }
}
