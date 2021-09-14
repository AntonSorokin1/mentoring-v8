package database.mappers;

import static java.sql.Date.valueOf;

import database.entities.ExamResult;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class ExamResultMapper implements Mapper<ExamResult> {

  private static final String ID = "id";
  private static final String CREATED = "created";
  private static final String UPDATED = "updated";
  private static final String SUBJECT_ID = "subject_id";
  private static final String STUDENT_ID = "student_id";
  private static final String MARK = "mark";

  @Override
  public void toSQL(PreparedStatement statement, ExamResult object) throws SQLException {
    statement.setLong(1, object.getId());
    statement.setDate(2, valueOf(object.getCreated()));
    statement.setDate(3, valueOf(object.getUpdated()));
    statement.setLong(4, object.getSubjectId());
    statement.setLong(5, object.getStudentId());
    statement.setInt(6, object.getMark());
  }

  @Override
  public ExamResult toObject(ResultSet resultSet) throws SQLException {
    Long id = resultSet.getLong(ID);
    LocalDate created = resultSet.getDate(CREATED).toLocalDate();
    LocalDate updated = resultSet.getDate(UPDATED).toLocalDate();
    Long subjectId = resultSet.getLong(SUBJECT_ID);
    Long studentId = resultSet.getLong(STUDENT_ID);
    Integer mark = resultSet.getInt(MARK);
    return new ExamResult(id, created, updated, subjectId, studentId, mark);
  }
}
