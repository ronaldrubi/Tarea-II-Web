package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.GrupoModule;

public class ActualizarGrupo extends PageController {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
    throws ServletException, IOException {
    GrupoModule module = (GrupoModule) context.getBean("grupoModule");
    try {
      String id = request.getParameter("id");
      int idGrupo = Integer.parseInt(id);
      String numero = request.getParameter("numero");
      String sigla = request.getParameter("sigla");
      String nombre = request.getParameter("nombre");
      String horario = request.getParameter("area");
      String aula = request.getParameter("aula");
	  String id_profesor = request.getParameter("id_profesor");
      module.actualizar(idGrupo,numero,sigla,nombre,horario,aula,id_profesor);
      response.sendRedirect("listaGrupos");
    } catch (Exception e) {
      request.setAttribute("mensaje",e.getMessage());
      forward("/paginaError.jsp",request,response);
    }
  }
}