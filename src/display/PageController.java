package display;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.web.context.*;
import org.springframework.web.context.support.*;

public class PageController extends HttpServlet {

  protected WebApplicationContext context;

  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
  }

   protected void forward(String target, HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    RequestDispatcher dispatcher =
      context.getServletContext().getRequestDispatcher(target);
    dispatcher.forward(request,response);
  }
}