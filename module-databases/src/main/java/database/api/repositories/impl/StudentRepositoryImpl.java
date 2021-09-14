package database.api.repositories.impl;

import static database.connector.DbConnector.getConnector;
import static database.constants.SQL.DELETE_STUDENT_BY_ID;
import static database.constants.SQL.INSERT_STUDENT;
import static database.constants.SQL.SELECT_ALL_STUDENTS;
import static database.constants.SQL.SELECT_STUDENT_BY_ID;
import static database.constants.SQL.UPDATE_STUDENT_BY_ID;
import static java.time.LocalDate.now;

import database.api.repositories.StudentRepository;
import database.entities.Student;
import database.mappers.Mapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

  @Autowired
  Mapper<Student> mapper;

  @Override
  public Student create(Student object) {
    try (
        Connection connection = getConnector().getConnection();
        PreparedStatement statement = connection.prepareStatement(INSERT_STUDENT)
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
  public Student read(Long id) {
    try (
        Connection connection = getConnector().getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_STUDENT_BY_ID)
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
  public List<Student> readAll() {
    try (
        Connection connection = getConnector().getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_ALL_STUDENTS)
    ) {
      ResultSet resultSet = statement.executeQuery();
      return mapper.toList(resultSet);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return new ArrayList<>();
  }

  @Override
  public Boolean update(Student object, Long id) {
    try (
        Connection connection = getConnector().getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT_BY_ID)
    ) {
      object.setUpdated(now());
      mapper.toSQL(statement, object);
      int lastParamIndex = statement.getParameterMetaData().getParameterCount();
      statement.setLong(lastParamIndex, id);
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
        PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_BY_ID)
    ) {
      statement.setLong(1, id);
      return statement.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }
}
