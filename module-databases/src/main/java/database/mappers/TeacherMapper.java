package database.mappers;

import static java.sql.Date.valueOf;

import database.entities.Teacher;
import database.entities.TeacherTitle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper implements Mapper<Teacher> {

  private static final String ID = "id";
  private static final String CREATED = "created";
  private static final String UPDATED = "updated";
  private static final String NAME = "name";
  private static final String SURNAME = "surname";
  private static final String BIRTH_DATE = "birth_date";
  private static final String TITLE = "title";

  @Override
  public void toSQL(PreparedStatement statement, Teacher object) throws SQLException {
    statement.setLong(1, object.getId());
    statement.setDate(2, valueOf(object.getCreated()));
    statement.setDate(3, valueOf(object.getUpdated()));
    statement.setString(4, object.getName());
    statement.setString(5, object.getSurname());
    statement.setDate(6, valueOf(object.getBirthDate()));
    statement.setString(7, object.getTitle().toString());
  }

  @Override
  public Teacher toObject(ResultSet resultSet) throws SQLException {
    Long id = resultSet.getLong(ID);
    LocalDate created = resultSet.getDate(CREATED).toLocalDate();
    LocalDate updated = resultSet.getDate(UPDATED).toLocalDate();
    String name = resultSet.getString(NAME);
    String surname = resultSet.getString(SURNAME);
    LocalDate birthDate = resultSet.getDate(BIRTH_DATE).toLocalDate();
    TeacherTitle title = TeacherTitle.valueOf(resultSet.getString(TITLE));
    return new Teacher(id, created, updated, name, surname, birthDate, title);
  }
}
