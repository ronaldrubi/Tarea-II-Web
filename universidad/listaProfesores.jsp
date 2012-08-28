<%@ page import="java.util.*" %>
<html>
  <head>
    <title>Sistema Universitario</title>
  </head>
  <h1>Sistema Universitario</h1>
  <h2>Listado de profesores</h2>
  <% List profs = (List)request.getAttribute("profesores"); %>
  <table>
    <tr><th>Nombre</th><th>T&iacute;tulo</th><th>Area</th><th>Acciones</th></tr>
    <% for(int i = 0, n = profs.size(); i < n; i++) {
         Map prof = (Map) profs.get(i); %>
        <tr><td><%= prof.get("nombre") %></td>
        <td><%= prof.get("titulo") %></td>
        <td><%= prof.get("area") %></td>
        <td><a href='/universidad/detalleProfesor?id=<%= prof.get("id") %>'>
              <input type="submit" value="Detalle"/></a>
            <a href='/universidad/eliminarProfesor?id=<%= prof.get("id") %>'>
              <input type="submit" value="Eliminar"/></a></td></tr>
    <% } %>
  </table>
    <table>
      <tr><td><a href='/universidad/agregarProfesor'>
        <input type="submit" name="action" value="Agregar"/></a>
      </td></tr>
    </table>
</html>