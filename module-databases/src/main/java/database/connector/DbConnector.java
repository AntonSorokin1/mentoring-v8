package database.connector;

import static database.constants.Properties.PASSWORD;
import static database.constants.Properties.URL;
import static database.constants.Properties.USERNAME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

  private static DbConnector dbConnector;

  private DbConnector() {
  }

  public static synchronized DbConnector getConnector() {
    DbConnector localInstance = dbConnector;
    if (localInstance == null) {
      synchronized (DbConnector.class) {
        localInstance = dbConnector;
        if (localInstance == null) {
          dbConnector = localInstance = new DbConnector();
        }
      }
    }
    return localInstance;
  }

  public Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USERNAME, PASSWORD);
  }
}
