package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.GrupoModule;

public class EliminarGrupo extends PageController {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    GrupoModule module = (GrupoModule) context.getBean("grupoModule");
    try {
      String id = request.getParameter("id");
	  int idGrupo = Integer.parseInt(id);
      module.eliminar(idGrupo);
      response.sendRedirect("listaGrupos");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}