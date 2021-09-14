package database.mappers;

import static java.sql.Date.valueOf;

import database.entities.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper implements Mapper<Student> {

  private static final String ID = "id";
  private static final String CREATED = "created";
  private static final String UPDATED = "updated";
  private static final String NAME = "name";
  private static final String SURNAME = "surname";
  private static final String PHONE_NUMBER = "phone_number";
  private static final String BIRTH_DATE = "birth_date";

  @Override
  public void toSQL(PreparedStatement statement, Student student) throws SQLException {
    statement.setLong(1, student.getId());
    statement.setDate(2, valueOf(student.getCreated()));
    statement.setDate(3, valueOf(student.getUpdated()));
    statement.setString(4, student.getName());
    statement.setString(5, student.getSurname());
    statement.setString(6, student.getPhoneNumber());
    statement.setDate(7, valueOf(student.getBirthDate()));
  }

  @Override
  public Student toObject(ResultSet resultSet) throws SQLException {
    Long id = resultSet.getLong(ID);
    LocalDate created = resultSet.getDate(CREATED).toLocalDate();
    LocalDate updated = resultSet.getDate(UPDATED).toLocalDate();
    String name = resultSet.getString(NAME);
    String surname = resultSet.getString(SURNAME);
    String phoneNumber = resultSet.getString(PHONE_NUMBER);
    LocalDate birthDate = resultSet.getDate(BIRTH_DATE).toLocalDate();
    return new Student(id, created, updated, name, surname, phoneNumber, birthDate);
  }
}
