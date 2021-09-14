package database.api.repositories.impl;

import static database.connector.DbConnector.getConnector;
import static database.constants.SQL.DELETE_STUDENT_BY_ID;
import static database.constants.SQL.DELETE_TEACHER_BY_ID;
import static database.constants.SQL.INSERT_STUDENT;
import static database.constants.SQL.INSERT_TEACHER;
import static database.constants.SQL.SELECT_ALL_STUDENTS;
import static database.constants.SQL.SELECT_ALL_TEACHERS;
import static database.constants.SQL.SELECT_STUDENT_BY_ID;
import static database.constants.SQL.SELECT_TEACHER_BY_ID;
import static database.constants.SQL.UPDATE_STUDENT_BY_ID;
import static database.constants.SQL.UPDATE_TEACHER_BY_ID;
import static java.time.LocalDate.now;

import database.api.repositories.TeacherRepository;
import database.entities.Teacher;
import database.mappers.Mapper;
import database.mappers.TeacherMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository {

  Mapper<Teacher> mapper = new TeacherMapper();

  @Override
  public Teacher create(Teacher object) {
    try (
        Connection connection = getConnector().getConnection();
        PreparedStatement statement = connection.prepareStatement(INSERT_TEACHER)
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
  public Teacher read(Long id) {
    try (
        Connection connection = getConnector().getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_TEACHER_BY_ID)
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
  public List<Teacher> readAll() {
    try (
        Connection connection = getConnector().getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_ALL_TEACHERS)
    ) {
      ResultSet resultSet = statement.executeQuery();
      return mapper.toList(resultSet);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return new ArrayList<>();
  }

  @Override
  public Boolean update(Teacher object, Long id) {
    try (
        Connection connection = getConnector().getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_TEACHER_BY_ID)
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
        PreparedStatement statement = connection.prepareStatement(DELETE_TEACHER_BY_ID)
    ) {
      statement.setLong(1, id);
      return statement.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }
}
