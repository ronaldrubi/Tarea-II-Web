<%@ page import="java.util.*" %>
<html>
  <head>
    <title>Sistema Universitario</title>
  </head>
  <h1>Sistema Universitario</h1>
  <h2>Listado de grupos</h2>
  <% List grupos = (List)request.getAttribute("grupos"); %>
  <table>
    <tr><th>Sigla</th><th>Nombre</th><th>Horario</th><th>Acciones</th></tr>
    <% for(int i = 0, n = grupos.size(); i < n; i++) {
         Map grupo = (Map) grupos.get(i); %>
        <tr><td><%= grupo.get("sigla") %></td>
        <td><%= grupo.get("nombre") %></td>
        <td><%= grupo.get("horario") %></td>
        <td><a href='/universidad/detalleGrupo?id=<%= grupo.get("id") %>'>
              <input type="submit" value="Detalle"/></a>
            <a href='/universidad/eliminarGrupo?id=<%= grupo.get("id") %>'>
              <input type="submit" value="Eliminar"/></a></td></tr>
    <% } %>
  </table>
    <table>
      <tr><td><a href='/universidad/agregarGrupo'>
        <input type="submit" name="action" value="Agregar"/></a>
      </td></tr>
    </table>
</html>