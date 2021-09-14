package database.mappers;

import static java.sql.Date.valueOf;

import database.entities.Subject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapper implements Mapper<Subject> {

  private static final String ID = "id";
  private static final String CREATED = "created";
  private static final String UPDATED = "updated";
  private static final String NAME = "name";
  private static final String TEACHER_ID = "teacher_id";

  @Override
  public void toSQL(PreparedStatement statement, Subject object) throws SQLException {
    statement.setLong(1, object.getId());
    statement.setDate(2, valueOf(object.getCreated()));
    statement.setDate(3, valueOf(object.getUpdated()));
    statement.setString(4, object.getName());
    statement.setLong(5, object.getTeacherId());
  }

  @Override
  public Subject toObject(ResultSet resultSet) throws SQLException {
    Long id = resultSet.getLong(ID);
    LocalDate created = resultSet.getDate(CREATED).toLocalDate();
    LocalDate updated = resultSet.getDate(UPDATED).toLocalDate();
    String name = resultSet.getString(NAME);
    Long teacherId = resultSet.getLong(TEACHER_ID);
    return new Subject(id, created, updated, name, teacherId);
  }
}
