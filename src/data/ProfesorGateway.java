package data;

import java.util.*;
import javax.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProfesorGateway extends TableGateway {

  private final static String findStatement =
     "SELECT * "+
     "FROM profesor "+
     "WHERE id = ?";

  public Map<String, Object> find(String id) {
    List profs = jdbcTemplate.queryForList(findStatement,id);
    return (Map<String, Object>)profs.get(0);
  }

  private final static String findAllStatement =
     "SELECT * "+
     "FROM profesor ";

  public List<Map<String, Object>> findAll() {
    return jdbcTemplate.queryForList(findAllStatement);
  }

  private static final String insertStatement =
    "INSERT INTO profesor "+
  "VALUES (?,?,?,?,?,?)";

  public int insert(String cedula,String nombre,String titulo,String area,String telefono) {
    Random generator = new Random();
    int id = generator.nextInt();
      jdbcTemplate.update(insertStatement,
         id,cedula,nombre,titulo,area,telefono);
    return id;
  }

  private static final String updateStatement =
    "UPDATE profesor "+
    "SET cedula = ?, nombre = ?, titulo = ?, "+
    "area = ?, telefono = ? WHERE id = ?";

  public void update(int id,String cedula,String nombre,String titulo,String area,String telefono) {
      jdbcTemplate.update(updateStatement,
          cedula,nombre,titulo,area,telefono,id);
  }

  private static final String deleteStatement =
    "DELETE FROM profesor "+
    "WHERE id = ?";

  public void delete(int id) {
      jdbcTemplate.update(deleteStatement,id);
  }
}