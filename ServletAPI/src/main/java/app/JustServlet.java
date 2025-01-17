package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "JustServlet", urlPatterns = "/show_page")
public class JustServlet extends HttpServlet {
  private static Logger logger = LoggerFactory.getLogger(JustServlet.class);

  ArrayList<Product> products = new ArrayList<>();

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    logger.info("Log: JustServlet");
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();

    for (int i = 0; i < 10; i++) {
      products.add(new Product(i, 1000, "this is " + i+ "element"));
    }

// Формирование HTML-страницы с продуктами
    out.println("<html>");
    out.println("<body>");
    out.println("<h1>JustServlet request</h1>");
    out.println("<ul>"); // Начало списка

    for (Product product : products) {
      out.printf("<li>ID: %d, Price: %d, Description: %s</li>",
          product.getId(), product.getCost(), product.getTitle());
    }

    out.println("</ul>"); // Конец списка
    out.println("</body>");
    out.println("</html>");

    out.close();
  }
}
