package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.ProfesorModule;

public class EliminarProfesor extends PageController {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    ProfesorModule module = (ProfesorModule) context.getBean("profesorModule");
    try {
      String id = request.getParameter("id");
	  int idProf = Integer.parseInt(id);
      module.eliminar(idProf);
      response.sendRedirect("listaProfesores");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}