package database.mappers;

import database.entities.AbstractIdentifiableObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Mapper<T extends AbstractIdentifiableObject> {
  void toSQL(PreparedStatement statement, T object) throws SQLException;

  T toObject(ResultSet resultSet) throws SQLException;

  default List<T> toList(ResultSet resultSet) throws SQLException {
    List<T> list = new ArrayList<>();
    while (resultSet.next()) {
      list.add(toObject(resultSet));
    }
    return list;
  }
}
