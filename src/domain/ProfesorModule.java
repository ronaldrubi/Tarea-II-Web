package domain;

import data.TableGateway;
import data.ProfesorGateway;

import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;

public class ProfesorModule {

  private ProfesorGateway gateway;

  public void setGateway(TableGateway gateway) {
    this.gateway = (ProfesorGateway)gateway;
  }

  public void actualizar(int id, String cedula, String nombre, String titulo,
                    String area, String telefono) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de profesor incorrecto");
    if (titulo.toLowerCase().equals("bachiller") ||
        titulo.toLowerCase().equals("licenciado") ||
        titulo.toLowerCase().equals("master") ||
        titulo.toLowerCase().equals("doctor"))
      gateway.update(id,cedula,nombre,titulo,area,telefono);
    else
      throw new Exception("Error en título de profesor");
  }
  
  public void insertar(String cedula, String nombre, String titulo,
                    String area, String telefono) throws Exception {
    if (titulo.toLowerCase().equals("bachiller") ||
        titulo.toLowerCase().equals("licenciado") ||
        titulo.toLowerCase().equals("master") ||
        titulo.toLowerCase().equals("doctor"))
      gateway.insert(cedula,nombre,titulo,area,telefono);
    else
      throw new Exception("Error en título de profesor");
  }
  
  public void eliminar(int id) throws Exception {
      gateway.delete(id);
  }

  public Map<String,Object> buscar(int id) throws Exception {
    if (id <= 0)
      throw new Exception("Identificador de profesor incorrecto");
    Map<String,Object> prof = gateway.find(id+"");
    return prof;
  }

  public List<Map<String,Object>> listado() throws Exception {
    List<Map<String,Object>> profs = gateway.findAll();
    return profs;
  }
}