package data;

import java.util.*;
import javax.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;

public class GrupoGateway extends TableGateway {

  private final static String findStatement =
     "SELECT * "+
     "FROM grupo "+
     "WHERE id = ?";

  public Map<String, Object> find(String id) {
    List grupos = jdbcTemplate.queryForList(findStatement,id);
    return (Map<String, Object>)grupos.get(0);
  }

  private final static String findAllStatement =
     "SELECT * "+
     "FROM grupo ";

  public List<Map<String, Object>> findAll() {
    return jdbcTemplate.queryForList(findAllStatement);
  }

  private static final String insertStatement =
    "INSERT INTO grupo "+
  "VALUES (?,?,?,?,?,?,?)";

  public int insert(String numero,String sigla,String nombre,String horario, String aula, String id_profesor) {
    Random generator = new Random();
    int id = generator.nextInt();
      jdbcTemplate.update(insertStatement,
         id,numero,sigla,nombre,horario,aula,id_profesor);
    return id;
  }

  private static final String updateStatement =
    "UPDATE grupo "+
    "SET numero = ?, sigla = ?, nombre = ?, "+
    "horario = ?, aula = ?, id_profesor = ? WHERE id = ?";

  public void update(int id,String numero,String sigla,String nombre,String horario,String aula, String id_profesor) {
      jdbcTemplate.update(updateStatement,
          numero,sigla,nombre,horario,aula,id_profesor,id);
  }

  private static final String deleteStatement =
    "DELETE FROM grupo "+
    "WHERE id = ?";

  public void delete(int id) {
      jdbcTemplate.update(deleteStatement,id);
  }
}