package houseportal;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BasicServletTest {
  @Test
  void servletConstructorDoesWork() {
    BasicServlet servlet = new BasicServlet();
    assertTrue(servlet.getClass().getName().equals("houseportal.BasicServlet"));
  }
}
