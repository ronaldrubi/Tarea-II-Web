package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.ProfesorModule;

public class InsertarProfesor extends PageController {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    ProfesorModule module = (ProfesorModule) context.getBean("profesorModule");
    try {
      String cedula = request.getParameter("cedula");
      String nombre = request.getParameter("nombre");
      String titulo = request.getParameter("titulo");
      String area = request.getParameter("area");
      String telefono = request.getParameter("telefono");
      module.insertar(cedula,nombre,titulo,area,telefono);
      response.sendRedirect("listaProfesores");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}