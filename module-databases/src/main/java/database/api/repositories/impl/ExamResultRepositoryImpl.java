package database.api.repositories.impl;

import static database.connector.DbConnector.getConnector;
import static database.constants.SQL.DELETE_EXAM_RESULT_BY_ID;
import static database.constants.SQL.DELETE_STUDENT_BY_ID;
import static database.constants.SQL.INSERT_EXAM_RESULT;
import static database.constants.SQL.SELECT_ALL_EXAM_RESULTS;
import static database.constants.SQL.SELECT_EXAM_RESULT_BY_ID;
import static database.constants.SQL.UPDATE_EXAM_RESULT_BY_ID;
import static database.constants.SQL.UPDATE_STUDENT_BY_ID;
import static java.time.LocalDate.now;

import database.api.repositories.ExamResultRepository;
import database.entities.ExamResult;
import database.mappers.ExamResultMapper;
import database.mappers.Mapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ExamResultRepositoryImpl implements ExamResultRepository {

  Mapper<ExamResult> mapper = new ExamResultMapper();

  @Override
  public ExamResult create(ExamResult object) {
    try (
        Connection connection = getConnector().getConnection();
        PreparedStatement statement = connection.prepareStatement(INSERT_EXAM_RESULT)
    ) {
      LocalDate now = now();
      object.setCreated(now);
      object.setUpdated(now);
      mapper.toSQL(statement, object);
      statement.execute();
      return object;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public ExamResult read(Long id) {
    try (
        Connection connection = getConnector().getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_EXAM_RESULT_BY_ID)
    ) {
      statement.setLong(1, id);
      ResultSet resultSet = statement.executeQuery();
      return mapper.toObject(resultSet);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public List<ExamResult> readAll() {
    try (
        Connection connection = getConnector().getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_ALL_EXAM_RESULTS)
    ) {
      ResultSet resultSet = statement.executeQuery();
      return mapper.toList(resultSet);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return new ArrayList<>();
  }

  @Override
  public Boolean update(ExamResult object, Long id) {
    try (
        Connection connection = getConnector().getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_EXAM_RESULT_BY_ID)
    ) {
      object.setUpdated(now());
      mapper.toSQL(statement, object);
      statement.setLong(5, id);
      return statement.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public Boolean delete(Long id) {
    try (
        Connection connection = getConnector().getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_EXAM_RESULT_BY_ID)
    ) {
      statement.setLong(1, id);
      return statement.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }
}
